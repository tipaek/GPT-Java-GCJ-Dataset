import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = Integer.parseInt(scanner.nextLine());
            int trace = 0;
            int[][] matrix = new int[n][n];
            int[] check = new int[n];
            int rowRepeats = 0;
            int colRepeats = 0;

            // Read matrix and calculate trace and row repeats
            for (int i = 0; i < n; i++) {
                String[] row = scanner.nextLine().split(" ");
                boolean rowHasRepeat = false;

                for (int j = 0; j < n; j++) {
                    int value = Integer.parseInt(row[j]);
                    matrix[i][j] = value;

                    if (i == j) {
                        trace += value;
                    }

                    check[value - 1]++;
                    if (check[value - 1] > 1) {
                        rowHasRepeat = true;
                    }
                }

                if (rowHasRepeat) {
                    rowRepeats++;
                }

                Arrays.fill(check, 0);
            }

            // Calculate column repeats
            for (int j = 0; j < n; j++) {
                boolean colHasRepeat = false;

                for (int i = 0; i < n; i++) {
                    int value = matrix[i][j];
                    check[value - 1]++;
                    if (check[value - 1] > 1) {
                        colHasRepeat = true;
                    }
                }

                if (colHasRepeat) {
                    colRepeats++;
                }

                Arrays.fill(check, 0);
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        scanner.close();
    }
}