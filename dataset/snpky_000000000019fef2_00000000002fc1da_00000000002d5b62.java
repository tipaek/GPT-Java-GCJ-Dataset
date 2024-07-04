import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    public void solve(InputReader in, PrintWriter out) {
        int x = in.nextInt();
        int y = in.nextInt();

        int a = Math.abs(x);
        int b = Math.abs(y);
        if (a == b) {
            out.println("IMPOSSIBLE");
            return;
        }
        int sum = a+b;
        int high = next(sum);
        int c = (int) next(a);
        int d = (int) next(b);

        StringBuilder sb = new StringBuilder();
        if (sum+1 == high) {
            while(a > 0 || b > 0) {
                if (a%2 == 1) {
                    if (x > 0) {
                        sb.append('E');
                    } else {
                        sb.append('W');
                    }
                    a = a/2;
                }
                if (b%2 == 1) {
                    if (y > 0) {
                        sb.append('N');
                    } else {
                        sb.append('S');
                    }
                    b = b/2;
                }
            }
            out.println(sb.toString());
            return;
        }

        int cd = c-a;
        int dd = d-b;

        if ((c^d^cd^dd) != (high-1)) {
            out.println("IMPOSSIBLE");
            return;
        }

        while (c > 0 || d > 0 || cd > 0 || dd > 0) {
            if (c%2 == 1) {
                if (x > 0) {
                    sb.append('E');
                } else {
                    sb.append('W');
                }
                c = c/2;
                d = d/2;
                cd = cd/2;
                dd = dd/2;
            }
            if (d%2 == 1) {
                if (y > 0) {
                    sb.append('N');
                } else {
                    sb.append('S');
                }
                c = c/2;
                d = d/2;
                cd = cd/2;
                dd = dd/2;
            }
            if (cd%2 == 1) {
                if (x < 0) {
                    sb.append('E');
                } else {
                    sb.append('W');
                }
                c = c/2;
                d = d/2;
                cd = cd/2;
                dd = dd/2;
            }
            if (dd%2 == 1) {
                if (y < 0) {
                    sb.append('N');
                } else {
                    sb.append('S');
                }
                c = c/2;
                d = d/2;
                cd = cd/2;
                dd = dd/2;
            }
        }
        out.println(sb.toString());
    }

    public int next(int sum) {
        int high = 1;
        while(true) {
            if (sum <= high) {
                break;
            }
            high *= 2;
        }
        return high;
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Solution obj = new Solution();
        int t = in.nextInt();
        for (int a = 1; a <= t; a++) {
            out.print("Case #" + a + ": ");
            obj.solve(in, out);
        }
        out.close();
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public float nextFloat() {
            return Float.parseFloat(next());
        }

    }
}
