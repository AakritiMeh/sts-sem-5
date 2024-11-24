import java.util.*;

public class hamiltonianCycle {
    private int V; // Number of vertices
    private int[][] graph;
    private int[] path;

    public hamiltonianCycle(int[][] graph) {
        this.graph = graph;
        this.V = graph.length;
        this.path = new int[V];
        Arrays.fill(path, -1);
    }

    public boolean isHamiltonianCycle() {
        // Start from the first vertex
        path[0] = 0;

        if (!hamiltonianCycleUtil(1)) {
            System.out.println("No Hamiltonian Cycle found.");
            return false;
        }

        printCycle();
        return true;
    }

    private boolean hamiltonianCycleUtil(int pos) {
        // Base case: all vertices are in the cycle
        if (pos == V) {
            // Check if there is an edge from the last vertex to the first
            return graph[path[pos - 1]][path[0]] == 1;
        }

        // Try different vertices as candidates for the cycle
        for (int v = 1; v < V; v++) {
            if (isSafe(v, pos)) {
                path[pos] = v;

                // Recurse to build the rest of the path
                if (hamiltonianCycleUtil(pos + 1)) {
                    return true;
                }

                // Backtrack
                path[pos] = -1;
            }
        }
        return false;
    }

    private boolean isSafe(int v, int pos) {
        // Check if the vertex is adjacent to the previous vertex
        if (graph[path[pos - 1]][v] == 0) {
            return false;
        }

        // Check if the vertex is already in the path
        for (int i = 0; i < pos; i++) {
            if (path[i] == v) {
                return false;
            }
        }

        return true;
    }

    private void printCycle() {
        System.out.print("Hamiltonian Cycle found: ");
        for (int vertex : path) {
            System.out.print(vertex + " ");
        }
        System.out.println(path[0]); // To complete the cycle
    }

    public static void main(String[] args) {
        // Example graph (adjacency matrix)
        int[][] graph = {
                { 0, 1, 1, 0, 1 },
                { 1, 0, 1, 1, 1 },
                { 1, 1, 0, 1, 0 },
                { 0, 1, 1, 0, 1 },
                { 1, 1, 0, 1, 0 }
        };

        hamiltonianCycle hc = new hamiltonianCycle(graph);
        hc.isHamiltonianCycle();
    }
}
