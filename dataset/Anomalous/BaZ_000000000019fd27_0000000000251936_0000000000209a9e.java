import java.io.*;
import java.util.*;

public class Solution {
    static MyScanner scan;
    static PrintWriter pw;
    static final long MOD = 1_000_000_007;
    static final long INF = 1_000_000_000_000_000_000L;
    static final long inf = 2_000_000_000;
    static int[] arr;

    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    solve();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }, "BaZ", 1 << 27).start();
    }

    static void solve() throws IOException {
        initIo(false, "");
        int t = ni(), b = ni();
        while (t-- > 0) {
            int ptr = 1;
            ArrayList<Integer> diffZero = new ArrayList<>();
            ArrayList<Integer> one = new ArrayList<>();
            ArrayList<Integer> zero = new ArrayList<>();
            for (int i = 1; i <= 150;) {
                if (i % 10 == 1) {
                    if (!diffZero.isEmpty()) {
                        char newVal = query(diffZero.get(0), i++);
                        if (newVal == '1') {
                            complement(diffZero, b);
                        }
                    }
                    if (!one.isEmpty()) {
                        char newVal = query(one.get(0), i++);
                        if (newVal == '0') {
                            ArrayList<Integer> temp = one;
                            one = zero;
                            zero = temp;
                        }
                    } else if (!zero.isEmpty()) {
                        char newVal = query(zero.get(0), i++);
                        if (newVal == '1') {
                            ArrayList<Integer> temp = one;
                            one = zero;
                            zero = temp;
                        }
                    }
                }

                if (ptr <= (b + 1) / 2) {
                    if (i % 10 != 0) {
                        char c1 = query(ptr, i++);
                        char c2 = query(b - (ptr - 1), i++);
                        if (c1 == c2) {
                            if (c1 == '0') {
                                zero.add(ptr);
                            } else {
                                one.add(ptr);
                            }
                        } else {
                            if (c1 == '0') {
                                diffZero.add(ptr);
                            } else {
                                diffZero.add(b - (ptr - 1));
                            }
                        }
                        ptr++;
                    } else {
                        query(1, i++);
                    }
                } else {
                    break;
                }
            }

            char[] ans = new char[b + 1];
            for (int e : diffZero) {
                ans[e] = '0';
                ans[b - (e - 1)] = '1';
            }
            for (int e : zero) {
                ans[e] = ans[b - (e - 1)] = '0';
            }
            for (int e : one) {
                ans[e] = ans[b - (e - 1)] = '1';
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= b; ++i) {
                sb.append(ans[i]);
            }
            pw.println(sb);
            pw.flush();

            char c = ne().charAt(0);
            if (c == 'N') {
                System.exit(1);
            }
        }
        pw.flush();
        pw.close();
    }

    static void complement(ArrayList<Integer> list, int B) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, B - (list.get(i) - 1));
        }
    }

    static char query(int idx, int queryNo) throws IOException {
        pl(idx);
        pw.flush();
        char c = ne().charAt(0);
        if (c == 'N') {
            System.exit(1);
        }
        return c;
    }

    static void initIo(boolean isFileIO, String suffix) throws IOException {
        scan = new MyScanner(isFileIO, suffix);
        if (isFileIO) {
            pw = new PrintWriter("/Users/amandeep/Desktop/output" + suffix + ".txt");
        } else {
            pw = new PrintWriter(System.out, true);
        }
    }

    static int ni() throws IOException {
        return scan.nextInt();
    }

    static long nl() throws IOException {
        return scan.nextLong();
    }

    static double nd() throws IOException {
        return scan.nextDouble();
    }

    static String ne() throws IOException {
        return scan.next();
    }

    static String nel() throws IOException {
        return scan.nextLine();
    }

    static void pl() {
        pw.println();
    }

    static void p(Object o) {
        pw.print(o + " ");
    }

    static void pl(Object o) {
        pw.println(o);
    }

    static void psb(StringBuilder sb) {
        pw.print(sb);
    }

    static void pa(String arrayName, int[] arr) {
        pl(arrayName + " : ");
        for (int o : arr) p(o);
        pl();
    }

    static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        MyScanner(boolean readingFromFile, String suffix) throws IOException {
            if (readingFromFile) {
                br = new BufferedReader(new FileReader("/Users/amandeep/Desktop/input" + suffix + ".txt"));
            } else {
                br = new BufferedReader(new InputStreamReader(System.in));
            }
        }

        String nextLine() throws IOException {
            return br.readLine();
        }

        String next() throws IOException {
            if (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
}