import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int size = scanner.nextInt();
            boolean[][] rowCheck = new boolean[size + 1][size + 1];
            boolean[][] colCheck = new boolean[size + 1][size + 1];
            boolean[] colFlags = new boolean[size + 1];
            int trace = 0, duplicateRows = 0, duplicateColumns = 0;

            for (int i = 0; i < size; i++) {
                boolean rowHasDuplicate = false;
                for (int j = 0; j < size; j++) {
                    int value = scanner.nextInt();

                    if (rowCheck[i][value] && !rowHasDuplicate) {
                        duplicateRows++;
                        rowHasDuplicate = true;
                    }
                    if (colCheck[j][value] && !colFlags[j]) {
                        duplicateColumns++;
                        colFlags[j] = true;
                    }

                    rowCheck[i][value] = true;
                    colCheck[j][value] = true;

                    if (i == j) {
                        trace += value;
                    }
                }
            }
            System.out.printf("Case #%d: %d %d %d\n", t + 1, trace, duplicateRows, duplicateColumns);
        }

        scanner.close();
    }
}