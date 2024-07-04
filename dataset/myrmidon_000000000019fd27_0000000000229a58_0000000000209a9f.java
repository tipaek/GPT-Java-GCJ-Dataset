import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final int t = Integer.parseInt(br.readLine());
        final String[] ps = new String[10];
        final String[] pe = new String[10];
        ps[0] = "";
        pe[0] = "";
        for (int i=1; i<10; i++) {
            ps[i] = ps[i - 1].concat("(");
            pe[i] = pe[i - 1].concat(")");
        }
        for (int ti = 1; ti <= t; ti++) {
            final String s = br.readLine();
            int p = 0;
            final StringBuilder sb = new StringBuilder();
            for (int i=0; i<s.length(); i++) {
                final int d = s.charAt(i)-'0';
                if (p < d) {
                    sb.append(ps[d - p]);
                } else {
                    sb.append(pe[p-d]);
                }
                sb.append(d);
                p=d;
            }
            sb.append(pe[p]);
            System.out.println(String.format("Case #%d: %s", ti, sb.toString()));
        }
    }
}
