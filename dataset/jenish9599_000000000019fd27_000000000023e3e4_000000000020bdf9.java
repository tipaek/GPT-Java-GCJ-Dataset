import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.FilterInputStream;
import java.io.BufferedInputStream;
import java.util.Comparator;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        ScanReader in = new ScanReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ACTIVITY solver = new ACTIVITY();
        solver.solve(1, in, out);
        out.close();
    }

    static class ACTIVITY {
        public void solve(int testNumber, ScanReader in, PrintWriter out) {
            int t = in.scanInt();
            int cases = 1;
            while (t-- > 0) {

                int n = in.scanInt();
                int arr[][] = new int[n][];
                int A[][] = new int[n][];
                for (int i = 0; i < n; i++) {
                    arr[i] = new int[]{in.scanInt(), in.scanInt(), i};
                    A[i] = new int[]{arr[i][0], arr[i][1]};
                }


                char ans[] = new char[n];
                Arrays.fill(ans, '-');
                boolean flag = true;

                Arrays.sort(arr, new Comparator<int[]>() {

                    public int compare(int[] o1, int[] o2) {
                        return o1[1] - o2[1];
                    }
                });


                int free0 = -1;
                int free1 = -1;

                for (int i = 0; i < n; i++) {
                    int s = arr[i][0];
                    int e = arr[i][1];

                    if (s >= free0 && s >= free1) {
                        if (free0 >= free1) {
                            ans[arr[i][2]] = 'C';
                            free0 = e;
                        } else {
                            ans[arr[i][2]] = 'J';
                            free1 = e;
                        }
                        continue;
                    }


                    if (s >= free0) {
                        ans[arr[i][2]] = 'C';
                        free0 = e;
                    } else if (s >= free1) {
                        ans[arr[i][2]] = 'J';
                        free1 = e;
                    } else {
                        flag = false;
                    }
                }

                for (int i = 0; i < n; i++) if (ans[i] == '-') flag = false;


//            if (flag != BF(A)) throw new RuntimeException();

                out.print("Case #" + cases++ + ": ");
                if (flag) {
//                if (!checker(A, ans)) throw new RuntimeException("ERE");
                    out.println(String.valueOf(ans));
                } else {
                    out.println("IMPOSSIBLE");
                }


            }
        }

    }

    static class ScanReader {
        private byte[] buf = new byte[4 * 1024];
        private int INDEX;
        private BufferedInputStream in;
        private int TOTAL;

        public ScanReader(InputStream inputStream) {
            in = new BufferedInputStream(inputStream);
        }

        private int scan() {
            if (INDEX >= TOTAL) {
                INDEX = 0;
                try {
                    TOTAL = in.read(buf);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (TOTAL <= 0) return -1;
            }
            return buf[INDEX++];
        }

        public int scanInt() {
            int I = 0;
            int n = scan();
            while (isWhiteSpace(n)) n = scan();
            int neg = 1;
            if (n == '-') {
                neg = -1;
                n = scan();
            }
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    I *= 10;
                    I += n - '0';
                    n = scan();
                }
            }
            return neg * I;
        }

        private boolean isWhiteSpace(int n) {
            if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1) return true;
            else return false;
        }

    }
}

