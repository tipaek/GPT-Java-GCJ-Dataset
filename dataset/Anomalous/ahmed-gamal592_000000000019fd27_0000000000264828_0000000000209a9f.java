import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static String solution(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '0') {
                while (!stack.isEmpty()) {
                    stack.pop();
                    ans.append(')');
                }
                ans.append(curr);
            } else {
                int num = curr - '0'; // Convert char to int

                while (stack.size() < num) {
                    ans.append('(');
                    stack.push('(');
                }
                while (stack.size() > num) {
                    stack.pop();
                    ans.append(')');
                }

                ans.append(curr);
            }
        }

        while (!stack.isEmpty()) {
            stack.pop();
            ans.append(')');
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();
        in.nextLine();

        for (int i = 0; i < tests; i++) {
            String line = in.nextLine();
            System.out.println(solution(line));
        }
    }
}