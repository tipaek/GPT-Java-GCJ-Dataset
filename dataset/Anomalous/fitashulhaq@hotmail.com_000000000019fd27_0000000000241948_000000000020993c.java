import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Number of test cases

        for (int i = 1; i <= t; ++i) {
            int sizeOfMatrix = in.nextInt();
            int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];
            int diagonalSum = 0;
            int sameRow = 0;
            int sameColumn = 0;
            boolean[] repeatedRows = new boolean[sizeOfMatrix];
            boolean[] repeatedColumns = new boolean[sizeOfMatrix];

            for (int j = 0; j < sizeOfMatrix; j++) {
                for (int k = 0; k < sizeOfMatrix; k++) {
                    matrix[j][k] = in.nextInt();
                    if (j == k) {
                        diagonalSum += matrix[j][k];
                    }
                }
            }

            for (int j = 0; j < sizeOfMatrix; j++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                for (int k = 0; k < sizeOfMatrix; k++) {
                    // Check for repeated elements in the row
                    if (!rowSet.add(matrix[j][k])) {
                        if (!repeatedRows[j]) {
                            repeatedRows[j] = true;
                            sameRow++;
                        }
                    }
                    // Check for repeated elements in the column
                    if (!colSet.add(matrix[k][j])) {
                        if (!repeatedColumns[j]) {
                            repeatedColumns[j] = true;
                            sameColumn++;
                        }
                    }
                }
            }

            System.out.println("Case #" + i + ": " + diagonalSum + " " + sameColumn + " " + sameRow);
        }
    }
}