
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
            int numCases = new Integer(_scanner.nextLine());
            for (int caseNum = 1; caseNum <= numCases; caseNum++) {
                Solution s = new Solution(caseNum, _scanner);
                s.debug("starting");
                Object answer = s.solve();
                output.println("Case #" + caseNum + ": " + answer);
            }
            if (nonStandardOutput) output.close();
            if (local && _scanner.hasNext()) throw new RuntimeException("Solution input not all read");
        }
    }

    private Solution(int caseNum, Scanner scanner) {
        this.caseNum = caseNum;
        this.scanner = scanner;
    }

    int[][] skills;
    boolean[][] out;
    int R;
    int C;

    private Object solve() {
        int[] rc = readInts(2);
        R = rc[0];
        C = rc[1];

        skills = new int[R][C];
        out = new boolean[R][C];
        long remaining = 0L;
        for (int i = 0; i < R; i++) {
            skills[i] = readInts(C);
            for (int j = 0; j < C; j++) {
                remaining += skills[i][j];
            }
        }

        long total = 0L;

        while (true) {
            total += remaining;
            boolean[][] eliminate = new boolean[R][C];
            boolean anyelim = false;
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    if (out[r][c]) continue;

                    int[] nbrs = nbrs(r, c); //count, sum
                    if (nbrs[0] == 0) continue;

                    if (skills[r][c] * nbrs[0] < nbrs[1]) {
                        anyelim = true;
                        eliminate[r][c] = true;
                        remaining -= skills[r][c];
                    }
                }
            }
            if (!anyelim) break;
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    if (eliminate[r][c]) out[r][c] = true;
                }
            }

        }

        return total;
    }

    private int[] nbrs(int r, int c) {
        int[][] moves = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int count = 0;
        int sum = 0;

        for (int[] move : moves) {
            int ron = r;
            int con = c;
            while (true) {
                ron += move[0];
                con += move[1];

                if (ron < 0 || ron >= R || con < 0 || con >= C) break;
                if (out[ron][con]) continue;
                count++;
                sum += skills[ron][con];
                break;
            }
        }

        return new int[]{count, sum};
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
