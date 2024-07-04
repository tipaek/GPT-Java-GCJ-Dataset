
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
            String[] tb = _scanner.nextLine().split(" ");
            int numCases = new Integer(tb[0]);
            int B = new Integer(tb[1]);
            for (int caseNum = 1; caseNum <= numCases; caseNum++) {
                Solution s = new Solution(caseNum, _scanner);
                s.debug("starting");
                String answer = s.solve(B);
                if (answer.equals("N")) break;
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

    private String solve(int B) {
        int[] bits = new int[B];
        Arrays.fill(bits, -1);
        //first 10
        for (int i = 0; i < 5; i++) {
            fetch2(i, bits);
        }
        debug("first10", bits);

        int done = 10;
        while (done < B) {
            
            mutate(bits, done);

            int nextBatch = Math.min(8, B - done);
            for (int i = done / 2; i < (done + nextBatch) / 2; i++) {
                fetch2(i, bits);
            }

            done += nextBatch;
            debug("done", done, bits);
        }
        
        output.println(Arrays.stream(bits).boxed().map(i -> i.toString()).collect(Collectors.joining()));
        String answer = readString();
        debug("answer", answer);
//        assert(answer.equals("Y"));
        return answer;
    }

    private void mutate(int[] bits, int done) {
        int firstmatch = -1;
        int firstnonmatch = -1;
        
        for (int i = 0; i < done / 2; i++) {
            int l = bits[i];
            int r = bits[bits.length - 1 - i];
            if (firstmatch == -1 && l == r) firstmatch = i;
            if (firstnonmatch == -1 && l != r) firstnonmatch = i;
        }
        
        if (firstnonmatch == -1 || firstmatch == -1) {
            //symmetric or antisymmetric
            int val0 = fetch(0);
            int waste = fetch(0);
            if (val0 != bits[0]) {
                negate(bits);
            }
            return;
        }
        
        int valmatch = fetch(firstmatch);
        int valnonmatch = fetch(firstnonmatch);
        
        if (valmatch != bits[firstmatch]) negate(bits);
        if (valnonmatch != bits[firstnonmatch]) reverse(bits);
    }

    private void fetch2(int posn, int[] bits) {
        bits[posn] = fetch(posn);
        bits[bits.length - 1 - posn] = fetch(bits.length - 1 - posn);
    }

    private int fetch(int posn) {
        output.println(posn + 1);
        int reply = readInt();
        debug("fetch", posn, reply);
        return reply;
    }

    private void reverse(int[] bits) {
        for (int i = 0; i < bits.length / 2; i++) {
            int tmp = bits[i];
            bits[i] = bits[bits.length - 1 - i];
            bits[bits.length - 1 - i] = tmp;
        }
    }

    private void negate(int[] bits) {
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] != -1) bits[i] = 1 - bits[i];
        }
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
