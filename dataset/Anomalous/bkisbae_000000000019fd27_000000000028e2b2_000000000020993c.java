import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 0; t < testCases; t++) {
            solve();
        }
    }

    private static void solve() {
        int size = scanner.nextInt();
        int[][] matrix = new int[size][size];
        int trace = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
                if (i == j) {
                    trace += matrix[i][j];
                }
            }
        }

        int rowDuplicates = countRowDuplicates(matrix);
        int colDuplicates = countColumnDuplicates(matrix);

        // Uncomment the following line to print the result
        // System.out.println("Case #" + (n++) + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
    }

    private static int countRowDuplicates(int[][] matrix) {
        int duplicateCount = 0;
        for (int[] row : matrix) {
            Set<Integer> seen = new HashSet<>();
            for (int value : row) {
                if (seen.contains(value)) {
                    duplicateCount++;
                    break;
                }
                seen.add(value);
            }
        }
        return duplicateCount;
    }

    private static int countColumnDuplicates(int[][] matrix) {
        int duplicateCount = 0;
        int size = matrix.length;
        for (int col = 0; col < size; col++) {
            Set<Integer> seen = new HashSet<>();
            for (int row = 0; row < size; row++) {
                if (seen.contains(matrix[row][col])) {
                    duplicateCount++;
                    break;
                }
                seen.add(matrix[row][col]);
            }
        }
        return duplicateCount;
    }
}