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
        int nCount = Integer.valueOf(br.readLine());
        int mat[][] = new int[nCount][nCount];
        for (int row = 0 ; row < nCount ; row++) {
            String[] rowArr = br.readLine().split(" ");
            for (int col = 0 ; col < rowArr.length ; col++) {
                mat[row][col] = Integer.valueOf(rowArr[col]);
            }
        }
        // print solution
        printSolution(caseNo, nCount, mat);
    }
    
    public void printSolution(int caseNo, int nCount, int mat[][]) {
        int traceMat = getTraceMat(nCount, mat);
        int invalidRows = getInvalidRows(nCount, mat);
        int invalidCols = getInvalidCol(nCount, mat);
        
        System.out.println("Case #" +caseNo+": "+traceMat+" "+invalidRows+" "+invalidCols+"");
    }
    
    public int getTraceMat(int nCount, int mat[][]) {
        int trace = 0;
        
        for (int idx = 0 ; idx < nCount; idx++) {
            trace = trace + mat[idx][idx];
        }
        return trace;
    }
    
    public int getInvalidRows(int nCount, int mat[][]) {
        
        int invalidRows = 0;

        Set<Integer> rowSet = new HashSet();
        for (int row = 0 ; row < nCount ; row++) {
            rowSet.clear();
            for (int col = 0 ; col < nCount ; col++) {
                if (rowSet.contains(mat[row][col])) {
                    invalidRows++;
                    break;
                }
                rowSet.add(mat[row][col]);
            }
        }
        return invalidRows;
    }
    
    public int getInvalidCol(int nCount, int mat[][]) {
        int invalidCols = 0;

        Set<Integer> colSet = new HashSet();
        for (int col = 0 ; col < nCount ; col++) {
            colSet.clear();
            for (int row = 0 ; row < nCount ; row++) {
                if (colSet.contains(mat[row][col])) {
                    invalidCols++;
                    break;
                }
                colSet.add(mat[row][col]);
            }
        }
        return invalidCols;
    }
}