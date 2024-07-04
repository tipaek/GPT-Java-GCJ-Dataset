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
        private int[][] matrix;
        private int N;

        public Matrix(int N, String[] lines) {
            this.N = N;
            this.matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                String[] lineValues = lines[i].split(" ");
                if (lineValues.length != N) {
                    logger.log(Level.WARNING, "Incorrect number of values in line " + i);
                    return;
                }
                for (int j = 0; j < N; j++) {
                    matrix[j][i] = Integer.parseInt(lineValues[j]);
                }
            }
        }

        public int[][] getMatrix() {
            return matrix;
        }

        public int getN() {
            return N;
        }

        public void isNaturalLatinSquare(int caseNumber) {
            int trace = 0;
            boolean[] isColumnRepeated = new boolean[N];
            boolean[] isRowRepeated = new boolean[N];
            int nRowRepeatedValues = 0;
            int nColumnRepeatedValues = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int firstValue = matrix[i][j];
                    if (i == j) {
                        trace += firstValue;
                    }

                    for (int ii = i + 1; ii < N; ii++) {
                        int value = matrix[ii][j];
                        if (value > 0 && value <= N) {
                            if (value == firstValue && !isColumnRepeated[j]) {
                                isColumnRepeated[j] = true;
                                nColumnRepeatedValues++;
                                break;
                            }
                        } else {
                            logger.log(Level.WARNING, "Value out of parameters 1 to N: " + value);
                        }
                    }

                    for (int jj = j + 1; jj < N; jj++) {
                        int value = matrix[i][jj];
                        if (value > 0 && value <= N) {
                            if (value == firstValue && !isRowRepeated[i]) {
                                isRowRepeated[i] = true;
                                nRowRepeatedValues++;
                                break;
                            }
                        } else {
                            logger.log(Level.WARNING, "Value out of parameters 1 to N: " + value);
                        }
                    }
                }
            }

            System.out.println(String.format("Case #%d: %d %d %d", caseNumber, trace, nRowRepeatedValues, nColumnRepeatedValues));
        }
    }

    public static String[] readInput(InputStream inStream) {
        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException ioe) {
            logger.log(Level.SEVERE, "IOException while reading input", ioe);
        }

        return lines.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] lines = readInput(System.in);
        Solution solution = new Solution();

        if (lines.length > 3) {
            int T = Integer.parseInt(lines[0]);
            Matrix[] matrices = new Matrix[T];

            int mIndex = 1;
            for (int t = 0; t < T; t++) {
                int N = Integer.parseInt(lines[mIndex]);
                mIndex++;
                matrices[t] = solution.new Matrix(N, Arrays.copyOfRange(lines, mIndex, mIndex + N));
                mIndex += N;
            }

            for (int m = 0; m < T; m++) {
                matrices[m].isNaturalLatinSquare(m + 1);
            }
        } else {
            logger.log(Level.WARNING, "Empty input test file");
        }
    }
}