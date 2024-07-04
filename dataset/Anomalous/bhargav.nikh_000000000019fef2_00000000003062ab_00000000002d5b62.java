import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        new Solution().solveCases();
    }

    private void solveCases() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nCases = Integer.parseInt(br.readLine());
        for (int idx = 1; idx <= nCases; idx++) {
            solve(idx, br);
        }
    }

    private void solve(int caseNo, BufferedReader br) throws Exception {
        String[] inpArr = br.readLine().split(" ");
        long x = Long.parseLong(inpArr[0]);
        long y = Long.parseLong(inpArr[1]);
        printSolve(caseNo, x, y);
    }

    private boolean resultFound;
    private String result;

    private void printSolve(int caseNo, long x, long y) {
        resultFound = false;
        result = "";

        if (!bothEvenOrOdd(x, y)) {
            long maxIdx = (long) logBase2(Math.abs(x) + Math.abs(y)) + 1;
            findPath(0, 0, 0, x, y, maxIdx, new StringBuilder());
        }

        if (!resultFound) {
            result = "IMPOSSIBLE";
        }
        System.out.println("Case #" + caseNo + ": " + result);
    }

    private void findPath(long idx, long curX, long curY, long x, long y, long maxIdx, StringBuilder resultStr) {
        if (idx > maxIdx) {
            return;
        }

        if (curX == x && curY == y) {
            resultFound = true;
            result = resultStr.toString();
            return;
        }

        long val = 1L << idx;

        if (idx == 0) {
            if (Math.abs(y) % 2 == 1) {
                exploreDirection(idx, curX, curY, x, y, maxIdx, resultStr, "N", 0, val);
                if (resultFound) return;
                exploreDirection(idx, curX, curY, x, y, maxIdx, resultStr, "S", 0, -val);
            } else {
                exploreDirection(idx, curX, curY, x, y, maxIdx, resultStr, "E", val, 0);
                if (resultFound) return;
                exploreDirection(idx, curX, curY, x, y, maxIdx, resultStr, "W", -val, 0);
            }
        } else {
            exploreDirection(idx, curX, curY, x, y, maxIdx, resultStr, "N", 0, val);
            if (resultFound) return;
            exploreDirection(idx, curX, curY, x, y, maxIdx, resultStr, "S", 0, -val);
            if (resultFound) return;
            exploreDirection(idx, curX, curY, x, y, maxIdx, resultStr, "E", val, 0);
            if (resultFound) return;
            exploreDirection(idx, curX, curY, x, y, maxIdx, resultStr, "W", -val, 0);
        }
    }

    private void exploreDirection(long idx, long curX, long curY, long x, long y, long maxIdx, StringBuilder resultStr, String direction, long dx, long dy) {
        resultStr.append(direction);
        findPath(idx + 1, curX + dx, curY + dy, x, y, maxIdx, resultStr);
        resultStr.setLength(resultStr.length() - 1);
    }

    private boolean bothEvenOrOdd(long x, long y) {
        return (x % 2 == y % 2);
    }

    private double logBase2(long a) {
        return Math.log(a) / Math.log(2);
    }
}