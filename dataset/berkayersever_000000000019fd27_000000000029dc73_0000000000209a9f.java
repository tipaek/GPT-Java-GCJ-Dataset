import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int t = Integer.parseInt(input.nextLine());
        for (int i = 1; i <= t; i++) {
            String s = input.nextLine();
            System.out.println("Case #" + i + ": " + checkNestingDepth(s));
        }
    }

    public static String checkNestingDepth(String s) {
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            int digit = Integer.parseInt(s.substring(i, i + 1));
            if (!stack.isEmpty() && stack.peek().equals(")") && digit > 0) {
                while (stack.peek().equals(")") && count < digit) {
                    stack.pop();
                    count++;
                }
            }
            for (int j = 0; j < digit - count; j++) {
                stack.push("(");
            }
            stack.push(Integer.toString(digit));
            for (int j = 0; j < digit; j++) {
                stack.push(")");
            }
        }
        return stack.toString().replaceAll("\\s+","").replaceAll(",","").replaceAll("\\[","").replaceAll("\\]","");
    }
}