import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Vestigium {

    public static int countColumnRepeats(String[][] matrix) {
        int repeatCount = 0;
        int size = matrix.length;

        for (int col = 0; col < size; col++) {
            boolean[] seen = new boolean[size + 1];
            for (int row = 0; row < size; row++) {
                int value = Integer.parseInt(matrix[row][col]);
                if (seen[value]) {
                    repeatCount++;
                    break;
                }
                seen[value] = true;
            }
        }

        return repeatCount;
    }

    public static int countRowRepeats(String[][] matrix) {
        int repeatCount = 0;
        int size = matrix.length;

        for (int row = 0; row < size; row++) {
            boolean[] seen = new boolean[size + 1];
            for (int col = 0; col < size; col++) {
                int value = Integer.parseInt(matrix[row][col]);
                if (seen[value]) {
                    repeatCount++;
                    break;
                }
                seen[value] = true;
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
            int size = Integer.parseInt(reader.readLine());
            String[][] matrix = new String[size][size];

            for (int i = 0; i < size; i++) {
                matrix[i] = reader.readLine().split(" ");
            }

            int trace = calculateTrace(matrix);
            int rowRepeats = countRowRepeats(matrix);
            int columnRepeats = countColumnRepeats(matrix);

            System.out.println("Case #" + testCase + ": " + trace + " " + rowRepeats + " " + columnRepeats);
        }
    }
}