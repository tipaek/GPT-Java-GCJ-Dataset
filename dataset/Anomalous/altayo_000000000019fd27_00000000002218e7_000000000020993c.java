import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[matrixSize][matrixSize];
            Set<Integer>[] rowSets = new Set[matrixSize];
            Set<Integer>[] colSets = new Set[matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                rowSets[i] = new HashSet<>();
                colSets[i] = new HashSet<>();
            }

            int trace = 0;
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                    rowSets[row].add(matrix[row][col]);
                    colSets[col].add(matrix[row][col]);
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }
            scanner.nextLine();  // Consume the remaining newline

            int repeatedRows = 0;
            int repeatedCols = 0;

            for (int i = 0; i < matrixSize; i++) {
                if (rowSets[i].size() < matrixSize) {
                    repeatedRows++;
                }
                if (colSets[i].size() < matrixSize) {
                    repeatedCols++;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + repeatedRows + " " + repeatedCols);
        }
    }
}