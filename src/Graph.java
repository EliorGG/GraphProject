import java.util.Set;

public interface Graph {
    public int numberOfVertices();
    public int numberOfEdges();
    public boolean containsEdge(int i,int j);
    public void addEdge(int i, int j);
    public void removeEdge(int i, int j);
    public int degree(int v);
    public Set<Integer> neighborsOf(int v);
    public Set<Edge> edgeSet();
}