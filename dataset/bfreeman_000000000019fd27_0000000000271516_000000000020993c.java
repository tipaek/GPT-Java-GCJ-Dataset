import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public final static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int numCases = in.nextInt();
        for (int i = 0; i < numCases; i++) {
            runCase(i + 1);
        }
    }

    public static void runCase(int caseNum) {
        int mDim = in.nextInt();
        int[][] m = new int[mDim][mDim];

        fillM(m);
        int trace = trace(m);

        int repRows = 0;
        for (int i = 0; i < mDim; i++) {
            if (repeats(m[i])) {
                repRows++;
            }
        }

        int repCols = 0;
        for (int i = 0; i < mDim; i++) {
            if (repeats(getCol(m, i))) {
                repCols++;
            }
        }

        printCaseResult(caseNum, formatResult(trace, repRows, repCols));
    }

    public static void fillM(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                m[i][j] = in.nextInt();
            }
        }
    }

    public static int trace(int[][] m) {
        int trace = 0;
        for (int i = 0; i < m.length; i++) {
            trace += m[i][i];
        }
        return trace;
    }

    public static boolean repeats(int[] v) {
        ArrayList<Integer> seen = new ArrayList<>(v.length);
        for (Integer i : v) {
            if (seen.contains(i)) {
                return true;
            } else {
                seen.add(i);
            }
        }
        return false;
    }

    public static int[] getCol(int[][] m, int c) {
        int[] col = new int[m.length];
        for (int i = 0; i < m.length; i++) {
            col[i] = m[i][c];
        }
        return col;
    }

    public static String formatResult(int trace, int repRows, int repCols) {
        StringBuilder str = new StringBuilder();
        str.append(trace).append(" ").append(repRows).append(" ").append(repCols);
        return str.toString();
    }

    public static void printCaseResult(int caseNum, String result) {
        System.out.printf("Case #%d: %s%n", caseNum, result);
    }
}
