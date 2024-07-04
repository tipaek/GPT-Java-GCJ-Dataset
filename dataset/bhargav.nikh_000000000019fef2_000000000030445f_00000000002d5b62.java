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
        String[] inpArr = br.readLine().split(" ");
        long x = Integer.valueOf(inpArr[0]);
        long y = Integer.valueOf(inpArr[1]);
        printSolve (caseNo, x, y);
    }    
    
    boolean resultFound;
    String result;
    public void printSolve (int caseNo, long x, long y) {
        resultFound = false;
        result = "";
        
        if (!bothEvenOrOdd(x, y)) {
            long maxIdx = ((long)logBase2(Math.abs(x) + Math.abs(y))) + 1;
            solve(0, 0, 0, x, y, maxIdx, new StringBuilder(""));
        }
        
        if (resultFound == false) {
            result = "IMPOSSIBLE";
        }
        System.out.println("Case #"+caseNo+": "+result);
        return;
    }
    
    public void solve (long idx, long curX, long curY, 
        long x, long y, long maxIdx, StringBuilder resultStr) {
        
        if (idx == maxIdx+1) {
            return;
        }
        
        if (curX == x && curY == y) {
            resultFound = true;
            result = resultStr.toString();
        }
        
        // Recursive work
        long val = (long)Math.pow(2, idx);
        
        resultStr.append("N");
        solve(idx + 1, curX, curY + val, x, y, maxIdx, resultStr);
        resultStr.setLength(resultStr.length() - 1);
        if (resultFound)    return;
        
        resultStr.append("S");
        solve(idx + 1, curX, curY - val , x, y, maxIdx, resultStr);        
        resultStr.setLength(resultStr.length() - 1);
        if (resultFound)    return;
        
        resultStr.append("E");
        solve(idx + 1, curX + val, curY , x, y, maxIdx, resultStr);        
        resultStr.setLength(resultStr.length() - 1);
        if (resultFound)    return;
        
        resultStr.append("W");
        solve(idx + 1, curX - val, curY , x, y, maxIdx, resultStr);        
        resultStr.setLength(resultStr.length() - 1);
        if (resultFound)    return;
        
    }
    
    public boolean bothEvenOrOdd(long x, long y) {
        if ((x % 2) == 0 && (y % 2) == 0) {
            return true;
        }
        if ((x % 2) != 0 && (y % 2) != 0) {
            return true;
        }
        return false;
    }
    
    public double logBase2(long a) {
        double val = Math.log(a) / Math.log((double)2);
        return val;
    }
}
    