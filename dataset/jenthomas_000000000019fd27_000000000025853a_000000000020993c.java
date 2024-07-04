import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Nb of test cases

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt(); // Size of matrix
            int[][] matrix = new int[n][n];
            int k = 0; // Trace
            long r = 0; // number of rows of the matrix that contain repeated elements
            long c = 0; // number of columns of the matrix that contain repeated elements

            for (int j = 0; j < n; j++) {
                Map<Integer, Integer> row = new HashMap<>();
                for (int l = 0; l < n; l++) {
                    int value = in.nextInt();
                    matrix[l][j] = value;
                    if (j == l) {
                        k = k + value;
                    }
                    row.merge(value, 1, Integer::sum);
                }
                if (row.entrySet().stream()
                        .anyMatch(e -> e.getValue() > 1)) {
                    r = r + 1;
                }
            }

            for (int j = 0; j < n; j++) {
                Map<Integer, Integer> column = new HashMap<>();
                for (int l = 0; l < n; l++) {
                    column.merge(matrix[j][l], 1, Integer::sum);
                }
                if (column.entrySet().stream()
                        .anyMatch(e -> e.getValue() > 1)) {
                    c = c + 1;
                }
            }

            System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
        }
    }
}