
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
        int[] CD = readInts(2);
        int C = CD[0];
        int D = CD[1];
        int[] Xs_tmp = readInts(C - 1);

        //Number updated strictly before this
        int[] Xs = new int[C];
        Arrays.fill(Xs, -1);
        Xs[0] = 0;
        for (int i = 0; i < C - 1; i++) {
            if (Xs_tmp[i] < 0) Xs[i + 1] = -Xs_tmp[i];
        }

        //Fixed time of update
        int[] fixedtime = new int[C];
        boolean[] fixedtimetaken = new boolean[C];
        Arrays.fill(fixedtime, -1);
        fixedtime[0] = 0;
        for (int i = 0; i < C - 1; i++) {
            if (Xs_tmp[i] > 0) fixedtime[i + 1] = Xs_tmp[i];
        }

        int[][] links = new int[D][2];
        for (int i = 0; i < D; i++) {
            links[i] = readInts(2);
            links[i][0]--;
            links[i][1]--;
        }

        int[] updatedAt = new int[C];
        Arrays.fill(updatedAt, -1);
        updatedAt[0] = 0;

        int[] linktime = new int[D];

        List<Set<Integer>> nodeorder = new ArrayList<>();
        for (int i = 1; i < C; i++) {
            Set<Integer> s = new HashSet<>();
            for (int node = 0; node < C; node++) {
                if (Xs[node] == i) s.add(node);
            }
            if (!s.isEmpty()) nodeorder.add(s);
        }

        int arrivaltime = 0;
        
        debug(Xs);
        debug(fixedtime);
        //debug(nodeorder);
        //debug(links);

        int numprocessed = 1;
        for (Set<Integer> nodes : nodeorder) {
            int requirePriorNum = Xs[nodes.iterator().next()];
            int lastFixedTime = arrivaltime;
            while (requirePriorNum > numprocessed) {
                //process next
                int node = -1;
                int earliest = -1;
                for (int i = 0; i < C; i++) {
                    if (fixedtime[i] > 0 && !fixedtimetaken[i]) {
                        if (earliest == -1 || earliest > fixedtime[i]) {
                            earliest = fixedtime[i];
                            node = i;
                        }
                    }
                }

                debug("take fixed " + node + " time " + fixedtime[node]);
                numprocessed++;
                fixedtimetaken[node] = true;
                lastFixedTime = fixedtime[node];

                for (int d = 0; d < D; d++) {
                    int other = -1;
                    if (links[d][0] == node) other = links[d][1];
                    if (links[d][1] == node) other = links[d][0];
                    if (other == -1) continue;
                    if (updatedAt[other] == -1) continue;
                    if (updatedAt[other] == lastFixedTime) continue;

                    updatedAt[node] = lastFixedTime;
                    linktime[d] = lastFixedTime - updatedAt[other];
                    //debug("using link " + Arrays.toString(links[d]) + " arrival " + arrivaltime);
                    break;
                }

            }

            arrivaltime = lastFixedTime + 1;

            for (int node : nodes) {
                for (int d = 0; d < D; d++) {
                    int other = -1;
                    if (links[d][0] == node) other = links[d][1];
                    if (links[d][1] == node) other = links[d][0];
                    if (other == -1) continue;
                    if (updatedAt[other] == -1) continue;
                    if (updatedAt[other] == arrivaltime) continue;

                    updatedAt[node] = arrivaltime;
                    linktime[d] = arrivaltime - updatedAt[other];
                    //debug("using link " + Arrays.toString(links[d]) + " arrival " + arrivaltime);
                    break;
                }
            }
            numprocessed += nodes.size();
            //arrivaltime++;
        }

        //any remaining fixed time after all positionals
        while (C > numprocessed) {
            //process next
            int node = -1;
            int earliest = -1;
            for (int i = 0; i < C; i++) {
                if (fixedtime[i] > 0 && !fixedtimetaken[i]) {
                    if (earliest == -1 || earliest > fixedtime[i]) {
                        earliest = fixedtime[i];
                        node = i;
                    }
                }
            }

            debug("leftovers take fixed " + node + " time " + fixedtime[node]);
            numprocessed++;
            fixedtimetaken[node] = true;
            int lastFixedTime = fixedtime[node];

            for (int d = 0; d < D; d++) {
                int other = -1;
                if (links[d][0] == node) other = links[d][1];
                if (links[d][1] == node) other = links[d][0];
                if (other == -1) continue;
                if (updatedAt[other] == -1) continue;
                if (updatedAt[other] == lastFixedTime) continue;

                updatedAt[node] = lastFixedTime;
                linktime[d] = lastFixedTime - updatedAt[other];
                //debug("using link " + Arrays.toString(links[d]) + " arrival " + arrivaltime);
                break;
            }

        }

        StringBuilder sb = new StringBuilder();
        for (int d = 0; d < D; d++) {
            if (linktime[d] == 0) linktime[d] = 1000000;
            sb.append(linktime[d] + " ");
        }
        return sb.toString().trim();
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
