import java.util.HashSet;
import java.util.Set;

public abstract class AbstractGraph implements Graph {
    final private int numOfVertices;
    public AbstractGraph(int numOfVertices) {this.numOfVertices = numOfVertices;}

    public int numberOfVertices() {return numOfVertices;}
    public int numberOfEdges(){return edgeSet().size();}
    public int degree(int v) throws IllegalArgumentException {
        if(!rangeCheck(v)) throw new IllegalArgumentException();
        return neighborsOf(v).size();
    }
    public Set<Edge> edgeSet() {
        Set<Edge> edges = new HashSet<>();
        for(int v = 0; v < numOfVertices; v++) {
            for(int j=v+1; j < numOfVertices; j++) {
                if(containsEdge(v,j)) edges.add(new Edge(v,j));
            }
        }
        return edges;
    }
    public Set<Integer> neighborsOf(int v) throws IllegalArgumentException {
        if(!rangeCheck(v)) throw new IllegalArgumentException();
        Set<Integer> neighbors = new HashSet<>();
        for(int i=0;v<numOfVertices;i++){
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
        for(Edge e: edgeSet()) {
            if (!otherGraph.containsEdge(e.getLeft(), e.getRight())) return false;
        }
        return true;
    }

    public Graph clone() throws CloneNotSupportedException {
        Graph graph;
        if(this instanceof AdjacencyMatrix) graph = new AdjacencyMatrix(numOfVertices);
        if(this instanceof AdjacenyList) graph = new AdjacenyList(numOfVertices);
        else throw new CloneNotSupportedException();
        for(Edge e: edgeSet()) {
            graph.addEdge(e.getLeft(), e.getRight());
        }
        return graph;
    }
}
