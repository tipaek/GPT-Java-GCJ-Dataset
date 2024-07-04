import java.io.*;
import java.util.*;

import static java.lang.Math.*;

class Main {
    static class Reader {
        BufferedReader in;

        Reader() throws IOException {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        StringTokenizer tok = new StringTokenizer("");

        String next() throws IOException {
            if (!tok.hasMoreTokens()) {
                tok = new StringTokenizer(in.readLine());
            }
            return tok.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }

    static class Writer {
        PrintWriter out;

        Writer() throws IOException {
            out = new PrintWriter(System.out);
        }


        StringBuilder str = new StringBuilder();

        void print(Object o) {
            str.append(o);
        }

        void close() {
            out.append(str);
            out.close();
        }
    }

    public static void main(String[] args) throws IOException {
        Reader in = new Reader();
        Writer out = new Writer();
        int t = in.nextInt();
        long M[][] = new long[100][100];
        for (int t0 = 0; t0 < t; t0++) {
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    M[i][j] = in.nextInt();
                }
            }
            long row = 0;
            long col = 0;
            long sum = 0;
            HashSet<Long> r;
            HashSet<Long> c;
            for (int i = 0; i < n; i++) {
                r = new HashSet<>();
                c = new HashSet<>();
                boolean ro = false;
                boolean co = false;
                for (int j = 0; j < n; j++) {
                    if (r.contains(M[i][j])) {
                        ro = true;
                    }
                    r.add(M[i][j]);
                    if (c.contains(M[j][i])) {
                        co = true;
                    }
                    c.add(M[j][i]);
                    if (i == j) {
                        sum += M[i][j];
                    }
                }
                if (ro) {
                    row++;
                }
                if (co) {
                    col++;
                }
            }
            out.print("Case #" + (t0 + 1) + ": " + sum + " " + row + " " + col + "\n");
        }
        out.close();
    }
}
