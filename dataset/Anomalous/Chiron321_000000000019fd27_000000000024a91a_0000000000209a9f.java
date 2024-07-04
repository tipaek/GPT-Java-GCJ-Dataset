import java.util.Scanner;
import java.util.Stack;

public class Solution {
    private static String result = "";
    private static Stack<String> stack;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseNo = 1;
        int testCases = sc.nextInt();
        
        while (testCases-- > 0) {
            result = "";
            stack = new Stack<>();
            char[] inputChars = sc.next().toCharArray();
            
            for (int i = 0; i < inputChars.length; i++) {
                if (inputChars[i] == '1') {
                    handleOne(inputChars[i]);
                }
                if (inputChars[i] == '0' || i == inputChars.length - 1) {
                    handleZero(inputChars[i]);
                }
            }
            
            System.out.println("Case #" + caseNo + ": " + result);
            caseNo++;
        }
        
        sc.close();
    }

    private static void handleZero(char number) {
        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                stack.pop();
                result += ")";
            }
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