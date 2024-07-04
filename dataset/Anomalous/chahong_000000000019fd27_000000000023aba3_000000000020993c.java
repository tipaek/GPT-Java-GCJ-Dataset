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

            // Read matrix and calculate diagonal sum
            for (int j = 0; j < t; j++) {
                for (int k = 0; k < t; k++) {
                    int num = sc.nextInt();
                    matrix[j][k] = num;
                    if (j == k) {
                        crossSum += num;
                    }
                }
            }

            // Check for row and column repetitions
            for (int j = 0; j < t; j++) {
                boolean[] rowCheck = new boolean[t + 1];
                boolean[] colCheck = new boolean[t + 1];
                boolean rowHasRepeat = false;
                boolean colHasRepeat = false;

                for (int k = 0; k < t; k++) {
                    // Check row
                    if (rowCheck[matrix[j][k]]) {
                        if (!rowHasRepeat) {
                            rowRepeats++;
                            rowHasRepeat = true;
                        }
                    } else {
                        rowCheck[matrix[j][k]] = true;
                    }

                    // Check column
                    if (colCheck[matrix[k][j]]) {
                        if (!colHasRepeat) {
                            colRepeats++;
                            colHasRepeat = true;
                        }
                    } else {
                        colCheck[matrix[k][j]] = true;
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + crossSum + " " + rowRepeats + " " + colRepeats);
        }
    }
}