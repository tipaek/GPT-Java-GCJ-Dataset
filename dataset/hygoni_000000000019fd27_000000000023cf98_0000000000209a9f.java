import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static String repeat(char c, int len) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++) {
            sb.append(c);
        }
        return sb.toString();
    }
    public static String solve(String input) {
        StringBuilder sb = new StringBuilder();
        int depth = 0;
        for(int i = 0; i < input.length(); i++) {
            int n = input.charAt(i) - '0';
            if (depth < n) {
                sb.append(repeat('(', n - depth));
                depth = n;
                sb.append((char)(n + '0'));
            } else if (depth > n) {
                sb.append(repeat(')', depth - n));
                sb.append((char)(n + '0'));
                depth = n;
            } else {
                sb.append((char)(n + '0'));
            }
        }
        sb.append(repeat(')', depth));
        return sb.toString();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            System.out.println(solve(input));
        }
        br.close();
    }
}
