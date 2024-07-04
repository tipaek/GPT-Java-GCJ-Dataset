package p1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int trace = 0;
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }

            int rowDuplicates = 0;
            for (int row = 0; row < matrixSize; row++) {
                boolean[] exists = new boolean[matrixSize];
                boolean hasDuplicate = false;
                for (int col = 0; col < matrixSize; col++) {
                    int value = matrix[row][col] - 1;
                    if (exists[value]) {
                        hasDuplicate = true;
                        break;
                    } else {
                        exists[value] = true;
                    }
                }
                if (hasDuplicate) {
                    rowDuplicates++;
                }
            }

            int colDuplicates = 0;
            for (int col = 0; col < matrixSize; col++) {
                boolean[] exists = new boolean[matrixSize];
                boolean hasDuplicate = false;
                for (int row = 0; row < matrixSize; row++) {
                    int value = matrix[row][col] - 1;
                    if (exists[value]) {
                        hasDuplicate = true;
                        break;
                    } else {
                        exists[value] = true;
                    }
                }
                if (hasDuplicate) {
                    colDuplicates++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", t, trace, rowDuplicates, colDuplicates);
        }

        scanner.close();
    }
}