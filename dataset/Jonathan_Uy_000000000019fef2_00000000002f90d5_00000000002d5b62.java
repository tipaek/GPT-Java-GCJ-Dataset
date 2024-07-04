import java.io.*;
import java.util.*;

/**
 * Problem 1: Subtask 2
 */

public class Solution {
    static class Pair {
        int x, y, i;
        public Pair(int a, int b, int c){
            x = a; y = b; i = c;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        
        String[][] dp = new String[2001][2001];
        Queue<Pair> Q = new LinkedList<>();
        Q.add(new Pair(1000, 1000, 0));
        dp[1000][1000] = "";
        
        while(!Q.isEmpty()){
            Pair P = Q.remove();
            if(P.y + (1<<P.i) <= 2000 && dp[P.x][P.y + (1<<P.i)] == null){
                dp[P.x][P.y + (1<<P.i)] = dp[P.x][P.y] + "N";
                Q.add(new Pair(P.x, P.y + (1<<P.i), P.i+1));
            }
            if(P.y - (1<<P.i) >= 0 && dp[P.x][P.y - (1<<P.i)] == null){
                dp[P.x][P.y - (1<<P.i)] = dp[P.x][P.y] + "S";
                Q.add(new Pair(P.x, P.y - (1<<P.i), P.i+1));
            }
            if(P.x + (1<<P.i) <= 2000 && dp[P.x + (1<<P.i)][P.y] == null){
                dp[P.x + (1<<P.i)][P.y] = dp[P.x][P.y] + "E";
                Q.add(new Pair(P.x + (1<<P.i), P.y, P.i+1));
            }
            if(P.x - (1<<P.i) >= 0 && dp[P.x - (1<<P.i)][P.y] == null){
                dp[P.x - (1<<P.i)][P.y] = dp[P.x][P.y] + "W";
                Q.add(new Pair(P.x - (1<<P.i), P.y, P.i+1));
            }
        }
        
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            if(-100 <= X && X <= 100 && -100 <= Y && Y <= 100)
                System.out.printf("Case #%d: %s\n", t, dp[X+1000][Y+1000] == null ? "IMPOSSIBLE" : dp[X+1000][Y+1000]);
        }
    }
}