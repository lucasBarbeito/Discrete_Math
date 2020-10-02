package tp2;

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
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean exercise_b(Graph<T> graph, T v) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean exercise_c(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean exercise_d(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
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
        throw new UnsupportedOperationException("TODO");
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
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public Map<T, Integer> exercise_n(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }

}