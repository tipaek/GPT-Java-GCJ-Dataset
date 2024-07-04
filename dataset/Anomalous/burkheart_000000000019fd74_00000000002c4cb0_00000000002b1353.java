import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public Solution() {}

    public static int N;

    public static class State {
        public int score;
    }

    public static State solve() {
        boolean[] selectedRows = new boolean[31];
        boolean found = false;
        int remaining = N;

        for (int row = 30; row > 1; row--) {
            int value = 0;
            if (!found) value += row - 1;
            value += (1 << (row - 1)) - 1;

            if (value < remaining) {
                remaining -= value;
                found = true;
                selectedRows[row] = true;
            }
        }

        boolean isLeft = true;
        int sum = 0;

        for (int row = 1; row <= 500; row++) {
            if (row == 1) {
                System.out.println("1 1");
                sum++;
            } else {
                if (selectedRows[row]) {
                    if (isLeft) {
                        for (int col = 1; col <= row; col++) {
                            System.out.println(row + " " + col);
                        }
                        isLeft = false;
                    } else {
                        for (int col = row; col >= 1; col--) {
                            System.out.println(row + " " + col);
                        }
                        isLeft = true;
                    }
                    sum += 1 << (row - 1);
                } else {
                    if (isLeft) {
                        System.out.println(row + " 1");
                    } else {
                        System.out.println(row + " " + row);
                    }
                    sum++;
                }
            }

            if (sum >= N) break;
        }

        assert N == sum;
        return null;
    }

    public static int DEBUG_TEST_CASE = 0;
    public static boolean SIMULATE_TEST_CASES = false;

    public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int tmax;

        if (!SIMULATE_TEST_CASES) {
            tmax = in.nextInt();
            for (int t = 1; t <= tmax; ++t) {
                N = in.nextInt();

                if ((DEBUG_TEST_CASE <= 0) || (t == DEBUG_TEST_CASE)) {
                    System.out.println("Case #" + t + ":");
                    solve();
                }
            }
        } else {
            // Simulating test cases
            tmax = 1000;
            for (int t = 1; t <= tmax; ++t) {
                N = t;
                solve();
            }
        }
    }
}