import java.util.Scanner;

public class Solution {
    private static final String OUTPUT_FORMAT = "Case #%d: %d %d %d";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int caseNum = 1; caseNum <= testCases; caseNum++) {
                processTestCase(caseNum, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void processTestCase(int caseNum, Scanner scanner) {
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

        System.out.println(String.format(OUTPUT_FORMAT, caseNum, diagonalSum, rowDuplicates, columnDuplicates));
    }

    private static int calculateDiagonalSum(int[][] matrix, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int countRowDuplicates(int[][] matrix, int size) {
        int duplicateCount = 0;
        for (int i = 0; i < size; i++) {
            boolean[] used = new boolean[size + 1];
            for (int j = 0; j < size; j++) {
                if (used[matrix[i][j]]) {
                    duplicateCount++;
                    break;
                }
                used[matrix[i][j]] = true;
            }
        }
        return duplicateCount;
    }

    private static int countColumnDuplicates(int[][] matrix, int size) {
        int duplicateCount = 0;
        for (int i = 0; i < size; i++) {
            boolean[] used = new boolean[size + 1];
            for (int j = 0; j < size; j++) {
                if (used[matrix[j][i]]) {
                    duplicateCount++;
                    break;
                }
                used[matrix[j][i]] = true;
            }
        }
        return duplicateCount;
    }
}