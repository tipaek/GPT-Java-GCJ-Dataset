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
            System.out.printf("Case #%d:\n", t);

            if (N <= 500) {
                printPath(N, 1);
            } else if (N <= 997) {
                printPath(499, N - 499);
            } else {
                printPath(499, 995 - 498, N - 995);
            }
        }
    }

    private void printPath(int limit, int... specialSteps) {
        System.out.printf("%d %d\n", 1, 1);

        for (int i = 2; i <= limit; i++) {
            boolean isSpecialStep = false;
            for (int step : specialSteps) {
                if (i == step + 1) {
                    System.out.printf("%d %d\n", i, 2);
                    isSpecialStep = true;
                    break;
                }
            }
            if (!isSpecialStep) {
                System.out.printf("%d %d\n", i, 1);
            }
        }
    }
}