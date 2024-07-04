import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private static Scanner scanner;
    private static int testCaseNumber = 1;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        scanner.nextLine();

        while (t-- > 0) {
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

        int duplicateRows = countDuplicateRows(matrix);
        int duplicateColumns = countDuplicateColumns(matrix);

        System.out.println("Case #" + (testCaseNumber++) + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
    }

    private static int countDuplicateRows(int[][] matrix) {
        int duplicateCount = 0;

        for (int[] row : matrix) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int element : row) {
                if (uniqueElements.contains(element)) {
                    duplicateCount++;
                    break;
                }
                uniqueElements.add(element);
            }
        }

        return duplicateCount;
    }

    private static int countDuplicateColumns(int[][] matrix) {
        int duplicateCount = 0;

        for (int col = 0; col < matrix.length; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < matrix.length; row++) {
                if (uniqueElements.contains(matrix[row][col])) {
                    duplicateCount++;
                    break;
                }
                uniqueElements.add(matrix[row][col]);
            }
        }

        return duplicateCount;
    }
}