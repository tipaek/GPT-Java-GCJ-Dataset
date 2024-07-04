import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0, rowRepeats = 0, colRepeats = 0;
            Set<Integer>[] rowSets = new HashSet[matrixSize];
            Set<Integer>[] colSets = new HashSet[matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                rowSets[i] = new HashSet<>();
                colSets[i] = new HashSet<>();
            }

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    rowSets[i].add(matrix[i][j]);
                    colSets[j].add(matrix[i][j]);
                }
            }

            for (int i = 0; i < matrixSize; i++) {
                if (rowSets[i].size() != matrixSize) {
                    rowRepeats++;
                }
                if (colSets[i].size() != matrixSize) {
                    colRepeats++;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        scanner.close();
    }
}