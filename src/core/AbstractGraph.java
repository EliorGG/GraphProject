package core;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractGraph<E extends Edge> implements Graph<E> {
    final private int numOfVertices;
    final private boolean directed;

    public AbstractGraph(int numOfVertices,boolean directed) {
        this.numOfVertices = numOfVertices;
        this.directed = directed;
    }

    public int numberOfVertices() {return numOfVertices;}
    public int numberOfEdges(){return edgeSet().size();}
    public boolean isDirected() {return directed;}

    public int degree(int v) throws IllegalArgumentException {
        if(!rangeCheck(v)) throw new IllegalArgumentException();
        return neighborsOf(v).size();
    }

    public Set<E> edgeSet() {
        Set<E> edges = new HashSet<>();
        for(int v = 0; v < numOfVertices; v++) {
            int startJ = isDirected() ? 0 : v;
            for(int j=startJ; j < numOfVertices; j++) {
                if(containsEdge(v,j)) edges.add(getEdge(v,j));
            }
        }
        return edges;
    }

    public Set<Integer> neighborsOf(int v) throws IllegalArgumentException {
        if(!rangeCheck(v)) throw new IllegalArgumentException();
        Set<Integer> neighbors = new HashSet<>();
        for(int i=0;i<numOfVertices;i++){
            if(containsEdge(v,i)) neighbors.add(i);
        }
        return neighbors;
    }

    protected boolean rangeCheck(int i,int j){
        return rangeCheck(i) && rangeCheck(j);
    }
    protected boolean rangeCheck(int v) {
        return v >= 0 && v < numOfVertices;
    }

    public String toString() {return "number of vertices: " + numOfVertices+"\n"+"edges: "+edgeSet().toString()+"\n";}

    public boolean equals(Object other) {
        if(!(other instanceof AbstractGraph)) return false;
        AbstractGraph otherGraph = (AbstractGraph)other;
        if(numOfVertices != otherGraph.numOfVertices) return false;
        for(E e: edgeSet()) {
            if (!otherGraph.containsEdge(e.getLeft(), e.getRight())) return false;
        }
        return true;
    }

    public Graph clone() throws CloneNotSupportedException {
        Graph graph;
        if(this instanceof AdjacencyMatrix) graph = new AdjacencyMatrix(numOfVertices,directed);
        if(this instanceof AdjacencyList) graph = new AdjacencyList(numOfVertices,directed);
        else throw new CloneNotSupportedException();
        for(E e: edgeSet()) {
            graph.addEdge(e.clone());
        }
        return graph;
    }
}
