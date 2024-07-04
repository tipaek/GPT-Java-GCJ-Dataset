
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Solution {

    private static Reader input;
    private static PrintWriter output;
    private static boolean local;
    private static boolean nonStandardOutput;
    private final int caseNum;
    private final Scanner scanner;

    public static void main(String[] args) {
        if (input == null) input = new BufferedReader(new InputStreamReader(System.in));
        if (output == null) output = new PrintWriter(System.out, true);
        try (Scanner _scanner = new Scanner(input)) {
            String[] tab = _scanner.nextLine().split(" ");
            int numCases = new Integer(tab[0]);
            long A = new Long(tab[1]);
            long B = new Long(tab[2]);
            for (int caseNum = 1; caseNum <= numCases; caseNum++) {
                Solution s = new Solution(caseNum, _scanner);
                s.debug("starting");
                boolean answer = s.solve(A, B);
                if (!answer) break;
//                output.println("Case #" + caseNum + ": " + answer);
            }
            if (nonStandardOutput) output.close();
            if (local && _scanner.hasNext()) throw new RuntimeException("Solution input not all read");
        }
    }

    private Solution(int caseNum, Scanner scanner) {
        this.caseNum = caseNum;
        this.scanner = scanner;
    }

    private boolean solve(long A, long B) {
        long tennine = 1_000_000_000;

        if (A == tennine - 5L && B == tennine - 5L) {
            return solve1(A, B);
        }
        if (A == tennine - 50L && B == tennine - 50L) {
            return solve2(A, B);
        }
        return solve3(A, B);
    }

    private boolean solve1(long A, long B) {
        for (long x = -5; x <= 5; x++) {
            for (long y = -5; y <= 5; y++) {
                String ans = tryy(x, y);
                if (ans.equals("CENTER")) return true;
            }
        }
        return false;
    }

    private boolean solve2(long A, long B) {
        long tennine = 1_000_000_000;
        long x = -tennine;
        while (true) {
            String ans = tryy(x, 0);
            if (ans.equals("HIT")) break;
            x++;
        }

        long y = -tennine;
        while (true) {
            String ans = tryy(0, y);
            if (ans.equals("HIT")) break;
            y++;
        }

        long centrex = x + tennine - 50L;
        long centrey = y + tennine - 50L;

        for (long gx = centrex - 5; gx <= centrex + 5; gx++) {
            for (long gy = centrey - 5; gy <= centrey + 5; gy++) {
                String ans = tryy(gx, gy);
                if (ans.equals("CENTER")) return true;
            }
        }
        return false;
    }

    private boolean solve3(long A, long B) {

        long tennine = 1_000_000_000;
        int parts = 8;
        boolean[][] in = new boolean[parts + 1][parts + 1];
//        int[] colct = new int[parts+1];
        for (int x = 0; x <= parts; x++) {
            for (int y = 0; y <= parts; y++) {
                long gx = -tennine + (((2L * tennine) * (long) x) / ((long) parts));
                long gy = -tennine + (((2L * tennine) * (long) y) / ((long) parts));
                debug(gx, gy);
                String ans = tryy(gx, gy);
                if (ans.equals("CENTER")) return true;
                in[x][y] = ans.equals("HIT");
//                if (in[x][y]) colct[x]++;
            }
        }

        long[][] points = new long[3][2];
        int found = 0;
        for (int col = 0; col <= parts; col++) {
//            if (colct[col] == 0) continue;
//            if (in[col][0]) continue;
            if (found == 3) break;

            for (int row = 0; row < parts; row++) {
                if (!in[col][row] && in[col][row + 1]) {
                    points[found] = bs(col, row);
                    found++;
                    break;
                }
            }
        }

        long x1 = points[0][0];
        long y1 = points[0][1];
        long x2 = points[1][0];
        long y2 = points[1][1];
        long x3 = points[2][0];
        long y3 = points[2][1];

        debug(x1, y1, x2, y2, x3, y3);
        long rhs1 = -1L * ((x1 * x1 - x2 * x2) + (y1 * y1 - y2 * y2));
        long mx1 = -2L * (x1 - x2);
        long my1 = -2L * (y1 - y2);

        long rhs2 = -1L * ((x1 * x1 - x3 * x3) + (y1 * y1 - y3 * y3));
        long mx2 = -2L * (x1 - x3);
        long my2 = -2L * (y1 - y3);

        long centrey = (mx2 * rhs1 - mx1 * rhs2) / (mx2 * my1 - mx1 * my2);
        long centrex = (rhs1 - centrey * my1) / mx1;
        
        debug(centrex, centrey);

        for (long gx = centrex - 5; gx <= centrex + 5; gx++) {
            for (long gy = centrey - 5; gy <= centrey + 5; gy++) {
                String ans = tryy(gx, gy);
                if (ans.equals("CENTER")) return true;
            }
        }
        return false;
    }

    private long[] bs(int col, int row) {
        long tennine = 1_000_000_000;
        int parts = 8;
        long gx = -tennine + (((2L * tennine) * (long) col) / ((long) parts));
        long lbound = -tennine + (((2L * tennine) * (long) row) / ((long) parts));
        long ubound = -tennine + (((2L * tennine) * (long) (row+1)) / ((long) parts));
        
//integer binary search
//find integer i in lbound..ubound s.t. property holds precisely for all j <= i.

        while (ubound > lbound) {
            
            long mid = (lbound + ubound + 1L) / 2L;
            if ("MISS".equals(tryy(gx, mid))) {
                lbound = mid;
            } else {
                ubound = mid - 1L;
            }

        }
        return new long[]{gx, lbound};
    }

    private String tryy(long x, long y) {
        output.println(x + " " + y);
        return readString();
    }

    private String[] readStrings(Integer count) {
        String line = scanner.nextLine();
        String[] tokens = line.split(" ");
        if (count != null && tokens.length != count) throw new RuntimeException("Incorrect count, expected " + count + ", got " + tokens.length);
        return tokens;
    }

    private int[] readInts(Integer count) {
        String[] tokens = readStrings(count);
        int[] out = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            out[i] = new Integer(tokens[i]);
        }
        return out;
    }

    private long[] readLongs(Integer count) {
        String[] tokens = readStrings(count);
        long[] out = new long[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            out[i] = new Long(tokens[i]);
        }
        return out;
    }

    private double[] readDoubles(Integer count) {
        String[] tokens = readStrings(count);
        double[] out = new double[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            out[i] = new Double(tokens[i]);
        }
        return out;
    }

    private String readString() {
        return scanner.nextLine();
    }

    private int readInt() {
        return new Integer(readString());
    }

    private long readLong() {
        return new Long(readString());
    }

    private double readDouble() {
        return new Double(readString());
    }

    private String[] readMultipleStrings(int count) {
        String[] out = new String[count];
        for (int i = 0; i < count; i++) {
            out[i] = readString();
        }
        return out;
    }

    private <T> void send(T[] elements) {
        output.println(Arrays.stream(elements).map(e -> e.toString()).collect(Collectors.joining(" ")));
    }

    private <T> Set<T> toSet(T[] elements) {
        return Arrays.stream(elements).collect(Collectors.toSet());
    }

    public static void setLocal(Reader _input, PrintWriter _output) {
        local = true;
        input = _input;
        output = _output;
        if (_output != null) nonStandardOutput = true;
    }

    private void debug(Object... args) {
        if (local) System.out.println("Debug case " + caseNum + ": " + Arrays.stream(args).map(o -> toString(o)).collect(Collectors.joining(" ")));
    }

    private void debugCase(int caseNum, Object... args) {
        if (this.caseNum == caseNum) debug(args);
    }

    private String toString(Object o) {
        if (o instanceof Object[]) return Arrays.toString((Object[]) o);
        if (o instanceof int[]) return Arrays.toString((int[]) o);
        return Objects.toString(o);
    }

}
