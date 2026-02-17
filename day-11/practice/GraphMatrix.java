import java.util.Scanner;
public class GraphMatrix {

    static void addEdge(int[][] graph, int u, int v){

        graph[u][v] = 1;
        graph[v][u] = 1;   // remove for directed graph
    }

    static void printGraph(int[][] graph){

        for(int i=0;i<graph.length;i++){

            for(int j=0;j<graph[i].length;j++){
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // int [][] graph= {
        //     {0,1,1,0,0},
        //     {1,0,0,1,0},
        //     {1,0,0,0,1},
        //     {0,1,0,0,0},
        //     {0,0,1,0,0}
        // };

        // addEdge(graph,2,3);
        // addEdge(graph,3,4);
        // printGraph(graph);

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = sc.nextInt();

        int[][] graph = new int[V][V];

        System.out.print("Enter the number of edges: ");
        int E = sc.nextInt();

        System.out.println("Enter the edges (u v):");
        for(int i = 0; i < E; i++){
            System.out.print("Edge " + (i+1) + ": ");
            int u = sc.nextInt();
            int v = sc.nextInt();
            addEdge(graph, u-1, v-1);
        }

        System.out.println("\nAdjacency Matrix:");
        printGraph(graph);

    }


}
