import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        for (int i = 0; i < T; i++) {
            String exp = scan.next();
            System.out.println("Case #" + (i + 1) + ": " + processExpression(exp));
        }
    }

    private static String processExpression(String exp) {
        Stack<Character> braces = new Stack<>();
        ArrayList<Character> result = new ArrayList<>();
        int top = -1;
        int currentMax = 0;
        boolean open = true;

        for (int j = 0; j < exp.length(); j++) {
            char currentChar = exp.charAt(j);
            int currentInt = Character.getNumericValue(currentChar);

            if (!open) { // closing brackets
                if (currentInt == currentMax) {
                    result.add(currentChar);
                } else if (currentInt < currentMax) {
                    while (top > (currentInt - 1)) {
                        braces.pop();
                        top--;
                        result.add(')');
                    }
                    result.add(currentChar);
                    if (top == -1) {
                        open = true;
                        continue;
                    }
                } else { // currentInt > currentMax
                    while (top != -1) {
                        braces.pop();
                        top--;
                        result.add(')');
                    }
                    open = true;
                }
            }

            if (open) { // opening brackets
                currentMax = currentInt;
                for (int temp = 0; temp < currentInt; temp++) {
                    braces.push('(');
                    top++;
                    result.add('(');
                }
                result.add(currentChar);
                open = false;
            }
        }

        // emptying remaining stack
        while (top != -1) {
            braces.pop();
            top--;
            result.add(')');
        }

        return getStringRepresentation(result);
    }

    private static String getStringRepresentation(ArrayList<Character> list) {
        StringBuilder builder = new StringBuilder(list.size());
        for (Character ch : list) {
            builder.append(ch);
        }
        return builder.toString();
    }
}