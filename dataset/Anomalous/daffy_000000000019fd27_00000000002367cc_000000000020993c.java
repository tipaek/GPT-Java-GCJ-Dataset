import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = Integer.parseInt(scanner.nextLine());
            int trace = 0;
            int[][] matrix = new int[n][n];
            int[] check = new int[n];
            int rowRepeats = 0;
            int colRepeats = 0;

            for (int row = 0; row < n; row++) {
                String[] rowValues = scanner.nextLine().split(" ");
                boolean rowHasRepeat = false;
                Arrays.fill(check, 0);

                for (int col = 0; col < n; col++) {
                    int value = Integer.parseInt(rowValues[col]);
                    if (row == col) {
                        trace += value;
                    }
                    if (++check[value - 1] > 1) {
                        rowHasRepeat = true;
                    }
                    matrix[row][col] = value;
                }

                if (rowHasRepeat) {
                    rowRepeats++;
                }
            }

            for (int col = 0; col < n; col++) {
                boolean colHasRepeat = false;
                Arrays.fill(check, 0);

                for (int row = 0; row < n; row++) {
                    int value = matrix[row][col];
                    if (++check[value - 1] > 1) {
                        colHasRepeat = true;
                    }
                }

                if (colHasRepeat) {
                    colRepeats++;
                }
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        scanner.close();
    }
}