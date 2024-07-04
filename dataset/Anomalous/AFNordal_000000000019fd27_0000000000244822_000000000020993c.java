import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int size = scanner.nextInt();
            int trace = 0;
            boolean[][] rowCheck = new boolean[size][size + 1];
            boolean[][] colCheck = new boolean[size][size + 1];
            int duplicateRows = 0;
            int duplicateCols = 0;

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    int value = scanner.nextInt();
                    if (i == j) {
                        trace += value;
                    }
                    if (rowCheck[i][value]) {
                        rowCheck[i][0] = true;
                    } else {
                        rowCheck[i][value] = true;
                    }
                    if (colCheck[j][value]) {
                        colCheck[j][0] = true;
                    } else {
                        colCheck[j][value] = true;
                    }
                    if (i == size - 1 && colCheck[j][0]) {
                        duplicateCols++;
                    }
                }
                if (rowCheck[i][0]) {
                    duplicateRows++;
                }
            }
            System.out.printf("Case #%d: %d %d %d%n", t, trace, duplicateRows, duplicateCols);
        }

        scanner.close();
    }
}