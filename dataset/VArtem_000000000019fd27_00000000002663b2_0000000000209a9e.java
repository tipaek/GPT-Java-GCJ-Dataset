import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ESAbATAd solver = new ESAbATAd();
        solver.solve(1, in, out);
        out.close();
    }

    static class ESAbATAd {
        public void solve(int testNumber, FastScanner in, PrintWriter out) {
//        out.printf("Case #%d: ", testNumber);
            int t = in.nextInt();
            int b = in.nextInt();
            while (t-- > 0) {
                int[] bits = new int[b];
                Arrays.fill(bits, -1);
                for (int block = 0; block < b / 10; block++) {
                    for (int i = 0; i < 5; i++) {
                        int left = block * 5 + i;
                        bits[left] = ask(in, out, left);
                        bits[b - 1 - left] = ask(in, out, b - 1 - left);
                    }
                }

                for (int block = 0; block < b / 10; block++) {
                    fixBlock(bits, in, out, 5 * block, b - 1 - 5 * block, 5);
                }
                if (b <= 20) {
                    printBits(in, out, bits);
                    continue;
                }

                fixBlock(bits, in, out, 0, b - 1, 25);
                fixBlock(bits, in, out, 25, b - 1 - 25, 25);
                printBits(in, out, bits);
            }
        }

        private void printBits(FastScanner in, PrintWriter out, int[] bits) {
            for (int i = 0; i < bits.length; i++) {
                out.print(bits[i]);
            }
            out.println();
            out.flush();
            char res = in.next().charAt(0);
            if (res != 'Y') {
                out.close();
                System.exit(0);
            }
        }

        private void fixBlock(int[] bits, FastScanner in, PrintWriter out, int leftBase, int rightBase, int length) {
            boolean checkedEq = false, checkedDiff = false;
            int op = 0; // bit 0 - complement, bit 1 - reverse
            for (int i = 0; i < length; i++) {
                if (bits[leftBase + i] == bits[rightBase - i] && !checkedEq) {
                    checkedEq = true;
                    int bit = ask(in, out, leftBase + i);
                    if (bit != bits[leftBase + i]) {
                        op ^= 1;
                    }
                }
            }
            if ((op & 1) == 1) {
                for (int i = 0; i < length; i++) {
                    bits[leftBase + i] ^= 1;
                    bits[rightBase - i] ^= 1;
                }
            }

            for (int i = 0; i < length; i++) {
                if (bits[leftBase + i] != bits[rightBase - i] && !checkedDiff) {
                    checkedDiff = true;
                    int bit = ask(in, out, leftBase + i);
                    if (bit != bits[leftBase + i]) {
                        op ^= 2;
                    }
                }
            }
            if ((op & 2) == 2) {
                for (int i = 0; i < length; i++) {
                    int tmp = bits[leftBase + i];
                    bits[leftBase + i] = bits[rightBase - i];
                    bits[rightBase - i] = tmp;
                }
            }
//        System.err.printf("Block: %d %d, op = %d\n", leftBase, leftBase + length - 1, op);
            // make it always ask 2 queries
            if (!checkedDiff) {
                ask(in, out, leftBase);
            }
            if (!checkedEq) {
                ask(in, out, leftBase);
            }
        }

        private int ask(FastScanner in, PrintWriter out, int i) {
            out.println(i + 1);
            out.flush();
            return in.nextInt();
        }

    }

    static class FastScanner {
        public BufferedReader br;
        public StringTokenizer st;

        public FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        public FastScanner(String fileName) {
            try {
                br = new BufferedReader(new FileReader(fileName));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                String line = null;
                try {
                    line = br.readLine();
                } catch (IOException e) {
                }
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

    }
}

