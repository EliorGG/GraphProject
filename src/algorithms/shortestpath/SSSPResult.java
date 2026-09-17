package algorithms.shortestpath;

import java.util.LinkedList;
import java.util.List;

public class SSSPResult {
    private final int source;
    private final double[] distances;
    private final int[] parents;
    private final boolean negativeCycle;

    public SSSPResult(int source, double[] distances, int[] parents, boolean negativeCycle) {
        this.source = source;
        this.distances = distances;
        this.parents = parents;
        this.negativeCycle = negativeCycle;
    }

    public double getDistanceTo(int target) {
        return distances[target];
    }

    public boolean hasNegativeCycle() {
        return negativeCycle;
    }

    public List<Integer> getPathTo(int target) {
        LinkedList<Integer> path = new LinkedList<>();
        if (negativeCycle || distances[target] == Double.POSITIVE_INFINITY) {
            return path;
        }

        for (int at = target; at != -1; at = parents[at]) {
            path.addFirst(at);
        }
        return path;
    }
}