import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Vestigium {

    public static int countColumnRepeats(String[][] matrix) {
        int repeatCount = 0;
        for (int col = 0; col < matrix.length; col++) {
            for (int row1 = 0; row1 < matrix.length; row1++) {
                for (int row2 = row1 + 1; row2 < matrix.length; row2++) {
                    if (matrix[row1][col].equals(matrix[row2][col])) {
                        repeatCount++;
                        row1 = matrix.length; // Exit outer loop
                        break; // Exit inner loop
                    }
                }
            }
        }
        return repeatCount;
    }

    public static int countRowRepeats(String[][] matrix) {
        int repeatCount = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col1 = 0; col1 < matrix.length; col1++) {
                for (int col2 = col1 + 1; col2 < matrix.length; col2++) {
                    if (matrix[row][col1].equals(matrix[row][col2])) {
                        repeatCount++;
                        col1 = matrix.length; // Exit outer loop
                        break; // Exit inner loop
                    }
                }
            }
        }
        return repeatCount;
    }

    public static int calculateTrace(String[][] matrix) {
        int traceSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            traceSum += Integer.parseInt(matrix[i][i]);
        }
        return traceSum;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = Integer.parseInt(reader.readLine());
            String[][] matrix = new String[n][n];

            for (int i = 0; i < n; i++) {
                matrix[i] = reader.readLine().split(" ");
            }

            int trace = calculateTrace(matrix);
            int rowRepeats = countRowRepeats(matrix);
            int columnRepeats = countColumnRepeats(matrix);

            System.out.println("Case #" + testCase + ": " + trace + " " + rowRepeats + " " + columnRepeats);
        }
    }
}