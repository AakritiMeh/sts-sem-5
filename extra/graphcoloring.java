import java.io.*;
import java.util.*;

class Graph {
    private int V; // No. of vertices
    private LinkedList<Integer> adj[];

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v); // Graph is undirected
    }

    void greedyColoring() {
        int result[] = new int[V];
        Arrays.fill(result, -1);
        result[0] = 0;
        boolean available[] = new boolean[V];
        Arrays.fill(available, true);

        for (int u = 1; u < V; u++) {
            for (int i : adj[u]) {
                if (result[i] != -1)
                    available[result[i]] = false;
            }

            int cr;
            for (cr = 0; cr < V; cr++) {
                if (available[cr])
                    break;
            }

            result[u] = cr;
            Arrays.fill(available, true);
        }

        for (int u = 0; u < V; u++)
            System.out.println("Vertex " + u + " ---> Color " + result[u]);
    }

    public static void main(String args[]) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int vertices = scanner.nextInt();

        System.out.println("Enter the number of edges:");
        int edges = scanner.nextInt();

        Graph graph = new Graph(vertices);

        System.out.println("Enter the edges (format: vertex1 vertex2):");
        for (int i = 0; i < edges; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            graph.addEdge(v, w);
        }

        System.out.println("Coloring of the graph:");
        graph.greedyColoring();

        scanner.close();
    }
}
