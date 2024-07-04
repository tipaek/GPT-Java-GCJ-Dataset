import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(in.readLine());
        for (int c = 1; c <= cases; ++c) {
            String s = in.readLine();
            StringBuilder sb = new StringBuilder();
            int n = 0;
            for (int i = 0; i < s.length(); ++i) {
                int d = s.charAt(i)-'0';
                while (d > n) {
                    sb.append("(");
                    ++n;
                }
                while (d < n) {
                    sb.append(")");
                    --n;
                }
                sb.append(d);
            }
            while (n > 0) {
                sb.append(")");
                --n;
            }
            System.out.printf("Case #%d: %s\n", c, sb.toString());
        }
    }
}
