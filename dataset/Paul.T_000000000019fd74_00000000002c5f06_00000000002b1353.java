
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
                output.println("Case #" + caseNum + ":\n" + answer);
            }
            if (nonStandardOutput) output.close();
            if (local && _scanner.hasNext()) throw new RuntimeException("Solution input not all read");
        }
    }

    private Solution(int caseNum, Scanner scanner) {
        this.caseNum = caseNum;
        this.scanner = scanner;
    }

    private Object solve() {
        int N = readInt();

        if (N <= 500) return solve500(N);
        if (N <= 1000) return solve1000(N);
        return solveBig(N);
    }

    private Object solveBig(int N) {

        long[][] PT = new long[60 + 1][60 + 1];
        PT[1][1] = 1L;
        for (int r = 2; r <= 60; r++) {
            PT[r][1] = 1L;
            PT[r][r] = 1L;
            for (int k = 2; k < r; k++) {
                PT[r][k] = PT[r - 1][k - 1] + PT[r - 1][k];
            }
        }

        long tot = 9;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            sb.append(i + " " + i + "\n");
        }

        for (int col = 10; col >= 2; col -= 2) {
            int rowofcol = 1;

            long keep = 0L;
            for (int i = 1; i <= (col - 2); i++) {
                keep += i;
            }

            long running = 0L;
            while (true) {
                long next = PT[rowofcol + col][col] + PT[rowofcol + col - 1][col - 1];
                if ((N - keep) < (tot + running + next)) break;
                running += next;
                rowofcol++;
            }

            for (int i = 1; i <= rowofcol; i++) {
                sb.append((i + col) + " " + col + "\n");
            }
            for (int i = 1; i <= rowofcol; i++) {
                sb.append((rowofcol + col - i) + " " + (col - 1) + "\n");
            }

            tot += running;
        }
        
        return sb.toString();

    }

    private Object solve500(int N) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append((i + 1) + " 1");
            if (i < N - 1) sb.append("\n");
        }
        return sb.toString();
    }

    private Object solve1000(int N) {
        StringBuilder sb = new StringBuilder();
        sb.append("1 1\n");
        sb.append("2 1\n");
        sb.append("3 2\n");
        sb.append("4 2\n");
        sb.append("5 2\n");
        sb.append("6 2\n");
        sb.append("7 2\n");
        sb.append("7 1\n");

        int total = 23;
        int nextup = 7;

        while (total <= N) {
            if (total + nextup == N) {
                sb.append((nextup + 1) + " 2");
                return sb.toString();
            }

            if (total + nextup + 1 == N) {
                sb.append((nextup + 1) + " 1\n");
                sb.append((nextup + 1) + " 2");
                return sb.toString();
            }

            sb.append((nextup + 1) + " 1\n");

            total++;
            nextup++;

        }

        return "broken " + total;
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
