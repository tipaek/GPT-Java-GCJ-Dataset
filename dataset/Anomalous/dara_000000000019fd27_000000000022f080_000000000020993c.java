import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner reader = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = reader.nextInt(); // Number of test cases
        reader.nextLine();
        String[] results = new String[t];

        for (int p = 0; p < t; p++) {
            int n = reader.nextInt(); // Size of the matrix
            reader.nextLine();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                String line = reader.nextLine();
                String[] splitLine = line.split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(splitLine[j]);
                }
            }

            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
                boolean[] rowCheck = new boolean[n + 1];
                boolean[] colCheck = new boolean[n + 1];

                for (int j = 0; j < n; j++) {
                    if (rowCheck[matrix[i][j]]) {
                        rowRepeats++;
                        break;
                    }
                    rowCheck[matrix[i][j]] = true;
                }

                for (int j = 0; j < n; j++) {
                    if (colCheck[matrix[j][i]]) {
                        colRepeats++;
                        break;
                    }
                    colCheck[matrix[j][i]] = true;
                }
            }

            results[p] = "Case #" + (p + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats;
        }

        for (String result : results) {
            System.out.println(result);
        }
    }
}