import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            HashSet<Integer>[] rowSets = new HashSet[n];
            HashSet<Integer>[] colSets = new HashSet[n];
            
            int trace = 0, duplicateRows = 0, duplicateCols = 0;

            for (int i = 0; i < n; i++) {
                rowSets[i] = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (colSets[j] == null) {
                        colSets[j] = new HashSet<>();
                    }
                    matrix[i][j] = scanner.nextInt();
                    rowSets[i].add(matrix[i][j]);
                    colSets[j].add(matrix[i][j]);
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                if (rowSets[i].size() != n) {
                    duplicateRows++;
                }
                if (colSets[i].size() != n) {
                    duplicateCols++;
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
        
        scanner.close();
    }
}