import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(in.readLine());
        Solver s = new Solver();
        for (int i = 1; i <= testCount; i++) {
           s.solve(i, in);
        }
    }

    static class Solver {
        void solve(int k, BufferedReader in) throws IOException {
            StringBuilder res = new StringBuilder();
            String line = in.readLine();
            int pos = 0;
            for (int i = 0; i < line.length(); i++) {
                int curr = line.charAt(i) - '0';

                if (pos < curr) {
                    while (pos < curr) {
                        res.append("(");
                        pos++;
                    }
                } else {
                    if (pos > curr) {
                        while (pos > curr) {
                            res.append(")");
                            pos--;
                        }
                    }
                }

                // append same char
                res.append(curr);
                while (i + 1 < line.length() && (line.charAt(i + 1) - '0') == curr) {
                    res.append(curr);
                    i++;
                }
            }

            while (pos > 0) {
                res.append(")");
                pos--;
            }


            System.out.println("Case #" + k + ": " + res);
        }
    }
}
