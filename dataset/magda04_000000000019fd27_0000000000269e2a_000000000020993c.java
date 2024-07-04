import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int numOfTestCases = Integer.parseInt(scanner.nextLine());

        List<Matrix> matrices = new ArrayList<>();

        for (int i = 0; i < numOfTestCases; i++) {
            int size = Integer.parseInt(scanner.nextLine());
            Matrix matrix = new Matrix(size);

            for (int j = 0; j < size; j++) {
                String input = scanner.nextLine();
                String[] numbers = input.split(" ");
                matrix.populateRow(j, numbers);
            }
            matrices.add(matrix);
        }

        for (int i = 0; i < numOfTestCases; i++) {
            Matrix m = matrices.get(i);
            System.out.printf("Case #%d: %d %d %d\n", i + 1, m.countTrace(),
                    m.rowsWithRepeatedNum(), m.columnsWithRepeatedNum());
        }

    }

    private static class Matrix {
        int size;
        int[][] matrix;

        Matrix(int size) {
            this.size = size;
            this.matrix = new int[size][size];
        }

        void populateRow(int rowNum, String[] row) {
            for (int i = 0; i < size; i++) {
                matrix[rowNum][i] = Integer.parseInt(row[i]);
            }
        }

        int countTrace() {
            int sum = 0;
            for (int i = 0; i < size; i++) {
                sum += matrix[i][i];
            }
            return sum;
        }

        int rowsWithRepeatedNum() {
            int rowCounter = 0;

            for (int i = 0; i < size; i++) {
                Set<Integer> notRepeated = new HashSet<>();

                for (int j = 0; j < size; j++) {
                    if (!notRepeated.contains(matrix[i][j])) {
                        notRepeated.add(matrix[i][j]);
                    } else {
                        rowCounter++;
                        break;
                    }
                }

            }
            return rowCounter;
        }


        int columnsWithRepeatedNum() {
            int columnCounter = 0;

            for (int j = 0; j < size; j++) {
                Set<Integer> notRepeated = new HashSet<>();

                for (int i = 0; i < size; i++) {
                    if (!notRepeated.contains(matrix[i][j])) {
                        notRepeated.add(matrix[i][j]);
                    } else {
                        columnCounter++;
                        break;
                    }
                }

            }
            return columnCounter;
        }
    }

}