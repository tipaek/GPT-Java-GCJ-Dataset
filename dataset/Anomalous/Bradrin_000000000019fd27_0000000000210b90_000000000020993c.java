import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private void solve(Scanner scanner) {
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        
        // Reading the matrix from input
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int rowDuplicates = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                rowSet.add(matrix[i][j]);
            }
            if (rowSet.size() != n) {
                rowDuplicates++;
            }
        }

        int colDuplicates = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                colSet.add(matrix[j][i]);
            }
            if (colSet.size() != n) {
                colDuplicates++;
            }
        }

        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

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