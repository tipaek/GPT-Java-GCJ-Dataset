import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int crossSum = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            int[][] matrix = new int[t][t];

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
                    if (rowCheck[matrix[j][k]]) {
                        rowHasRepeat = true;
                    } else {
                        rowCheck[matrix[j][k]] = true;
                    }

                    if (colCheck[matrix[k][j]]) {
                        colHasRepeat = true;
                    } else {
                        colCheck[matrix[k][j]] = true;
                    }
                }

                if (rowHasRepeat) {
                    rowRepeats++;
                }

                if (colHasRepeat) {
                    colRepeats++;
                }
            }

            System.out.println(crossSum + " " + rowRepeats + " " + colRepeats);
        }
    }
}