import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        List<TestCase> testCaseList = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
            int tc = sc.nextInt();
            for (int i = 0; i < tc; i++) {
                TestCase testCase = new TestCase();
                testCase.parse(sc);
                testCaseList.add(testCase);
            }
        }

        for (int i = 0; i < testCaseList.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + testCaseList.get(i).solve());
        }
    }

    private static class TestCase {
        String input;

        public void parse(Scanner sc) {
            input = sc.next();
        }

        public String solve() {
            StringBuilder output = new StringBuilder(input.length());

            int previous = 0;

            for (int i = 0; i < input.length(); i++) {
                int curValue = Integer.parseInt(String.valueOf(input.charAt(i)));

                if (curValue > previous) {
                    output.append(repeat("(", curValue - previous));
                } else if (curValue < previous) {
                    output.append(repeat(")", previous - curValue));
                }

                output.append(curValue);

                previous = curValue;
            }

            output.append(repeat(")", previous));

            return output.toString();
        }

        private String repeat(String input, int n) {
            return String.join("", Collections.nCopies(n, input));
        }

    }
}
