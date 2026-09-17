package core;

import java.util.Set;

public interface Graph<E extends Edge> {
    public int numberOfVertices();
    public int numberOfEdges();
    public boolean containsEdge(int i,int j);
    public void addEdge(E edge);
    public void removeEdge(int i, int j);
    public E getEdge(int i, int j);
    public int degree(int v);
    public Set<Integer> neighborsOf(int v);
    public Set<E> edgeSet();
    public boolean isDirected();
}