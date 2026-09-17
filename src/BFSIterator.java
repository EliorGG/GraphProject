import java.util.*;

public class BFSIterator implements Iterator<Integer> {
    private Graph g;   // The graph to traverse
    private Queue<Integer> q=new LinkedList<>(); // Queue for BFS
    private Set<Integer> visited = new HashSet<>();
    // Set of visited vertices
    public BFSIterator(Graph g, int start) {
        this.g = g;
        q.add(start);
        visited.add(start);
    }


    @Override
    public boolean hasNext() {
        return !q.isEmpty();
    }

    @Override
    public Integer next() {
        if(!hasNext()) throw new NoSuchElementException();
        int next=q.remove();
        for(int v: g.neighborsOf(next)) {
            if(!visited.contains(v)) {
                q.add(v);
                visited.add(v);
            }
        }
        return next;
    }
}
