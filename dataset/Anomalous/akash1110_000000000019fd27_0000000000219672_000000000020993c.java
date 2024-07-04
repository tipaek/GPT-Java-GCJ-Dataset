import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MatrixAnalysis {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int caseRuns = input.nextInt();
        for (int caseNumber = 1; caseNumber <= caseRuns; caseNumber++) {
            int matrixSize = input.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = input.nextInt();
                }
            }

            int trace = calculateTrace(matrix, matrixSize);
            int repeatingRows = countRepeatingRows(matrix, matrixSize);
            int repeatingColumns = countRepeatingColumns(matrix, matrixSize);

            System.out.println("Case #" + caseNumber + ": " + trace + " " + repeatingRows + " " + repeatingColumns);
        }
        input.close();
    }

    static int calculateTrace(int[][] matrix, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    static int countRepeatingRows(int[][] matrix, int size) {
        int repeatingRows = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    repeatingRows++;
                    break;
                }
            }
        }
        return repeatingRows;
    }

    static int countRepeatingColumns(int[][] matrix, int size) {
        int repeatingColumns = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> columnSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!columnSet.add(matrix[j][i])) {
                    repeatingColumns++;
                    break;
                }
            }
        }
        return repeatingColumns;
    }
}