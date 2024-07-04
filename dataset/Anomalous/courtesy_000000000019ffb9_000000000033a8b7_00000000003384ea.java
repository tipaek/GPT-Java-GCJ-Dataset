import java.io.*;
import java.util.*;

public class Solution {

    public static FastReader fr = new FastReader();
    public static OutputWriter op = new OutputWriter();

    public static void main(String[] args) throws IOException {
        int T = fr.nextInt();
        for (int cs = 1; cs <= T; cs++) {
            long L = fr.nextLong();
            long R = fr.nextLong();

            long n = 0;
            if (L > R) {
                long D = L - R;
                n = calculateN(D);
                L -= (n * (n + 1)) / 2;
            } else {
                long D = R - L;
                n = calculateN(D);
                R -= (n * (n + 1)) / 2;
            }

            boolean swapped = false;
            if (R > L) {
                long temp = L;
                L = R;
                R = temp;
                swapped = true;
            }

            long x1 = calculateX(L, n);
            long x2 = calculateX(R, n + 1);
            long ans = n + x1 + x2;

            long pl = L - (n * x1 + x1 * x1);
            long pr = R - (n * x2 + x2 * (x2 + 1));

            if (swapped) {
                long temp = pr;
                pr = pl;
                pl = temp;
            }

            System.out.println("Case #" + cs + ": " + ans + " " + pl + " " + pr);
        }
    }

    public static long calculateN(long D) {
        double t = (Math.sqrt(8 * D + 1) - 1) / 2.0;
        return (long) Math.floor(t);
    }

    public static long calculateX(long D, long n) {
        double t = (Math.sqrt(4 * D + n * n) - n) / 2.0;
        return (long) Math.floor(t);
    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter() {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        }

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) writer.print(' ');
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

        public void flush() {
            writer.flush();
        }
    }

    static class FastReader {
        private final BufferedReader br;
        private StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
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

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}