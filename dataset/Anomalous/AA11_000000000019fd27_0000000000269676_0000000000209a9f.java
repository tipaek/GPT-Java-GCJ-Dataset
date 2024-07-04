import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            String s = br.readLine();
            int n = s.length();
            StringBuilder res = new StringBuilder();
            int currentDepth = 0;

            for (int j = 0; j < n; j++) {
                int num = s.charAt(j) - '0';
                while (currentDepth < num) {
                    res.append('(');
                    currentDepth++;
                }
                while (currentDepth > num) {
                    res.append(')');
                    currentDepth--;
                }
                res.append(s.charAt(j));
            }

            while (currentDepth > 0) {
                res.append(')');
                currentDepth--;
            }

            System.out.println("Case #" + i + ": " + res.toString());
        }
    }
}