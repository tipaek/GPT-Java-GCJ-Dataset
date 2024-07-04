

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
    private static boolean isBalance(String temp){
        Stack<Character> stack = new Stack<>();
        for(char ch : temp.toCharArray()){
            if(ch=='('){
                stack.push(ch);
            }else if(ch==')' && stack.peek()=='('){
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());

        for (int t = 1; t <= test; t++) {
            StringBuilder builder = new StringBuilder();
            String candidate = br.readLine();
            int first = candidate.charAt(0) - '0';
            int end = first;
            for (int idx = 0; idx < first; idx++) {
                builder.append("(");
            }
            builder.append(first);
            for (int index = 1; index < candidate.length(); index++) {
                int value = candidate.charAt(index) - '0';
                if (value == first) {
                    builder.append(value);
                } else if (value < first) {
                    int diff = first - value;
                    for (int idx = 0; idx < diff; idx++) {
                        builder.append(")");
                    }
                    builder.append(value);
                    end = end - diff;
                } else if(value > first) {
                    int diff = value - end;
                    end = value;
                    for (int idx = 0; idx < diff; idx++) {
                        builder.append("(");
                    }
                    builder.append(value);
                }
                first = value;
            }
            for (int idx = 0; idx < end; idx++) {
                builder.append(")");
            }
            StringBuilder ans = new StringBuilder();
            ans.append("Case #");
            ans.append(t);
            ans.append(": ");
            ans.append(builder);
            System.out.println(ans.toString());
        }
    }

}
