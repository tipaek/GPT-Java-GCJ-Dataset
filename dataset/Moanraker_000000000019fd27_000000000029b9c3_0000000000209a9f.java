import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            oneRun(i);
        }
    }

    private static void oneRun(int num) throws IOException {
        char[] tokens = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();

        char prev = '0';

        for (int i = 0; i < tokens.length; i++) {
            int diff = tokens[i] - prev;
            char paren = diff > 0 ? '(' : ')';
            for (int j = 0; j < Math.abs(diff); j++) {
                sb.append(paren);
            }
            sb.append(tokens[i]);
            prev = tokens[i];
        }

        for (int i = '0'; i < prev; i++) {
            sb.append(')');
        }

        System.out.println(String.format("Case #%s: %s", num, sb.toString()));
    }
}