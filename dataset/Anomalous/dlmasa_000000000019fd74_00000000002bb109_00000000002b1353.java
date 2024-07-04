import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        new Solution().solve();
    }

    public void solve() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int N = scanner.nextInt();
            System.out.printf("Case #%d:%n", t);

            if (N <= 500) {
                printSteps(N, 1);
            } else if (N <= 997) {
                printSteps(499, 1);
                printStep(500, 2);
                printSteps(N - 500, 1);
            } else {
                printSteps(498, 1);
                printStep(499, 2);
                printStep(500, 2);
                printSteps(N - 500, 1);
            }
        }
    }

    private void printSteps(int count, int column) {
        for (int i = 1; i <= count; i++) {
            System.out.printf("%d %d%n", i, column);
        }
    }

    private void printStep(int row, int column) {
        System.out.printf("%d %d%n", row, column);
    }
}