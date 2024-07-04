import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int crossSum = 0;
            int[][] matrix = new int[t][t];
            int rowRepeats = 0, colRepeats = 0;

            // Read matrix and calculate crossSum
            for (int j = 0; j < t; j++) {
                for (int k = 0; k < t; k++) {
                    matrix[j][k] = sc.nextInt();
                    if (j == k) {
                        crossSum += matrix[j][k];
                    }
                }
            }

            // Check for repeated elements in rows and columns
            for (int j = 0; j < t; j++) {
                boolean[] rowCheck = new boolean[t + 1];
                boolean[] colCheck = new boolean[t + 1];
                boolean rowHasRepeat = false;
                boolean colHasRepeat = false;

                for (int k = 0; k < t; k++) {
                    if (!rowHasRepeat && rowCheck[matrix[j][k]]) {
                        rowRepeats++;
                        rowHasRepeat = true;
                    }
                    rowCheck[matrix[j][k]] = true;

                    if (!colHasRepeat && colCheck[matrix[k][j]]) {
                        colRepeats++;
                        colHasRepeat = true;
                    }
                    colCheck[matrix[k][j]] = true;
                }
            }

            System.out.println(crossSum + " " + rowRepeats + " " + colRepeats);
        }
    }
}