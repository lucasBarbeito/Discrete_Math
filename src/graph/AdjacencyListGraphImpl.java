package graph;

import java.util.*;

// TODO: implement
public class AdjacencyListGraphImpl<T> implements Graph<T> {

    private HashMap<T,LinkedList<Edge<T>>> graph;

    public AdjacencyListGraphImpl(){
        graph = new HashMap<T, LinkedList<Edge<T>>>();

    }

    @Override
    public void addVertex(T x) {
        if (!hasVertex(x)){
            graph.put(x,new LinkedList<Edge<T>>());
        }
    }

    @Override
    public boolean hasVertex(T v){
        if (graph.isEmpty()){
            return false;
        }else {
            for (Map.Entry me : graph.entrySet()){
                if (me.getKey().equals(v)) return true;
            }
        }
        return false;
    }

    @Override
    public void removeVertex(T x) {
        if (!graph.isEmpty()){
            if (hasVertex(x)){
                for (Map.Entry me : graph.entrySet()) {
                    if (me.getKey().equals(x)){
                        graph.remove(x);
                    }
                }
            }
        }
    }

    @Override
    public void addEdge(T v, T w) {
        if (!hasEdge(v,w)){
            if (hasVertex(v) && hasVertex(w)) {
                for (Map.Entry<T, LinkedList<Edge<T>>> me : graph.entrySet()) {
                    if (me.getKey().equals(v) && me.getKey().equals(w)){
                        me.getValue().add(new Edge<T>(v,w));
                    }else {
                        if (me.getKey().equals(v)) {
                            me.getValue().add(new Edge<T>(v, w));
                        }
                        if (me.getKey().equals(w)) {
                            me.getValue().add(new Edge<T>(v, w));
                        }
                    }

                }
            }
        }
    }

    @Override
    public void removeEdge(T v, T w) {
        if (hasEdge(v,w)) {
            for (Map.Entry<T, LinkedList<Edge<T>>> me : graph.entrySet()) {
                if (me.getKey().equals(v)) {
                    for (int i = 0; i < me.getValue().size(); i++) {
                        if ((me.getValue().get(i).getVertex1().equals(v) && me.getValue().get(i).getVertex2().equals(w))
                                || (me.getValue().get(i).getVertex1().equals(w) && me.getValue().get(i).getVertex2().equals(v))) {
                            me.getValue().remove(me.getValue().get(i));
                        }
                    }
                }
                if (me.getKey().equals(w)) {
                    for (int i = 0; i < me.getValue().size(); i++) {
                        if ((me.getValue().get(i).getVertex1().equals(v) && me.getValue().get(i).getVertex2().equals(w))
                                || (me.getValue().get(i).getVertex1().equals(w) && me.getValue().get(i).getVertex2().equals(v))) {
                            me.getValue().remove(me.getValue().get(i));
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean hasEdge(T v, T w) {
        if (hasVertex(v) && hasVertex(w)) {
            for (Map.Entry<T, LinkedList<Edge<T>>> me : graph.entrySet()) {
                if (me.getKey().equals(v)) {
                    for (int i = 0; i < me.getValue().size(); i++) {
                        if ((me.getValue().get(i).getVertex1().equals(v) || me.getValue().get(i).getVertex1().equals(w))
                                && (me.getValue().get(i).getVertex2().equals(v) || me.getValue().get(i).getVertex2().equals(w))) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    @Override
    public int order() {
        return getVertexes().size();
    }

    @Override
    public int alpha() {
        int alpha = 0;
        for (Map.Entry<T, LinkedList<Edge<T>>> me : graph.entrySet()){
            alpha = me.getValue().size();
        }
        return alpha;
    }

    @Override
    public List<T> getVertexes() {
        List<T> vertexList = new ArrayList<T>();
        if (!(graph.size() == 0)){
            for (Map.Entry<T, LinkedList<Edge<T>>> me : graph.entrySet()){
                vertexList.add(me.getKey());
            }
        }
        return vertexList;
    }

    @Override
    public List<T> getAdjacencyList(T v) {
        List<T> vertexList = new ArrayList<T>();
        if (!(graph.size() == 0)){
            for (Map.Entry<T, LinkedList<Edge<T>>> me : graph.entrySet()){
                if (me.getKey().equals(v)){
                    for (int i = 0; i < me.getValue().size(); i++){
                        if (me.getValue().get(i).getVertex1().equals(v)){
                            vertexList.add(me.getValue().get(i).getVertex2());
                        }else {
                            vertexList.add(me.getValue().get(i).getVertex1());
                        }
                    }
                }
            }
        }
        return vertexList;
    }
    // mis metodos

    @Override
    public List<T> getLoops() {
        ArrayList<T> loopsArrayList = new ArrayList<T>();
        for (Map.Entry<T, LinkedList<Edge<T>>> me : graph.entrySet()) {
            for (int i = 0; i < me.getValue().size(); i++){
                if (me.getValue().get(i).getVertex1().equals(me.getValue().get(i).getVertex2())){
                    loopsArrayList.add(me.getValue().get(i).getVertex2());
                }
            }
        }
        return loopsArrayList;
    }

    @Override
    public void showGraph() {

        for (int i = 0; i < getVertexes().size(); i++) {
            graph.keySet();
            for (int j = 0; j < graph.get(getVertexes().get(i)).size(); j++) {
                System.out.println(graph.get(getVertexes().get(i)).get(i).toString());
            }
        }
    }

    @Override
    public boolean belongstoEdge(T v, Edge<T> edge) {
        boolean belongs = false;
        for (Map.Entry<T, LinkedList<Edge<T>>> me : graph.entrySet()) {
            for (int i = 0; i < me.getValue().size(); i++) {
                if (v.equals(me.getValue().get(i).getVertex1()) || v.equals(me.getValue().get(i).getVertex2())) {
                    belongs = true;
                }
                else
                    belongs = false;
            }
        }
        return belongs;
    }

    @Override
    public List<Edge<T>> getEdges() { //En este tengo el problema que me pone el doble de edges de lo que deberia
        List<Edge<T>> edges = new ArrayList<>();

        for (Map.Entry<T, LinkedList<Edge<T>>> me : graph.entrySet()) {
            for (int i = 0; i < me.getValue().size(); i++) {
                if(!edges.contains(me.getValue().get(i)))
                edges.add(me.getValue().get(i));
            }
        }
        return edges;
    }

}
