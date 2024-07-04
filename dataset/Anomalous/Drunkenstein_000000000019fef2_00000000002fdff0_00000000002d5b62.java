import java.io.*;
import java.util.*;

public class Solution {
    static InputStream inputStream;
    static PrintWriter out;
    static InputReader in;
    static int test;

    public static void main(String[] args) {
        try {
            inputStream = System.in;
            out = new PrintWriter(System.out);
            in = new InputReader(inputStream);

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

    static void solve() throws Exception {
        int x = in.nextInt();
        int y = in.nextInt();

        boolean reverseX = x < 0;
        boolean reverseY = y < 0;

        if (reverseX) x = -x;
        if (reverseY) y = -y;

        StringBuilder result = new StringBuilder();

        if (x != 0 && y != 0) {
            while (x != 0 && y != 0) {
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
        }

        if (x != 0) {
            while (x != 0) {
                if (x % 2 == 0) {
                    out.println("IMPOSSIBLE");
                    return;
                }
                if (x % 4 == 3 || x == 1) {
                    x = (x - 1) / 2;
                    result.append("E");
                } else {
                    x = (x + 1) / 2;
                    result.append("W");
                }
            }
        }

        if (y != 0) {
            while (y != 0) {
                if (y % 2 == 0) {
                    out.println("IMPOSSIBLE");
                    return;
                }
                if (y % 4 == 3 || y == 1) {
                    y = (y - 1) / 2;
                    result.append("N");
                } else {
                    y = (y + 1) / 2;
                    result.append("S");
                }
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
                    String str = reader.readLine();
                    if (str == null)
                        return "";
                    else
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