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
         * @param N size of the matrix
         * @param lines array of strings representing the matrix
         */
        public Matrix(int N, String[] lines) {
            this.N = N;
            this.matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                String[] lineValues = lines[i].split(" ");
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(lineValues[j]);
                }
            }
        }

        /**
         * Check if the matrix NxN is a natural Latin square.
         * Matrix is a Latin square if each cell contains one of N different values, 
         * and no value is repeated within a row or a column.
         * 
         * The trace of a square matrix is the sum of the values on the main diagonal 
         * 
         * @param caseNumber the case number for output
         */
        public void isNaturalLatinSquare(int caseNumber) {
            int trace = 0;
            int nRowRepeatedValues = 0;
            int nColumnRepeatedValues = 0;

            for (int i = 0; i < N; i++) {
                boolean[] rowCheck = new boolean[N + 1];
                boolean[] colCheck = new boolean[N + 1];

                for (int j = 0; j < N; j++) {
                    if (i == j) {
                        trace += matrix[i][j];
                    }

                    if (rowCheck[matrix[i][j]]) {
                        nRowRepeatedValues++;
                        break;
                    }
                    rowCheck[matrix[i][j]] = true;

                    if (colCheck[matrix[j][i]]) {
                        nColumnRepeatedValues++;
                        break;
                    }
                    colCheck[matrix[j][i]] = true;
                }
            }

            System.out.println(String.format("Case #%d: %d %d %d", caseNumber, trace, nRowRepeatedValues, nColumnRepeatedValues));
        }
    }

    /**
     * Read input file line by line
     * @param inStream the input stream
     * @return array of strings representing the input lines
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
     * @param args arguments
     */
    public static void main(String[] args) {
        String[] lines = readInput(System.in);

        Solution solution = new Solution();
        if (lines.length > 1) {
            int T = Integer.parseInt(lines[0]);
            Matrix[] matrices = new Matrix[T];

            int index = 1;
            for (int t = 0; t < T; t++) {
                int N = Integer.parseInt(lines[index]);
                matrices[t] = solution.new Matrix(N, Arrays.copyOfRange(lines, index + 1, index + 1 + N));
                index += N + 1;
            }

            for (int i = 0; i < matrices.length; i++) {
                matrices[i].isNaturalLatinSquare(i + 1);
            }
        } else {
            logger.log(Level.WARNING, "Empty input test file");
        }
    }
}