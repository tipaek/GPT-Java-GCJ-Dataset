import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        List<String> lines = new ArrayList<>();
        while (in.hasNext()) {
            lines.add(in.nextLine());
        }

        for (int i = 1; i < lines.size(); i++) {
            String result = processLine(lines.get(i));
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String processLine(String line) {
        Matrix matrix = new Matrix(line);
        matrix.generateMatrix();
        return matrix.getResult();
    }

    public static class Matrix {
        private int size;
        private int trace;
        private int[][] matrix;
        private boolean isPossible = true;

        public Matrix(String input) {
            String[] inputArray = input.split(" ");
            this.size = Integer.parseInt(inputArray[0]);
            this.trace = Integer.parseInt(inputArray[1]);
            this.matrix = new int[size][size];
        }

        public void generateMatrix() {
            for (int i = 0; i < size; i++) {
                if (!tryFillDiagonal(i)) {
                    isPossible = false;
                    return;
                }
            }

            boolean failedToFillRows = false;
            for (int i = 0; i < size; i++) {
                if (!tryFillRow(i, 0)) {
                    failedToFillRows = true;
                    break;
                }
            }

            if (failedToFillRows) {
                for (int i = 0; i < size; i++) {
                    resetRow(i, 0);
                }
                for (int i = size - 1; i >= 0; i--) {
                    if (!tryFillRow(i, 0)) {
                        isPossible = false;
                        return;
                    }
                }
            }
        }

        boolean tryFillDiagonal(int id) {
            if (id == size) {
                return isDiagonalValid();
            }
            for (int i = 1; i <= size; i++) {
                resetDiagonal(id);
                matrix[id][id] = i;
                if (tryFillDiagonal(id + 1)) {
                    return true;
                }
            }

            return isDiagonalValid();
        }

        boolean isDiagonalValid() {
            Map<Integer, Integer> valueMap = new HashMap<>();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                sum += matrix[i][i];

                Integer valueCount = valueMap.getOrDefault(matrix[i][i], 0);
                valueMap.put(matrix[i][i], valueCount + 1);
            }

            if (sum != trace) {
                return false;
            }

            if (valueMap.size() == 2) {
                for (Map.Entry<Integer, Integer> entry : valueMap.entrySet()) {
                    if (entry.getValue() == 1) {
                        return false;
                    }
                }
            }

            return true;
        }

        private void resetDiagonal(int fromId) {
            for (int i = fromId; i < size; i++) {
                matrix[fromId][fromId] = 0;
            }
        }

        boolean tryFillRow(int row, int col) {
            if (col == size) {
                return !rowContains(row, 0);
            }

            if (row == col) {
                return tryFillRow(row, col + 1);
            }

            for (int i = 1; i <= size; i++) {
                resetRow(row, col);
                if (!rowContains(row, i) && !columnContains(col, i)) {
                    matrix[row][col] = i;
                    if (tryFillRow(row, col + 1)) {
                        return true;
                    }
                }
            }

            return !rowContains(row, 0);
        }

        private boolean columnContains(int column, int number) {
            for (int i = 0; i < size; i++) {
                if (matrix[i][column] == number) {
                    return true;
                }
            }
            return false;
        }

        private boolean rowContains(int row, int number) {
            for (int i = 0; i < size; i++) {
                if (matrix[row][i] == number) {
                    return true;
                }
            }
            return false;
        }

        private void resetRow(int row, int fromCol) {
            for (int i = fromCol; i < size; i++) {
                if (row != i) {
                    matrix[row][i] = 0;
                }
            }
        }

        public String getResult() {
            String result = "";
            if (isPossible) {
                result += "POSSIBLE\n";
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        result += matrix[i][j] + " ";
                    }
                    result += "\n";
                }
            } else {
                result += "IMPOSSIBLE";
            }

            return result;
        }
    }
}