import java.io.*;
import java.util.*;

public class Solution {
    static InputStream inputStream = System.in;
    static PrintWriter out = new PrintWriter(System.out);
    static InputReader in = new InputReader(inputStream);
    static int test;

    static void solve() throws Exception {
        int x = in.nextInt();
        int y = in.nextInt();

        boolean reverseX = x < 0;
        boolean reverseY = y < 0;

        if (reverseX) x = -x;
        if (reverseY) y = -y;

        StringBuilder result = new StringBuilder();

        while (x != 0 || y != 0) {
            if (x % 2 == 1) {
                if (y % 2 == 1) {
                    out.println("IMPOSSIBLE");
                    return;
                } else {
                    y /= 2;
                    if (y % 2 == 1) {
                        if (x % 4 == 3) {
                            x = (x + 1) / 2;
                            result.append("W");
                        } else {
                            x = (x - 1) / 2;
                            result.append("E");
                        }
                    } else {
                        if (x % 4 == 3 || y == 0) {
                            x = (x - 1) / 2;
                            result.append("E");
                        } else {
                            x = (x + 1) / 2;
                            result.append("W");
                        }
                    }
                }
            } else if (y % 2 == 1) {
                if (x % 2 == 1) {
                    out.println("IMPOSSIBLE");
                    return;
                } else {
                    x /= 2;
                    if (x % 2 == 1) {
                        if (y % 4 == 3) {
                            y = (y + 1) / 2;
                            result.append("S");
                        } else {
                            y = (y - 1) / 2;
                            result.append("N");
                        }
                    } else {
                        if (y % 4 == 3 || x == 0) {
                            y = (y - 1) / 2;
                            result.append("N");
                        } else {
                            y = (y + 1) / 2;
                            result.append("S");
                        }
                    }
                }
            } else {
                out.println("IMPOSSIBLE");
                return;
            }
        }

        String ans = result.toString();
        if (reverseX) {
            ans = ans.replace('E', 'e').replace('W', 'E').replace('e', 'W');
        }
        if (reverseY) {
            ans = ans.replace('N', 'n').replace('S', 'N').replace('n', 'S');
        }

        out.println(ans);
    }

    static void printCase() {
        out.print("Case #" + test + ": ");
    }

    public static void main(String[] args) {
        try {
            int tests = in.nextInt();
            for (test = 1; test <= tests; test++) {
                printCase();
                solve();
            }
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    String str = reader.readLine();
                    if (str == null) return "";
                    tokenizer = new StringTokenizer(str);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}