import java.io.*;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class Solution {
    private static final boolean DEBUG = false;
    private static final DecimalFormat DOUBLE_FORMAT = new DecimalFormat("#0.000000");

    private static int T;
    private static long L, R;

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);

            try (Scanner in = openInput(args);
                 PrintStream out = openOutput(args)) {
                T = in.nextInt();
                for (int caseNumber = 1; caseNumber <= T; caseNumber++) {
                    readCaseInput(in);
                    solveCase(caseNumber, out);
                    out.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readCaseInput(Scanner in) {
        L = in.nextLong();
        R = in.nextLong();
    }

    private static void solveCase(int caseNumber, PrintStream out) {
        long left = L, right = R;
        long discrepancy = Math.abs(left - right);
        long countInit = countCustomers(discrepancy, 1L, 1L);
        long demandInit = calculateDemand(1L, 1L, countInit);

        if (left < right) {
            right -= demandInit;
        } else {
            left -= demandInit;
        }

        long count = countInit;
        if (left >= right) {
            count += adjustCounts(left, right, countInit, true);
        } else {
            count += adjustCounts(left, right, countInit, false);
        }

        writeCaseResult(out, caseNumber, String.format("%d %d %d", count, left, right));
    }

    private static long adjustCounts(long left, long right, long countInit, boolean isLeftGreaterOrEqual) {
        long countLeft, countRight;
        if (isLeftGreaterOrEqual) {
            countLeft = countCustomers(left, countInit + 1, 2L);
            countRight = countCustomers(right, countInit + 2, 2L);
            countRight = Math.min(countRight, countLeft);
            countLeft = Math.min(countLeft, countRight + 1);
        } else {
            countLeft = countCustomers(left, countInit + 2, 2L);
            countRight = countCustomers(right, countInit + 1, 2L);
            countLeft = Math.min(countLeft, countRight);
            countRight = Math.min(countRight, countLeft + 1);
        }
        left -= calculateDemand(countInit + (isLeftGreaterOrEqual ? 1 : 2), 2L, countLeft);
        right -= calculateDemand(countInit + (isLeftGreaterOrEqual ? 2 : 1), 2L, countRight);
        return countLeft + countRight;
    }

    private static long countCustomers(long stock, long initial, long step) {
        long l = 0L, r = Math.min(stock + 1, 20000000000L);
        while (l + 1 < r) {
            long m = (l + r) / 2;
            long demand = calculateDemand(initial, step, m);
            if (demand > stock) {
                r = m;
            } else if (demand < stock) {
                l = m;
            } else {
                return m;
            }
        }
        return l;
    }

    private static long calculateDemand(long initial, long step, long n) {
        long last = initial + (n - 1) * step;
        return n * (initial + last) / 2L;
    }

    private static void writeCaseResult(PrintStream out, int caseNumber, String formattedResult) {
        out.println("Case #" + caseNumber + ": " + formattedResult);
    }

    private static Scanner openInput(String[] args) throws FileNotFoundException {
        if (DEBUG) {
            String inPathName = args[0];
            return new Scanner(new BufferedReader(new FileReader(new File(inPathName))));
        } else {
            return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        }
    }

    private static PrintStream openOutput(String[] args) throws IOException {
        if (DEBUG) {
            String inPathName = args[0];
            String inPathBase = inPathName.substring(0, inPathName.lastIndexOf('.'));
            return new PrintStream(new BufferedOutputStream(new FileOutputStream(new File(inPathBase + ".out"))));
        } else {
            return System.out;
        }
    }
}