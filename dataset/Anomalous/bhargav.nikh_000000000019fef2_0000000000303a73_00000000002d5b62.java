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
            solveCase(idx, br);
        }
    }

    private void solveCase(int caseNo, BufferedReader br) throws Exception {
        String[] inputs = br.readLine().split(" ");
        long x = Long.parseLong(inputs[0]);
        long y = Long.parseLong(inputs[1]);
        printSolution(caseNo, x, y);
    }

    private boolean resultFound;
    private String result;

    private void printSolution(int caseNo, long x, long y) {
        resultFound = false;
        result = "";

        if (!bothEvenOrOdd(x, y)) {
            long maxIdx = (long) Math.ceil(logBase2(Math.abs(x) + Math.abs(y)));
            findPath(0, 0, 0, x, y, maxIdx, new StringBuilder());
        }

        if (!resultFound) {
            result = "IMPOSSIBLE";
        }
        System.out.println("Case #" + caseNo + ": " + result);
    }

    private void findPath(long idx, long curX, long curY, long targetX, long targetY, long maxIdx, StringBuilder path) {
        if (idx == maxIdx || resultFound) {
            return;
        }

        if (curX == targetX && curY == targetY) {
            resultFound = true;
            result = path.toString();
            return;
        }

        long step = 1L << idx;

        path.append("N");
        findPath(idx + 1, curX, curY + step, targetX, targetY, maxIdx, path);
        if (resultFound) return;
        path.setLength(path.length() - 1);

        path.append("S");
        findPath(idx + 1, curX, curY - step, targetX, targetY, maxIdx, path);
        if (resultFound) return;
        path.setLength(path.length() - 1);

        path.append("E");
        findPath(idx + 1, curX + step, curY, targetX, targetY, maxIdx, path);
        if (resultFound) return;
        path.setLength(path.length() - 1);

        path.append("W");
        findPath(idx + 1, curX - step, curY, targetX, targetY, maxIdx, path);
        path.setLength(path.length() - 1);
    }

    private boolean bothEvenOrOdd(long x, long y) {
        return (x % 2 == y % 2);
    }

    private double logBase2(long value) {
        return Math.log(value) / Math.log(2);
    }
}