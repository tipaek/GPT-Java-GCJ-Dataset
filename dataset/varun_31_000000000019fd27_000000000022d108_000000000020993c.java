import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] matrix = new int[n][n];
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            int trace = 0;
            for (int j = 0; j < n; j++) {
                trace += matrix[j][j];
            }
            int noofColsRepeated = 0, noOfRowsRepeated = 0;
            for (int j = 0; j < n; j++) {
                HashSet<Integer> set = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    if (set.contains(matrix[k][j])) {
                        noofColsRepeated++;
                        break;
                    }
                    set.add(matrix[k][j]);
                }
            }
            for (int j = 0; j < n; j++) {
                HashSet<Integer> set = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    if (set.contains(matrix[j][k])) {
                        noOfRowsRepeated++;
                        break;
                    }
                    set.add(matrix[j][k]);
                }
            }
            pw.println("Case #" + i + ": " + trace + " " + noOfRowsRepeated + " " + noofColsRepeated);
        }
        pw.close();
    }
}