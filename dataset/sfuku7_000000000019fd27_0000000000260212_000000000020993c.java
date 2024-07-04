import java.util.*;
import java.io.*;
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        StringBuilder ans = new StringBuilder();
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] M = new int[N][N];
            int k = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                    if (i == j) {
                        k += M[i][j];
                    }
                }
            }

            int r = 0;
            for (int i = 0; i < N; i++) {
                boolean valid = true;
                Set<Integer> set = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    if (set.contains(M[i][j])) {
                        valid = false;
                        break;
                    }
                    set.add(M[i][j]);
                }
                if (!valid) {
                    r++;
                }
            }

            int c = 0;
            for (int j = 0; j < N; j++) {
                boolean valid = true;
                Set<Integer> set = new HashSet<>();
                for (int i = 0; i < N; i++) {
                    if (set.contains(M[i][j])) {
                        valid = false;
                        break;
                    }
                    set.add(M[i][j]);
                }
                if (!valid) {
                    c++;
                }
            }

            ans.append("Case #"+t+": "+k+" "+r+" "+c+"\n");
 
        }
        System.out.print(ans);
    }
}

