import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        StringBuilder output = new StringBuilder();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String input = sc.next();
            StringBuilder result = new StringBuilder();
            int openBrackets = 0;

            for (int i = 0; i < input.length(); i++) {
                int n = Character.getNumericValue(input.charAt(i));

                if (n == 0 && openBrackets > 0) {
                    result.append(repeat(openBrackets, ")"));
                    openBrackets = 0;
                } else if (n > openBrackets) {
                    result.append(repeat(n - openBrackets, "("));
                    openBrackets = n;
                } else if (n < openBrackets) {
                    result.append(repeat(openBrackets - n, ")"));
                    openBrackets = n;
                }

                result.append(n);
            }

            if (openBrackets > 0) {
                result.append(repeat(openBrackets, ")"));
            }

            output.append("Case #").append(testCase).append(": ").append(result);
            if (testCase < testCases) {
                output.append("\n");
            }
        }

        System.out.println(output);
    }

    private static String repeat(int n, String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }
}