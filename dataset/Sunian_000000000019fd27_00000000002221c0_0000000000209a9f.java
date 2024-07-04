import java.util.Scanner;

/**
 * Created by Sun on 4/3/2020.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < T; i++) {
            String justDigits = scan.nextLine();
            int[] digits = new int[justDigits.length()];
            for (int n = 0; n < digits.length; n++) {
                digits[n] = Integer.parseInt(justDigits.charAt(n) + "");
            }
            String output = nestDecimal(digits);
            System.out.printf("Case #%d: %s\n", i + 1, output);
        }
    }

    private static String nestDecimal(int[] input) {
        int depth = 0;
        StringBuilder output = new StringBuilder(input.length * 2);
        for (int i : input) {
            while (depth < i) {
                output.append("(");
                depth++;
            }
            while (depth > i) {
                output.append(")");
                depth--;
            }
            output.append(i);
        }
        while (depth > 0) {
            output.append(")");
            depth--;
        }
        return output.toString();
    }

    private static String nestBinary(int[] input) {
        boolean wasOne = false;
        StringBuilder output = new StringBuilder(input.length * 2);
        for (int i : input) {
            if (i == 0) {
                if (wasOne) {
                    output.append(")0");
                } else {
                    output.append("0");
                }
                wasOne = false;
            } else {
                if (wasOne) {
                    output.append("1");
                } else {
                    output.append("(1");
                }
                wasOne = true;
            }
        }
        if (wasOne) {
            output.append(")");
        }
        return output.toString();
    }
}
