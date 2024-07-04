import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int trace = 0, rowRepeats = 0, colRepeats = 0;
            int[][] matrix = new int[n][n];

            // Read matrix and calculate trace
            for (int row = 0; row < n; row++) {
                boolean[] rowCheck = new boolean[n];
                boolean rowHasRepeat = false;

                for (int col = 0; col < n; col++) {
                    int value = scanner.nextInt();
                    matrix[row][col] = value;

                    if (!rowCheck[value - 1]) {
                        rowCheck[value - 1] = true;
                    } else if (!rowHasRepeat) {
                        rowRepeats++;
                        rowHasRepeat = true;
                    }

                    if (row == col) {
                        trace += value;
                    }
                }
            }

            // Check for column repeats
            for (int col = 0; col < n; col++) {
                boolean[] colCheck = new boolean[n];
                boolean colHasRepeat = false;

                for (int row = 0; row < n; row++) {
                    int value = matrix[row][col];

                    if (!colCheck[value - 1]) {
                        colCheck[value - 1] = true;
                    } else if (!colHasRepeat) {
                        colRepeats++;
                        colHasRepeat = true;
                    }
                }
            }

            System.out.println("case #" + caseNum + " " + trace + " " + rowRepeats + " " + colRepeats);
        }

        scanner.close();
    }
}