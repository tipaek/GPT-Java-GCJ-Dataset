import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            setupDiagonalValues();
            for (int i = 0; i < size; i++) {
                if (!tryFillRow(i, 0)) {
                    isPossible = false;
                }
            }
        }

        private void setupDiagonalValues() {
            int averageValue = trace / size;
            int averageModulus = trace % size;

            boolean moreThanOne = averageModulus > 1;
            boolean lessThanSize = averageModulus < size - 1;

            for (int i = 0; i < size; i++) {
                matrix[i][i] = averageValue;
                if (averageModulus != 0) {
                    if (moreThanOne && lessThanSize) {
                        matrix[i][i]++;
                        averageModulus--;
                    }
                    if (!moreThanOne) {
                        matrix[i][i]--;
                        averageModulus++;
                        moreThanOne = true;
                    }
                    if (!lessThanSize) {
                        matrix[i][i] += 2;
                        averageModulus -=2;
                        lessThanSize = true;
                    }
                }
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
