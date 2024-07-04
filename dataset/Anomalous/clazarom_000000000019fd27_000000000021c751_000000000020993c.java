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

        public Matrix(int size, String[] lines) {
            this.size = size;
            this.matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                String[] lineValues = lines[i].split(" ");
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = Integer.parseInt(lineValues[j]);
                }
            }
        }

        public int[][] getMatrix() {
            return matrix;
        }

        public int getSize() {
            return size;
        }

        public void checkNaturalLatinSquare(int caseNumber) {
            int trace = 0;
            int repeatedRows = 0;
            int repeatedColumns = 0;

            for (int i = 0; i < size; i++) {
                trace += matrix[i][i];
                if (hasDuplicates(matrix[i])) {
                    repeatedRows++;
                }
                if (hasDuplicates(getColumn(matrix, i))) {
                    repeatedColumns++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, repeatedRows, repeatedColumns);
        }

        private boolean hasDuplicates(int[] array) {
            boolean[] seen = new boolean[size + 1];
            for (int value : array) {
                if (value < 1 || value > size || seen[value]) {
                    return true;
                }
                seen[value] = true;
            }
            return false;
        }

        private int[] getColumn(int[][] matrix, int columnIndex) {
            int[] column = new int[size];
            for (int i = 0; i < size; i++) {
                column[i] = matrix[i][columnIndex];
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
            e.printStackTrace();
        }

        return lines.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] lines = readInput(System.in);

        if (lines.length > 1) {
            int testCases = Integer.parseInt(lines[0]);
            Matrix[] matrices = new Matrix[testCases];

            int lineIndex = 1;
            for (int t = 0; t < testCases; t++) {
                int size = Integer.parseInt(lines[lineIndex]);
                matrices[t] = new Matrix(size, Arrays.copyOfRange(lines, lineIndex + 1, lineIndex + 1 + size));
                lineIndex += size + 1;
            }

            for (int t = 0; t < testCases; t++) {
                matrices[t].checkNaturalLatinSquare(t + 1);
            }
        } else {
            logger.log(Level.WARNING, "Empty input test file");
        }
    }
}