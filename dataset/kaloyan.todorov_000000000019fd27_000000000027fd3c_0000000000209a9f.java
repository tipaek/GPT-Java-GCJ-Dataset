import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static String stringWithParenthesis(String input) {
        StringBuilder sb = new StringBuilder();
        StringBuilder currentGroup = new StringBuilder();
        boolean parenthesisGroup = true;
        Character lastChar = input.charAt(0);
        currentGroup.append(input.charAt(0));

        for (int i = 1; i < input.length(); i++) {
            Character currentChar = input.charAt(i);
            if (currentChar != lastChar && parenthesisGroup) {
                parenthesisGroup = false;
                sb.append("(");
                sb.append(currentGroup.toString());
                sb.append(")");
                currentGroup = new StringBuilder();
            } else if (currentChar != lastChar) {
                parenthesisGroup = true;
                sb.append(currentGroup.toString());
                currentGroup = new StringBuilder();
            }

            lastChar = currentChar;
            currentGroup.append(currentChar);
        }

        if (parenthesisGroup && currentGroup.length() != input.length()) {
            sb.append("(");
            sb.append(currentGroup.toString());
            sb.append(")");
        } else {
            sb.append(currentGroup);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            String input = in.next();
            String output = stringWithParenthesis(input);
            System.out.println("Case #" + i + ": " + output);
        }
    }
}
