import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String out = "";
        int testCases = sc.nextInt();

        for (int testCase = 0; testCase < testCases; testCase++) {
            String validMatrix = "";

            int n = sc.nextInt();
            int t = sc.nextInt();

            Integer[] trace = constructTract(n, t);
            boolean possible = trace.length > 0;

            if (possible) {
                for (int i =0; i < n; i++) {
                    int start = trace[i] - i + n;
                    for (int j = 0; j < n; j++) {
                        start = start > n ? start - n : start;
                        int num = i == j ? trace[i] : start;
                        validMatrix += num + (j + 1 < n ? " " : "");
                        start++;
                    }
                    validMatrix += (i + 1 < n ? "\n" : "");
                }
            }

            out += "Case #" + (testCase+1) + ": " + (possible ? "POSSIBLE\n" + validMatrix : "IMPOSSIBLE") + (testCase + 1 < testCases ? "\n" : "");
        }

        System.out.print(out);
    }

    private static Integer[] constructTract(int n, int t) {
        return constructTraceHelper(t, new Integer[n], 0);
    }

    private static Integer[] constructTraceHelper(int t, Integer[] usedNumbers, Integer position) {
        Integer n = usedNumbers.length;
        if (position == n) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += usedNumbers[i];
            }

            return sum == t ? usedNumbers : new Integer[0];
        }

        for (int i = 1; i <= n; i++) {
            if (canNumberBeUsed(usedNumbers, i, position)) {
                usedNumbers[position] = i;

                Integer[] trace = constructTraceHelper(t, cloneArray(usedNumbers), position + 1);

                if (trace.length > 0) {
                    return trace;
                }
            }
        }

        return new Integer[0];
    }

    private static Integer[] cloneArray(Integer[] arr) {
        Integer[] arrClone = new Integer[arr.length];

        for (int i = 0; i < arr.length; i++) {
            arrClone[i] = arr[i];
        }

        return arrClone;
    }

    private static boolean canNumberBeUsed(Integer[] usedNumbers, int number, Integer position) {
        boolean canBeUsed = true;

        int n = usedNumbers.length;
        for (int i = 0; i < position && usedNumbers[i] != null && canBeUsed; i++) {
            int used = usedNumbers[i];
            int atPosition = used + (position - i);
            atPosition = atPosition > n ? atPosition - n : atPosition;

            canBeUsed = atPosition != number;
        }

        return canBeUsed;
    }
}