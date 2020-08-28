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

        graph.put(x,null);
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
            for (Map.Entry me : graph.entrySet()) {
                if (me.getKey().equals(x)){
                    graph.remove(x);
                }
            }
        }
    }

    @Override
    public void addEdge(T v, T w) {
        if (hasVertex(v) && hasVertex(w)) {
            for (Map.Entry<T, LinkedList<Edge<T>>> me : graph.entrySet()) {
                if (me.getKey().equals(v)) {
                    me.getValue().add(new Edge<T>(v, w));
                }
            }
            for (Map.Entry<T, LinkedList<Edge<T>>> me : graph.entrySet()) {
                if (me.getKey().equals(w)) {
                    me.getValue().add(new Edge<T>(v, w));
                }
            }
        }
    }

    @Override
    public void removeEdge(T v, T w) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean hasEdge(T v, T w) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public int order() {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public int alpha() {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public List<T> getVertexes() {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public List<T> getAdjacencyList(T v) {
        throw new UnsupportedOperationException("TODO");
    }

}
