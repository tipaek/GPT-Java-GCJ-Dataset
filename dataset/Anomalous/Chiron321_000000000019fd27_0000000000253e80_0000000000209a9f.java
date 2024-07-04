import java.util.Scanner;
import java.util.Stack;

public class Solution {
    private static String result = "";
    private static Stack<String> stack;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNumber = 1;
        int testCases = scanner.nextInt();
        
        while (testCases-- > 0) {
            result = "";
            stack = new Stack<>();
            char[] input = scanner.next().toCharArray();
            
            for (char ch : input) {
                int number = Character.getNumericValue(ch);
                
                if (number > stack.size()) {
                    pushToStack(number);
                } else if (number < stack.size()) {
                    popFromStack(number);
                } else {
                    result += ch;
                }
            }
            
            while (!stack.isEmpty()) {
                stack.pop();
                result += ")";
            }
            
            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }
        
        scanner.close();
    }

    private static void popFromStack(int number) {
        while (number < stack.size()) {
            result += ")";
            stack.pop();
        }
        result += number;
    }

    private static void pushToStack(int number) {
        while (number > stack.size()) {
            result += "(";
            stack.push("(");
        }
        result += number;
    }
}