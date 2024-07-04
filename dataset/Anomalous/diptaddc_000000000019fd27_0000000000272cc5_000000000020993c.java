import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            int trace = 0, rowCount = 0, colCount = 0;
            int n = Integer.parseInt(br.readLine());
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    int value = Integer.parseInt(line[j]);
                    if (i == j) {
                        trace += value;
                    }
                    matrix[i][j] = value;
                }
            }

            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowCount++;
                        break;
                    }
                }
                for (int j = 0; j < n; j++) {
                    if (!colSet.add(matrix[j][i])) {
                        colCount++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowCount + " " + colCount);
        }
    }
}