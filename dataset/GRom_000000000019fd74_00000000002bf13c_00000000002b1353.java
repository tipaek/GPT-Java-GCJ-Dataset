import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {

    private Scanner scanner;
    private PrintStream printStream;

    public static void main(String[] args) {
        new Solution().execute(System.in, System.out);
    }

    Solution() {
        // No-op.
    }

    void execute(InputStream in, PrintStream out) {
        scanner = new Scanner(in);
        printStream = out;

        int cases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < cases; i++) {
            solveCase(i + 1);
        }
    }

    private void solveCase(int caseNo) {
        printStream.println(String.format("Case #%d:", caseNo));

        int n = Integer.parseInt(scanner.nextLine());

        solve(n);
    }

    void solve(int n) {
        int stepsLeft = 499;
        int pointLeft = n - 1;

        int r = 1;
        int c = 1;

        printStream.println("1 1");

        while (pointLeft > 0 && stepsLeft > 0) {
            int nextVal = r;

            if (nextVal <= pointLeft) {
                pointLeft -= nextVal;
                stepsLeft--;

                r++;
                c = 2;

                printStream.printf("%d %d\n", r, c);
            } else {
                c = 1;
                printStream.printf("%d %d\n", r, c);
                pointLeft--;
                stepsLeft--;

                while (pointLeft > 0  && stepsLeft > 0) {
                    r--;
                    printStream.printf("%d %d\n", r, c);
                    pointLeft--;
                    stepsLeft--;
                }
            }
        }
    }
}