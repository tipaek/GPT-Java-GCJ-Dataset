import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scan.nextInt();
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;
            
            int[][] matrix = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = scan.nextInt();
                    if (j == k) {
                        trace += matrix[j][k];
                    }
                }
            }

            // Check for repeated elements in rows
            for (int j = 0; j < n; j++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    if (!rowSet.add(matrix[j][k])) {
                        rowRepeats++;
                        break;
                    }
                }
            }

            // Check for repeated elements in columns
            for (int k = 0; k < n; k++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!colSet.add(matrix[j][k])) {
                        colRepeats++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}