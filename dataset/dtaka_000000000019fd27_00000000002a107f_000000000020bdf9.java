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
            int[][] a = new int[N][4];
            for (int i = 0; i < N; i++) {
                line = stdin.readLine();
                String[] strs = line.split(" ");
                int S = Integer.parseInt(strs[0]);
                int E = Integer.parseInt(strs[1]);
                a[i][0] = i;
                a[i][1] = S;
                a[i][2] = E;
            }
            int CS = 0;
            int CE = 0;
            int JS = 0;
            int JE = 0;
            
            Arrays.sort(a, new Comparator<int[]>() {
                public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o1[1], o2[1]);
                }
            });
            
            boolean f = false;
            for (int i = 0; i < N; i++) {
                if (CE <= a[i][1]) {
                    CS = a[i][1];
                    CE = a[i][2];
                    a[i][3] = 1;
                } else if (JE <= a[i][1]) {
                    JS = a[i][1];
                    JE = a[i][2];
                    a[i][3] = 2;
                } else {
                    f = true;
                    break;
                }
            }
            
            if (f) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", t);
            } else {
                Arrays.sort(a, new Comparator<int[]>() {
                    public int compare(int[] o1, int[] o2) {
                        return Integer.compare(o1[0], o2[0]);
                    }
                });
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < N; i++) {
                    if (a[i][3] == 1) {
                        sb.append('C');
                    } else {
                        sb.append('J');
                    }
                }
                String p = sb.toString();
                System.out.printf("Case #%d: %s\n", t, p);
            }
        }
    }
}
