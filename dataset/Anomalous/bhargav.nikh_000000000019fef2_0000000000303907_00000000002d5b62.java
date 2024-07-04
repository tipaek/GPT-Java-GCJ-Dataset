import java.util.*;
import java.io.*;

public class Solution {

    private boolean resultFound;
    private String result;

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

    public void printSolve(int caseNo, long x, long y) {
        resultFound = false;
        result = "";

        if (!bothEvenOrOdd(x, y)) {
            long maxIdx = ((long) logBase2(Math.abs(x) + Math.abs(y))) + 1;
            solve(0, 0, 0, x, y, maxIdx, new StringBuilder());
        }

        if (!resultFound) {
            result = "IMPOSSIBLE";
        }
        System.out.println("Case #" + caseNo + ": " + result);
    }

    public void solve(long idx, long curX, long curY, long x, long y, long maxIdx, StringBuilder resultStr) {
        if (idx == maxIdx || resultFound) {
            return;
        }

        if (curX == x && curY == y) {
            resultFound = true;
            result = resultStr.toString();
            return;
        }

        long val = (long) Math.pow(2, idx);

        resultStr.append("N");
        solve(idx + 1, curX, curY + val, x, y, maxIdx, resultStr);
        resultStr.setLength(resultStr.length() - 1);
        if (resultFound) return;

        resultStr.append("S");
        solve(idx + 1, curX, curY - val, x, y, maxIdx, resultStr);
        resultStr.setLength(resultStr.length() - 1);
        if (resultFound) return;

        resultStr.append("E");
        solve(idx + 1, curX + val, curY, x, y, maxIdx, resultStr);
        resultStr.setLength(resultStr.length() - 1);
        if (resultFound) return;

        resultStr.append("W");
        solve(idx + 1, curX - val, curY, x, y, maxIdx, resultStr);
        resultStr.setLength(resultStr.length() - 1);
    }

    public boolean bothEvenOrOdd(long x, long y) {
        return (x % 2 == 0 && y % 2 == 0) || (x % 2 != 0 && y % 2 != 0);
    }

    public double logBase2(long a) {
        return Math.log(a) / Math.log(2);
    }
}