public abstract class RelaxAlgorithm extends SSSPalgorithm {
    public RelaxAlgorithm(Graph graph) {
        super(graph);
    }

    protected void initialize() {
        for(int i: pi){
            pi[i]=null;
            d[i]=Integer.MAX_VALUE;
        }
        pi[source]=source;
        d[source]=0;
    }
}
