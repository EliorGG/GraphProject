# 🕸️ Java Graph Algorithms Library

A comprehensive, object-oriented framework for graph representation and advanced algorithm implementations in Java. 
This project serves as a robust library for classic computer science graph algorithms, including Shortest Paths, Minimum Spanning Trees, Maximum Flow, and more.

## 🚀 Features

### Supported Graph Types
* **Directed / Undirected Graphs**
* **Weighted / Unweighted Edges**
* **Flow Networks** (Edges with capacity and flow)
* Multiple representations: Adjacency Matrix & Adjacency List.

### Implemented Algorithms
Currently implemented or planned algorithms, categorized by family:

**1. Graph Traversals & Analysis**
* BFS (Breadth-First Search) & DFS (Depth-First Search)
* Topological Sort
* Graph Strongly Connected Components (GSCC)
* Transitive Closure
* Triangle Detection

**2. Minimum Spanning Tree (MST)**
* Prim's Algorithm
* Kruskal's Algorithm (using Union-Find)
* Borůvka's Algorithm
* Yao's Algorithm & KKT (Karger-Klein-Tarjan)

**3. Shortest Paths (SSSP & APSP)**
* Dijkstra's Algorithm
* Bellman-Ford Algorithm
* Floyd-Warshall Algorithm
* Johnson's Algorithm
* Seidel's Algorithm

**4. Network Flow & Matching**
* Ford-Fulkerson Algorithm
* Dinic's Algorithm
* Hopcroft-Karp Algorithm (Bipartite Matching)

## 🏗️ Architecture & Design

The library is built with strong software engineering principles in mind:
* **Strategy Pattern:** Algorithms are encapsulated in classes implementing generic family interfaces (e.g., `SSSPAlgorithm`, `MSTAlgorithm`).
* **Result Objects (DTOs):** Algorithms return structured objects (like `SSSPResult` or `MaxFlowResult`) instead of mutating the graph or returning generic types.
* **Edge Hierarchy:** Base `Edge` class extended by `WeightedEdge` and `FlowEdge` to ensure type safety.

## 💻 Usage Example

Here is a quick example of how to build a graph and run Dijkstra's algorithm:

```java
import graph.core.*;
import graph.shortestpath.sssp.*;

public class Main {
    public static void main(String[] args) {
        // 1. Create a directed graph with 5 vertices
        Graph g = new AdjacencyList(5);
        g.setDirected(true);

        // 2. Add weighted edges
        g.addEdge(0, 1, 10.0);
        g.addEdge(0, 2, 3.0);
        g.addEdge(2, 1, 1.0);
        g.addEdge(1, 3, 2.0);

        // 3. Run Dijkstra's Algorithm from source node 0
        SSSPAlgorithm dijkstra = new DijkstraAlgorithm(0);
        SSSPResult result = dijkstra.execute(g);

        // 4. Get results
        System.out.println("Distance to node 3: " + result.getDistanceTo(3));
        System.out.println("Shortest path: " + result.getPathTo(3));
    }
}
