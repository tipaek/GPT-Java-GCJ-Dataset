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
        private int size;

        public Matrix(int size, String[] lines) {
            this.size = size;
            this.matrix = new int[size][size];
            for (int i = 0; i < size; i++) {
                String[] values = lines[i].split(" ");
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = Integer.parseInt(values[j]);
                }
            }
        }

        public int[][] getMatrix() {
            return matrix;
        }

        public int getSize() {
            return size;
        }

        public void isNaturalLatinSquare(int caseNumber) {
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;
            boolean[] rowChecked = new boolean[size];
            boolean[] colChecked = new boolean[size];

            for (int i = 0; i < size; i++) {
                trace += matrix[i][i];
                for (int j = 0; j < size; j++) {
                    if (!rowChecked[i] && hasDuplicate(matrix[i])) {
                        rowRepeats++;
                        rowChecked[i] = true;
                    }
                    if (!colChecked[j] && hasDuplicate(getColumn(matrix, j))) {
                        colRepeats++;
                        colChecked[j] = true;
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, rowRepeats, colRepeats);
        }

        private boolean hasDuplicate(int[] array) {
            boolean[] seen = new boolean[size + 1];
            for (int value : array) {
                if (value < 1 || value > size || seen[value]) {
                    return true;
                }
                seen[value] = true;
            }
            return false;
        }

        private int[] getColumn(int[][] matrix, int colIndex) {
            int[] column = new int[size];
            for (int i = 0; i < size; i++) {
                column[i] = matrix[i][colIndex];
            }
            return column;
        }
    }

    public static String[] readInput(InputStream inStream) {
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error reading input", e);
        }
        return lines.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] lines = readInput(System.in);
        if (lines.length > 3) {
            int testCases = Integer.parseInt(lines[0]);
            Solution solution = new Solution();
            int lineIndex = 1;

            for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
                int size = Integer.parseInt(lines[lineIndex]);
                lineIndex++;
                String[] matrixLines = Arrays.copyOfRange(lines, lineIndex, lineIndex + size);
                lineIndex += size;

                Matrix matrix = solution.new Matrix(size, matrixLines);
                matrix.isNaturalLatinSquare(caseNumber);
            }
        } else {
            logger.log(Level.WARNING, "Empty input test file");
        }
    }
}