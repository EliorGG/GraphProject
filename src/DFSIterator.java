import core.Graph;

import java.util.*;

public class DFSIterator implements Iterator<Integer> {
    private Graph g;
    private Stack<Integer> stack=new Stack<>();
    private Set<Integer> visited = new HashSet<>();

    public DFSIterator(Graph g,int start) {
        this.g = g;
        stack.push(start);
        visited.add(start);
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public Integer next() throws NoSuchElementException {
        if(!hasNext()) throw new NoSuchElementException();
        int next=stack.pop();
        for(int v: g.neighborsOf(next)) {
            if(!visited.contains(v)) {
                stack.push(v);
                visited.add(v);
            }
        }
        return next;
    }
}
