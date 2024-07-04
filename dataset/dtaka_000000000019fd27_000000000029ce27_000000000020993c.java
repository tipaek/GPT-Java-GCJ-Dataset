import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String line = stdin.readLine();
        int T = Integer.parseInt(line);
        
        for (int t = 1; t <= T; t++) {
            line = stdin.readLine();
            int N = Integer.parseInt(line);
            
            int k = 0;
            int r = 0;
            int c = 0;
            boolean[] fc = new boolean[N];
            boolean[] fr = new boolean[N];
            boolean[][] uc = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                line = stdin.readLine();
                String[] strs = line.split(" ");
                boolean[] ur = new boolean[N];
                for (int j = 0; j < N; j++) {
                    int v = (int)(strs[j].charAt(0) - '0');
                    if (ur[v-1]) fr[i] = true;
                    if (uc[j][v-1]) fc[j] = true;
                    ur[v-1] = true;
                    uc[j][v-1] = true;
                    if (i == j) k += v;
                }
            }
            for (int i = 0; i < N; i++) {
                if (fr[i]) r++;
                if (fc[i]) c++;
            }
            
            System.out.printf("Case #%d: %d %d %d\n", t, k, r, c);
        }
    }
}
