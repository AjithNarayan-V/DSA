
import java.util.ArrayList;
import java.util.Scanner;
public class WeightedGraph {
    ArrayList<ArrayList<int[]>> graph;
    int V;

    public WeightedGraph(int vertexes) {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter no of vertex");
        int V = sc.nextInt();
        WeightedGraph graph = new WeightedGraph(V);
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
        sc.close();
    }
    
}