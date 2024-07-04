//package com.google.jam;

import java.io.*;
import java.util.*;

import static java.lang.System.exit;


public class Solution {
    static InputStream inputStream;
    static PrintWriter out;
    static InputReader in;
    static int test;

    static void solve() throws Exception {
        int x = in.nextInt();
        int y = in.nextInt();

        int reverseX = 0;
        int reverseY = 0;

        if (x < 0) {
            x = -x;
            reverseX = 1;
        }
        if (y < 0) {
            y = -y;
            reverseY = 1;
        }

        StringBuilder result = new StringBuilder();

        if (x != 0 && y != 0)
            do {
                if (x % 2 == 1) {
                    if (y % 2 == 1) {
                        out.println("IMPOSSIBLE");
                        return;
                    } else {
                        y = y / 2;
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
                        x = x / 2;
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
            } while (x != 0 && y != 0);

        if (x != 0) {
            do {
                if (x % 2 == 0) {
                    out.println("IMPOSSIBLE");
                    return;
                }
                if (x % 4 == 3 || x==1) {
                    x = (x - 1) / 2;
                    result.append("E");
                } else {
                    x = (x + 1) / 2;
                    result.append("W");
                }
            } while (x != 0);
        }

        if (y != 0) {
            do {
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
            } while (y != 0);
        }


        String ans = result.toString();
        if (reverseX == 1) {
            ans = ans.replace('E', 'e');
            ans = ans.replace('W', 'E');
            ans = ans.replace('e', 'W');
        }
        if (reverseY == 1) {
            ans = ans.replace('N', 'n');
            ans = ans.replace('S', 'N');
            ans = ans.replace('n', 'S');
        }


        out.println(ans);
    }

    static int getVal(int row, int col) {
        return col == 0 ? 1 : row;
    }

    static void printCase() {
        out.print("Case #" + test + ": ");
    }

    public static void main(String[] args) {
        try {
            //inputStream = new FileInputStream(new File("./src/test.txt"));
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
            exit(1);
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) throws FileNotFoundException {
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
