import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numOfCases = scanner.nextInt();

        for (int i = 0; i < numOfCases; i++) {
            String s = scanner.next();
            System.out.println("Case #" + (i + 1) + ": " + solve(s));
        }
    }

    private static String solve(String s) {
        int nestedCount = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            int digit = Integer.parseInt(s.substring(i, i + 1));

            if (digit == nestedCount) {
                result.append(digit);
            } else if (digit > nestedCount) {
                for (int j = 0; j < digit - nestedCount; j++) {
                    result.append("(");
                }

                nestedCount = digit;
                result.append(digit);
            } else {
                for (int j = 0; j < nestedCount - digit; j++) {
                    result.append(")");
                }

                nestedCount = digit;
                result.append(digit);
            }
        }

        for (int i = 0; i < nestedCount; i++) {
            result.append(")");
        }

        return result.toString();
    }
}