package tp1;

import graph.Graph;

import java.util.ArrayList;
import java.util.List;

// TODO: implement
public class Tp1Impl<T> implements Tp1<T> {
    @Override
    public void exercise_a(Graph<T> graph) {
        graph.showGraph();
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
        int[][] incindentMatrix = new int[graph.order()][graph.getEdges().size()];

        for (int i = 0; i < incindentMatrix.length; i++) {
            for (int j = 0; j < incindentMatrix[i].length; j++) {
                if(graph.belongstoEdge(graph.getVertexes().get(i) , graph.getEdges().get(j))){
                    incindentMatrix[i][j] = 1;
                }
                else {
                    incindentMatrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < incindentMatrix.length; i++) {

            for (int j = 0; j < incindentMatrix[i].length; j++) {
                System.out.print("\t" + incindentMatrix[i][j] + "");
            }
            System.out.println();
        }
        return incindentMatrix;
    }

    //algo random para el push
}
