import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.run();
    }

    void run() {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            processTestCase(in, i);
        }
    }

    void processTestCase(Scanner in, int caseNumber) {
        int size = in.nextInt();
        int trace = 0;
        int numRepeatRow = 0;
        int numRepeatCol = 0;
        boolean[][] col = new boolean[size + 1][size + 1];

        for (int r = 1; r <= size; ++r) {
            boolean[] row = new boolean[size + 1];
            boolean rowRepeat = false;
            for (int c = 1; c <= size; ++c) {
                int val = in.nextInt();
                col[c][val] = true;
                if (r == c) {
                    trace += val;
                }
                if (row[val]) {
                    rowRepeat = true;
                } else {
                    row[val] = true;
                }
            }
            if (rowRepeat) {
                numRepeatRow++;
            }
        }

        for (int c = 1; c <= size; ++c) {
            if (hasColumnRepeat(col, size, c)) {
                numRepeatCol++;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + trace + " " + numRepeatRow + " " + numRepeatCol);
    }

    boolean hasColumnRepeat(boolean[][] col, int size, int column) {
        for (int r = 1; r <= size; ++r) {
            if (!col[column][r]) {
                return true;
            }
        }
        return false;
    }
}