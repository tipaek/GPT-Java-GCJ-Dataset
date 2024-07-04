import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private static Scanner scanner;
    private static int testCaseNumber = 1;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        int testCases = Integer.parseInt(scanner.nextLine());
        scanner.nextLine();

        while (testCases-- > 0) {
            solve();
        }
    }

    private static void solve() {
        int size = scanner.nextInt();
        int[][] matrix = new int[size][size];

        int diagonalSum = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
                if (i == j) {
                    diagonalSum += matrix[i][j];
                }
            }
        }

        int rowDuplicates = countRowDuplicates(matrix);
        int columnDuplicates = countColumnDuplicates(matrix);

        System.out.println("Case #" + (testCaseNumber++) + ": " + diagonalSum + " " + rowDuplicates + " " + columnDuplicates);
    }

    private static int countRowDuplicates(int[][] matrix) {
        int duplicateCount = 0;

        for (int[] row : matrix) {
            Set<Integer> seen = new HashSet<>();
            for (int value : row) {
                if (!seen.add(value)) {
                    duplicateCount++;
                    break;
                }
            }
        }

        return duplicateCount;
    }

    private static int countColumnDuplicates(int[][] matrix) {
        int duplicateCount = 0;

        for (int col = 0; col < matrix.length; col++) {
            Set<Integer> seen = new HashSet<>();
            for (int row = 0; row < matrix.length; row++) {
                if (!seen.add(matrix[row][col])) {
                    duplicateCount++;
                    break;
                }
            }
        }

        return duplicateCount;
    }
}