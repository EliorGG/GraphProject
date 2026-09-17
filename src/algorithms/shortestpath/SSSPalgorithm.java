package algorithms.shortestpath;

import algorithms.GraphAlgorithm;
import core.Graph;

public abstract class SSSPalgorithm extends GraphAlgorithm {
    int source;
    protected int[] d;
    protected int[] pi;
    public SSSPalgorithm(Graph graph, int source) {
        super(graph);
        this.source = source;
        d=new int[graph.numberOfVertices()];
        pi=new int[graph.numberOfVertices()];
    }
}
