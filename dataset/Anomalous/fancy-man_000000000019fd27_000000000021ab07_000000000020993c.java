import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume the remaining newline

            int[][] matrix = new int[n][n];
            boolean[][] columnCheck = new boolean[n][n];
            boolean[][] rowCheck = new boolean[n][n];

            int trace = 0;
            for (int i = 0; i < n; i++) {
                String[] tokens = scanner.nextLine().split(" ");
                for (int j = 0; j < n; j++) {
                    int value = Integer.parseInt(tokens[j]);
                    matrix[i][j] = value;
                    columnCheck[j][value - 1] = true;
                    rowCheck[i][value - 1] = true;
                }
                trace += matrix[i][i];
            }

            int columnRepeats = 0, rowRepeats = 0;
            for (int i = 0; i < n; i++) {
                boolean columnHasDuplicate = false;
                boolean rowHasDuplicate = false;

                for (int j = 0; j < n; j++) {
                    if (!columnCheck[i][j]) {
                        columnHasDuplicate = true;
                    }
                    if (!rowCheck[i][j]) {
                        rowHasDuplicate = true;
                    }
                }

                if (columnHasDuplicate) {
                    columnRepeats++;
                }
                if (rowHasDuplicate) {
                    rowRepeats++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", caseNum, trace, rowRepeats, columnRepeats);
        }
    }
}