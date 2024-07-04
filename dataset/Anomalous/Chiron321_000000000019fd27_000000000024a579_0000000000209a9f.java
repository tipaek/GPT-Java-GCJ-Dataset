import java.util.Scanner;
import java.util.Stack;

public class Solution {
    private static String result;
    private static Stack<String> stack;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        
        while (testCases-- > 0) {
            result = "";
            stack = new Stack<>();
            char[] testCase = sc.next().toCharArray();
            
            for (int i = 0; i < testCase.length; i++) {
                if (testCase[i] == '1') {
                    handleOne(testCase[i]);
                }
                if (testCase[i] == '0' || i == testCase.length - 1) {
                    handleZeroOrEnd(testCase[i]);
                }
            }
            System.out.println(result);
        }
        sc.close();
    }

    private static void handleZeroOrEnd(char number) {
        while (!stack.isEmpty()) {
            stack.pop();
            result += ")";
        }
        if (number == '0') {
            result += number;
        }
    }

    private static void handleOne(char number) {
        if (stack.isEmpty()) {
            result += "(" + number;
        } else {
            result += "(" + number;
        }
        stack.push("(");
    }
}