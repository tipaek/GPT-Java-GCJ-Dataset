import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        
        for (int q = 0; q < t; q++) {
            int n = scanner.nextInt();
            int k = 0, r = 0, c = 0;
            int[][] matrix = new int[n][n];

            // Read matrix and count duplicate rows
            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();
                    matrix[i][j] = value;
                    rowSet.add(value);
                }
                if (rowSet.size() != n) {
                    r++;
                }
            }

            // Count duplicate columns
            for (int i = 0; i < n; i++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    colSet.add(matrix[j][i]);
                }
                if (colSet.size() != n) {
                    c++;
                }
            }

            // Calculate the sum of the diagonal
            for (int i = 0; i < n; i++) {
                k += matrix[i][i];
            }

            System.out.println("Case #" + (q + 1) + ": " + k + " " + r + " " + c);
        }
    }
}