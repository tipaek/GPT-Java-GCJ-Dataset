import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        in.nextLine();
        StringBuilder result = new StringBuilder();

        for (int z=0;z < cases;++z) {
            Stack<String> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();
            int[] tokens = Arrays.stream(in.nextLine().split("")).mapToInt(Integer::valueOf).toArray();

            sb.append(genPs("(", tokens[0], stack)).append(tokens[0]);

            for (int i=1;i < tokens.length;++i) {
                int diff = tokens[i] - tokens[i - 1];
                if(diff == 0) {
                    sb.append(tokens[i]);
                } else if (diff > 0) {
                    sb.append(genPs("(", diff, stack)).append(tokens[i]);
                } else {
                    for (int j=0;j < Math.abs(diff);++j) stack.pop();
                    sb.append(genPs(")", Math.abs(diff), stack)).append(tokens[i]);
                }
            }

            while (!stack.isEmpty()) sb.append(stack.pop());

            result.append("Case #").append(z + 1).append(": ").append(sb.toString()).append("\n");
        }

        System.out.println(result.toString());
        in.close();
    }

    static String genPs(String p, int n, Stack<String> stack) {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i < n;i++) {
            sb.append(p);
            if (p.equals("(")) stack.push(")");
        }
        return sb.toString();
    }
}
