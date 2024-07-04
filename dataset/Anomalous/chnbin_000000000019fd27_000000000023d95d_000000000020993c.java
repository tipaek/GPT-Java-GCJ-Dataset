import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int diagonalSum = 0;
            int repeatedRows = 0;
            int repeatedColumns = 0;

            for (int row = 0; row < matrixSize; row++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean hasRowRepeat = false;

                for (int col = 0; col < matrixSize; col++) {
                    int number = scanner.nextInt();
                    if (!rowSet.add(number)) {
                        hasRowRepeat = true;
                    }
                    matrix[row][col] = number;

                    if (row == col) {
                        diagonalSum += number;
                    }
                }

                if (hasRowRepeat) {
                    repeatedRows++;
                }
            }

            for (int col = 0; col < matrixSize; col++) {
                Set<Integer> colSet = new HashSet<>();
                boolean hasColRepeat = false;

                for (int row = 0; row < matrixSize; row++) {
                    if (!colSet.add(matrix[row][col])) {
                        hasColRepeat = true;
                    }
                }

                if (hasColRepeat) {
                    repeatedColumns++;
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + diagonalSum + " " + repeatedRows + " " + repeatedColumns);
        }
    }
}