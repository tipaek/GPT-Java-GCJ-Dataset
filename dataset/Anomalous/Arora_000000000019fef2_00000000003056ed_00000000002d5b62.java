import java.io.*;
import java.util.*;

class Solution { // PRACTICE
    public static void main(String args[]) {
        FastScanner sc = new FastScanner(System.in);
        int t = sc.nextInt();
        for (int p1 = 0; p1 < t; p1++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int[] a = new int[32];
            int[] b = new int[32];
            int ns = 1, ew = 1;

            if (x < 0) {
                x = Math.abs(x);
                ew = -1;
            }
            if (y < 0) {
                y = Math.abs(y);
                ns = -1;
            }

            String xBinary = Integer.toBinaryString(x);
            String yBinary = Integer.toBinaryString(y);
            int xLength = xBinary.length();
            int yLength = yBinary.length();

            for (int i = 0; i < xLength; i++) {
                a[31 - i] = xBinary.charAt(xLength - 1 - i) - '0';
            }

            for (int i = 0; i < yLength; i++) {
                b[31 - i] = yBinary.charAt(yLength - 1 - i) - '0';
            }

            int flag = 0;
            int firstNonZeroIndex = -1;

            for (int i = 0; i < 32; i++) {
                if (a[i] == 1 || b[i] == 1) {
                    firstNonZeroIndex = i;
                    break;
                }
            }

            for (int i = 31; i >= firstNonZeroIndex; i--) {
                if (a[i] != b[i]) {
                    continue;
                } else {
                    if (i == 31) {
                        flag = 1;
                        break;
                    } else if (a[i] == 0) {
                        if (a[i + 1] == 1) {
                            a[i + 1] = -1;
                            a[i] = 1;
                        } else if (b[i + 1] == 1) {
                            b[i + 1] = -1;
                            b[i] = 1;
                        }
                    } else if (a[i] == 1) {
                        if (a[i + 1] == 1) {
                            a[i + 1] = -1;
                            for (int j = i; j >= 0; j--) {
                                if (a[j] == 1) {
                                    a[j] = 0;
                                } else {
                                    a[j] = 1;
                                    break;
                                }
                            }
                        } else if (b[i + 1] == 1) {
                            b[i + 1] = -1;
                            for (int j = i; j >= 0; j--) {
                                if (b[j] == 1) {
                                    b[j] = 0;
                                } else {
                                    b[j] = 1;
                                    break;
                                }
                            }
                        }
                    }
                }
            }

            if (flag == 1) {
                System.out.println("Case #" + (p1 + 1) + ": IMPOSSIBLE");
            } else {
                StringBuilder ans = new StringBuilder();
                for (int i = 31; i >= 0; i--) {
                    if (a[i] * ew == -1) {
                        ans.append("W");
                    } else if (a[i] * ew == 1) {
                        ans.append("E");
                    } else if (b[i] * ns == -1) {
                        ans.append("S");
                    } else if (b[i] * ns == 1) {
                        ans.append("N");
                    } else {
                        break;
                    }
                }
                System.out.println("Case #" + (p1 + 1) + ": " + ans.toString());
            }
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}