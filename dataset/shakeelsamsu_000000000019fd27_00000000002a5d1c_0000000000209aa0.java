import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int t = Integer.parseInt(in.readLine());
        for(int tt = 1; tt <= t; tt++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            boolean p = false;
            int x = 0;
            int[][] matrix = new int[n][n];
            if(k % n == 0) {
                String res = "Case #" + tt + ": POSSIBLE\n";
                for(int i = 0; i < n; i++) {
                    matrix[i][i] = k/n;
                }
                for(int i = 0; i < n; i++) {
                    int a = (Math.pow(n, 2) == k) ? 1 : 0;
                    int b = n - 1;
                    for(int j = i + 1; j < n; j++) {
                        if(n - a == k / n) a++;
                        if(n - b == k / n) b--;
                        matrix[i][j] = n - a;
                        matrix[j][i] = n - b;
                        a++;
                        b--;
                    }
                }

                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < n; j++) {
                        res += matrix[i][j] + " ";
                    }
                    res = res.substring(0, res.length() - 1);
                    res += "\n";
                }
                out.print(res);
            }
            else {
                out.println("Case #" + tt + ": IMPOSSIBLE");
            }
        }
        out.close();
    }
}