import java.util.*;
import java.io.*;

public class Solution {

    public static class mColoringProblem {
         int V = 4;
        int[] color;

        /* A utility function to check if the current
           color assignment is safe for vertex v */
        boolean isSafe(int v, int graph[][], int color[],
                       int c)
        {
            for (int i = 0; i < V; i++)
                if (graph[v][i] == 1 && c == color[i])
                    return false;
            return true;
        }

        /* A recursive utility function to solve m
           coloring  problem */
        boolean graphColoringUtil(int graph[][], int m,
                                  int color[], int v)
        {
        /* base case: If all vertices are assigned
           a color then return true */
            if (v == V)
                return true;

        /* Consider this vertex v and try different
           colors */
            for (int c = 1; c <= m; c++)
            {
            /* Check if assignment of color c to v
               is fine*/
                if (isSafe(v, graph, color, c))
                {
                    color[v] = c;

                /* recur to assign colors to rest
                   of the vertices */
                    if (graphColoringUtil(graph, m,
                            color, v + 1))
                        return true;

                /* If assigning color c doesn't lead
                   to a solution then remove it */
                    color[v] = 0;
                }
            }

        /* If no color can be assigned to this vertex
           then return false */
            return false;
        }

        /* This function solves the m Coloring problem using
           Backtracking. It mainly uses graphColoringUtil()
           to solve the problem. It returns false if the m
           colors cannot be assigned, otherwise return true
           and  prints assignments of colors to all vertices.
           Please note that there  may be more than one
           solutions, this function prints one of the
           feasible solutions.*/
        int[] graphColoring(int[][] graph, int m)
        {
            // Initialize all color values as 0. This
            // initialization is needed correct functioning
            // of isSafe()
            color = new int[V];
            for (int i = 0; i < V; i++)
                color[i] = 0;

            // Call graphColoringUtil() for vertex 0
            if (!graphColoringUtil(graph, m, color, 0))
            {
                //System.out.println("Solution does not exist");
                return null;
            }

            // Print the solution
            //printSolution(color);
            return color ;

        }
        /* A utility function to print solution */
        void printSolution(int color[])
        {
            System.out.println("Solution Exists: Following" +
                    " are the assigned colors");
            for (int i = 0; i < V; i++)
                System.out.print(" " + color[i] + " ");
            System.out.println();
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
            int[][] graph = new int[N][N];
            for (int i = 0 ; i < N ; i++ ) {
                for ( int j = i ; j < N ; j++ ) {
                    if ( j!=i && overlap(mat[i] ,mat[j]) ) {
                        graph[i][j] = 1 ; graph[j][i] = 1 ;
                    }
                }
            }

//            System.out.println();
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < N; j++) {
//                    System.out.print(graph[i][j] + " ");
//                }
//                System.out.println();
//            }

            mColoringProblem coloringProblem = new mColoringProblem();
            coloringProblem.V = N ;

            int[] result =  coloringProblem.graphColoring(graph , 2) ;

            // solution
            if (result == null )
                System.out.println("Case #" + x + ": " +"IMPOSSIBLE");
            else {
                StringBuilder s = new StringBuilder();
                for (int u = 0; u < N; u++)
                    s.append((result[u] == 1) ? "C" : "J");
                System.out.println("Case #" + x + ": " +s);
            }
        }
    }

    private static boolean overlap(int[] t1, int[] t2) {
        if ( (t2[0]  <  t1[1] && t2[0] > t1[0]) || (t2[1] > t1[0] && t2[1] < t1[1] ) ) return true ;
        else return false ;
    }

}
