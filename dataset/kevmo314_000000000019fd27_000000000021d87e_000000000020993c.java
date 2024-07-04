import java.io.*;
import java.util.*;
import java.math.*;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t=  0; t < T; t++) {
            int N = in.nextInt();
            int[][] m = new int[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    m[i][j] = in.nextInt();
                }
            }
            
            int k = 0;
            for(int i = 0; i < N; i++) {
                k += m[i][i];
            }
            int r = 0;
            for(int i = 0; i < N; i++) {
                HashSet<Integer> s = new HashSet<Integer>();
                for(int j = 0; j < N; j++) {
                    s.add(m[i][j]);
                }
                if(s.size() != N) {
                    r++;
                }
            }
            int c = 0;
            for(int i = 0; i < N; i++) {
                HashSet<Integer> s = new HashSet<Integer>();
                for(int j = 0; j < N; j++) {
                    s.add(m[j][i]);
                }
                if(s.size() != N) {
                    c++;
                }
            }
            System.out.format("Case #%d: %d %d %d\n", t + 1, k, r, c);
        }
        
    }
}