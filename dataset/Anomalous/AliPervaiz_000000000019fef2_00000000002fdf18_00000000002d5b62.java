import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = Integer.parseInt(input.readLine());

        for (int tc = 1; tc <= T; tc++) {
            out.print("Case #" + tc + ": ");
            StringTokenizer st = new StringTokenizer(input.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if ((x + y) % 2 == 0) {
                out.println("IMPOSSIBLE");
            } else if (Math.abs(x) + Math.abs(y) == 1) {
                if (x == 1) out.println("E");
                else if (x == -1) out.println("W");
                else if (y == 1) out.println("N");
                else if (y == -1) out.println("S");
            } else {
                long sum = Math.abs(x) + Math.abs(y);
                long bits = 0;
                long wow = 1;

                while (wow < sum) {
                    bits++;
                    wow *= 2;
                }

                long total = (1 << bits) - 1;
                long diff = total - (x + y);
                diff >>= 1;
                StringBuilder ans = new StringBuilder();

                for (int i = 0; i < bits; i++) {
                    long v = 1 << i;
                    if ((diff & v) != 0) v *= -1;
                    v /= Math.abs(v);

                    if (x % 2 != 0) {
                        if (v < 0) ans.append("W");
                        else ans.append("E");
                        x -= v;
                    } else {
                        if (v < 0) ans.append("S");
                        else ans.append("N");
                        y -= v;
                    }
                    x /= 2;
                    y /= 2;
                }

                out.println(ans);
            }
        }

        out.flush();
        out.close();
    }
}