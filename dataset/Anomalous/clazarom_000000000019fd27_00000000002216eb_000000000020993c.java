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

    public class Matrix {

        private final int[][] matrix;
        private final int N;

        /**
         * Construct a matrix from lines (array of Strings)
         *
         * @param N     size of the matrix
         * @param lines array of strings representing the matrix
         */
        public Matrix(int N, String[] lines) {
            this.N = N;
            this.matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                String[] lineValues = lines[i].split(" ");
                if (lineValues.length != N) {
                    throw new IllegalArgumentException("Matrix row does not have the correct number of columns");
                }
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(lineValues[j]);
                }
            }
        }

        /**
         * Get values in the matrix
         *
         * @return matrix
         */
        public int[][] getMatrix() {
            return matrix;
        }

        /**
         * Get size of the matrix
         *
         * @return N
         */
        public int getN() {
            return N;
        }

        /**
         * Check if the matrix NxN is a natural Latin square.
         * A matrix is a Latin square if each cell contains one of N different values,
         * and no value is repeated within a row or a column.
         * The trace of a square matrix is the sum of the values on the main diagonal
         *
         * @param caseNumber the case number
         */
        public void isNaturalLatinSquare(int caseNumber) {
            int trace = 0;
            boolean[] rowHasRepeats = new boolean[N];
            boolean[] colHasRepeats = new boolean[N];
            int repeatedRows = 0, repeatedCols = 0;

            for (int i = 0; i < N; i++) {
                boolean[] rowSeen = new boolean[N + 1];
                boolean[] colSeen = new boolean[N + 1];

                for (int j = 0; j < N; j++) {
                    int rowValue = matrix[i][j];
                    int colValue = matrix[j][i];

                    if (i == j) {
                        trace += rowValue;
                    }

                    if (rowValue < 1 || rowValue > N) {
                        logger.log(Level.WARNING, "Value out of parameters 1 to N: " + rowValue);
                    } else if (rowSeen[rowValue]) {
                        if (!rowHasRepeats[i]) {
                            rowHasRepeats[i] = true;
                            repeatedRows++;
                        }
                    } else {
                        rowSeen[rowValue] = true;
                    }

                    if (colValue < 1 || colValue > N) {
                        logger.log(Level.WARNING, "Value out of parameters 1 to N: " + colValue);
                    } else if (colSeen[colValue]) {
                        if (!colHasRepeats[j]) {
                            colHasRepeats[j] = true;
                            repeatedCols++;
                        }
                    } else {
                        colSeen[colValue] = true;
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, repeatedRows, repeatedCols);
        }
    }

    /**
     * Read input stream
     *
     * @param inStream input stream
     * @return array of strings read from the input stream
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

        if (lines.length > 1) {
            int T = Integer.parseInt(lines[0]);
            Solution solution = new Solution();
            Matrix[] matrices = new Matrix[T];

            int index = 1;
            for (int t = 0; t < T; t++) {
                int N = Integer.parseInt(lines[index]);
                matrices[t] = solution.new Matrix(N, Arrays.copyOfRange(lines, index + 1, index + 1 + N));
                index += N + 1;
            }

            for (int t = 0; t < T; t++) {
                matrices[t].isNaturalLatinSquare(t + 1);
            }
        } else {
            logger.log(Level.WARNING, "Empty input test file");
        }
    }
}