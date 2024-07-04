import java.util.*;
import java.io.*;

class Solution {
    public static void main (String[] args) throws Exception {
        new Solution().solveCases();
    }
    
    public void solveCases() throws Exception {
        BufferedReader br =  
                   new BufferedReader(new InputStreamReader(System.in)); 
        String[] strArr = br.readLine().split(" ");
        
        int nCases = Integer.valueOf(strArr[0]);
        int nBits = Integer.valueOf(strArr[1]);
        for (int idx = 1 ; idx <= nCases ; idx++) {
            boolean solved = solve (idx, nBits, br);
            if (!solved) 
                break;
        }
        
    }
    
    public boolean solve(int caseNo, int nBits, BufferedReader br) throws Exception {
        boolean resultFound = false;
        
        String[] result = new String[nBits + 1];
        for (int qIdx = 1, bIdx = 1 ; qIdx <= 150 && bIdx <= nBits ; qIdx++ ) {
            // if ((qIdx % 10) == 1) {
            //     System.out.println(bIdx);
            //     // System.out.flush();
            //     br.readLine();
            //     qIdx++;
            // }
            System.out.println(bIdx);
            // System.out.flush();
            result[bIdx] = br.readLine();
            bIdx++;
        }
        
        // String resultBit Arr
        StringBuilder resultBld = new StringBuilder();
        for (int idx = 1 ; idx <= nBits ; idx++) {
            resultBld.append(result[idx]);
        }
        System.out.println(resultBld.toString());
        // System.out.flush();
        if (br.readLine().equals("Y")) {
            resultFound = true;
        }
        return resultFound;
    }
}
