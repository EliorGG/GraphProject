import algorithms.GraphAlgorithm;
import core.Graph;

import java.util.Iterator;

public class ConnectivityAlgorithm extends GraphAlgorithm {
    private boolean[] visited;
    public ConnectivityAlgorithm(Graph g) {
        super(g);
    }
    @Override
    public Object run() {
        visited = new boolean[graph.numberOfVertices()];
        Iterator<Integer> itr = new DFSIterator(super.graph,0);
        while(itr.hasNext()) {
            visited[itr.next()] = true;
        }
        return reachedAll();
    }

    private void dfsVisit(int v) {
        visited[v] = true;
        for(int u: graph.neighborsOf(v)){
            if(!visited[u]) dfsVisit(u);
        }
    }
    private boolean reachedAll() {
        for(boolean v: visited) if(!v) return false;
        return true;
    }
}
