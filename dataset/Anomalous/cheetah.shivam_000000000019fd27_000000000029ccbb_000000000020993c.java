import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < numberOfTestCases; i++) {
            int sizeOfMatrix = Integer.parseInt(bufferedReader.readLine());
            int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];

            for (int j = 0; j < sizeOfMatrix; j++) {
                String[] inputLines = bufferedReader.readLine().split(" ");
                for (int k = 0; k < sizeOfMatrix; k++) {
                    matrix[j][k] = Integer.parseInt(inputLines[k]);
                }
            }

            calculateOutput(matrix, i);
        }
    }

    public static void calculateOutput(int[][] matrix, int caseNumber) {
        int numberOfRowsWithRepeatedValues = 0;
        int numberOfColumnsWithRepeatedValues = 0;
        int traceCount = 0;

        int size = matrix.length;

        for (int i = 0; i < size; i++) {
            int[] rowNumberCount = new int[size];
            int[] columnNumberCount = new int[size];

            for (int j = 0; j < size; j++) {
                rowNumberCount[matrix[i][j] - 1]++;
                columnNumberCount[matrix[j][i] - 1]++;

                if (i == j) {
                    traceCount += matrix[i][j];
                }
            }

            if (hasRepeatedValues(rowNumberCount)) {
                numberOfRowsWithRepeatedValues++;
            }

            if (hasRepeatedValues(columnNumberCount)) {
                numberOfColumnsWithRepeatedValues++;
            }
        }

        String outputString = String.format("Case #%d: %d %d %d", caseNumber + 1, traceCount, numberOfColumnsWithRepeatedValues, numberOfRowsWithRepeatedValues);
        System.out.println(outputString);
    }

    private static boolean hasRepeatedValues(int[] countArray) {
        for (int count : countArray) {
            if (count > 1) {
                return true;
            }
        }
        return false;
    }
}