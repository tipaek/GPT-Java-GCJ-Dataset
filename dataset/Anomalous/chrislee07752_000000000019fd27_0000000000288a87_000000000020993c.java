import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scan.nextInt();
            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;
            int[][] matrix = new int[n][n];
            Set<Integer>[] rowSets = new HashSet[n];
            Set<Integer>[] colSets = new HashSet[n];

            for (int j = 0; j < n; j++) {
                rowSets[j] = new HashSet<>();
                colSets[j] = new HashSet<>();
            }

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = scan.nextInt();
                    if (j == k) {
                        trace += matrix[j][k];
                    }
                    rowSets[j].add(matrix[j][k]);
                    colSets[k].add(matrix[j][k]);
                }
            }

            for (int j = 0; j < n; j++) {
                if (rowSets[j].size() < n) {
                    rowDuplicates++;
                }
                if (colSets[j].size() < n) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}