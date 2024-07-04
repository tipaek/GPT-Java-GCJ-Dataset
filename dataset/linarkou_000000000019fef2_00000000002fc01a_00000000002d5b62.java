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
            String xb = Integer.toBinaryString(Math.abs(x));
            String yb = Integer.toBinaryString(Math.abs(y));
            int next2 = Integer.highestOneBit(Math.abs(y)) * 2;
            String ybRev = Integer.toBinaryString(Math.abs(next2 - Math.abs(y)));
            int[] bits = new int[50];
            int[] bits2 = new int[50];
            int xbLength = xb.length();
            int ybLength = yb.length();
            int ybRevLength = ybRev.length();
            for (int i = xbLength - 1; i >= 0; --i) {
                if (xb.charAt(i) == '1') {
                    bits[xbLength - i - 1] = 1;
                    bits2[xbLength - i - 1] = 1;
                }
            }
            boolean canY = true;
            for (int i = ybLength - 1; i >= 0; --i) {
                if (yb.charAt(i) == '1') {
                    if (bits[ybLength - i - 1] != 1) {
                        bits[ybLength - i - 1] = 2;
                    } else {
                        canY = false;
                        break;
                    }
                } else if (bits[ybLength - i - 1] != 1) {
                    canY = false;
                    break;
                }
            }
            boolean canYreversed = true;
            if (bits2[ybLength] != 1) {
                bits2[ybLength] = -2;
            } else {
                canYreversed = false;
            }
            for (int i = ybLength - 1; i >= 0; --i) {
                if (i >= ybRevLength) {
                    if (bits[i] == 0) {
                        canYreversed = false;
                        break;
                    }
                    continue;
                }
                if (ybRev.charAt(i) == '1') {
                    if (bits2[ybRevLength - i - 1] != 1) {
                        bits2[ybRevLength - i - 1] = 2;
                    } else {
                        canYreversed = false;
                        break;
                    }
                } else if (bits2[ybRevLength - i - 1] != 1) {
                    canYreversed = false;
                    break;
                }
            }
            if (!canY && !canYreversed) {
                out.println("IMPOSSIBLE");
                continue;
            }
            boolean reversed = false;
            if (!canY) {
                bits = bits2;
                reversed = true;
            }
            boolean impossible = false;
            for (int i = 0; i < bits.length - 1; ++i) {
                if (bits[i+1] != 0 && bits[i] == 0) {
                    impossible = true;
                    break;
                }
            }
            if (impossible) {
                out.println("IMPOSSIBLE");
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bits.length; ++i) {
                if (bits[i] == 1) {
                    sb.append(x >= 0 ? 'E' : 'W');
                } else if (bits[i] == 2) {
                    if (!reversed) {
                        sb.append(y >= 0 ? 'N' : 'S');
                    } else {
                        sb.append(y >= 0 ? 'S' : 'N');
                    }
                } else if (reversed && bits[i] == -2) {
                    sb.append(y >= 0 ? 'N' : 'S');
                }
            }
            out.println(sb.toString());
        }
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