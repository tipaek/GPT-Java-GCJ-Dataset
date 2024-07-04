import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            boolean[][] rowCheck = new boolean[n][n + 1];
            boolean[][] colCheck = new boolean[n][n + 1];
            int trace = 0, duplicateRows = 0, duplicateCols = 0;

            for (int i = 0; i < n; i++) {
                boolean rowHasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();
                    if (i == j) {
                        trace += value;
                    }
                    if (rowCheck[i][value]) {
                        rowHasDuplicate = true;
                    }
                    if (colCheck[j][value]) {
                        colCheck[j][0] = true; // Mark column as having a duplicate
                    }
                    rowCheck[i][value] = true;
                    colCheck[j][value] = true;
                }
                if (rowHasDuplicate) {
                    duplicateRows++;
                }
            }

            for (int j = 0; j < n; j++) {
                if (colCheck[j][0]) {
                    duplicateCols++;
                }
            }

            System.out.printf("Case #%d: %d %d %d\n", caseNum, trace, duplicateRows, duplicateCols);
        }

        scanner.close();
    }
}