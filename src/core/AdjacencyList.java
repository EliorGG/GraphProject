package core;

import java.util.*;

public class AdjacencyList<E extends Edge> extends AbstractGraph<E> {
    private List<E>[] adjList;

    public AdjacencyList(int verticesNum,boolean directed) {
        super(verticesNum,directed);
        adjList = (List<E>[]) new LinkedList[verticesNum];
        for(int i=0; i<verticesNum; i++){
            adjList[i] = new LinkedList<>();
        }
    }

    public AdjacencyList(Graph<E> other) {
        this(other.numberOfVertices(), other.isDirected());
        for (E edge : other.edgeSet()) {
            addEdge((E) edge.clone());
        }
    }

    @Override
    public boolean containsEdge(int i, int j) throws IllegalArgumentException  {
        return getEdge(i, j) != null;
    }

    @Override
    public E getEdge(int i, int j) {
        if(!rangeCheck(i,j)) throw new IllegalArgumentException();
        for (E edge : adjList[i]) {
            if (edge.getRight() == j || (!isDirected() && edge.getLeft() == j)) {
                return edge;
            }
        }
        return null;
    }

    @Override
    public void addEdge(E edge) throws IllegalArgumentException{
        int u = edge.getLeft();
        int v = edge.getRight();
        if(!rangeCheck(u,v)) throw new IllegalArgumentException();

        adjList[u].add(edge);
        if (!isDirected()) {
            adjList[v].add(edge);
        }
    }

    @Override
    public void removeEdge(int i, int j) throws IllegalArgumentException {
        if(!rangeCheck(i,j)) throw new IllegalArgumentException();
        E edgeToRemove = getEdge(i, j);
        if (edgeToRemove != null) {
            adjList[i].remove(edgeToRemove);
            if (!isDirected()) {
                adjList[j].remove(edgeToRemove);
            }
        }
    }

    @Override
    public int degree(int i) throws IllegalArgumentException {
        if(!rangeCheck(i)) throw new IllegalArgumentException();
        return adjList[i].size();
    }

    @Override
    public Set<Integer> neighborsOf(int v) throws IllegalArgumentException{
        if(!rangeCheck(v)) throw new IllegalArgumentException();
        Set<Integer> neighbors = new HashSet<>();

        for (E edge : adjList[v]) {
            neighbors.add(edge.getRight());
        }
        return neighbors;
    }
}
