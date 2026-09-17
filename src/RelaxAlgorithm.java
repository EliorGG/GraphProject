import algorithms.shortestpath.SSSPalgorithm;
import core.Edge;
import core.Graph;

public abstract class RelaxAlgorithm extends SSSPalgorithm {
    public RelaxAlgorithm(Graph graph, int source) {
        super(graph,source);
    }

    protected void initialize() {
        for(int i = 0; i < pi.length; i++){
            pi[i] = -1;
            d[i] = Integer.MAX_VALUE;
        }
        pi[source] = source;
        d[source] = 0;
    }

    protected void relax(Edge e, int w) {

    }
}
