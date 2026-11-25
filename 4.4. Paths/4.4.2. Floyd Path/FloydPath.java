import java.util.ArrayList;
import java.util.List;

public class FloydPath {
    static int INF = (int)1e8;

    public static void floyd_warshall(int V, int[][] dist, int[][] next) {
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] == INF || dist[k][j] == INF) {
                        continue;
                    } if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
    }

    public static List<Integer> construct_path(int u, int v, int[][] graph, int[][] next) {
        List<Integer> path = new ArrayList<>();
        path.add(u);
        while (u != v) {
            u = next[u][v];
            path.add(u);
        }
        return path;
    }

    public static void print_path(List<Integer> path) {
        int n = path.size();
        for (int i = 0; i < n - 1; i++) {
            System.out.print(path.get(i) + " -> ");
        }
        System.out.println(path.getLast());
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] graph = {{0, 1, INF, INF, INF},
                {INF, 0, 1, INF, INF},
                {INF, INF, 0, 1, INF},
                {INF, INF, INF, 0, 1},
                {INF, INF, INF, INF, 0}};

        int[][] dist = new int[V][V];
        int[][] next = new int[V][V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
                next[i][j] = j;
            }
        }

        floyd_warshall(V, dist, next);
        System.out.print("The shortest path from 0 to 4: ");
        List<Integer> path = construct_path(0, 4, graph, next);
        print_path(path);
        System.out.println("Distance from 0 to 4: " + dist[0][4]);
    }
}
