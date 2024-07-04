import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        Solution solution = new Solution();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = stringToInt(reader.readLine());

            for (int i = 0; i < testCases; i++) {
                String[] values = reader.readLine().split(" ");

                String result = solution.test((i + 1), stringToInt(values[0]), stringToInt(values[1]));
                solution.outputResult(result);
            }
        }
    }

    private void outputResult(String result) {
        System.out.println(result);
    }

    private static int stringToInt(String s) throws IOException {
        return Integer.parseInt(s);
    }

    String test(final int testCase, final int n, final int k) {
        return String.format("Case #%s: %s", testCase, test(n, k));
    }

    private String test(final int n, final int k) {
        if (n > 2 && k == sumElementsOf(n)) {
            return "POSSIBLE\n" + printSumMatrix(n);
        } else if (isKRepresentByAnyValueOfN(n, k)) {
            return "POSSIBLE\n" + printShiftMatrix(n, k / n);
        }
        return "IMPOSSIBLE";
    }

    private String printSumMatrix(final int n) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int start = n + i;
            for (int j = 0; j < n; j++) {
                int element = (start + j);
                if (element % n == 0) {
                    element = n;
                } else if (element > n) {
                    element = element % n;
                }
                result.append(element);

                if (j != (n - 1)) {
                    result.append(' ');
                }
            }
            if (i != (n - 1)) {
                result.append('\n');
            }
        }
        return result.toString();
    }

    private String printShiftMatrix(int n, int firstElement) {
        StringBuilder result = new StringBuilder();

        int start = firstElement;
        for (int i = 0; i < n; i++) {
            int lastElement = firstElement;
            for (int j = 0; j < n; j++) {
                int element = (start + j) % n;
                if (element == 0) {
                    element = n;
                }
                lastElement = element;
                result.append(element);

                if (j != (n - 1)) {
                    result.append(' ');
                }
            }
            start = lastElement;
            if (i != (n - 1)) {
                result.append('\n');
            }
        }
        return result.toString();
    }

    private boolean isKRepresentByAnyValueOfN(final int n, final int k) {
        return k % n == 0;
    }

    private int sumElementsOf(int n) {
        return n * (n + 1) >> 1;
    }
}