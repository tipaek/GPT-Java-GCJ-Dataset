import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder output = new StringBuilder();
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int t = scanner.nextInt();
            StringBuilder validMatrix = new StringBuilder();

            Integer[] trace = constructTrace(n, t);
            boolean possible = trace.length > 0;

            if (possible) {
                for (int i = 0; i < n; i++) {
                    int start = trace[i] - i + n;
                    for (int j = 0; j < n; j++) {
                        start = start > n ? start - n : start;
                        int num = i == j ? trace[i] : start;
                        validMatrix.append(num).append(j + 1 < n ? " " : "");
                        start++;
                    }
                    validMatrix.append(i + 1 < n ? "\n" : "");
                }
            }

            output.append("Case #").append(testCase).append(": ")
                  .append(possible ? "POSSIBLE\n" + validMatrix : "IMPOSSIBLE")
                  .append(testCase < testCases ? "\n" : "");
        }

        System.out.print(output);
    }

    private static Integer[] constructTrace(int n, int t) {
        return constructTraceHelper(t, new Integer[n], 0);
    }

    private static Integer[] constructTraceHelper(int t, Integer[] usedNumbers, int position) {
        int n = usedNumbers.length;
        if (position == n) {
            int sum = 0;
            for (int num : usedNumbers) {
                sum += num;
            }
            return sum == t ? usedNumbers : new Integer[0];
        }

        for (int i = 1; i <= n; i++) {
            if (canNumberBeUsed(usedNumbers, i, position)) {
                usedNumbers[position] = i;
                Integer[] trace = constructTraceHelper(t, usedNumbers.clone(), position + 1);
                if (trace.length > 0) {
                    return trace;
                }
            }
        }

        return new Integer[0];
    }

    private static boolean canNumberBeUsed(Integer[] usedNumbers, int number, int position) {
        int n = usedNumbers.length;
        for (int i = 0; i < position; i++) {
            if (usedNumbers[i] != null) {
                int used = usedNumbers[i];
                int atPosition = used + (position - i);
                atPosition = atPosition > n ? atPosition - n : atPosition;
                if (atPosition == number) {
                    return false;
                }
            }
        }
        return true;
    }
}