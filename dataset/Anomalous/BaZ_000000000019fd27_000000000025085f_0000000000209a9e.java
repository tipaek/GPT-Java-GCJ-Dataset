import java.util.*;
import java.io.*;

public class Solution {
    static final long MOD = 1_000_000_007;
    static final long INF = 1_000_000_000_000_000_000L;
    static final long inf = 2_000_000_000;
    static MyScanner scan;
    static PrintWriter pw;
    static int[] arr;

    public static void main(String[] args) {
        new Thread(null, () -> {
            try {
                solve();
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        }, "BaZ", 1 << 27).start();
    }

    static void solve() throws IOException {
        initIo(false, "");
        StringBuilder sb = new StringBuilder();
        int t = ni(), b = ni();

        while (t-- > 0) {
            int ptr = 1;
            ArrayList<Integer> diffZero = new ArrayList<>();
            ArrayList<Integer> one = new ArrayList<>();
            ArrayList<Integer> zero = new ArrayList<>();

            for (int i = 1; i <= 150; ) {
                if (i % 10 == 1) {
                    handleSpecialCases(diffZero, one, zero, b, i++);
                }

                if (ptr <= (b + 1) / 2) {
                    if (i % 10 != 0) {
                        char c1 = query(ptr, i++);
                        char c2 = query(b - (ptr - 1), i++);
                        categorizeResponses(ptr, c1, c2, diffZero, one, zero, b);
                        ptr++;
                    } else {
                        handleSpecialCases(diffZero, one, zero, b, i++);
                    }
                } else {
                    break;
                }
            }

            char[] ans = buildAnswerArray(diffZero, one, zero, b);
            sb.setLength(0);
            for (char c : ans) {
                sb.append(c);
            }
            pw.println(sb);
            pw.flush();

            if (ne().charAt(0) == 'N') {
                System.exit(1);
            }
        }
        pw.flush();
        pw.close();
    }

    static void handleSpecialCases(ArrayList<Integer> diffZero, ArrayList<Integer> one, ArrayList<Integer> zero, int b, int i) throws IOException {
        if (!diffZero.isEmpty()) {
            if (query(diffZero.get(0), i++) == '1') {
                complement(diffZero, b);
            }
        }
        if (!one.isEmpty()) {
            if (query(one.get(0), i++) == '0') {
                Collections.swap(one, zero);
            }
        } else if (!zero.isEmpty()) {
            if (query(zero.get(0), i++) == '1') {
                Collections.swap(one, zero);
            }
        }
        if (diffZero.isEmpty() && one.isEmpty() && zero.isEmpty()) {
            query(1, i++);
        }
    }

    static void categorizeResponses(int ptr, char c1, char c2, ArrayList<Integer> diffZero, ArrayList<Integer> one, ArrayList<Integer> zero, int b) {
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
    }

    static char[] buildAnswerArray(ArrayList<Integer> diffZero, ArrayList<Integer> one, ArrayList<Integer> zero, int b) {
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
        return ans;
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

    static String ne() throws IOException {
        return scan.next();
    }

    static void pl(Object o) {
        pw.println(o);
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

        String next() throws IOException {
            if (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}