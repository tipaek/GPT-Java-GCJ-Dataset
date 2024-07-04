
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
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
        if (isKRepresentByAnyValueOfN(n, k)) {
            return "POSSIBLE\n" + printShiftMatrix(n, k / n);
        } else if (n > 2 && k == sumElementsOf(n) || k % 2 == 0) {
            return "POSSIBLE\n" + printSumMatrix(n);
        }
        return "IMPOSSIBLE";
    }

    String printSumMatrix(final int n) {
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

    private String printShiftMatrix(int n, int start) {
        int k = n + 1;

        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int temp = k;

            StringBuilder tempBuilder = new StringBuilder();
            while (temp <= n) {
                int v = getValue(temp, start);
                tempBuilder.append(v).append(' ');
                temp++;
            }

            for (int j = 1; j < k; j++) {
                int v = getValue(j, start);
                tempBuilder.append(v).append(' ');
            }

            k--;
            result.append(tempBuilder.toString().trim());
            if (i != n) {
                result.append('\n');
            }
        }
        return result.toString();
    }

    private static int getValue(int inputValue, int start) {
        int v = inputValue;
        if (v == 1) {
            v = start;
        } else if (1 < v && v <= start) {
            v -= 1;
        }
        return v;
    }

    private boolean isKRepresentByAnyValueOfN(final int n, final int k) {
        return k % n == 0;
    }

    private int sumElementsOf(int n) {
        return n * (n + 1) >> 1;
    }
}
