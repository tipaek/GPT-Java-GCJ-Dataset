/*
 * Copyright (c) 2015, 2099, Ashok and/or its affiliates. All rights reserved.
 * ASHOK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms, But you are free to use it :).
 *
 */
// package com.ashok.codejam.cj20.r1C;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Problem Name:
 * Link:
 *
 * @author Ashok Rajpurohit (ashok1113@gmail.com)
 */
class oneC2020 {
    private static final PrintWriter out = new PrintWriter(System.out);
    private static final InputReader in = new InputReader();
    private static final String CASE = "Case #";

    public static void main(String[] args) throws IOException {
        solve();
        in.close();
        out.close();
    }

    private static void solve() throws IOException {
        int t = in.readInt();
        for (int i = 1; i <= t; i++) {
            print(i, process());
        }
    }

    private static String process() throws IOException {
        return PeppurrCat.process();
    }

    final static class PeppurrCat {
        private static String process() throws IOException {
            int x = in.readInt(), y = in.readInt();
            String m = in.read();
            Point[] catPath = new Point[m.length() + 1];
            catPath[0] = new Point(x, y);
            for (int i = 0; i < m.length(); i++) {
                char ch = m.charAt(i);
                if (ch == 'E') x++;
                else if (ch == 'W') x--;
                else if (ch == 'N') y++;
                else y--;
                catPath[i + 1] = new Point(x, y);
            }

            Point self = new Point(0, 0);
            for (int i = 0; i < catPath.length; i++) {
                if (self.distance(catPath[i]) <= i) return "" + i;
            }

            return "IMPOSSIBLE";
        }

    }

    final static class Point {
        final int x, y;

        Point(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        int distance(Point point) {
            return Math.abs(x - point.x) + Math.abs(y - point.y);
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    private static void print(int testNo, String result) {
        out.println(String.join(" ", CASE + testNo + ":", result));
    }

    private static class InputReader {
        protected byte[] buffer = new byte[8192];
        protected int offset = 0;
        protected int bufferSize = 0;
        InputStream in;

        public InputReader() {
            in = System.in;
        }

        public void close() throws IOException {
            in.close();
        }

        public int readInt() throws IOException {
            int number = 0;
            int s = 1;
            if (offset == bufferSize) {
                offset = 0;
                bufferSize = in.read(buffer);
            }
            if (bufferSize == -1)
                throw new IOException("No new bytes");
            for (; buffer[offset] < 0x30 || buffer[offset] == '-'; ++offset) {
                if (buffer[offset] == '-')
                    s = -1;
                if (offset == bufferSize - 1) {
                    offset = -1;
                    bufferSize = in.read(buffer);
                }
            }
            for (; offset < bufferSize && buffer[offset] > 0x2f; ++offset) {
                number = (number << 3) + (number << 1) + buffer[offset] - 0x30;
                if (offset == bufferSize - 1) {
                    offset = -1;
                    bufferSize = in.read(buffer);
                }
            }
            ++offset;
            return number * s;
        }

        public String read() throws IOException {
            StringBuilder sb = new StringBuilder();
            if (offset == bufferSize) {
                offset = 0;
                bufferSize = in.read(buffer);
            }

            if (bufferSize == -1 || bufferSize == 0)
                throw new IOException("No new bytes");

            for (;
                 buffer[offset] == ' ' || buffer[offset] == '\t' || buffer[offset] ==
                         '\n' || buffer[offset] == '\r'; ++offset) {
                if (offset == bufferSize - 1) {
                    offset = -1;
                    bufferSize = in.read(buffer);
                }
            }
            for (; offset < bufferSize; ++offset) {
                if (buffer[offset] == ' ' || buffer[offset] == '\t' ||
                        buffer[offset] == '\n' || buffer[offset] == '\r')
                    break;
                if (Character.isValidCodePoint(buffer[offset])) {
                    sb.appendCodePoint(buffer[offset]);
                }
                if (offset == bufferSize - 1) {
                    offset = -1;
                    bufferSize = in.read(buffer);
                }
            }
            return sb.toString();
        }
    }
}
