package algorithms;
import core.Graph;
import core.Edge;

public interface GraphAlgorithm<T, E extends Edge> {
    T execute(Graph<E> graph);
}