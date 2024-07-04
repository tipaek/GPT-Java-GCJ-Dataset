
import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for(int i = 1; i <= T; i++) {
            String s = sc.nextLine();
            String re = helper(s);
            System.out.println(String.format("Case #%s: %s", i, re));
        }
    }


    private static String helper(String s) {

        Stack<Character> stack = new Stack<>();
        char[] sArr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < sArr.length; i++) {
            int num = sArr[i] - '0';
            if (num > stack.size()) {
                while(num != stack.size()) {
                    stack.push('(');
                    sb.append('(');
                }
                sb.append(num);
            } else if (num == stack.size()) sb.append(num);
            else {
                while(stack.size() != num) {
                    stack.pop();
                    sb.append(')');
                }
                sb.append(num);
            }
        }

        while(stack.size() > 0) {
            stack.pop();
            sb.append(')');
        }
        return sb.toString();
    }


}
