import java.io.*;
import java.util.regex.Pattern;

public class Solution {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in), 1024);
    private static final PrintWriter WRITER = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out), 1024));

    private static int readInt() throws IOException {
        return Integer.parseInt(READER.readLine());
    }

    private static String readLine() throws IOException {
        return READER.readLine();
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

    private static void processAndWriteCase(int caseNumber, int[][] matrix) {
        int trace = 0;
        int duplicateRows = 0;
        int duplicateColumns = 0;

        int size = matrix.length;

        for (int i = 0; i < size; i++) {
            boolean[] rowCheck = new boolean[size + 1];
            boolean[] columnCheck = new boolean[size + 1];

            for (int j = 0; j < size; j++) {
                // Calculate trace
                if (i == j) {
                    trace += matrix[i][j];
                }

                // Check for duplicate in row
                if (rowCheck[matrix[i][j]]) {
                    duplicateRows++;
                    break;
                }
                rowCheck[matrix[i][j]] = true;

                // Check for duplicate in column
                if (columnCheck[matrix[j][i]]) {
                    duplicateColumns++;
                    break;
                }
                columnCheck[matrix[j][i]] = true;
            }
        }

        WRITER.printf("Case #%d: %d %d %d\n", caseNumber, trace, duplicateRows, duplicateColumns);
    }

    public static void main(String[] args) throws IOException {
        int testCases = readInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = readInt();
            int[][] matrix = readMatrix(matrixSize);
            processAndWriteCase(caseNumber, matrix);
        }
        WRITER.flush();
        WRITER.close();
    }
}