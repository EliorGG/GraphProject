public class AdjacencyMatrix extends AbstractGraph {
    private boolean[][] adjMatrix;

    public AdjacencyMatrix(int verticesNum) {
        super(verticesNum);
        adjMatrix = new boolean[verticesNum][verticesNum];
        for (int i = 0; i < adjMatrix.length; i++)
            for (int j = 0; j < adjMatrix[i].length; j++)
                adjMatrix[i][j] = false;
    }

    public AdjacencyMatrix(Graph other) {
        this(other.numberOfVertices());
        for(int i = 0; i < other.numberOfVertices(); i++)
            for(int j = i+1; j < other.numberOfVertices(); j++)
                if(other.containsEdge(i,j))
                    addEdge(i,j);
    }


    @Override
    public boolean containsEdge(int i, int j) throws IllegalArgumentException{
        if(!rangeCheck(i,j)) throw new IllegalArgumentException();
        return adjMatrix[i][j];
    }

    @Override
    public void addEdge(int i, int j) throws IllegalArgumentException{
        if(!rangeCheck(i,j)) throw new IllegalArgumentException();
        adjMatrix[i][j] = true;
        adjMatrix[j][i] = true;
    }

    @Override
    public void removeEdge(int i, int j) throws IllegalArgumentException{
        if(!rangeCheck(i,j)) throw new IllegalArgumentException();
        adjMatrix[i][j] = false;
        adjMatrix[j][i] = false;
    }

}
