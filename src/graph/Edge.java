package graph;

public class Edge <T> {
    private T vertex1;
    private T vertex2;

    public Edge(T vertex1, T vertex2){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }

    public T getVertex1() {
        return vertex1;
    }

    public T getVertex2() {
        return vertex2;
    }

    @Override
    public String toString() {
        return  "The edge is between: " + vertex1 + " and " + vertex2;

    }
    //algo random para el push

}