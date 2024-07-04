import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws Exception {
        new Solution().solveCases();
    }

    public void solveCases() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nCases = Integer.parseInt(br.readLine());
        for (int idx = 1; idx <= nCases; idx++) {
            solve(idx, br);
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
            long maxIdx = (long) (Math.log(Math.abs(x) + Math.abs(y)) / Math.log(2)) + 1;
            solve(0, 0, 0, x, y, maxIdx, new StringBuilder());
        }

        if (!resultFound) {
            result = "IMPOSSIBLE";
        }
        System.out.println("Case #" + caseNo + ": " + result);
    }

    private void solve(long idx, long curX, long curY, long x, long y, long maxIdx, StringBuilder resultStr) {
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
                tryDirection(idx, curX, curY, x, y, maxIdx, resultStr, 'N', 0, val);
                tryDirection(idx, curX, curY, x, y, maxIdx, resultStr, 'S', 0, -val);
            } else {
                tryDirection(idx, curX, curY, x, y, maxIdx, resultStr, 'E', val, 0);
                tryDirection(idx, curX, curY, x, y, maxIdx, resultStr, 'W', -val, 0);
            }
        } else {
            tryDirection(idx, curX, curY, x, y, maxIdx, resultStr, 'N', 0, val);
            tryDirection(idx, curX, curY, x, y, maxIdx, resultStr, 'S', 0, -val);
            tryDirection(idx, curX, curY, x, y, maxIdx, resultStr, 'E', val, 0);
            tryDirection(idx, curX, curY, x, y, maxIdx, resultStr, 'W', -val, 0);
        }
    }

    private void tryDirection(long idx, long curX, long curY, long x, long y, long maxIdx, StringBuilder resultStr, char direction, long deltaX, long deltaY) {
        resultStr.append(direction);
        solve(idx + 1, curX + deltaX, curY + deltaY, x, y, maxIdx, resultStr);
        if (resultFound) return;
        resultStr.setLength(resultStr.length() - 1);
    }

    private boolean bothEvenOrOdd(long x, long y) {
        return (x % 2 == y % 2);
    }
}