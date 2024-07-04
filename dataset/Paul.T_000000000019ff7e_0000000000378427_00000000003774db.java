
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
        String[] CJ = readStrings(2);
        String C = CJ[0];
        String J = CJ[1];
        String[][] mid = calculate(C, J);
//        int[][] backward = calculate2(C, J);
//        
//        debug(Arrays.deepToString(forward));
////        debug(Arrays.deepToString(backward));
//        
//        int diff = forward[C.length()][J.length()];
//        debug(diff);
//        
//        for (int i = 0; i <= C.length(); i++) {
//            for (int j = 0; j <= J.length(); j++) {
//                if (i == 0 && j == 0) continue;
//                int f = forward[i][j];
//                int b = backward[C.length() - i][J.length() - j];
//                if (f + b == diff && (Math.abs(f - b) <= 1)) {
//                    String cs = i == 0 ? "" : C.substring(0, i);
//                    String je = j == 0 ? "" : J.substring(J.length() - j);
//                    debug(f, b);
//                    debug("cs", i, cs, "je", j, je);
//                    return cs + je;
//                }
//            }
//        }
        String out = mid[C.length()][J.length()];
        
//        calculate(C, out);
//        calculate(J, out);
        return out;
    }

    String[][] calculate(String x, String y) {
        int[][] dp = new int[x.length() + 1][y.length() + 1];
        String[][] mid = new String[x.length() + 1][y.length() + 1];

        for (int i = 0; i <= x.length(); i++) {
            for (int j = 0; j <= y.length(); j++) {
                if (i == 0 && j == 0) {
                    mid[i][j] = "";
                    continue;
                }

                if (i == 0) {
                    dp[i][j] = j;
                    boolean useX = dp[i][j] % 2 == 0;
                    mid[i][j] = mid[i][j - 1];
                    if (!useX) mid[i][j] += mid[i][j] + y.charAt(j - 1);

                } else if (j == 0) {
                    dp[i][j] = i;
                    boolean useX = dp[i][j] % 2 == 0;
                    mid[i][j] = mid[i - 1][j];
                    if (useX) mid[i][j] += x.charAt(i - 1);

                } else {
                    int cost = costOfSubstitution(x.charAt(i - 1), y.charAt(j - 1));
                    int o1 = dp[i - 1][j - 1] + cost;
                    int o2 = dp[i - 1][j] + 1;
                    int o3 = dp[i][j - 1] + 1;
                    int min = min(o1, o2, o3);
                    dp[i][j] = min;
                    boolean useX = dp[i][j] % 2 == 0;
                    if (o1 == min) {
                        if (useX) {
                            mid[i][j] = mid[i - 1][j - 1] + x.charAt(i - 1);
                        } else {
                            mid[i][j] = mid[i - 1][j - 1] + y.charAt(j - 1);
                        }
                    } else if (o2 == min) {
                        mid[i][j] = mid[i - 1][j];
                        if (useX) mid[i][j] += x.charAt(i - 1);
                    } else {
                        mid[i][j] = mid[i][j - 1];
                        if (!useX) mid[i][j] += mid[i][j] + y.charAt(j - 1);
                    }

//                    dp[i][j] = min(dp[i - 1][j - 1]
//                            + costOfSubstitution(x.charAt(i - 1), y.charAt(j - 1)),
//                            dp[i - 1][j] + 1,
//                            dp[i][j - 1] + 1);
                }
            }
        }
        debug(dp[x.length()][y.length()]);
        return mid;
    }

    int[][] calculate2(String x, String y) {
        int[][] dp = new int[x.length() + 1][y.length() + 1];

        for (int i = 0; i <= x.length(); i++) {
            for (int j = 0; j <= y.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = min(dp[i - 1][j - 1]
                            + costOfSubstitution(x.charAt(x.length() - 1 - (i - 1)), y.charAt(y.length() - 1 - (j - 1))),
                            dp[i - 1][j] + 1,
                            dp[i][j - 1] + 1);
                }
            }
        }
        return dp;
    }

    public static int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }

    public static int min(int... numbers) {
        return Arrays.stream(numbers)
                .min().orElse(Integer.MAX_VALUE);
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
