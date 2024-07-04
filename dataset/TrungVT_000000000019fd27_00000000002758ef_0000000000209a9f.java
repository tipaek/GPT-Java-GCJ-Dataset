import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            System.out.println(solve2(br.readLine(), i + 1));
        }
    }

    public static String solve2(String input, int index) {
        return "Case #"
                + index + ": "
                + addBrackets(input);
    }

    private static String addBrackets(String input) {
        StringBuilder sb = new StringBuilder();
        int depth = 0;
        for (char ch : input.toCharArray()) {
            int d = ch - '0';
            while (depth != d) {
                if (depth < d) {
                    sb.append('(');
                    depth++;
                } else {
                    sb.append(')');
                    depth--;
                }
            }
            sb.append(ch);
        }
        while (depth > 0) {
            sb.append(')');
            depth--;
        }
        return sb.toString();
    }

}
