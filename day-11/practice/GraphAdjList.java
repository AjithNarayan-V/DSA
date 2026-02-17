import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GraphAdjList {

    ArrayList<ArrayList<Integer>> graph;
    int V;

    // Constructor to initialize the graph
    public GraphAdjList(int vertices){
        this.V = vertices;
        graph = new ArrayList<>();
        
        // initialize empty list for each vertex
        for(int i = 0; i < V; i++){
            graph.add(new ArrayList<>());
        }
    }

    // Method to add edge
    public void addEdge(int u, int v){
        graph.get(u).add(v);
        graph.get(v).add(u);   // remove this line for directed graph
    }

    // Method to print graph
    public void printGraph(){
        for(int i=0;i<graph.size();i++){
            System.out.print(i + " -> ");
            for(int neighbor : graph.get(i)){
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

      void bfs(int start){

        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> q = new LinkedList<>();

        visited[start] = true;
        q.add(start);
        boolean first = true;

        while(!q.isEmpty()){

            int node = q.poll();
            
            if(!first){
                System.out.print(" ");
            }
            System.out.print(node);
            first = false;

            for(int neighbor : graph.get(node)){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
    }
    boolean firstDFS = true;
    
    void dfs(int node, boolean[] visited){

        visited[node] = true;
        
        if(!firstDFS){
            System.out.print(" ");
        }
        System.out.print(node);
        firstDFS = false;

        for(int neighbor : graph.get(node)){
            if(!visited[neighbor]){
                dfs(neighbor,visited);
            }
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = sc.nextInt();

        // Create graph object
        GraphAdjList graph = new GraphAdjList(V);

        System.out.print("Enter the number of edges: ");
        int E = sc.nextInt();

        System.out.println("Enter the edges (u v) [0 to " + (V-1) + "]:");
        for(int i = 0; i < E; i++){
            System.out.print("Edge " + (i+1) + ": ");
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }

        System.out.println("\nAdjacency List:");
        graph.printGraph();
        System.out.println("\nBFS Traversal starting from vertex 0:");
        graph.bfs(0);
        System.out.println();

        System.out.println("DFS Traversal starting from vertex 0:");
        boolean[] visited = new boolean[V];
        graph.firstDFS = true;
        graph.dfs(0, visited);
        System.out.println();
        sc.close();
    }

}
