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
         * @param lines array of strings representing matrix rows
         */
        public Matrix(int N, String[] lines) {
            this.N = N;
            this.matrix = new int[N][N];

            if (lines.length != N) {
                throw new IllegalArgumentException("Number of lines does not match matrix size N");
            }

            for (int i = 0; i < N; i++) {
                String[] lineValues = lines[i].split(" ");
                if (lineValues.length != N) {
                    throw new IllegalArgumentException("Number of values in line does not match matrix size N");
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
         * Matrix is a Latin square if each cell contains one of N different values,
         * and no value is repeated within a row or a column.
         * The trace of a square matrix is the sum of the values on the main diagonal
         *
         * @param caseNumber the case number
         */
        public void isNaturalLatinSquare(int caseNumber) {
            int trace = 0;
            boolean[] columnRepeated = new boolean[N];
            boolean[] rowRepeated = new boolean[N];
            int rowRepeatCount = 0;
            int columnRepeatCount = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int value = matrix[i][j];
                    if (i == j) {
                        trace += value;
                    }

                    // Check for repeated values in the column
                    for (int k = i + 1; k < N; k++) {
                        if (matrix[k][j] == value && !columnRepeated[j]) {
                            columnRepeated[j] = true;
                            columnRepeatCount++;
                            break;
                        }
                    }

                    // Check for repeated values in the row
                    for (int l = j + 1; l < N; l++) {
                        if (matrix[i][l] == value && !rowRepeated[i]) {
                            rowRepeated[i] = true;
                            rowRepeatCount++;
                            break;
                        }
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, rowRepeatCount, columnRepeatCount);
        }
    }

    /**
     * Read input stream
     *
     * @param inStream input stream
     * @return array of strings representing the input
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

            int lineIndex = 1;
            for (int t = 0; t < T; t++) {
                int N = Integer.parseInt(lines[lineIndex]);
                lineIndex++;
                matrices[t] = solution.new Matrix(N, Arrays.copyOfRange(lines, lineIndex, lineIndex + N));
                lineIndex += N;
            }

            for (int t = 0; t < T; t++) {
                matrices[t].isNaturalLatinSquare(t + 1);
            }
        } else {
            logger.log(Level.WARNING, "Empty input test file");
        }
    }
}