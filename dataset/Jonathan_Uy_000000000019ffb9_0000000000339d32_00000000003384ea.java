import java.io.*;
import java.util.*;

/**
 * Problem 1
 */

public class Solution {
    static BufferedReader br;
    static StringTokenizer st;
    
    public static void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        long L = Long.parseLong(st.nextToken());
        long R = Long.parseLong(st.nextToken());
        
        long N = 1;
        while(N <= Math.max(L,R)){
            if(L >= R){
                L -= N;
            } else {
                R -= N;
            }
            N++;
        }
        N--;
        
        System.out.printf("%d %d %d\n", N, L, R);
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