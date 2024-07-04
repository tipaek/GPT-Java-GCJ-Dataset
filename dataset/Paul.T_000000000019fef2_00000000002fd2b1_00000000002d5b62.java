
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
        long[] params = readLongs(2);
        Long X = params[0];
        Long Y = params[1];

        String xPlus = X > 0 ? "E" : "W";
        String xMinus = X > 0 ? "W" : "E";
        String yPlus = Y > 0 ? "N" : "S";
        String yMinus = Y > 0 ? "S" : "N";
        
        X = Math.abs(X);
        Y = Math.abs(Y);
        String out = "";
        int i = 0;
        while ((X != 0 || Y != 0)) {
            if (X == 0 & Y == 1) {
                out += yPlus;
                break;
            }
            if (X == 0 & Y == -1) {
                out += yMinus;
                break;
            }
            if (X == 1 & Y == 0) {
                out += xPlus;
                break;
            }
            if (X == -1 & Y == 0) {
                out += xMinus;
                break;
            }
            if (X % 2L == Y % 2L) return "IMPOSSIBLE";
            if (X % 2L == 1) {
                long nx = (X + 1L) / 2L;
                long ny = Y / 2L;
                if (nx % 2L == ny % 2L) {
                    X -= 1L;
                    out += xPlus;
                } else {
                    X += 1L;
                    out += xMinus;                    
                }
            } else {
                long nx = X / 2L;
                long ny = (Y + 1L) / 2L;
                if (nx % 2L == ny % 2L) {
                    Y -= 1L;
                    out += yPlus;
                } else {
                    Y += 1L;
                    out += yMinus;                    
                }                
            }
            
            X /= 2L;
            Y /= 2L;
            i++;
        }



        return out;
        
    }





    private Object solvex() {
        long[] params = readLongs(2);
        Long X = params[0];
        Long Y = params[1];

        String xPlus = X > 0 ? "E" : "W";
        String xMinus = X > 0 ? "W" : "E";
        String yPlus = Y > 0 ? "N" : "S";
        String yMinus = Y > 0 ? "S" : "N";

        List<Integer> dsX = splitToDigits(Math.abs(X), 2);
        List<Integer> dsY = splitToDigits(Math.abs(Y), 2);

        String s = solve2(dsX, dsY, xPlus, yPlus);
        if (!s.equals("IMPOSSIBLE")) return s;
        
        long free = 1L;
        for (int i = 0; i < Math.max(dsX.size(), dsY.size()); i++) {
            free *= 2L;
        }
        
        dsX = splitToDigits(free - Math.abs(X), 2);
        dsY = splitToDigits(Math.abs(Y), 2);
        
        s = solve2(dsX, dsY, xMinus, yPlus);
        if (!s.equals("IMPOSSIBLE")) return s + xPlus;
        
        
        
        dsX = splitToDigits(Math.abs(X), 2);
        dsY = splitToDigits(free - Math.abs(Y), 2);
        
        s = solve2(dsX, dsY, xPlus, yMinus);
        if (!s.equals("IMPOSSIBLE")) return s + yPlus;
        

        dsX = splitToDigits(free * 2L - Math.abs(X), 2);
        dsY = splitToDigits(free - Math.abs(Y), 2);
        
        s = solve2(dsX, dsY, xMinus, yMinus);
        if (!s.equals("IMPOSSIBLE")) return s + yPlus + xPlus;


        dsX = splitToDigits(free - Math.abs(X), 2);
        dsY = splitToDigits(free * 2L - Math.abs(Y), 2);
        
        s = solve2(dsX, dsY, xMinus, yMinus);
        if (!s.equals("IMPOSSIBLE")) return s + xPlus + yPlus;


        return "IMPOSSIBLE";
        
    }

    private String solve2(List<Integer> dsX, List<Integer> dsY, String xPlus, String yPlus) {

        while (dsX.size() < dsY.size()) dsX.add(0, 0);
        while (dsY.size() < dsX.size()) dsY.add(0, 0);
        debug(dsX, dsY, xPlus, yPlus);
        String out = "";

        for (int i = dsX.size() - 1; i >= 0; i--) {
            int dx = dsX.get(i);
            int dy = dsY.get(i);

            if (dx == 1 && dy == 1) return "IMPOSSIBLE";
            if (dx == 0 && dy == 0) return "IMPOSSIBLE";
            if (dx == 1) {
                out += xPlus;
            }
            if (dy == 1) {
                out += yPlus;
            }
        }

        return out;
    }

    public static ArrayList<Integer> splitToDigits(long in, int base) {
        ArrayList<Integer> out = new ArrayList<>();
        while (in > 0) {
            out.add((int) (in % base));
            in /= base;
        }
        Collections.reverse(out);
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
