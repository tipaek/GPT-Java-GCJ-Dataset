import java.util.*;
import java.io.*;

public class ParentingPartneringReturnsSolution {


    // This class represents an undirected graph using adjacency list
    static class Graph {
        private int V;   // No. of vertices
        private LinkedList<Integer> adj[]; //Adjacency List

        //Constructor
        Graph(int v)
        {
            V = v;
            adj = new LinkedList[v];
            for (int i=0; i<v; ++i)
                adj[i] = new LinkedList();
        }

        //Function to add an edge into the graph
        void addEdge(int v,int w)
        {
            adj[v].add(w);
            adj[w].add(v); //Graph is undirected
        }

        // Assigns colors (starting from 0) to all vertices and
        // prints the assignment of colors
        int[] greedyColoring()
        {
            int result[] = new int[V];

            // Initialize all vertices as unassigned
            Arrays.fill(result, -1);

            // Assign the first color to first vertex
            result[0]  = 0;

            // A temporary array to store the available colors. False
            // value of available[cr] would mean that the color cr is
            // assigned to one of its adjacent vertices
            boolean available[] = new boolean[V];

            // Initially, all colors are available
            Arrays.fill(available, true);

            // Assign colors to remaining V-1 vertices
            for (int u = 1; u < V; u++)
            {
                // Process all adjacent vertices and flag their colors
                // as unavailable
                Iterator<Integer> it = adj[u].iterator() ;
                while (it.hasNext())
                {
                    int i = it.next();
                    if (result[i] != -1)
                        available[result[i]] = false;
                }

                // Find the first available color
                int cr;
                for (cr = 0; cr < V; cr++){
                    if (available[cr])
                        break;
                }

                // CUSTUM
                if ( cr >=2 ) return null;
                result[u] = cr; // Assign the found color

                // Reset the values back to true for the next iteration
                Arrays.fill(available, true);
            }

            return result;

        }

        @Override
        public String toString() {
            String s = "" ;
            for (List<Integer> adjs: adj ) {
                s += adjs + " \n";
            }
            return s ;
        }
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int x = 1; x <= t; ++x) {
            int N = in.nextInt();

            int[][] mat = new int[N][2];

            // fill the matrix
            for (int i = 0; i < N; i++) {
                mat[i][0] = in.nextInt();
                mat[i][1] = in.nextInt();
            }
            // fil the graph
            Graph graph = new Graph(N);
            for (int i = 0 ; i < N ; i++ ) {
                for ( int j = i ; j < N ; j++ ) {
                    if ( j!=i && overlap(mat[i] ,mat[j]) )
                        graph.addEdge(j , i);
                }
            }


            int[] result =  graph.greedyColoring() ;

            // solution
            if (result == null )
                System.out.println("Case #" + x + ": " +"IMPOSSIBLE");
            else {
                StringBuilder s = new StringBuilder();
                for (int u = 0; u < N; u++)
                    s.append((result[u] == 1) ? "J" : "C");
                System.out.println("Case #" + x + ": " +s);
            }
        }
    }

    private static boolean overlap(int[] t1, int[] t2) {
        if ( (t2[0]  <  t1[1] && t2[0] > t1[0]) || (t2[1] > t1[0] && t2[1] < t1[1] ) ) return true ;
        else return false ;
    }

}
