import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.nio.charset.StandardCharsets.UTF_8;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in, UTF_8));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out, UTF_8))) {
            int tests = parseInt(in.readLine().trim());
            for (int t = 1; t <= tests; t++) {
                int u = parseInt(in.readLine().trim());
                int[] q = new int[10000];
                String[] qs = new String[10000];
                String[] r = new String[10000];
                for (int i = 0; i < 10000; i++) {
                    StringTokenizer tokens = new StringTokenizer(in.readLine());
                    q[i] = parseInt(tokens.nextToken());
                    qs[i] = q[i] + "";
                    r[i] = tokens.nextToken();
                }
                if (u == 2) {
                    String defined = "";
                    for (int digit = 1; digit <= 9; digit++) {
                        for (int i = 0; i < q.length; i++) {
                            if (q[i] == digit && !defined.contains(r[i])) {
                                defined = defined + r[i];
                                break;
                            }
                        }
                    }
                    boolean ok = false;
                    for (int i = 0; i < r.length; i++) {
                        for (int j = 0; j < r[i].length(); j++) {
                            if (!defined.contains(r[i].charAt(j) + "")) {
                                defined = r[i].charAt(j) + defined;
                                ok = true;
                                break;
                            }
                        }
                        if (ok) {
                            break;
                        }
                    }
                    out.write("Case #" + t + ": " + defined);
                    out.newLine();
                }
            }
        }
    }
}
