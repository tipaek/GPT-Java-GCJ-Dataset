import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        new Solution().solveCases();
    }

    public void solveCases() throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int nCases = Integer.parseInt(br.readLine());
            for (int idx = 1; idx <= nCases; idx++) {
                solve(idx, br);
            }
        }
    }

    public void solve(int caseNo, BufferedReader br) throws Exception {
        String[] inpArr = br.readLine().split(" ");
        long x = Long.parseLong(inpArr[0]);
        long y = Long.parseLong(inpArr[1]);
        printSolve(caseNo, x, y);
    }

    private boolean resultFound;
    private String result;

    public void printSolve(int caseNo, long x, long y) {
        resultFound = false;
        result = "";

        if (!bothEvenOrOdd(x, y)) {
            long maxIdx = (long) logBase2(Math.abs(x) + Math.abs(y)) + 1;
            solve(0, 0, 0, x, y, maxIdx, new StringBuilder());
        }

        if (!resultFound) {
            result = "IMPOSSIBLE";
        }
        System.out.println("Case #" + caseNo + ": " + result);
    }

    public void solve(long idx, long curX, long curY, long x, long y, long maxIdx, StringBuilder resultStr) {
        if (idx > maxIdx) {
            return;
        }

        if (curX == x && curY == y) {
            resultFound = true;
            result = resultStr.toString();
            return;
        }

        long val = 1L << idx;

        char[] directions = idx == 0 ? (y % 2 == 1 ? new char[]{'N', 'S'} : new char[]{'E', 'W'}) : new char[]{'N', 'S', 'E', 'W'};
        long[][] deltas = idx == 0 ? (y % 2 == 1 ? new long[][]{{0, val}, {0, -val}} : new long[][]{{val, 0}, {-val, 0}}) : new long[][]{{0, val}, {0, -val}, {val, 0}, {-val, 0}};

        for (int i = 0; i < directions.length; i++) {
            resultStr.append(directions[i]);
            solve(idx + 1, curX + deltas[i][0], curY + deltas[i][1], x, y, maxIdx, resultStr);
            if (resultFound) return;
            resultStr.setLength(resultStr.length() - 1);
        }
    }

    public boolean bothEvenOrOdd(long x, long y) {
        return (x % 2 == y % 2);
    }

    public double logBase2(long a) {
        return Math.log(a) / Math.log(2);
    }
}