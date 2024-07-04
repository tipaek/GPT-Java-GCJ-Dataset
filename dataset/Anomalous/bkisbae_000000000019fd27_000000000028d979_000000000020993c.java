import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private static Scanner scanner;
    private static int testCaseNumber = 1;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
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
        int duplicateRows = 0;
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = 0; j < matrix[i].length; j++) {
                if (!seen.add(matrix[i][j])) {
                    duplicateRows++;
                    break;
                }
            }
        }
        return duplicateRows;
    }

    private static int countColumnDuplicates(int[][] matrix) {
        int duplicateColumns = 0;
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = 0; j < matrix.length; j++) {
                if (!seen.add(matrix[j][i])) {
                    duplicateColumns++;
                    break;
                }
            }
        }
        return duplicateColumns;
    }
}