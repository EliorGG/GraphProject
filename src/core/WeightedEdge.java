package core;

import java.util.Objects;

public class WeightedEdge extends Edge {
    double weight;

    public WeightedEdge(int left, int right, double weight) {
        super(left, right);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeightedEdge that = (WeightedEdge) o;
        if (Double.compare(that.weight, weight) != 0) return false;
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLeft(), getRight(), weight);
    }

    @Override
    public WeightedEdge clone() {
        return new WeightedEdge(getLeft(), getRight(), weight);
    }
}