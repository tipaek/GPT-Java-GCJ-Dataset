import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String s = br.readLine();
            Stack r = new Stack();
            int p = 0;

            for (int c: s.toCharArray()) {
                c -= '0';
                if (c > p) {
                    for (int i = 0; i < c - p; i++) {
                        r.push('(');
                    }
                }
                else if (c < p) {
                    for (int i = 0; i < p - c; i++) {
                        r.push(')');
                    }
                }

                r.push((char)(c + '0'));
                p = c;
            }

            for (int i = 0; i < p; i++) {
                r.push(')');
            }

            System.out.println("Case #" + (-~t) + ": " + r.toString().replaceAll("\\[|\\]| |,", ""));
        }

        br.close();
    }
}