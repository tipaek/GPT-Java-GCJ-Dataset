
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

    private Object solve() {
        long[] LR = readLongs(2);
        long L = LR[0];
        long R = LR[1];
        
        long excess = L - R;
        long people = bsInit(Math.abs(excess));
        long nextPerson = people + 1;
        
        if (excess > 0) {
            L -= (people * (people + 1)) / 2L;
        } else {
            R -= (people * (people + 1)) / 2L;
        }
        
        excess = L - R;
        
        
        if (L >= R) {
            long takeL = bs2(nextPerson, L);
            long takeR = bs2(nextPerson+1, R);
            
            L -= sumother(nextPerson, takeL);
            R -= sumother(nextPerson+1, takeR);
            
            people += takeL + takeR;
            return people + " " + L + " " + R;
        } else {
            long takeL = bs2(nextPerson+1, L);
            long takeR = bs2(nextPerson, R);
            
            L -= sumother(nextPerson+1, takeL);
            R -= sumother(nextPerson, takeR);
            
            people += takeL + takeR;
            return people + " " + L + " " + R;
            
        }
        
    }
    
    //inc
    long sum(long a, long b) {
        long len = (b - a) + 1;
        return ((len * (len + 1)) / 2) + len * (a - 1);
    }
    
    long sumother(long start, long length) {
        long q = start * length;
        q += length * (length - 1);
        return q;
        
    }
    
    long bsInit(long max) {
        long lbound = 0L;
        long ubound = 2_000_000_000L;

        while (ubound > lbound) {
            
            long mid = (lbound + ubound + 1L) / 2L;
            if (lowOrRight(mid, max)) {
                lbound = mid;
            } else {
                ubound = mid - 1L;
            }

        }        
        return lbound;
    }
    
    long bs2(long nextPerson, long max) {
        long lbound = 0L;
        long ubound = 2_000_000_000L;

        while (ubound > lbound) {
            
            long mid = (lbound + ubound + 1L) / 2L;
            if (lowOrRight2(mid, nextPerson, max)) {
                lbound = mid;
            } else {
                ubound = mid - 1L;
            }

        }        
        return lbound;
    }    
    
    boolean lowOrRight(long i, long max) {
        return (i * (i + 1)) / 2L <= max;
    }
    
    boolean lowOrRight2(long i, long nextPerson, long max) {
        return sumother(nextPerson, i) <= max;
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
