import java.util.Scanner;
import java.util.Stack;

public class Solution {
    static String result = "";
    static Stack < String > stack;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseNo = 1;
        int test = sc.nextInt();
        while (test--> 0) {
            result = "";
            stack = new Stack <String> ();
            char[] testCase = sc.next().toCharArray();
            for (int i = 0; i < testCase.length; i++) {
                if (testCase[i] == '1') {
                    pushIntoStack(testCase[i]);
                }
                if (testCase[i] == '0' || i == testCase.length - 1) {
                    popFromStack(testCase[i]);
                }
            }
            System.out.println("Case #" + caseNo + ": "+ result);
            caseNo++;
        }
        sc.close();
    }

    private static void popFromStack(char number) {
        if (!stack.empty()) {
            result += ")";
            stack.pop();
        }
        result += (number == '0') ? number : "";
    }

    private static void pushIntoStack(char number) {
        if(stack.empty()) {
            result += "(" + number;
            stack.push("(");
        }
        else
        result += number;
    }
}