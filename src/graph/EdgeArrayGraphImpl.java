package graph;

import java.util.ArrayList;
import java.util.List;

// TODO: implement
public class EdgeArrayGraphImpl<T> implements Graph<T> {

    int numberOfVertex = 0;
    int alpha = 0;
    ArrayList<T> vertexes;
    ArrayList<Edge<T>> edges;


    public EdgeArrayGraphImpl(){
        vertexes = new ArrayList<T>();
        edges = new ArrayList<Edge<T>>();
    }
    @Override
    public void addVertex(T x) {
        vertexes.add(x);
        numberOfVertex++;
    }

    @Override
    public boolean hasVertex(T v){
        for (int i = 0; i < vertexes.size(); i++){
            if (vertexes.get(i).equals(v)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void removeVertex(T x) {
        if (hasVertex(x)){
            for (int i = 0 ; i < vertexes.size(); i++){
                if (vertexes.get(i).equals(x)){
                    vertexes.remove(vertexes.get(i));
                }
            }
            ArrayList<T> tempArray = (ArrayList<T>) getAdjacencyList(x);
            for (int j = 0; j < tempArray.size(); j++){
                if (hasEdge(x,tempArray.get(j))){
                    removeEdge(x,tempArray.get(j));
                }
            }
        }
    }

    @Override
    public void addEdge(T v, T w) {
        edges.add(new Edge<>(v,w));
        alpha++;
    }

    @Override
    public void removeEdge(T v, T w) {
        if (hasEdge(v,w)){
            for (int i = 0 ; i < edges.size(); i++){
                if ((edges.get(i).getVertex1().equals(v) && edges.get(i).getVertex2().equals(w)) ||
                        (edges.get(i).getVertex1().equals(w) && edges.get(i).getVertex2().equals(v))){
                    edges.remove(edges.get(i));
                }
            }
        }
    }

    @Override
    public boolean hasEdge(T v, T w) {
        if (hasVertex(v) && hasVertex(w)){
            for (int i = 0; i< edges.size(); i++){
                if ((edges.get(i).getVertex1().equals(v) && edges.get(i).getVertex2().equals(w)) ||
                        (edges.get(i).getVertex1().equals(w) && edges.get(i).getVertex2().equals(v))) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int order() {
        return numberOfVertex;
    }

    @Override
    public int alpha() {
        return alpha;
    }

    @Override
    public List<T> getVertexes() {
        return vertexes;
    }

    @Override
    public List<T> getAdjacencyList(T v) {
        ArrayList<T> Vedges = new ArrayList<T>();
        if (hasVertex(v)){
            for (int i = 0; i < edges.size(); i++ ){
                if (edges.get(i).getVertex1().equals(v) || edges.get(i).getVertex2().equals(v)){
                    if (edges.get(i).getVertex1().equals(v)){
                        Vedges.add(edges.get(i).getVertex2());
                    }else {
                        Vedges.add(edges.get(i).getVertex1());
                    }
                }
            }
        }
        return Vedges;
    }
    // mis metodos

    @Override
    public List<T> getLoops() {
        ArrayList<T> loopsArrayList = new ArrayList<T>();
        for (int i = 0; i < edges.size(); i++){
            if (edges.get(i).getVertex1().equals(edges.get(i).getVertex2())){
                loopsArrayList.add(edges.get(i).getVertex1()); // no hace falta agregar el lazo porque al estar en esta lista
                // se sabe que es un lazo.
            }
        }
        return loopsArrayList;
    }

    @Override
    public void showGraph() {

        for (int i = 0; i < vertexes.size() ; i++) {
            for (int j = 0; j < edges.size(); j++) {
                System.out.println("\t" + "vertex: " + vertexes.get(i).toString() +
                        " and its edge is: " + edges.get(j).toString());
            }
        }
    }

    @Override
    public boolean belongstoEdge(T v, Edge<T> edge) {
        boolean belongs = false;
        for (int i = 0; i < edges.size(); i++) {
            if(v.equals(edge.getVertex1()) || v.equals(edge.getVertex2())){
                belongs = true;
            }
            else{
                belongs = false;
            }
        }
        return belongs;
    }

    @Override
    public List<Edge<T>> getEdges() {
        List<Edge<T>> edgeslist = new ArrayList<>();

        for (int i = 0; i < edges.size(); i++) {
            if(!edgeslist.contains(edges.get(i)))
                edgeslist.add(edges.get(i));
        }
        return edgeslist;
    }
    //algo random para el push

}
