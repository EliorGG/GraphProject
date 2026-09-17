import java.util.*;

public class AdjacenyList extends AbstractGraph {
    private List<Integer> [] adjList;

    public AdjacenyList(int verticesNum) {
        super(verticesNum);
        adjList = new LinkedList[verticesNum];
    }

    public AdjacenyList(Graph other) {
        this(other.numberOfVertices());
        for(int i = 0; i < other.numberOfVertices(); i++)
            for(int j = i+1; j < other.numberOfVertices(); j++)
                if(other.containsEdge(i,j))
                    addEdge(i,j);
    }

    @Override
    public boolean containsEdge(int i, int j) throws IllegalArgumentException  {
        if(!rangeCheck(i,j)) throw new IllegalArgumentException();
        for (Integer k : adjList[i]) {
            if(k == j) return true;
        }
        return false;
    }

    @Override
    public void addEdge(int i, int j) throws IllegalArgumentException{
        if(!rangeCheck(i,j)) throw new IllegalArgumentException();
        adjList[i].add(j);
        adjList[j].add(i);
    }

    @Override
    public void removeEdge(int i, int j) throws IllegalArgumentException {
        if(!rangeCheck(i,j)) throw new IllegalArgumentException();
        if(!adjList[i].contains(j)) return;
        adjList[i].remove(j);
        adjList[j].remove(i);
    }
}
