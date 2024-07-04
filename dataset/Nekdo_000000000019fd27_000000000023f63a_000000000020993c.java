import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(f.readLine());
        PrintWriter out = new PrintWriter(System.out);
        for (int t1 = 1; t1 <= t; t1++) {
            int n = Integer.parseInt(f.readLine());
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer tokenizer = new StringTokenizer(f.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            int diagonal = 0;
            for (int i = 0, j = 0; i < n; i++, j++) {
                diagonal += map[i][j];
            }

            int rows = 0;
            for (int i = 0; i < n; i++) {
                HashSet<Integer> set = new HashSet<Integer>();
                for (int j = 0; j < n; j++) {
                    set.add(map[i][j]);
                }
                if (set.size() != n) {
                    rows++;
                }
            }

            int columns = 0;
            for (int i = 0; i < n; i++) {
                HashSet<Integer> set = new HashSet<Integer>();
                for (int j = 0; j < n; j++) {
                    set.add(map[j][i]);
                }
                if (set.size() != n) {
                    columns++;
                }
            }

            out.print("Case #");
            out.print(t1);
            out.print(": ");
            out.print(diagonal);
            out.print(" ");
            out.print(rows);
            out.print(" ");
            out.println(columns);
        }
        out.close();
    }
}
