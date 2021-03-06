package tp2;

import graph.Edge;
import graph.Graph;

import java.util.*;

public class Tp2Impl<T> implements Tp2<T> {
    @Override
    public List<T> depth_first_search(Graph<T> graph) {
        List<T> returningList = new ArrayList<>();
        Stack<T> stack = new Stack<>();
        HashMap<T,Boolean>  visitedVertex = new HashMap<>();
        int counter = 0;
        for (int i = 0 ; i< graph.getVertexes().size(); i++){
            visitedVertex.put(graph.getVertexes().get(i),false);
        }
        stack.push(graph.getVertexes().get(counter));
        while (counter < graph.getVertexes().size()){
            for (Map.Entry<T,Boolean> me : visitedVertex.entrySet()){
                if (stack.peek().equals(me.getKey()) && !me.getValue()){
                    me.setValue(true);
                    returningList.add(stack.peek());
                    List<T> edges = graph.getAdjacencyList(stack.peek());
                    stack.pop();
                    for (int i = 0; i < edges.size(); i++){
                        stack.push(edges.get(i));
                    }
                    counter++;
                }else {
                    if (stack.peek().equals(me.getKey()) && me.getValue()){
                        stack.pop();
                    }
                }
            }
        }

        return returningList;
    }

    @Override
    public List<T> breadth_first_search(Graph<T> graph) {
        List<T> returningList = new ArrayList<>();
        Queue<T> queue = new ArrayDeque<>();
        HashMap<T,Boolean>  visitedVertex = new HashMap<>();
        int counter = 0;
        for (int i = 0 ; i< graph.getVertexes().size(); i++){
            visitedVertex.put(graph.getVertexes().get(i),false);
        }
        queue.add(graph.getVertexes().get(counter));
        while (counter < graph.getVertexes().size()){
            for (Map.Entry<T,Boolean> me : visitedVertex.entrySet()){
                if (queue.peek().equals(me.getKey()) && !me.getValue()){
                    me.setValue(true);
                    returningList.add(queue.peek());
                    List<T> edges = graph.getAdjacencyList(queue.peek());
                    queue.remove();
                    for (int i = 0; i < edges.size(); i++){
                        queue.add(edges.get(i));
                    }
                    counter++;
                }else {
                    if (queue.peek().equals(me.getKey()) && me.getValue()){
                        queue.remove();
                    }
                }
            }
        }

        return returningList;
    }

    @Override
    public boolean exercise_a(Graph<T> graph, T v, T w) {
        if (v.equals(w) || graph.hasEdge(v, w)) return true;
        final HashMap<T,Boolean>  visitedVertex = new HashMap<>();
        for (int i = 0 ; i< graph.getVertexes().size(); i++){
            visitedVertex.put(graph.getVertexes().get(i),false);
        }
        if (excersise_a_auxiliary(visitedVertex,graph,v,w)){
            return true;
        }

        return false;
    }
    private boolean excersise_a_auxiliary(HashMap<T,Boolean> visitedVertex, Graph<T> graph, T v, T w){
        if (v.equals(w) || graph.hasEdge(v, w)) {
            return true;
        }else {
            visitedVertex.replace(v,true);
        }
        List<T> adjacenyList = graph.getAdjacencyList(v);

        if (adjacenyList.isEmpty()){
            return false;
        }else {
            for (int i = 0; i < adjacenyList.size(); i++) {
                if (adjacenyList.get(i).equals(w) && !visitedVertex.get(adjacenyList.get(i))) {
                    return true;
                } else {
                    for (Map.Entry<T,Boolean> me : visitedVertex.entrySet()){
                        if (adjacenyList.get(i).equals(me.getKey()) && !visitedVertex.get(adjacenyList.get(i))){
                            me.setValue(true);
                            if(excersise_a_auxiliary(visitedVertex, graph, adjacenyList.get(i), w)) {
                                return true;
                            }else {
                                break;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }
    @Override
    public boolean exercise_b(Graph<T> graph, T v) {
        if(graph.order() <= 1) return false;
        List<T> adjacencyList = graph.getAdjacencyList(v);
        for (int i = 0; i < adjacencyList.size(); i++){
            List<T> adjacencyListOfAVertexAdjacentToV = graph.getAdjacencyList(adjacencyList.get(i));
            for (int j = 0; j < adjacencyListOfAVertexAdjacentToV.size(); j++){
                if (!adjacencyListOfAVertexAdjacentToV.get(j).equals(v) && graph.hasEdge(v,adjacencyListOfAVertexAdjacentToV.get(j))){
                    return true;
                }

            }
        }

        return false;
    }


    @Override
    public boolean exercise_c(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean exercise_d(Graph<T> graph) {
        if (graph.order() == 0) return false;
        List<T> vertexes = graph.getVertexes();
        int counter = 1;
        HashMap<T,Boolean> visitedVertex = new HashMap<>();
        for (int i = 0 ; i< graph.getVertexes().size(); i++){
            visitedVertex.put(graph.getVertexes().get(i),false);
        }

        for (int i = 0; i < vertexes.size(); i++){
            List<T> adjacencyList = graph.getAdjacencyList(vertexes.get(i));
            if (i == 0) {
                visitedVertex.replace(vertexes.get(i), true);
            }
            for (int j = 0; j < adjacencyList.size(); j++){
                if (!visitedVertex.get(adjacencyList.get(j))){
                    if (adjacencyList.size() == 1 && visitedVertex.get(vertexes.get(i))){
                        visitedVertex.replace(adjacencyList.get(j),true);
                    }else {
                    visitedVertex.replace(adjacencyList.get(j),true);
                    counter++;
                    }
                }
            }
        }
        if (counter == vertexes.size()) return true;
        return false;
    }

    @Override
    public int exercise_e(Graph<T> graph, T v, T w) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public List<T> exercise_f(Graph<T> graph,T v, T w) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public List<T> exercise_g(Graph<T> graph, T v, T w) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public int exercise_h(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean exercise_i(Graph<T> g1, Graph<T> g2) {
        throw new UnsupportedOperationException("TODO");

    }

    @Override
    public boolean exercise_j(Graph<T> g1, Graph<T> g2) {
        List<T> g1Vertexes = g1.getVertexes();

        for (int i = 0; i < g1Vertexes.size(); i++){
            if (!g2.hasVertex(g1Vertexes.get(i))) return false;
        }
        return true;
    }

    @Override
    public boolean exercise_k(Graph<T> g1) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public Graph<T> exercise_l(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public int exercise_m(Graph<T> graph, T v) {
        List<T> loops = graph.getLoops();
        for (int i = 0 ; i < loops.size() ; i ++){
            if (loops.get(i).equals(v)){
                return graph.getAdjacencyList(v).size() + 1;
            }
        }
        return graph.getAdjacencyList(v).size();
    }

    @Override
    public Map<T, Integer> exercise_n(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }

}