import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            for (int rowIndex = 0; rowIndex < matrixSize; rowIndex++) {
                Set<Integer> rowSeen = new HashSet<>();
                boolean rowHasRepeats = false;

                for (int colIndex = 0; colIndex < matrixSize; colIndex++) {
                    int value = scanner.nextInt();
                    matrix[rowIndex][colIndex] = value;

                    if (rowIndex == colIndex) {
                        trace += value;
                    }

                    if (!rowSeen.add(value) && !rowHasRepeats) {
                        rowRepeats++;
                        rowHasRepeats = true;
                    }
                }
            }

            for (int colIndex = 0; colIndex < matrixSize; colIndex++) {
                Set<Integer> colSeen = new HashSet<>();

                for (int rowIndex = 0; rowIndex < matrixSize; rowIndex++) {
                    int value = matrix[rowIndex][colIndex];

                    if (!colSeen.add(value)) {
                        colRepeats++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + (caseIndex + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        scanner.close();
    }
}