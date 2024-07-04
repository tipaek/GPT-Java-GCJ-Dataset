import java.io.*;
import java.util.*;

public class Solution implements Runnable {
    boolean judge = true;
    FastReader scn;
    PrintWriter out;
    String INPUT = "";

    void solve() {
        int T = scn.nextInt();
        for (int tt = 1; tt <= T; tt++) {
            out.print("Case #" + tt + ": ");

            int x = scn.nextInt(), y = scn.nextInt();
            List<List<Integer>> X = new ArrayList<>();
            List<List<Integer>> Y = new ArrayList<>();

            generateSequences(x, 0, new ArrayList<>(), X);
            generateSequences(y, 0, new ArrayList<>(), Y);

            int jump = 100;
            List<Integer> A = null, B = null;
            for (List<Integer> a : X) {
                for (List<Integer> b : Y) {
                    if (isValidSequence(a, b)) {
                        int m2 = getMaxIndex(a, b);
                        if (m2 < jump) {
                            jump = m2;
                            A = a;
                            B = b;
                        }
                    }
                }
            }
            if (jump != 100) {
                printSequence(A, B);
            } else {
                out.println("IMPOSSIBLE");
            }
        }
    }

    void generateSequences(long cur, int k, List<Integer> list, List<List<Integer>> append) {
        if (k == 10) {
            if (cur == 0) {
                append.add(new ArrayList<>(list));
            }
            return;
        }
        long delta = 1L << k;

        list.add(0);
        generateSequences(cur, k + 1, list, append);
        list.remove(list.size() - 1);

        list.add(1);
        generateSequences(cur + delta, k + 1, list, append);
        list.remove(list.size() - 1);

        list.add(-1);
        generateSequences(cur - delta, k + 1, list, append);
        list.remove(list.size() - 1);
    }

    boolean isValidSequence(List<Integer> a, List<Integer> b) {
        for (int i = 0; i < a.size(); i++) {
            int aa = a.get(i), bb = b.get(i);
            if (aa != 0 && bb != 0) {
                return false;
            }
        }
        return true;
    }

    int getMaxIndex(List<Integer> a, List<Integer> b) {
        int m2 = 0;
        for (int i = 0; i < a.size(); i++) {
            int aa = a.get(i), bb = b.get(i);
            if (aa != 0 || bb != 0) {
                m2 = i;
            }
        }
        return m2;
    }

    void printSequence(List<Integer> A, List<Integer> B) {
        for (int i = 0; i < A.size(); i++) {
            int aa = A.get(i), bb = B.get(i);
            if (aa == 0 && bb == 0) {
                break;
            }
            if (bb == 0) {
                out.print(aa == -1 ? 'E' : 'W');
            }
            if (aa == 0) {
                out.print(bb == -1 ? 'N' : 'S');
            }
        }
        out.println();
    }

    public void run() {
        long startTime = System.currentTimeMillis();
        boolean onlineJudge = System.getProperty("ONLINE_JUDGE") != null || judge;
        out = new PrintWriter(System.out);
        scn = new FastReader(onlineJudge);
        solve();
        out.flush();
        if (!onlineJudge) {
            System.out.println("Time: " + (System.currentTimeMillis() - startTime) + " ms");
        }
    }

    public static void main(String[] args) {
        new Thread(null, new Solution(), "Main", 1 << 28).start();
    }

    class FastReader {
        InputStream is;
        byte[] inbuf = new byte[1024];
        int lenbuf = 0, ptrbuf = 0;

        public FastReader(boolean onlineJudge) {
            is = onlineJudge ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        }

        int readByte() {
            if (lenbuf == -1) throw new InputMismatchException();
            if (ptrbuf >= lenbuf) {
                ptrbuf = 0;
                try {
                    lenbuf = is.read(inbuf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (lenbuf <= 0) return -1;
            }
            return inbuf[ptrbuf++];
        }

        boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        int skip() {
            int b;
            while ((b = readByte()) != -1 && isSpaceChar(b));
            return b;
        }

        String next() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!isSpaceChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        int nextInt() {
            int num = 0, b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
            if (b == '-') {
                minus = true;
                b = readByte();
            }
            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }
    }
}