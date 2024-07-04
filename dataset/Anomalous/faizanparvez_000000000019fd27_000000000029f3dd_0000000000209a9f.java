import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            String input = reader.readLine();
            solve(input);
        }
    }

    static void solve(String input) {
        StringBuilder ans = new StringBuilder();
        char[] arr = input.toCharArray();
        Stack<Integer> stack = new Stack<>();

        for (char c : arr) {
            int currentNum = Character.getNumericValue(c);
            if (stack.isEmpty()) {
                for (int i = 0; i < currentNum; i++) {
                    ans.append('(');
                }
            } else {
                int diff = stack.peek() - currentNum;
                if (diff > 0) {
                    for (int i = 0; i < diff; i++) {
                        ans.append(')');
                    }
                } else if (diff < 0) {
                    for (int i = 0; i < -diff; i++) {
                        ans.append('(');
                    }
                }
            }
            ans.append(currentNum);
            stack.push(currentNum);
        }

        if (!stack.isEmpty()) {
            int lastNum = stack.pop();
            for (int i = 0; i < lastNum; i++) {
                ans.append(')');
            }
        }

        System.out.print(ans.toString());
    }
}