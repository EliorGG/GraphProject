public abstract class GraphAlgorithm {
    protected Graph graph;
    public GraphAlgorithm(Graph graph) {
        this.graph = graph;
    }
    public abstract Object run();
}
