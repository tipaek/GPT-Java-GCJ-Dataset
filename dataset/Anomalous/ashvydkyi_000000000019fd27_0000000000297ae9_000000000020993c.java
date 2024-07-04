import java.io.*;
import java.util.regex.Pattern;

public class Solution {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1024);
    private static final PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out), 1024));

    private static int readInt() throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static String readLine() throws IOException {
        return reader.readLine();
    }

    private static int[][] readMatrix(int size) throws IOException {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i] = Pattern.compile(" ").splitAsStream(readLine())
                                .mapToInt(Integer::parseInt)
                                .toArray();
        }
        return matrix;
    }

    private static void processCase(int caseNumber, int[][] matrix) {
        int trace = 0;
        int repeatedRows = 0;
        int repeatedColumns = 0;

        for (int i = 0; i < matrix.length; i++) {
            int[] rowCount = new int[matrix.length + 1];
            int[] colCount = new int[matrix.length + 1];

            for (int j = 0; j < matrix.length; j++) {
                if (i == j) trace += matrix[i][j];
                rowCount[matrix[i][j]]++;
                colCount[matrix[j][i]]++;
            }

            if (hasRepeatedElements(rowCount)) repeatedRows++;
            if (hasRepeatedElements(colCount)) repeatedColumns++;
        }

        writer.println("Case #" + caseNumber + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
    }

    private static boolean hasRepeatedElements(int[] count) {
        for (int i = 1; i < count.length; i++) {
            if (count[i] > 1) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        int testCases = readInt();
        for (int i = 1; i <= testCases; i++) {
            int matrixSize = readInt();
            int[][] matrix = readMatrix(matrixSize);
            processCase(i, matrix);
        }
        writer.flush();
        writer.close();
    }
}