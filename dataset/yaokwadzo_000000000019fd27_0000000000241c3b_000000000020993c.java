import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] mx = new int[n][n];
            for(int a=0; a<n; a++){
                for(int b=0; b<n;b++){
                    int o = in.nextInt();
                    mx[a][b] = o;
                }
            }
            int cR = 0;
            int cC = 0;
            int trace = 0;
            Set<Integer> cache = new HashSet<Integer>();
            for(int a=0; a<n; a++) {
                for (int b = 0; b < n; b++) {
                    if (a == b)
                        trace += mx[a][b];
                    cache.add(mx[a][b]);
                }
                if(cache.size() < n)
                    cC++;
                cache.clear();
            }
            for(int a=0; a<n; a++) {
                for (int b = 0; b < n; b++) {
                    cache.add(mx[b][a]);
                }
                if(cache.size() < n) cR++;
                cache.clear();
            }

            System.out.println("Case #" + i + ": " + trace+" "+cC+" "+cR);
        }
    }
}
