import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int t = Integer.parseInt(input.nextLine());
        String[] output = new String[t];

        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(input.nextLine());
            int[][] matrix = new int[n][n];

            for (int row = 0; row < n; row++) {
                String[] line = input.nextLine().split(" ");
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = Integer.parseInt(line[col]);
                }
            }

            output[testCase - 1] = latinSquare(testCase, n, matrix);
        }

        for (String result : output) {
            System.out.println(result);
        }
    }

    public static String latinSquare(int testCase, int n, int[][] matrix) {
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

        return "Case #" + testCase + ": " + trace + " " + rowRepeats + " " + colRepeats;
    }
}