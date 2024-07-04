
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
        output.println("xxx");
        readString();
        return false;
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
