
import java.util.*;
import java.io.*;
import java.util.function.Supplier;
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
            int numCases = 1; //new Integer(_scanner.nextLine());
            for (int caseNum = 1; caseNum <= numCases; caseNum++) {
                Solution s = new Solution(caseNum, _scanner);
                s.debug("starting");
                Object answer = s.solve();
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

    private Object solve() {
        int[] TNC = readInts(3);
        int T = TNC[0];
        int N = TNC[1];
        int C = TNC[2];
        
        Game[] games = new Game[T];
        for (int i = 0; i < T; i++) {
            games[i] = new Game();
            games[i].init();
        }
        
        while (true) {
            int[] toSend = new int[T];
            boolean anyNonZero = false;
            for (int i = 0; i < T; i++) {
                toSend[i] = games[i].next();
                if (toSend[i] > 0) anyNonZero = true;
            }
            String s = Arrays.stream(toSend).boxed().map(i -> i.toString()).collect(Collectors.joining(" "));
            output.println(s);
            if (!anyNonZero) break;

            int[] response = readInts(T);
            for (int i = 0; i < T; i++) {
                games[i].response(response[i]);
            }
        }
        
        String s = Arrays.stream(games).map(g -> g.guesses()).collect(Collectors.joining(" "));
        output.println(s);
        return "";
    }
    
    class Game {
        Set<Integer> remains = new HashSet<>();
        int process = 1;
        int sent = 0;
        boolean stop = false;
        
        private void init() {
            for (int i = 1; i <= 15; i++) {
                remains.add(i);
            }
        }

        private String guesses() {
            List<Integer> l = new ArrayList<>(remains);
            return l.get(0) + " " + l.get(1);
        }

        private void response(int i) {
            if (process == 0) return;
            if (i == 0) {
                remains.remove(sent - 1);
                sent = 0;
                process++;
                
                if (process == 14) process = 0;
                
                if (av() > 8.0) process = 0;
            }
        }

        private int next() {
            sent++;
            return process;
        }

        private double av() {
            double sum = 0d;
            double c = 0d;
            for (int i : remains) {
                c = c + 1d;
                sum = sum + (double) i;
            }
            return sum / c;
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


    private void debug(Supplier<String> supplier) {
        if (local) System.out.println("Debug case " + caseNum + ": " + supplier.get());
    }

    private String toString(Object o) {
        if (o instanceof Object[]) return Arrays.toString((Object[]) o);
        if (o instanceof int[]) return Arrays.toString((int[]) o);
        return Objects.toString(o);
    }

}
