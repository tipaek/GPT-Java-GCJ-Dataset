import java.util.Scanner;

// JAVA Code to check whether a given
// graph is Bipartite or not
import java.util.*;

class Bipartite {

    private int V ;
    private int[][] G;
    private int[] colorArr;
    public Bipartite(int[][] G) {
        V = G.length;
        this.G = G;
    }

    // This function returns true if graph
    // G[V][V] is Bipartite, else false
    private  boolean isBipartiteUtil(int src)
    {
        colorArr[src] = 1;

        // Create a queue (FIFO) of vertex numbers and
        // enqueue source vertex for BFS traversal
        LinkedList<Integer> q = new LinkedList<Integer>();
        q.add(src);

        // Run while there are vertices in queue
        // (Similar to BFS)
        while (!q.isEmpty())
        {
            // Dequeue a vertex from queue
            // ( Refer http://goo.gl/35oz8 )
            int u = q.getFirst();
            q.pop();

            // Return false if there is a self-loop
            if (G[u][u] == 1)
                return false;

            // Find all non-colored adjacent vertices
            for (int v = 0; v < V; ++v)
            {
                // An edge from u to v exists and
                // destination v is not colored
                if (G[u][v] ==1 && colorArr[v] == -1)
                {
                    // Assign alternate color to this
                    // adjacent v of u
                    colorArr[v] = 1 - colorArr[u];
                    q.push(v);
                }

                // An edge from u to v exists and
                // destination v is colored with same
                // color as u
                else if (G[u][v] ==1 && colorArr[v] ==
                        colorArr[u])
                    return false;
            }
        }

        // If we reach here, then all adjacent vertices
        // can be colored with alternate color
        return true;
    }

    // Returns true if G[][] is Bipartite, else false
    public  boolean isBipartite()
    {
        // Create a color array to store colors assigned
        // to all veritces. Vertex/ number is used as
        // index in this array. The value '-1' of
        // colorArr[i] is used to indicate that no color
        // is assigned to vertex 'i'. The value 1 is used
        // to indicate first color is assigned and value
        // 0 indicates second color is assigned.
        colorArr = new int[V];
        for (int i = 0; i < V; ++i)
            colorArr[i] = -1;

        // This code is to handle disconnected graoh
        for (int i = 0; i < V; i++)
            if (colorArr[i] == -1)
                if (isBipartiteUtil(i) == false)
                    return false;

        return true;
    }

    public int[] getColorArr() {
        return colorArr;
    }

}

public class Solution {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int z = 1; z <= t; z++) {
            String ans;
            int n = sc.nextInt();
            int[][] arr = new int[n][2];
            for(int i = 0; i < n; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            int[][] g = new int[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = i; j < n; j++) {
                    if(i != j && arr[i][1] > arr[j][0] && arr[j][1] > arr[i][0]) {
                        g[i][j] = 1;g[j][i] = 1;
                    }
                }
            }
            Bipartite bipartite = new Bipartite(g);
            boolean isBipartite = bipartite.isBipartite();
            if(!isBipartite) {
                ans = "IMPOSSIBLE";
            }
            else {
                ans = "";
                int[] color = bipartite.getColorArr();
                for(int i = 0; i < color.length; i++) {
                    if(color[i] == 1) {
                        ans += "J";
                    }
                    else {
                        ans += "C";
                    }
                }
            }
            System.out.println("Case #" + z + ": " + ans);
        }
    }
}
