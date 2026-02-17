import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GraphHashMap {

    HashMap<Integer, ArrayList<Integer>> graph;

    // Constructor to initialize the graph
    public GraphHashMap(){
        graph = new HashMap<>();
    }

    // Method to add vertex
    public void addVertex(int vertex){
        if(!graph.containsKey(vertex)){
            graph.put(vertex, new ArrayList<>());
        }
        else{
            System.out.println("Vertex " + vertex + " already exists.");
        }
    }

    // Method to add edge with validation
    public boolean addEdge(int u, int v){
        // Check if both vertices exist in the graph
        if(!graph.containsKey(u) || !graph.containsKey(v)){
            System.out.println("Vertex " + u + " or " + v + " does not exist.");
            return false;
        }
        
        graph.get(u).add(v);
        graph.get(v).add(u);   // remove this line for directed graph
        return true;
    }

    // Method to print graph
    public void printGraph(){
        for(int vertex : graph.keySet()){
            System.out.print(vertex + " -> ");

            for(int neighbor : graph.get(vertex)){
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
  // Create graph object
        GraphHashMap graph = new GraphHashMap();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter the vertex numbers: ");
        for(int i = 0; i < V; i++){
           graph.addVertex(sc.nextInt());
        }

        System.out.print("Enter the number of edges: ");
        int E = sc.nextInt();

        System.out.println("Enter the edges (u v):");
        for(int i = 0; i < E; i++){
            System.out.print("Edge " + (i+1) + ": ");
            int u = sc.nextInt();
            int v = sc.nextInt();
            
            // Validate if both vertices exist
            if(!graph.addEdge(u, v)){
                System.out.println("Invalid edge! Vertices " + u + " or " + v + " do not exist.");
                i--; // Retry this edge
            }
        }

        System.out.println("\nAdjacency List (HashMap):");
        graph.printGraph();

        sc.close();
    }

}
