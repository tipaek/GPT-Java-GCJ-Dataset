import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private void solve(Scanner scanner) {
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];

        // Reading the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Calculate the trace
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

        // Calculate row duplicates
        int rowDuplicates = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < n; j++) {
                uniqueElements.add(matrix[i][j]);
            }
            if (uniqueElements.size() != n) {
                rowDuplicates++;
            }
        }

        // Calculate column duplicates
        int colDuplicates = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < n; j++) {
                uniqueElements.add(matrix[j][i]);
            }
            if (uniqueElements.size() != n) {
                colDuplicates++;
            }
        }

        // Print the results
        System.out.println(trace + " " + rowDuplicates + " " + colDuplicates);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            new Solution().solve(scanner);
        }
        scanner.close();
    }
}