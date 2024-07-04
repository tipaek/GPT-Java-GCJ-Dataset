import java.util.Scanner;

public class Solution {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int testCaseCount = sc.nextInt();
        for (int i = 0; i < testCaseCount; i++) {
            String s = sc.next();
            solve(s, i);
        }
    }

    public static void solve(String s, int testCase) {
        StringBuilder finalVal = new StringBuilder();
        int lim = Integer.parseInt(s);

        if (lim == 0) {
            System.out.println("Case #" + (testCase + 1) + ": " + s);
        } else if (s.length() == 1) {
            finalVal.append("(".repeat(lim)).append(s).append(")".repeat(lim));
            System.out.println("Case #" + (testCase + 1) + ": " + finalVal);
        } else if (s.chars().allMatch(c -> c == '0' || c == '1')) {
            finalVal.append(s.charAt(0));
            for (int i = 0; i < s.length() - 1; i++) {
                int one = s.charAt(i) - '0';
                int two = s.charAt(i + 1) - '0';

                if (one > two) {
                    finalVal.append(")").append(s.charAt(i + 1));
                } else if (two > one) {
                    finalVal.append("(").append(s.charAt(i + 1));
                } else {
                    finalVal.append(s.charAt(i + 1));
                }
            }
            if (s.startsWith("1")) {
                finalVal.insert(0, "(");
            }
            if (s.endsWith("1")) {
                finalVal.append(")");
            }
            System.out.println("Case #" + (testCase + 1) + ": " + finalVal);
        } else {
            finalVal.append(s.charAt(0));
            for (int i = 0; i < s.length() - 1; i++) {
                int one = s.charAt(i) - '0';
                int two = s.charAt(i + 1) - '0';

                if (one < two) {
                    finalVal.append("(".repeat(two - one)).append(s.charAt(i + 1));
                } else if (one > two) {
                    finalVal.append(")".repeat(one - two)).append(s.charAt(i + 1));
                } else {
                    finalVal.append(s.charAt(i + 1));
                }
            }
            int firstDigit = s.charAt(0) - '0';
            int lastDigit = s.charAt(s.length() - 1) - '0';
            finalVal.insert(0, "(".repeat(firstDigit));
            finalVal.append(")".repeat(lastDigit));

            System.out.println("Case #" + (testCase + 1) + ": " + finalVal);
        }
    }
}