import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tc = in.nextInt();
        in.nextLine();
        for (int t = 1; t <= tc; ++t) {
            String line = in.nextLine();

            Stack<Character> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                int num = ch - '0';
                if (num == stack.size()) {
                    sb.append(ch);
                } else if (num < stack.size()) {
                    while(num != stack.size()) {
                        sb.append(stack.pop());
                    }
                    sb.append(num);
                } else {
                    int prNum = i > 0 ? line.charAt(i - 1) - '0' : 0;
                    while(prNum != stack.size()) {
                        sb.append(stack.pop());
                    }
                    for (int j = 0; j < num - prNum; j++) {
                        sb.append("(");
                        stack.push(')');
                    }
                    sb.append(num);
                }
            }
            while(!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            System.out.println(String.format("Case #%s: %s ", t, sb.toString()));

        }
    }
}
