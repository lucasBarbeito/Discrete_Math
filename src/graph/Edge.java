package graph;

public class Edge <T> {
    private T vertex1;
    private T vertex2;

    public Edge(T vertex1, T vertex2){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }
}