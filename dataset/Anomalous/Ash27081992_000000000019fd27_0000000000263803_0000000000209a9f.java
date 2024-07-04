import java.util.Scanner;

public class Solution {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
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
        } else if (!s.matches(".*[2-9].*")) {
            finalVal.append(s.charAt(0));
            for (int i = 0; i < s.length() - 1; i++) {
                int one = Character.getNumericValue(s.charAt(i));
                int two = Character.getNumericValue(s.charAt(i + 1));

                if (one > two) {
                    finalVal.append(")").append(s.charAt(i + 1));
                } else if (two > one) {
                    finalVal.append("(").append(s.charAt(i + 1));
                } else {
                    finalVal.append(s.charAt(i));
                }
            }
            if (s.startsWith("1")) {
                finalVal.insert(0, "(");
            }
            if (s.endsWith("1")) {
                finalVal.append(")");
            }
            System.out.println(finalVal);
        } else {
            finalVal.append(s.charAt(0));
            for (int i = 0; i < s.length() - 1; i++) {
                int one = Character.getNumericValue(s.charAt(i));
                int two = Character.getNumericValue(s.charAt(i + 1));

                if (one < two) {
                    finalVal.append("(".repeat(two - one)).append(s.charAt(i + 1));
                } else if (one > two) {
                    finalVal.append(")".repeat(one - two)).append(s.charAt(i + 1));
                } else {
                    finalVal.append(s.charAt(i));
                }
            }
            finalVal.insert(0, "(".repeat(Character.getNumericValue(s.charAt(0))));
            finalVal.append(")".repeat(Character.getNumericValue(s.charAt(s.length() - 1))));
            System.out.println("Case #" + (testCase + 1) + ": " + finalVal);
        }
    }
}