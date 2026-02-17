
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
public class Dijikstra {
    ArrayList<ArrayList<int[]>> graph;
    int V;

    public Dijikstra(int vertexes) {
        this.V = vertexes;
        graph = new ArrayList<>();
        for (int i = 0; i < vertexes; i++) {
            graph.add(new ArrayList<>());
        }
    }
    
    void AddEdges(int u, int v, int weight){
        graph.get(u).add(new int[]{v, weight});
        graph.get(v).add(new int[]{u, weight});
    }

    void PrintArray(){
        for(int i = 0; i < graph.size(); i++){
            System.out.print(i + " -> ");
            for(int[] edge : graph.get(i)){
                System.out.print("(" + edge[0] + ", w:" + edge[1] + ") ");
            }
            System.out.println();
        }
    }

    void dijkstra(int src) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[1] - b[1]
        );
        int[] dist = new int[V];
        // Initialize distances
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        pq.offer(new int[]{src, 0});
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int d = current[1];
            for (int[] neighbor : graph.get(node)) {
                int next = neighbor[0];
                int weight = neighbor[1];
                if (d + weight < dist[next]) {
                    dist[next] = d + weight;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }
        // Print shortest distances
        System.out.println("\nShortest distances from source " + src + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + " : " + (dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter no of vertex");
        int V = sc.nextInt();
        Dijikstra graph = new Dijikstra(V);
        System.out.println("enter No of Edges");
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            System.out.println("Enter u, v and weight");
            int u = sc.nextInt();
            int v = sc.nextInt();
            int weight = sc.nextInt();
            graph.AddEdges(u, v, weight);
        }
        graph.PrintArray();
        System.out.println("\nEnter source vertex for Dijkstra:");
        int source = sc.nextInt();
        graph.dijkstra(source);
        sc.close();
    }
    
}