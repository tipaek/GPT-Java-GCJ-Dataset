import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine().trim());

        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(reader.readLine().trim());
            int[][] matrix = new int[n][n];

            HashSet<Integer>[] rowSets = new HashSet[n];
            HashSet<Integer>[] colSets = new HashSet[n];

            for (int i = 0; i < n; i++) {
                rowSets[i] = new HashSet<>();
                colSets[i] = new HashSet<>();
            }

            int trace = 0;
            for (int i = 0; i < n; i++) {
                String[] line = reader.readLine().trim().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(line[j]);
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int rowDuplicates = 0;
            int colDuplicates = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!rowSets[i].add(matrix[i][j])) {
                        rowDuplicates++;
                        break;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n; i++) {
                    if (!colSets[j].add(matrix[i][j])) {
                        colDuplicates++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + tc + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}