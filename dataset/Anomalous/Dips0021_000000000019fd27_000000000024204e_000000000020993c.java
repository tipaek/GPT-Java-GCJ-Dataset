import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int k = 1; k <= T; k++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            // Calculate the trace
            for (int i = 0; i < n; i++) {
                trace += arr[i][i];
            }

            // Check for row repetitions
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    rowSet.add(arr[i][j]);
                }
                if (rowSet.size() < n) {
                    rowRepeats++;
                }
            }

            // Check for column repetitions
            for (int i = 0; i < n; i++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    colSet.add(arr[j][i]);
                }
                if (colSet.size() < n) {
                    colRepeats++;
                }
            }

            // Print the result for the current test case
            System.out.println("Case #" + k + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}