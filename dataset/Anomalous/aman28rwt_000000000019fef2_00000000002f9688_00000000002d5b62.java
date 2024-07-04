import java.io.*;
import java.util.*;

public class Solution implements Runnable {
    private boolean judge = true;
    private FastReader scn;
    private PrintWriter out;
    private static final String INPUT = "";

    public static void main(String[] args) {
        new Thread(null, new Solution(), "Main", 1 << 28).start();
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        boolean onlineJudge = System.getProperty("ONLINE_JUDGE") != null || judge;
        out = new PrintWriter(System.out);
        scn = new FastReader(onlineJudge);
        solve();
        out.flush();
        if (!onlineJudge) {
            System.out.println((System.currentTimeMillis() - startTime) + " ms");
        }
    }

    private void solve() {
        int T = scn.nextInt();
        for (int tt = 1; tt <= T; tt++) {
            out.print("Case #" + tt + ": ");
            int x = scn.nextInt(), y = scn.nextInt();
            List<List<Integer>> X = generatePossibleMoves(x);
            List<List<Integer>> Y = generatePossibleMoves(y);

            int minJumps = Integer.MAX_VALUE;
            List<Integer> bestA = null, bestB = null;
            for (List<Integer> a : X) {
                for (List<Integer> b : Y) {
                    if (isValidMove(a, b)) {
                        int jumps = getJumpCount(a, b);
                        if (jumps < minJumps) {
                            minJumps = jumps;
                            bestA = a;
                            bestB = b;
                        }
                    }
                }
            }

            if (minJumps != Integer.MAX_VALUE) {
                printResult(bestA, bestB);
            } else {
                out.println("IMPOSSIBLE");
            }
        }
    }

    private List<List<Integer>> generatePossibleMoves(int target) {
        List<List<Integer>> moves = new ArrayList<>();
        generateMoves(target, 0, new ArrayList<>(), moves);
        return moves;
    }

    private void generateMoves(long current, int step, List<Integer> path, List<List<Integer>> result) {
        if (step == 8) {
            if (current == 0) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        long delta = 1L << step;
        path.add(0);
        generateMoves(current, step + 1, path, result);
        path.remove(path.size() - 1);

        path.add(1);
        generateMoves(current + delta, step + 1, path, result);
        path.remove(path.size() - 1);

        path.add(-1);
        generateMoves(current - delta, step + 1, path, result);
        path.remove(path.size() - 1);
    }

    private boolean isValidMove(List<Integer> a, List<Integer> b) {
        int m1 = 0, m2 = 0;
        for (int i = 0; i < a.size(); i++) {
            int aa = a.get(i), bb = b.get(i);
            if (aa != 0 && bb != 0) return false;
            if (aa == 0 && bb == 0) m1 = i;
            else m2 = i;
        }
        return m1 >= m2;
    }

    private int getJumpCount(List<Integer> a, List<Integer> b) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) == 0 && b.get(i) == 0) {
                return i;
            }
        }
        return Integer.MAX_VALUE;
    }

    private void printResult(List<Integer> A, List<Integer> B) {
        for (int i = 0; i < A.size(); i++) {
            int aa = A.get(i), bb = B.get(i);
            if (aa == 0 && bb == 0) break;
            if (bb == 0) {
                out.print(aa == -1 ? 'E' : 'W');
            } else {
                out.print(bb == -1 ? 'N' : 'S');
            }
        }
        out.println();
    }

    class FastReader {
        private InputStream is;
        private byte[] inbuf = new byte[1024];
        private int lenbuf = 0, ptrbuf = 0;

        public FastReader(boolean onlineJudge) {
            is = onlineJudge ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        }

        private int readByte() {
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

        private boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        private int skip() {
            int b;
            while ((b = readByte()) != -1 && isSpaceChar(b));
            return b;
        }

        public String next() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!isSpaceChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public int nextInt() {
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