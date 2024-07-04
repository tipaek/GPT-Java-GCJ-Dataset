import java.io.*;
import java.util.*;

/**
 * Problem 2
 */

public class Solution {
    static BufferedReader br;
    static StringTokenizer st;
    
    static class Edge {
        int v, id;
        public Edge(int a, int b){
            v = a; id = b;
        }
    }
    
    public static void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        
        ArrayList<Edge>[] G = new ArrayList[C+1];
        boolean[] done = new boolean[C+1];
        int[] steps = new int[C+1];
        done[1] = true;
        for(int i = 1; i <= C; i++)
            G[i] = new ArrayList<Edge>();
        
        boolean allNegative = true;
        st = new StringTokenizer(br.readLine());
        for(int i = 2; i <= C; i++){
            steps[i] = Integer.parseInt(st.nextToken());
            if(steps[i] > 0)    allNegative = false;
        }
        
        int[] latency = new int[D+1];
        for(int i = 1; i <= D; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            G[u].add(new Edge(v, i));
            G[v].add(new Edge(u, i));
        }
        
        if(allNegative){
            for(int i = -1; i >= -100; i--){
                for(int c = 1; c <= C; c++){
                    if(steps[c] == i){
                        for(Edge e : G[c]){
                            if(done[e.v]){
                                latency[e.id] = steps[e.v] - i;
                            }
                        }
                        done[c] = true;
                    }
                }
            }
            for(int i = 1; i <= D; i++)
                if(latency[i] == 0)
                    latency[i] = 1000000;
            for(int i = 1; i < D; i++)
                System.out.print(latency[i] + " ");
            System.out.println(latency[D]);
        } else {
            System.out.println(":(");
        }
    }
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            System.out.printf("Case #%d: ", t);
            solve();
        }
    }
}