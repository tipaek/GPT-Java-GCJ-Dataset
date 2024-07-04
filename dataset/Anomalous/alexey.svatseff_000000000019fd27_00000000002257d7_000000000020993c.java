import java.io.*;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
    private static final boolean DEBUG = false;

    private static int T;
    private static int N;
    private static int trace;
    private static boolean[][] numPerRow, numPerCol;
    private static boolean[] rowDuplicates, colDuplicates;

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);

            try (Scanner in = openInput(args);
                 PrintStream out = openOutput(args)) {

                T = in.nextInt();
                for (int caseNumber = 1; caseNumber <= T; caseNumber++) {
                    readCaseInput(in);
                    solveCase(caseNumber, out);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readCaseInput(Scanner in) {
        N = in.nextInt();
        trace = 0;
        numPerRow = new boolean[N][N + 1];
        numPerCol = new boolean[N][N + 1];
        rowDuplicates = new boolean[N];
        colDuplicates = new boolean[N];

        for (int row = 0; row < N; row++) {
            for (int column = 0; column < N; column++) {
                int a = in.nextInt();
                if (row == column) trace += a;
                if (!rowDuplicates[row]) {
                    rowDuplicates[row] = numPerRow[row][a];
                    numPerRow[row][a] = true;
                }
                if (!colDuplicates[column]) {
                    colDuplicates[column] = numPerCol[column][a];
                    numPerCol[column][a] = true;
                }
            }
        }
    }

    private static void solveCase(int caseNumber, PrintStream out) {
        long rowDupCount = IntStream.range(0, N).filter(i -> rowDuplicates[i]).count();
        long colDupCount = IntStream.range(0, N).filter(i -> colDuplicates[i]).count();
        writeCaseResult(out, caseNumber, String.format("%d %d %d", trace, rowDupCount, colDupCount));
    }

    private static void writeCaseResult(PrintStream out, int caseNumber, String formattedResult) {
        out.println("Case #" + caseNumber + ": " + formattedResult);
        out.flush();
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