package core;

public class AdjacencyMatrix<E extends Edge> extends AbstractGraph<E> {
    private Edge[][] adjMatrix;

    public AdjacencyMatrix(int verticesNum,boolean directed) {
        super(verticesNum, directed);
        adjMatrix = new Edge[verticesNum][verticesNum];
        for (int i = 0; i < adjMatrix.length; i++)
            for (int j = 0; j < adjMatrix[i].length; j++)
                adjMatrix[i][j] = null;
    }

    public AdjacencyMatrix(Graph<E> other) {
        this(other.numberOfVertices(), other.isDirected());
        for (E edge : other.edgeSet()) {
            addEdge((E) edge.clone());
        }
    }

    @Override
    public boolean containsEdge(int i, int j) throws IllegalArgumentException{
        if(!rangeCheck(i,j)) throw new IllegalArgumentException();
        return adjMatrix[i][j]!=null;
    }

    @Override
    public void addEdge(E e) throws IllegalArgumentException{
        int u = e.getLeft();
        int v = e.getRight();
        if(!rangeCheck(u,v)) throw new IllegalArgumentException();
        adjMatrix[u][v] = e;
        if(!isDirected()) adjMatrix[v][u] = e;
    }

    @Override
    public void removeEdge(int i, int j) throws IllegalArgumentException{
        if(!rangeCheck(i,j)) throw new IllegalArgumentException();
        adjMatrix[i][j]=null;
        if(!isDirected()) adjMatrix[j][i]=null;
    }

    @Override
    public E getEdge(int i, int j) {
        if(!rangeCheck(i,j)) throw new IllegalArgumentException();
        return (E) adjMatrix[i][j];
    }

}
