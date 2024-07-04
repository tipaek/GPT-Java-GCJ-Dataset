import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        
        for (int i = 0; i < T; i++) {
            String exp = scan.next();
            ArrayList<Character> result = processExpression(exp);
            System.out.println("Case #" + (i + 1) + ": " + getStringRepresentation(result));
        }
        
        scan.close();
    }

    private static ArrayList<Character> processExpression(String exp) {
        Stack<Character> braces = new Stack<>();
        ArrayList<Character> result = new ArrayList<>();
        int top = -1;
        int currentMax = 0, currentMin = Integer.MAX_VALUE;
        boolean open = true, mid = false;

        for (int j = 0; j < exp.length(); j++) {
            int currentInt = Character.getNumericValue(exp.charAt(j));
            char currentChar = exp.charAt(j);
            System.out.println(currentInt);

            if (!open) { // closing brackets
                if (currentInt == currentMax) {
                    result.add(currentChar);
                } else if (currentInt < currentMax) {
                    while (top > currentInt - 1) {
                        braces.pop();
                        top--;
                        result.add(')');
                    }
                    result.add(currentChar);
                    currentMin = Math.min(currentMin, currentInt);
                    if (j != exp.length() - 1 && Character.getNumericValue(exp.charAt(j + 1)) > currentMin) {
                        open = true;
                        mid = true;
                        continue;
                    }
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
                currentMax = Math.max(currentMax, currentInt);
                currentMin = Math.min(currentMin, currentInt);
                if (!mid) {
                    for (int temp = 0; temp < currentInt; temp++) {
                        braces.push('(');
                        top++;
                        result.add('(');
                    }
                    result.add(currentChar);
                    open = false;
                } else { // mid=true
                    int limit = currentInt - top - 1;
                    for (int temp = 0; temp < limit; temp++) {
                        braces.push('(');
                        top++;
                        result.add('(');
                    }
                    result.add(currentChar);
                    if (j != exp.length() - 1 && Character.getNumericValue(exp.charAt(j + 1)) <= currentMin) {
                        mid = false;
                        open = false;
                    }
                }
            }
        }

        // emptying remaining stack
        while (top != -1) {
            braces.pop();
            top--;
            result.add(')');
        }

        return result;
    }

    private static String getStringRepresentation(ArrayList<Character> list) {
        StringBuilder builder = new StringBuilder(list.size());
        for (Character ch : list) {
            builder.append(ch);
        }
        return builder.toString();
    }
}