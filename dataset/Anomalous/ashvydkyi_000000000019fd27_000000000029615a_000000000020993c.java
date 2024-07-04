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
            int[] row = Pattern.compile(" ").splitAsStream(readLine())
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = row;
        }
        return matrix;
    }

    private static void printResult(int caseNumber, int[][] matrix) {
        int trace = 0;
        int repeatedRows = 0;
        int repeatedColumns = 0;

        for (int i = 0; i < matrix.length; i++) {
            boolean[] rowCheck = new boolean[matrix.length + 1];
            boolean[] columnCheck = new boolean[matrix.length + 1];
            boolean rowHasDuplicate = false;
            boolean columnHasDuplicate = false;

            for (int j = 0; j < matrix.length; j++) {
                if (i == j) trace += matrix[i][j];

                if (!rowHasDuplicate && rowCheck[matrix[i][j]]) {
                    repeatedRows++;
                    rowHasDuplicate = true;
                }
                rowCheck[matrix[i][j]] = true;

                if (!columnHasDuplicate && columnCheck[matrix[j][i]]) {
                    repeatedColumns++;
                    columnHasDuplicate = true;
                }
                columnCheck[matrix[j][i]] = true;
            }
        }
        WRITER.println("Case #" + caseNumber + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
    }

    public static void main(String[] args) throws IOException {
        int testCases = readInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = readInt();
            int[][] matrix = readMatrix(matrixSize);
            printResult(caseNumber, matrix);
        }
        WRITER.flush();
        WRITER.close();
    }
}