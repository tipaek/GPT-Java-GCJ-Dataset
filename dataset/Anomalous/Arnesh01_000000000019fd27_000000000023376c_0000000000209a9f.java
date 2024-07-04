import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            String s = br.readLine();
            int depth = 0;
            StringBuilder currentResult = new StringBuilder();

            for (char c : s.toCharArray()) {
                int digit = c - '0';
                while (depth < digit) {
                    currentResult.append('(');
                    depth++;
                }
                while (depth > digit) {
                    currentResult.append(')');
                    depth--;
                }
                currentResult.append(digit);
            }

            while (depth > 0) {
                currentResult.append(')');
                depth--;
            }

            result.append("Case #").append(t).append(": ").append(currentResult).append("\n");
        }

        System.out.print(result);
    }
}