import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        input.nextLine(); // Consume the newline character
        for (int i = 1; i <= t; i++) {
            String s = input.nextLine();
            System.out.println("Case #" + i + ": " + checkNestingDepth(s));
        }
    }

    public static String checkNestingDepth(String s) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char c : s.toCharArray()) {
            int digit = Character.getNumericValue(c);

            while (currentDepth < digit) {
                result.append('(');
                currentDepth++;
            }
            while (currentDepth > digit) {
                result.append(')');
                currentDepth--;
            }

            result.append(digit);
        }

        while (currentDepth > 0) {
            result.append(')');
            currentDepth--;
        }

        return result.toString();
    }
}