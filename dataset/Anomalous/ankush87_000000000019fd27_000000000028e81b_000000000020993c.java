import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(bufferedReader.readLine());
        String[] answers = new String[numberOfTestCases];

        for (int testCaseInstance = 0; testCaseInstance < numberOfTestCases; testCaseInstance++) {
            int matrixSize = Integer.parseInt(bufferedReader.readLine());
            int[][] matrix = new int[matrixSize][matrixSize];
            int[] matrixRowSum = new int[matrixSize];
            int[] matrixColumnSum = new int[matrixSize];
            int matrixDiagonalSum = 0;
            int expectedSum = matrixSize * (matrixSize + 1) / 2;
            int rowRepeatCount = 0;
            int columnRepeatCount = 0;

            for (int i = 0; i < matrixSize; i++) {
                String[] matrixRowArray = bufferedReader.readLine().split(" ");
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = Integer.parseInt(matrixRowArray[j]);
                    matrixRowSum[i] += matrix[i][j];
                    matrixColumnSum[j] += matrix[i][j];
                    if (i == j) {
                        matrixDiagonalSum += matrix[i][j];
                    }
                }
            }

            for (int i = 0; i < matrixSize; i++) {
                if (matrixRowSum[i] != expectedSum) {
                    rowRepeatCount++;
                }
                if (matrixColumnSum[i] != expectedSum) {
                    columnRepeatCount++;
                }
            }

            answers[testCaseInstance] = matrixDiagonalSum + " " + rowRepeatCount + " " + columnRepeatCount;
        }

        for (int i = 0; i < numberOfTestCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + answers[i]);
        }
    }
}