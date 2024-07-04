import java.util.Scanner;

public class Solution {
    private final Scanner scanner = new Scanner(System.in);

    private void solve(int testCaseNumber) {
        long xx = scanner.nextLong();
        long yy = scanner.nextLong();
        long x = Math.abs(xx);
        long y = Math.abs(yy);
        StringBuilder result = new StringBuilder();

        int[] xBits = new int[35];
        int[] yBits = new int[35];
        
        for (int i = 0; i < 35; i++) {
            long mask = 1L << i;
            if ((x & mask) != 0) {
                xBits[i] = 1;
            }
            if ((y & mask) != 0) {
                yBits[i] = 1;
            }
        }

        if (xBits[0] == 1 && yBits[0] == 1) {
            System.out.printf("Case #%d: IMPOSSIBLE%n", testCaseNumber);
            return;
        }

        for (int i = 0; i < 35; i++) {
            if (xBits[i] > 1) {
                xBits[i + 1] += xBits[i] / 2;
                xBits[i] %= 2;
            }
            if (yBits[i] > 1) {
                yBits[i + 1] += yBits[i] / 2;
                yBits[i] %= 2;
            }
            if (xBits[i] == 0 && yBits[i] == 0) {
                for (int j = i; j < 35; j++) {
                    if (xBits[j] != 0 || yBits[j] != 0) {
                        System.out.printf("Case #%d: IMPOSSIBLE%n", testCaseNumber);
                        return;
                    }
                }
                break;
            }
            if (xBits[i] != 0 && yBits[i] != 0) {
                if (xBits[i - 1] == 1) {
                    xBits[i + 1]++;
                    xBits[i - 1] = -1;
                    xBits[i] = 0;
                } else {
                    yBits[i + 1]++;
                    yBits[i - 1] = -1;
                    yBits[i] = 0;
                }
            }
        }

        for (int i = 0; i < xBits.length; i++) {
            if (xBits[i] == 0 && yBits[i] == 0) break;
            if (xBits[i] != 0) {
                result.append(xBits[i] == 1 ? 'E' : 'W');
            } else {
                result.append(yBits[i] == 1 ? 'N' : 'S');
            }
        }

        if (xx < 0) {
            for (int i = 0; i < result.length(); i++) {
                if (result.charAt(i) == 'E') {
                    result.setCharAt(i, 'W');
                } else if (result.charAt(i) == 'W') {
                    result.setCharAt(i, 'E');
                }
            }
        }
        if (yy < 0) {
            for (int i = 0; i < result.length(); i++) {
                if (result.charAt(i) == 'N') {
                    result.setCharAt(i, 'S');
                } else if (result.charAt(i) == 'S') {
                    result.setCharAt(i, 'N');
                }
            }
        }
        System.out.printf("Case #%d: %s%n", testCaseNumber, result.toString());
    }

    private void run() {
        int numberOfTestCases = scanner.nextInt();
        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            solve(testCase);
        }
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}