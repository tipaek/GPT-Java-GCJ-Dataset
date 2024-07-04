import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        solve(in, out);
        out.close();
    }

    public static void solve(InputReader in, PrintWriter out) {
        int t = in.nextInt();
        for (int index = 1; index <= t; ++index) {
            out.print("Case #");
            out.print(index);
            out.print(": ");
            Integer x = in.nextInt();
            Integer y = in.nextInt();
            if (x%2 == 1 && y%2 == 1) {
                out.println("IMPOSSIBLE");
                continue;
            }
            String res1 = solve(x,y);
            String res2 = solve(y,x);
            if ("IMPOSSIBLE".equals(res1)) {
                if ("IMPOSSIBLE".equals(res2)) {
                    out.println(res2);
                } else {
                    printReversed(out, res2);
                }
            } else {
                if ("IMPOSSIBLE".equals(res2)) {
                    out.println(res1);
                } else {
                    if (res1.length() < res2.length()) {
                        out.println(res1);
                    } else {
                        printReversed(out, res2);
                    }
                }
            }
        }
    }

    private static void printReversed(PrintWriter out, String res2) {
        for (int i = 0; i < res2.length(); ++i) {
            if (res2.charAt(i) == 'S') out.print('W');
            if (res2.charAt(i) == 'N') out.print('E');
            if (res2.charAt(i) == 'E') out.print('N');
            if (res2.charAt(i) == 'W') out.print('S');
        }
        out.println();
    }

    public static String solve(Integer x, Integer y) {
        String xb = Integer.toBinaryString(Math.abs(x));
        String yb = Integer.toBinaryString(Math.abs(y));
        int next2 = Integer.highestOneBit(Math.abs(y)) * 2;
        String ybRev = Integer.toBinaryString(Math.abs(next2 - Math.abs(y)));
        int xbLength = xb.length();
        int ybLength = yb.length();
        int ybRevLength = ybRev.length();
        boolean[] bitsx = new boolean[xbLength];
        boolean[] bitsy1 = new boolean[ybLength];
        boolean[] bitsy2 = new boolean[ybRevLength];
        for (int i = xbLength - 1; i >= 0; --i) {
            if (xb.charAt(i) == '1') {
                bitsx[xbLength - i - 1] = true;
            }
        }
        for (int i = ybLength - 1; i >= 0; --i) {
            if (yb.charAt(i) == '1') {
                bitsy1[ybLength - i - 1] = true;
            }
        }
        for (int i = ybRevLength - 1; i >= 0; --i) {
            if (ybRev.charAt(i) == '1') {
                bitsy2[ybRevLength - i - 1] = true;
            }
        }
        boolean canY = true;
        for (int i = 0; i < bitsy1.length; ++i) {
            if (!bitsy1[i] && i >= xbLength || bitsy1[i] && i < xbLength && bitsx[i] || !bitsy1[i] && i < xbLength && !bitsx[i]) {
                canY = false;
                break;
            }
        }
        if (xbLength - bitsy1.length >= 2) {
            canY = false;
        }
        boolean canYreversed = true;
        for (int i = 0; i < bitsy2.length; ++i) {
            if (!bitsy2[i] && i >= xbLength || bitsy2[i] && i < xbLength && bitsx[i] || !bitsy2[i] && i < xbLength && !bitsx[i]) {
                canYreversed = false;
                break;
            }
        }
        for (int i = bitsy2.length; i < ybLength; ++i) {
            if (i >= xbLength || !bitsx[i]) {
                canYreversed = false;
                break;
            }
        }
        if (xbLength - (ybLength + 1) >= 2) {
            canYreversed = false;
        }
        if (!canY && !canYreversed) {
            return "IMPOSSIBLE";
        }
        boolean reversed = false;
        boolean[] bitsy = bitsy1;
        if (!canY) {
            bitsy = bitsy2;
            reversed = true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.max(bitsx.length, ybLength + 1); ++i) {
            if (i < xbLength && bitsx[i]) {
                sb.append(x >= 0 ? 'E' : 'W');
            } else if (i < bitsy.length && bitsy[i]) {
                if (!reversed) {
                    sb.append(y >= 0 ? 'N' : 'S');
                } else {
                    sb.append(y >= 0 ? 'S' : 'N');
                }
            } else if (reversed && i == ybLength) {
                sb.append(y >= 0 ? 'N' : 'S');
            }
        }
        return sb.toString();
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

        public void skip() {
            tokenizer = null;
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}