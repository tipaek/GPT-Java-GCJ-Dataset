import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                StringTokenizer str = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(str.nextToken());
                }
            }

            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            // Calculate the trace
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Check for duplicates in rows
            for (int i = 0; i < n; i++) {
                HashSet<Integer> set = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    set.add(matrix[i][j]);
                }
                if (set.size() != n) {
                    rowDuplicates++;
                }
            }

            // Check for duplicates in columns
            for (int j = 0; j < n; j++) {
                HashSet<Integer> set = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    set.add(matrix[i][j]);
                }
                if (set.size() != n) {
                    colDuplicates++;
                }
            }

            out.println("#" + t + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }

        out.flush();
        out.close();
    }
}