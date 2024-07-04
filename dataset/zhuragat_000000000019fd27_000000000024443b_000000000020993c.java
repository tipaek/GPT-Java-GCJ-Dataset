import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int caseNumber = in.nextInt();
        for (int i = 0; i < caseNumber; i++) {
            int matrixSize = in.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            for (int j = 0; j < matrixSize; j++) {
                for (int k = 0; k < matrixSize; k++) {
                    matrix[j][k] = in.nextInt();
                }
            }

            int trace = 0;
            for (int j = 0; j < matrixSize; j++) {
                trace += matrix[j][j];
            }

            int row = 0;
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < matrixSize; j++) {
                for (int k = 0; k < matrixSize; k++) {
                    if (!set.add(matrix[j][k])) {
                        row++;
                        set.clear();
                        break;
                    }
                }
            }

            int column = 0;
            for (int j = 0; j < matrixSize; j++) {
                for (int k = 0; k < matrixSize; k++) {
                    if (!set.add(matrix[k][j])) {
                        column++;
                        set.clear();
                        break;
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + row + " " + column);
        }
    }
}
