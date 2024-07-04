import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for (int testCase = 1; testCase <= testCases; ++testCase) {
            String str = in.nextLine();
            char[] digits = str.toCharArray();
            StringBuffer output = new StringBuffer();
            int depth = 0;

            for (char ch : digits) {
                final int digit = Character.getNumericValue(ch);

                if (digit < depth) {
                    int diff = depth - digit;
                    output.append(repeat(")", diff));
                } else if (digit > depth) {
                    int diff = digit - depth;
                    output.append(repeat("(", diff));
                }
                output.append(digit);
                depth = digit;
            }
            if (depth > 0) {
                output.append(repeat(")", depth));
            }
            System.out.println("Case #" + testCase + ": " + output);
        }
    }

    private static StringBuffer repeat(String strToRepeat, int times) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < times; i++) {
            result.append(strToRepeat);
        }
        return result;
    }
}