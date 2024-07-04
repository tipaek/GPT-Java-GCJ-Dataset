import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            System.out.print("Case #" + caseNumber + ": ");
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            for (int row = 0; row < matrixSize; row++) {
                trace += matrix[row][row];
                HashSet<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < matrixSize; col++) {
                    if (!rowSet.add(matrix[row][col])) {
                        rowRepeats++;
                        break;
                    }
                }
            }

            for (int col = 0; col < matrixSize; col++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int row = 0; row < matrixSize; row++) {
                    if (!colSet.add(matrix[row][col])) {
                        colRepeats++;
                        break;
                    }
                }
            }

            System.out.println(trace + " " + rowRepeats + " " + colRepeats);
        }

        scanner.close();
    }
}