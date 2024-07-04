import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Solution {
    private static boolean DEBUG = false;

    // Solution //////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static void readCaseInput(int caseNumber, Scanner in) throws Exception {
        String unparsedString = in.nextLine();
        N = unparsedString.length();
        maxNum = 0;
        string = new int[N];
        closeCount = new int[N + 1];
        openCount = new int[N + 1];

        for (int i = 0; i < N; ++i) {
            string[i] = unparsedString.charAt(i) - '0';
            maxNum = Math.max(maxNum, string[i]);
        }
    }

    static int T;
    static int N;
    static int maxNum;
    static int[] string;
    static int[] closeCount, openCount;

    private static void solveCase(int caseNumber, PrintStream out) throws Exception {
        List<int[]> ranges = Collections.singletonList(new int[]{0, N});
        for (int level = 1; level <= maxNum; ++level) {
            ranges = wrapWithParentheses(level, ranges);
        }

        StringBuilder transformed = new StringBuilder();
        for (int i = 0; i <= N; ++i) {
            for (int j = 0; j < closeCount[i]; ++j) transformed.append(')');
            for (int j = 0; j < openCount[i]; ++j) transformed.append('(');
            if (i < N) transformed.append(string[i]);
        }

        writeCaseResult(out, caseNumber, transformed.toString());
    }

    private static List<int[]> wrapWithParentheses(int level, List<int[]> ranges) {
        List<int[]> upperRanges = new ArrayList<>();
        for (int[] range : ranges) {
            int[] upRange = null;
            for (int i = range[0]; i < range[1]; ++i) {
                if (string[i] >= level) {
                    if (upRange == null) {
                        upRange = new int[]{i, -1};
                        ++openCount[i];
                    }
                } else {
                    if (upRange != null) {
                        upRange[1] = i;
                        upperRanges.add(upRange);
                        upRange = null;
                        ++closeCount[i];
                    }
                }
            }
            if (upRange != null) {
                upRange[1] = range[1];
                upperRanges.add(upRange);
                ++closeCount[range[1]];
            }
        }
        return upperRanges;
    }

    private static void writeCaseResult(PrintStream out, int caseNumber, String formattedResult) throws IOException {
        out.println("Case #" + caseNumber + ": " + formattedResult);
        out.flush();
    }

    // Helpers ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    static final DecimalFormat DOUBLE_FORMAT = new DecimalFormat("#0.000000");

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);

            try (Scanner in = openInput(args);
                 PrintStream out = openOutput(args)) {

                T = in.nextInt();
                in.nextLine();
                for (int caseNumber = 1; caseNumber <= T; caseNumber++) {
                    readCaseInput(caseNumber, in);
                    solveCase(caseNumber, out);
                    out.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Scanner openInput(String[] args) throws FileNotFoundException {
        if (DEBUG) {
            String inPathName = args[0];
            File inFile = new File(inPathName);
            return new Scanner(new BufferedReader(new FileReader(inFile)));
        } else {
            return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        }
    }

    private static PrintStream openOutput(String[] args) throws IOException {
        if (DEBUG) {
            String inPathName = args[0];
            String inPathBase = inPathName.substring(0, inPathName.lastIndexOf('.'));
            File outFile = new File(inPathBase + ".out");
            return new PrintStream(new BufferedOutputStream(new FileOutputStream(outFile)));
        } else {
            return System.out;
        }
    }
}