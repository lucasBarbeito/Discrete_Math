package tp1;

import graph.Graph;

import java.util.ArrayList;
import java.util.List;

// TODO: implement
public class Tp1Impl<T> implements Tp1<T> {
    @Override
    public void exercise_a(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public int exercise_b(Graph<T> graph) {
        return graph.getLoops().size();
    }

    @Override
    public List<T> exercise_c(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean exercise_d(Graph<T> graph, T vertex) {
        if (graph.hasVertex(vertex)){
            if (graph.getAdjacencyList(vertex).size() == 0){
                return true;
            }
        }
        return false;
    }

    @Override
    public int exercise_e(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public List<T> exercise_f(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public Graph<T> exercise_g(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public int[][] exercise_h(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public int[][] exercise_i(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }
}
