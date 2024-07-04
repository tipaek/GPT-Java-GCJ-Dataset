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
        String[] input = br.readLine().split(" ");
        int nCount = Integer.parseInt(input[0]);
        int kSum = Integer.parseInt(input[1]);
        solve(caseNo, nCount, kSum);
    }

    private boolean resultPossible;
    private int[][] resultMat;

    private void solve(int caseNo, int nCount, int kSum) {
        resultPossible = false;
        resultMat = null;

        int[][] mat = new int[nCount + 1][nCount + 1];
        Set<Integer>[] rowSetArr = createSetArray(nCount);
        Set<Integer>[] colSetArr = createSetArray(nCount);

        checkPossibleTrace(mat, 1, nCount, kSum, rowSetArr, colSetArr);

        if (resultPossible) {
            System.out.println("Case #" + caseNo + ": POSSIBLE");
            printMatrix(resultMat, nCount);
        } else {
            System.out.println("Case #" + caseNo + ": IMPOSSIBLE");
        }
    }

    private Set<Integer>[] createSetArray(int nCount) {
        Set<Integer>[] setArr = new HashSet[nCount + 1];
        for (int i = 1; i <= nCount; i++) {
            setArr[i] = new HashSet<>();
        }
        return setArr;
    }

    private void checkPossibleTrace(int[][] mat, int curIdx, int nCount, int kLeft, Set<Integer>[] rowSetArr, Set<Integer>[] colSetArr) {
        if (resultPossible) return;
        
        if (curIdx == nCount + 1) {
            if (kLeft == 0) {
                checkPossibleLatMat(mat, 1, 1, nCount, rowSetArr, colSetArr);
            }
            return;
        }

        for (int val = Math.min(nCount, kLeft); val >= 1; val--) {
            mat[curIdx][curIdx] = val;
            rowSetArr[curIdx].add(val);
            colSetArr[curIdx].add(val);
            checkPossibleTrace(mat, curIdx + 1, nCount, kLeft - val, rowSetArr, colSetArr);
            rowSetArr[curIdx].remove(val);
            colSetArr[curIdx].remove(val);
        }
    }

    private void checkPossibleLatMat(int[][] mat, int curRow, int curCol, int nCount, Set<Integer>[] rowSetArr, Set<Integer>[] colSetArr) {
        if (resultPossible) return;
        
        if (curRow == nCount + 1) {
            resultPossible = true;
            resultMat = cloneMatrix(mat, nCount);
            return;
        }

        if (curCol > nCount) {
            checkPossibleLatMat(mat, curRow + 1, 1, nCount, rowSetArr, colSetArr);
            return;
        }

        if (curRow == curCol) {
            checkPossibleLatMat(mat, curRow, curCol + 1, nCount, rowSetArr, colSetArr);
            return;
        }

        for (int val = 1; val <= nCount; val++) {
            if (rowSetArr[curRow].contains(val) || colSetArr[curCol].contains(val)) continue;
            mat[curRow][curCol] = val;
            rowSetArr[curRow].add(val);
            colSetArr[curCol].add(val);
            checkPossibleLatMat(mat, curRow, curCol + 1, nCount, rowSetArr, colSetArr);
            rowSetArr[curRow].remove(val);
            colSetArr[curCol].remove(val);
        }
    }

    private int[][] cloneMatrix(int[][] mat, int nCount) {
        int[][] cloneMat = new int[nCount + 1][nCount + 1];
        for (int i = 1; i <= nCount; i++) {
            System.arraycopy(mat[i], 1, cloneMat[i], 1, nCount);
        }
        return cloneMat;
    }

    private void printMatrix(int[][] mat, int nCount) {
        for (int i = 1; i <= nCount; i++) {
            for (int j = 1; j <= nCount; j++) {
                if (j == nCount) {
                    System.out.println(mat[i][j]);
                } else {
                    System.out.print(mat[i][j] + " ");
                }
            }
        }
    }
}