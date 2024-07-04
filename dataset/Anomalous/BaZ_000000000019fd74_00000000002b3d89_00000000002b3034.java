/**
 * BaZ :D
 */

import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class Solution {
    static MyScanner scan;
    static PrintWriter pw;
    static final long MOD = 1_000_000_007;
    static final long INF = 1_000_000_000_000_000_000L;
    static final long inf = 2_000_000_000;

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
        StringBuilder sb = new StringBuilder();
        int t = ni();
        for (int case_ = 1; case_ <= t; ++case_) {
            p("Case #" + case_ + ":");
            int n = scan.nextInt();
            List<String> starts = new ArrayList<>();
            List<String> ends = new ArrayList<>();
            List<String> mid = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                String s = ne();
                StringBuilder reduced = new StringBuilder();
                int len = s.length();
                for (int j = 0; j < len; ++j) {
                    reduced.append(s.charAt(j));
                    if (s.charAt(j) == '*') {
                        while (j + 1 < len && s.charAt(j + 1) == '*') {
                            j++;
                        }
                    }
                }

                if (reduced.charAt(0) != '*') {
                    StringBuilder start_ = new StringBuilder();
                    int ptr = 0;
                    while (ptr < reduced.length() && reduced.charAt(ptr) != '*') {
                        start_.append(reduced.charAt(ptr));
                        ptr++;
                    }
                    starts.add(start_.toString());
                }
                int l = reduced.length();

                if (reduced.charAt(l - 1) != '*') {
                    int ptr = l - 1;
                    StringBuilder ends_ = new StringBuilder();
                    while (ptr >= 0 && reduced.charAt(ptr) != '*') {
                        ends_.append(reduced.charAt(ptr));
                        ptr--;
                    }
                    ends.add(ends_.reverse().toString());
                }

                for (int j = 0; j < l; ++j) {
                    if (reduced.charAt(j) != '*') {
                        StringBuilder mid_ = new StringBuilder();
                        mid_.append(reduced.charAt(j));
                        while (j + 1 < l && reduced.charAt(j + 1) != '*') {
                            j++;
                            mid_.append(reduced.charAt(j));
                        }
                        mid.add(mid_.toString());
                    }
                }
            }

            String pref = findPrefix(starts);
            String suff = findSuffix(ends);

            if (suff == null || pref == null) {
                pl("*");
            } else {
                StringBuilder ans = new StringBuilder();
                ans.append(pref);
                for (String s : mid) {
                    ans.append(s);
                }
                ans.append(suff);
                pl(ans.toString());
            }
        }
        pw.flush();
        pw.close();
    }

    static String findPrefix(List<String> starts) {
        if (starts.isEmpty()) return "";
        for (String s1 : starts) {
            boolean flag = true;
            for (String s2 : starts) {
                if (!s1.startsWith(s2)) {
                    flag = false;
                    break;
                }
            }
            if (flag) return s1;
        }
        return null;
    }

    static String findSuffix(List<String> ends) {
        if (ends.isEmpty()) return "";
        for (String s1 : ends) {
            boolean flag = true;
            for (String s2 : ends) {
                if (!s1.endsWith(s2)) {
                    flag = false;
                    break;
                }
            }
            if (flag) return s1;
        }
        return null;
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

    static void pa(String arrayName, Object[] arr) {
        pl(arrayName + " : ");
        for (Object o : arr) p(o);
        pl();
    }

    static void pa(String arrayName, int[] arr) {
        pl(arrayName + " : ");
        for (int o : arr) p(o);
        pl();
    }

    static void pa(String arrayName, long[] arr) {
        pl(arrayName + " : ");
        for (long o : arr) p(o);
        pl();
    }

    static void pa(String arrayName, double[] arr) {
        pl(arrayName + " : ");
        for (double o : arr) p(o);
        pl();
    }

    static void pa(String arrayName, char[] arr) {
        pl(arrayName + " : ");
        for (char o : arr) p(o);
        pl();
    }

    static void pa(String listName, List<?> list) {
        pl(listName + " : ");
        for (Object o : list) p(o);
        pl();
    }

    static void pa(String arrayName, Object[][] arr) {
        pl(arrayName + " : ");
        for (Object[] objects : arr) {
            for (Object o : objects) p(o);
            pl();
        }
    }

    static void pa(String arrayName, int[][] arr) {
        pl(arrayName + " : ");
        for (int[] ints : arr) {
            for (int o : ints) p(o);
            pl();
        }
    }

    static void pa(String arrayName, long[][] arr) {
        pl(arrayName + " : ");
        for (long[] longs : arr) {
            for (long o : longs) p(o);
            pl();
        }
    }

    static void pa(String arrayName, char[][] arr) {
        pl(arrayName + " : ");
        for (char[] chars : arr) {
            for (char o : chars) p(o);
            pl();
        }
    }

    static void pa(String arrayName, double[][] arr) {
        pl(arrayName + " : ");
        for (double[] doubles : arr) {
            for (double o : doubles) p(o);
            pl();
        }
    }

    static void pa(String arrayName, boolean[][] arr) {
        pl(arrayName + " : ");
        for (boolean[] booleans : arr) {
            for (boolean o : booleans) p(o);
            pl();
        }
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
            if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
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