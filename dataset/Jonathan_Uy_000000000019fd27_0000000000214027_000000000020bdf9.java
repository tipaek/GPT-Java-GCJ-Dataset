import java.io.*;
import java.util.*;

public class Solution {
    static class Interval {
        int l, r;
        public Interval(int a, int b){
            l = a; r = b;
        }
        boolean intersects(Interval other){
            return (this.r > other.l && this.l < other.r)
                    || (this.r >= other.r && this.l <= other.l);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        
        ArrayList<Integer>[] G = new ArrayList[1000];
        Queue<Integer> Q = new LinkedList<>();
        
        for(int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());
            
            Interval[] times = new Interval[N];
            boolean[] visited = new boolean[N];
            boolean[] black = new boolean[N];
            boolean possible = true;
            
            for(int i = 0; i < N; i++){
                G[i] = new ArrayList<Integer>();
                st = new StringTokenizer(br.readLine());
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                times[i] = new Interval(l, r);
            }
            
            for(int i = 0; i < N; i++)
                for(int j = 0; j < N; j++)
                    if(i != j && times[i].intersects(times[j]))
                        G[i].add(j);
            
            Q.add(0);
            while(!Q.isEmpty()){
                int u = Q.poll();
                for(int v : G[u]){
                    if(!visited[v]){
                        black[v] = !black[u];
                        visited[v] = true;
                        Q.add(v);
                    } else {
                        if(black[u] == black[v]){
                            possible = false;
                        }
                    }
                }
            }
            
            if(!possible){
                System.out.printf("Case #%d: IMPOSSIBLE\n", t);
            } else {
                System.out.printf("Case #%d: ", t);
                for(int i = 0; i < N; i++)
                    System.out.print(black[i] ? 'J' : 'C');
                System.out.println();
            }
        }
    }
}