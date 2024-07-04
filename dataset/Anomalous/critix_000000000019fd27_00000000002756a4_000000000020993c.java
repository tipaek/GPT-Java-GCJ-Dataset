import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int trace = 0, duplicateRows = 0, duplicateColumns = 0;

            boolean[][] rowCheck = new boolean[size][size];
            boolean[][] colCheck = new boolean[size][size];
            boolean[] rowCounted = new boolean[size];
            boolean[] colCounted = new boolean[size];

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    int value = scanner.nextInt();

                    if (row == col) {
                        trace += value;
                    }

                    if (rowCheck[row][value - 1] && !rowCounted[row]) {
                        duplicateRows++;
                        rowCounted[row] = true;
                    }

                    if (colCheck[col][value - 1] && !colCounted[col]) {
                        duplicateColumns++;
                        colCounted[col] = true;
                    }

                    rowCheck[row][value - 1] = true;
                    colCheck[col][value - 1] = true;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}