import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();

        String out = "";

        for (int testCase = 0; testCase < testCases; testCase++) {
            String input = sc.next();

            String res = "";
            int openBrackets = 0;

            for (int i = 0; i < input.length(); i++) {
                int n = Integer.parseInt(String.valueOf(input.charAt(i)));

                if (n == 0 && openBrackets > 0) {
                    res += repeat(openBrackets, ")");
                    openBrackets = 0;
                } else if (n > openBrackets) {
//                    if (openBrackets > 0) {
//                        res += repeat(openBrackets, ")");
//                        openBrackets = 0;
//                    }

                    res += repeat(n - openBrackets, "(");
                    openBrackets += n - openBrackets;
                } else if (n < openBrackets) {
                    res += repeat(openBrackets - n, ")");
                    openBrackets = n;
                }

                res += n;
            }

            if (openBrackets > 0) {
                res += repeat(openBrackets, ")");
            }

            out += "Case #" + testCase+1 + ": " + res + (testCase + 1 < testCases ? "\n" : "");
        }

        System.out.println(out);
    }

    private static String repeat(int n, String s) {
        return new String(new char[n]).replace("\0", s);
    }
}