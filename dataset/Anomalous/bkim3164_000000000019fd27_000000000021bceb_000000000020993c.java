import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            System.out.print("Case #" + caseNum + ": ");
            solve(scanner);
            System.out.println();
        }
        scanner.close();
    }

    static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        int diagonalSum = 0;
        int rowRepeats = 0;
        int columnRepeats = 0;

        // Read matrix and calculate diagonal sum
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
                if (i == j) {
                    diagonalSum += matrix[i][j];
                }
            }
        }

        // Check for row repeats
        for (int i = 0; i < n; i++) {
            if (hasDuplicates(matrix[i])) {
                rowRepeats++;
            }
        }

        // Check for column repeats
        for (int j = 0; j < n; j++) {
            int[] column = new int[n];
            for (int i = 0; i < n; i++) {
                column[i] = matrix[i][j];
            }
            if (hasDuplicates(column)) {
                columnRepeats++;
            }
        }

        // Output results
        System.out.print(diagonalSum + " " + rowRepeats + " " + columnRepeats);
    }

    static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}