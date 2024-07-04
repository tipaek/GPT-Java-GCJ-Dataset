import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            String expression = scanner.next();
            String result = processExpression(expression);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }
    
    private static String processExpression(String expression) {
        Stack<Character> stack = new Stack<>();
        ArrayList<Character> result = new ArrayList<>();
        int top = -1;
        int currentMax = 0;
        int currentMin = 200;
        boolean open = true;
        boolean mid = false;
        
        for (int j = 0; j < expression.length(); j++) {
            char currentChar = expression.charAt(j);
            int currentInt = Character.getNumericValue(currentChar);
            
            if (!open) {
                if (currentInt == currentMax) {
                    result.add(currentChar);
                } else if (currentInt < currentMax) {
                    while (top > (currentInt - 1)) {
                        stack.pop();
                        top--;
                        result.add(')');
                    }
                    result.add(currentChar);
                    currentMin = Math.min(currentMin, currentInt);
                    if (j != expression.length() - 1 && Character.getNumericValue(expression.charAt(j + 1)) > currentMin) {
                        open = true;
                        mid = true;
                        continue;
                    }
                    if (top == -1) {
                        open = true;
                        continue;
                    }
                } else {
                    while (top != -1) {
                        stack.pop();
                        top--;
                        result.add(')');
                    }
                    open = true;
                }
            }
            
            if (open) {
                currentMax = Math.max(currentMax, currentInt);
                currentMin = Math.min(currentMin, currentInt);
                if (!mid) {
                    for (int temp = 0; temp < currentInt; temp++) {
                        stack.push('(');
                        top++;
                        result.add('(');
                    }
                    result.add(currentChar);
                    open = false;
                } else {
                    int limit = currentInt - top - 1;
                    for (int temp = 0; temp < limit; temp++) {
                        stack.push('(');
                        top++;
                        result.add('(');
                    }
                    result.add(currentChar);
                    if (j != expression.length() - 1 && !(Character.getNumericValue(expression.charAt(j + 1)) > currentMin)) {
                        mid = false;
                        open = false;
                    }
                }
            }
        }
        
        while (top != -1) {
            stack.pop();
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