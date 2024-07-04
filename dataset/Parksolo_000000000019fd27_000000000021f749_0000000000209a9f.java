import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

    private static String run(final String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            int digit = Character.getNumericValue(chars[i]);
            int prev = 0;
            if (i > 0) {
                prev = Character.getNumericValue(chars[i - 1]);
            }
            for (int j = 0; j < prev - digit; j++) {
                sb.append(stack.pop());
            }
            int cnt = digit - stack.size();
            for (int j = 0; j < cnt; j++) {
                sb.append("(");
                stack.push(")");
            }
            sb.append(digit);
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseCnt = Integer.parseInt(br.readLine());
        for (int t = 1; t <= caseCnt; t++) {
            String output = String.format("Case #%s: %s", t, run(br.readLine()));
            System.out.println(output);
        }
    }
}