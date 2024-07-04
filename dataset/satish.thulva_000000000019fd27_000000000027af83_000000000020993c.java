import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author satish.thulva. Generated on 04/04/20
 **/
public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numTests = Integer.parseInt(reader.readLine());

            for (int i = 0; i < numTests; i += 1) {
                parseAndProcessTestCase(i + 1, reader);
            }
        }
    }

    private static void parseAndProcessTestCase(int testNumber, BufferedReader reader) throws IOException {
        int matrixSize = Integer.parseInt(reader.readLine());
        int[][] rowSum = new int[matrixSize][matrixSize];
        int[][] columnSum = new int[matrixSize][matrixSize];
        int trace = 0;
        String line = null;
        for (int i = 0; i < matrixSize; i += 1) {
            line = reader.readLine();
            String[] fields = line.split(" ", -1);
            for (int j = 0; j < matrixSize; j += 1) {
                int currentNum = Integer.parseInt(fields[j]);
                if (i == j) {
                    trace += currentNum;
                }
                columnSum[i][j] = i == 0 ? currentNum : columnSum[i - 1][j] + currentNum;
                rowSum[i][j] = j == 0 ? currentNum : rowSum[i][j - 1] + currentNum;
            }
        }

        int[] tempRow = new int[matrixSize + 1];
        int nonUniqueRows = 0, nonUniqueColumns = 0;
        int expectedSum = (matrixSize * (matrixSize + 1)) / 2;
        for (int i = 0; i < matrixSize; i += 1) {
            if (rowSum[i][matrixSize - 1] != expectedSum || !checkRow(i, rowSum, tempRow)) {
                nonUniqueRows += 1;
            }
            if (columnSum[matrixSize - 1][i] != expectedSum || !checkColumn(i, columnSum, tempRow)) {
                nonUniqueColumns += 1;
            }
        }

        System.out.println("Case #" + testNumber + ": " + trace + " " + nonUniqueRows + " " + nonUniqueColumns);
    }

    private static boolean checkRow(int rowIndex, int[][] rowSumMatrix, int[] tempRow) {
        for (int i = 0; i < tempRow.length; i += 1) {
            tempRow[i] = 0;
        }

        for (int i = 0; i < rowSumMatrix.length; i += 1) {
            int num = i == 0 ? rowSumMatrix[rowIndex][i] :
                      rowSumMatrix[rowIndex][i] - rowSumMatrix[rowIndex][i - 1];
            tempRow[num] += 1;
            if (tempRow[num] > 1) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkColumn(int columnIndex, int[][] columnSumMatrix, int[] tempRow) {
        for (int i = 0; i < tempRow.length; i += 1) {
            tempRow[i] = 0;
        }

        for (int i = 0; i < columnSumMatrix.length; i += 1) {
            int num = i == 0 ? columnSumMatrix[i][columnIndex] :
                      columnSumMatrix[i][columnIndex] - columnSumMatrix[i - 1][columnIndex];
            tempRow[num] += 1;
            if (tempRow[num] > 1) {
                return false;
            }
        }

        return true;
    }

}
