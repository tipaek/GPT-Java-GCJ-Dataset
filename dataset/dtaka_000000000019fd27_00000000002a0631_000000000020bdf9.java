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
            int[] s = new int[24*60+1];
            int[][] a = new int[N][2];
            for (int i = 0; i < N; i++) {
                line = stdin.readLine();
                String[] strs = line.split(" ");
                int S = Integer.parseInt(strs[0]);
                int E = Integer.parseInt(strs[1]);
                s[S]++;
                s[E]--;
                a[i][0] = i;
                a[i][1] = S;
            }
            boolean f = false;
            for (int i = 1; i <= 24*60; i++) {
                s[i] += s[i-1];
                if (s[i] > 2) {
                    f = true;
                    break;
                }
            }
            if (f) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", t);
            } else {
                Arrays.sort(a, new Comparator<int[]>() {
                    public int compare(int[] o1, int[] o2) {
                        return Integer.compare(o2[1], o1[1]);
                    }
                });
                char[] chs = new char[N];
                boolean c = true;
                for (int i = 0; i < N; i++) {
                    if (c) {
                        chs[a[i][0]] = 'C';
                    } else {
                        chs[a[i][0]] = 'J';
                    }
                    c = !c;
                }
                String p = new String(chs);
                System.out.printf("Case #%d: %s\n", t, p);
            }
        }
    }
}
