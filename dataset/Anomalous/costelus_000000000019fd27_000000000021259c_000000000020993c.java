import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    
    public static void main(String[] args) {
        new Solution().solve();
    }

    private void solve() {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int[][] results = new int[testCases][3];

        for (int t = 0; t < testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = readMatrix(scanner, size);
            results[t][0] = calculateTrace(matrix);
            results[t][1] = countDuplicateRows(matrix);
            results[t][2] = countDuplicateCols(matrix);
        }

        for (int t = 0; t < testCases; t++) {
            System.out.printf("Case #%d: %d %d %d%n", t + 1, results[t][0], results[t][1], results[t][2]);
        }
    }

    private int[][] readMatrix(Scanner scanner, int size) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
            }
            scanner.nextLine();
        }
        return matrix;
    }

    private int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private int countDuplicateRows(int[][] matrix) {
        int duplicateRows = 0;
        for (int[] row : matrix) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int element : row) {
                if (!uniqueElements.add(element)) {
                    duplicateRows++;
                    break;
                }
            }
        }
        return duplicateRows;
    }

    private int countDuplicateCols(int[][] matrix) {
        int duplicateCols = 0;
        for (int col = 0; col < matrix[0].length; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < matrix.length; row++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    duplicateCols++;
                    break;
                }
            }
        }
        return duplicateCols;
    }
}