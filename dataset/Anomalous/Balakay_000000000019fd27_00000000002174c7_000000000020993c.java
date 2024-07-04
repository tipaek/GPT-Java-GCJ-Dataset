import java.util.HashSet;
import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int diagonalSum = calculateDiagonalSum(matrix, n);
            int rowDuplicates = countRowDuplicates(matrix, n);
            int columnDuplicates = countColumnDuplicates(matrix, n);

            System.out.println("Case #" + caseNum + ": " + diagonalSum + " " + rowDuplicates + " " + columnDuplicates);
        }
    }

    private static int calculateDiagonalSum(int[][] matrix, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int countRowDuplicates(int[][] matrix, int n) {
        int duplicateCount = 0;

        for (int i = 0; i < n; i++) {
            HashSet<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    duplicateCount++;
                    break;
                }
            }
        }

        return duplicateCount;
    }

    private static int countColumnDuplicates(int[][] matrix, int n) {
        int duplicateCount = 0;

        for (int i = 0; i < n; i++) {
            HashSet<Integer> columnSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!columnSet.add(matrix[j][i])) {
                    duplicateCount++;
                    break;
                }
            }
        }

        return duplicateCount;
    }
}