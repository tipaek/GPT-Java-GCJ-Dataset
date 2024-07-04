
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
        int N = readInt();
        String[] patterns = readMultipleStrings(N);
        
        String head = "";
        String tail = "";
        int[] phs = new int[N];
        int[] pts = new int[N];

        int idx = 0;
        for (String pattern : patterns) {
            int fs = pattern.indexOf("*");
            int ls = pattern.lastIndexOf("*");
            String ph = pattern.substring(0, fs);
            String pt = pattern.substring(ls + 1);
            
            int mh = Math.min(head.length(), ph.length());
            int mt = Math.min(tail.length(), pt.length());
            
            if (!ph.substring(0, mh).equals(head.substring(0, mh))) return "*";
            if (!pt.substring(pt.length() - mt).equals(tail.substring(tail.length() - mt))) return "*";
            
            if (ph.length() > head.length()) head = ph;
            if (pt.length() > tail.length()) tail = pt;
            
            phs[idx] = ph.length();
            pts[idx] = pt.length();
            idx++;
            
            debug(pattern, fs, ls, ph, pt, head, tail);
        }
        debug("ht", head, tail);
        String out = head;
        idx = 0;
        for (String pattern : patterns) {
            String add = pattern.substring(phs[idx], pattern.length() - pts[idx]);
            debug(pattern, add);
            add = add.replaceAll("\\*", "");
            out += add;
            idx++;
        }
        
        out += tail;
        
        return out;
        
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
