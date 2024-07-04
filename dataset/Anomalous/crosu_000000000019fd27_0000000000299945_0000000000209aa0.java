import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class Solution {

    public static boolean debug = false;
    public static boolean fromFile = false;
    public static String inputFile = "testE.in";

    public static PrintWriter writer;
    public static Scanner scanner;

    public static void debugPrintln(String s) {
        if (debug) {
            writer.println(s);
        }
    }

    public static void debugPrint(String s) {
        if (debug) {
            writer.print(s);
        }
    }

    public static long now() {
        return System.nanoTime();
    }

    public static double round(double d, int sigDigits) {
        double factor = Math.pow(10, sigDigits);
        return Math.round(d * factor) / factor;
    }

    public static void printTime(long start, long stop) {
        long elapsed = stop - start;
        double msPerNs = Math.pow(10, -6);
        debugPrintln("Ms elapsed: " + round(elapsed * msPerNs, 4) + " (" + round(start * msPerNs, 4) + ", " + round(stop * msPerNs, 4) + ")");
    }

    public static Map<Integer, Integer> toTraceInfo(Vector<Integer> trace) {
        Map<Integer, Integer> values = new HashMap<>();
        for (int n : trace) {
            values.put(n, values.getOrDefault(n, 0) + 1);
        }
        return values;
    }

    public static Set<Integer> toTraceSignature(Vector<Integer> trace) {
        return new HashSet<>(toTraceInfo(trace).values());
    }

    public static int toTraceSum(Vector<Integer> trace) {
        int sum = 0;
        for (int n : trace) {
            sum += n;
        }
        return sum;
    }

    public static class LatinSquare {
        List<Integer> content;
        int n;

        public LatinSquare(int n) {
            this.n = n;
            content = new ArrayList<>(Collections.nCopies(n * n, null));
        }

        public LatinSquare(LatinSquare l) {
            this.content = new ArrayList<>(l.content);
            this.n = l.n;
        }

        public int get(int k) {
            return content.get(k);
        }

        public int get(int i, int j) {
            return get(i * n + j);
        }

        public void set(int k, Integer value) {
            content.set(k, value);
        }

        public void set(int i, int j, Integer value) {
            set(i * n + j, value);
        }

        @Override
        public String toString() {
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < n; i++) {
                ans.append("\n");
                for (int j = 0; j < n; j++) {
                    ans.append(get(i, j));
                    if (j < n - 1) {
                        ans.append(" ");
                    }
                }
            }
            return ans.toString();
        }

        public boolean isValidSet(int i, int j, int value) {
            for (int k = 0; k < i; k++) {
                if (get(k, j) == value) {
                    return false;
                }
            }
            for (int k = 0; k < j; k++) {
                if (get(i, k) == value) {
                    return false;
                }
            }
            return true;
        }

        public boolean isValidSet(int k, int value) {
            int j = k % n;
            int i = k / n;
            return isValidSet(i, j, value);
        }

        public Vector<Integer> trace() {
            Vector<Integer> trace = new Vector<>();
            for (int i = 0; i < n; i++) {
                trace.add(get(i, i));
            }
            return trace;
        }

        public Set<Integer> traceSignature() {
            return toTraceSignature(trace());
        }
    }

    public static void advance(LatinSquare l, int next, Map<Set<Integer>, LatinSquare> latinSquares) {
        boolean lastStep = next == (l.n * l.n - 1);

        for (int i = 0; i < l.n; i++) {
            if (l.isValidSet(next, i + 1)) {
                l.set(next, i + 1);

                if (lastStep) {
                    Set<Integer> traceSignature = l.traceSignature();
                    latinSquares.putIfAbsent(traceSignature, new LatinSquare(l));
                } else {
                    advance(l, next + 1, latinSquares);
                }
            }
        }
        l.set(next, null);
    }

    public static Map<Set<Integer>, LatinSquare> generateLatinSquares(int n) {
        Map<Set<Integer>, LatinSquare> latinSquares = new HashMap<>();
        LatinSquare base = new LatinSquare(n);

        for (int i = 0; i < n; i++) {
            base.set(0, i, i + 1);
        }

        advance(base, n, latinSquares);
        return latinSquares;
    }

    public static Vector<Integer> ithTrace(int i, int n) {
        Vector<Integer> digits = new Vector<>(n);
        for (int j = 0; j < n; j++) {
            digits.add((i % n) + 1);
            i /= n;
        }
        return digits;
    }

    public static Vector<Vector<Integer>> allTraces(int n) {
        Vector<Vector<Integer>> traces = new Vector<>();
        for (int i = 0; i < Math.pow(n, n); i++) {
            traces.add(ithTrace(i, n));
        }
        return traces;
    }

    public static LatinSquare convertLatinSquare(LatinSquare base, Vector<Integer> trace) {
        int[] mapping = new int[base.n];
        Map<Integer, Integer> baseTraceInfo = toTraceInfo(base.trace());
        Map<Integer, Integer> thisTraceInfo = toTraceInfo(trace);

        Set<Integer> unusedBase = new HashSet<>();
        for (int i = 0; i < base.n; i++) {
            unusedBase.add(i + 1);
        }

        for (int i = 0; i < trace.size(); i++) {
            int targetCount = thisTraceInfo.get(i + 1);
            for (int unused : unusedBase) {
                if (baseTraceInfo.get(unused) == targetCount) {
                    mapping[unused - 1] = i + 1;
                    unusedBase.remove(unused);
                    break;
                }
            }
        }

        LatinSquare ans = new LatinSquare(base);
        for (int i = 0; i < base.n; i++) {
            for (int j = 0; j < base.n; j++) {
                ans.set(i, j, mapping[base.get(i, j) - 1]);
            }
        }
        return ans;
    }

    public static Map<Integer, LatinSquare> solveForN(int n) {
        Map<Set<Integer>, LatinSquare> latinSquares = generateLatinSquares(n);
        Map<Integer, LatinSquare> solutions = new HashMap<>();
        Vector<Vector<Integer>> traces = allTraces(n);

        for (Vector<Integer> trace : traces) {
            Set<Integer> traceSignature = toTraceSignature(trace);
            int traceSum = toTraceSum(trace);
            if (latinSquares.containsKey(traceSignature)) {
                solutions.put(traceSum, convertLatinSquare(latinSquares.get(traceSignature), trace));
            }
        }
        return solutions;
    }

    public static void nextCase(int caseNum, Map<Integer, Map<Integer, LatinSquare>> solutions) {
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        Map<Integer, LatinSquare> solutionsForN = solutions.get(n);
        String result;

        if (!solutionsForN.containsKey(k)) {
            result = "IMPOSSIBLE";
        } else {
            result = "POSSIBLE";
            LatinSquare answer = solutionsForN.get(k);
            result += answer;
        }

        writer.print("Case #" + caseNum + ": " + result);
    }

    public static void main(String[] args) throws Exception {
        scanner = fromFile ? new Scanner(new File(inputFile)) : new Scanner(System.in);
        writer = new PrintWriter(System.out);

        int t = scanner.nextInt();
        Map<Integer, Map<Integer, LatinSquare>> solutions = new HashMap<>();

        for (int i = 2; i <= 5; i++) {
            solutions.put(i, solveForN(i));
        }

        debugPrintln("Solution is\n" + solutions);

        for (int i = 0; i < t; i++) {
            nextCase(i + 1, solutions);
            if (i < t - 1) {
                writer.println();
            }
        }

        writer.close();
        scanner.close();
    }
}