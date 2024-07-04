import java.util.*;
import java.io.*;

class Solution {
    
    public static void main (String[] args) throws Exception {
        new Solution().solveCases();
    }
    
    public void solveCases() throws Exception {
        BufferedReader br =  
                   new BufferedReader(new InputStreamReader(System.in)); 
        int nCases = Integer.valueOf(br.readLine());
        for (int idx = 1 ; idx <= nCases ; idx++) {
            solve (idx, br);
        }
    }
    
    public void solve(int caseNo, BufferedReader br) throws Exception {
        // Take input
        String[] strArr = br.readLine().split(" ");
        int nCount = Integer.valueOf(strArr[0]);
        int kSum = Integer.valueOf(strArr[1]);
        
        solve(caseNo, nCount, kSum);
    }
    
    boolean resultPossible;
    int resultMat[][];
    
    public void solve (int caseNo, int nCount, int kSum) {
        resultPossible = false;
        resultMat = null;
        
        int mat[][] = new int [nCount+1] [nCount+1];
        Set<Integer>[] rowSetArr = new HashSet[nCount + 1];
        Set<Integer>[] colSetArr = new HashSet[nCount + 1];
        initSetArr(rowSetArr, nCount);
        initSetArr(colSetArr, nCount);
        
        checkPossibleTrace(mat, 1, nCount, kSum, rowSetArr, colSetArr);
        
        // For Result
        if (resultPossible) {
            System.out.println("Case #"+caseNo+": POSSIBLE");
            for (int row = 1 ; row <= nCount ; row++) {
                for (int col = 1 ; col <= nCount ; col++) {
                    if (col == nCount) {
                        System.out.println(resultMat[row][col]);
                        continue;
                    }
                    System.out.print(resultMat[row][col]+" ");
                }   
            }   
        } else {
            System.out.println("Case #"+caseNo+": IMPOSSIBLE");
        }
    }
    
    public void initSetArr(Set<Integer>[] setArr, int nCount) {
        for (int idx = 1 ; idx <= nCount ; idx++) {
            setArr[idx] = new HashSet<Integer>();
        }
    }
    
    public void checkPossibleTrace(int mat[][], int curIdx, int nCount, int kLeft, 
            Set<Integer>[] rowSetArr, Set<Integer>[] colSetArr) {
        
        if (resultPossible)
            return;
        // if (curIdx == nCount) {
        //     if (kLeft > nCount) 
        //         return;
        //     mat[curIdx][curIdx] = kLeft;
        //     rowSetArr[curIdx].add(kLeft);
        //     colSetArr[curIdx].add(kLeft);
        //     // Check LatMat
        //     checkPossibleLatMat(mat, 1, 1, nCount, rowSetArr, colSetArr);
        //     rowSetArr[curIdx].remove(kLeft);    
        //     colSetArr[curIdx].remove(kLeft);    
        //     return;
        // }
        if (curIdx == nCount + 1) {
            if (kLeft != 0) 
                return;
            checkPossibleLatMat(mat, 1, 1, nCount, rowSetArr, colSetArr);    
            return;
        }
        if (kLeft <= 0)  return;
        // Recursive Work
        for (int val = Math.min(nCount, kLeft); val >= 1 ; val--) {
            mat[curIdx][curIdx] = val;
            
            rowSetArr[curIdx].add(val);
            colSetArr[curIdx].add(val);
            checkPossibleTrace(mat, curIdx + 1, nCount, 
                kLeft - val, rowSetArr, colSetArr);
            rowSetArr[curIdx].remove(val);  
            colSetArr[curIdx].remove(val);    
        }
    }
    
    public void checkPossibleLatMat(int mat[][], int curRow, int curCol, int nCount, 
            Set<Integer>[] rowSetArr, Set<Integer>[] colSetArr) {
        if (resultPossible)
            return;
        if (curRow == nCount + 1) {
            resultPossible = true;
            resultMat = getCloneMat(mat, nCount);
            return ;
        }
        if (curCol > nCount) {
            checkPossibleLatMat(mat, curRow + 1, 1, nCount, rowSetArr, colSetArr);
            return;
        }
        if (curRow == curCol) {
            checkPossibleLatMat(mat, curRow, curCol + 1, nCount, rowSetArr, colSetArr);
            return;
        }
        // Recursive Work
        for (int val = 1 ; val <= nCount ; val++) {
            if (rowSetArr[curRow].contains(val) || 
                    colSetArr[curCol].contains(val)) 
                continue;
            mat[curRow][curCol] = val;
            
            rowSetArr[curRow].add(val);
            colSetArr[curCol].add(val);
            
            checkPossibleLatMat(mat, curRow, curCol + 1, nCount, rowSetArr, colSetArr);
            
            rowSetArr[curRow].remove(val);
            colSetArr[curCol].remove(val);
        }
    }
    
    public int[][] getCloneMat(int mat[][], int nCount) {
        int cloneMat[][] = new int[nCount + 1][nCount + 1];
        
        for (int row = 1 ; row <= nCount ; row++) {
            for (int col = 1 ; col <= nCount ; col++) {
                cloneMat[row][col] = mat[row][col];
            }
        }
        return cloneMat;
    }
    
}   