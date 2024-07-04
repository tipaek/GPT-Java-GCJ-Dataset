import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Problem[] problems = readProblems();
        for (Problem p : problems) p.solve();
        printResults(problems);
    }

    static Problem[] readProblems() {
        Scanner scan = new Scanner(System.in);
        Problem[] problems = new Problem[scan.nextInt()];
        for (int i = 0; i < problems.length; i++) {
            String line = scan.next();
            int[] digits = new int[line.length()];
            for (int j = 0; j < digits.length; j++) digits[j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            problems[i] = new Problem(digits);
        }
        return problems;
    }

    static void printResults(Problem[] problems) {
        for (int i = 0; i < problems.length; i++) {
            Problem p = problems[i];
            System.out.println(String.format("Case #%d: %s", i + 1, p.result));
        }
    }

    static class Problem {
        int[] digits;

        String result;

        Problem(int[] digits) {
            this.digits = digits;
        }

        void solve() {
            int[] derivative = new int[digits.length + 1];
            derivative[0] = digits[0];
            derivative[digits.length] = -digits[digits.length - 1];
            for (int i = 0; i < digits.length - 1; i++) {
                derivative[i + 1] = digits[i + 1] - digits[i];
            }

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < derivative.length; i++) {
                while (derivative[i] > 0) {
                    builder.append('(');
                    derivative[i]--;
                }
                while (derivative[i] < 0) {
                    builder.append(')');
                    derivative[i]++;
                }
                if (i < digits.length) builder.append(digits[i]);
            }
            result = builder.toString();
        }
    }
}
