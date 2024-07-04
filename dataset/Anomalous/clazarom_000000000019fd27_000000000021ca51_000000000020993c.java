import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Solution {

    private static final Logger logger = Logger.getLogger(Solution.class.getName());

    public static class Matrix {

        private final int[][] matrix;
        private final int size;

        /**
         * Construct a matrix from lines (array of Strings)
         *
         * @param size  the size of the matrix
         * @param lines the lines containing the matrix values
         */
        public Matrix(int size, String[] lines) {
            this.size = size;
            this.matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                String[] lineValues = lines[i].split(" ");
                for (int j = 0; j < size; j++) {
                    matrix[j][i] = Integer.parseInt(lineValues[j]);
                }
            }
        }

        /**
         * Check if the matrix NxN is a natural Latin square.
         * A matrix is a Latin square if each cell contains one of N different values,
         * and no value is repeated within a row or a column.
         * The trace of a square matrix is the sum of the values on the main diagonal.
         *
         * @param caseNumber the case number
         */
        public void isNaturalLatinSquare(int caseNumber) {
            int trace = 0;
            boolean[] columnRepeated = new boolean[size];
            boolean[] rowRepeated = new boolean[size];
            int repeatedRows = 0;
            int repeatedColumns = 0;

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    int value = matrix[i][j];

                    if (i == j) {
                        trace += value;
                    }

                    for (int ii = i + 1; ii < size; ii++) {
                        if (matrix[ii][j] == value && !rowRepeated[ii]) {
                            rowRepeated[ii] = true;
                            repeatedRows++;
                            break;
                        }
                    }

                    for (int jj = j + 1; jj < size; jj++) {
                        if (matrix[i][jj] == value && !columnRepeated[jj]) {
                            columnRepeated[jj] = true;
                            repeatedColumns++;
                            break;
                        }
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, repeatedRows, repeatedColumns);
        }
    }

    /**
     * Read input file line by line
     *
     * @param inStream the input stream
     * @return an array of strings containing the lines
     */
    public static String[] readInput(InputStream inStream) {
        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException ioe) {
            logger.log(Level.SEVERE, "Error reading input", ioe);
        }

        return lines.toArray(new String[0]);
    }

    /**
     * Main method
     *
     * @param args arguments
     */
    public static void main(String[] args) {
        String[] lines = readInput(System.in);

        if (lines.length > 3) {
            int T = Integer.parseInt(lines[0]);
            Matrix[] matrices = new Matrix[T];

            int lineIndex = 1;
            for (int t = 0; t < T; t++) {
                int N = Integer.parseInt(lines[lineIndex]);
                lineIndex++;
                matrices[t] = new Matrix(N, Arrays.copyOfRange(lines, lineIndex, lineIndex + N));
                lineIndex += N;
            }

            for (int i = 0; i < matrices.length; i++) {
                matrices[i].isNaturalLatinSquare(i + 1);
            }
        } else {
            logger.log(Level.WARNING, "Empty input test file");
        }
    }
}