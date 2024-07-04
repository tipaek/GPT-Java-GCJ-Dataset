import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws Exception {
        new Solution().processCases();
    }

    public void processCases() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfCases = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= numberOfCases; i++) {
            handleCase(i, reader);
        }
    }

    public void handleCase(int caseNumber, BufferedReader reader) throws Exception {
        int matrixSize = Integer.parseInt(reader.readLine());
        int[][] matrix = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            String[] rowValues = reader.readLine().split(" ");
            for (int j = 0; j < rowValues.length; j++) {
                matrix[i][j] = Integer.parseInt(rowValues[j]);
            }
        }
        displaySolution(caseNumber, matrixSize, matrix);
    }

    public void displaySolution(int caseNumber, int matrixSize, int[][] matrix) {
        int trace = calculateTrace(matrixSize, matrix);
        int invalidRowCount = countInvalidRows(matrixSize, matrix);
        int invalidColCount = countInvalidColumns(matrixSize, matrix);

        System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, invalidRowCount, invalidColCount);
    }

    public int calculateTrace(int matrixSize, int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrixSize; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    public int countInvalidRows(int matrixSize, int[][] matrix) {
        int invalidRowCount = 0;
        Set<Integer> uniqueElements = new HashSet<>();
        for (int i = 0; i < matrixSize; i++) {
            uniqueElements.clear();
            for (int j = 0; j < matrixSize; j++) {
                if (!uniqueElements.add(matrix[i][j])) {
                    invalidRowCount++;
                    break;
                }
            }
        }
        return invalidRowCount;
    }

    public int countInvalidColumns(int matrixSize, int[][] matrix) {
        int invalidColCount = 0;
        Set<Integer> uniqueElements = new HashSet<>();
        for (int j = 0; j < matrixSize; j++) {
            uniqueElements.clear();
            for (int i = 0; i < matrixSize; i++) {
                if (!uniqueElements.add(matrix[i][j])) {
                    invalidColCount++;
                    break;
                }
            }
        }
        return invalidColCount;
    }
}