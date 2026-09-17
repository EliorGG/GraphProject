import algorithms.GraphAlgorithm;
import core.Graph;

public class EvenDegreesAlgorithm extends GraphAlgorithm {

    public EvenDegreesAlgorithm(Graph g) {super(g);}

    @Override
    public Object run() {
        for(int v=0;v< graph.numberOfVertices();v++){
            if(graph.degree(v)%2!=0) return false;
        }
        return true;
    }
}
