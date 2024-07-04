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
        String s = br.readLine();
        solve(caseNo, s);
    }
    
    public void solve (int caseNo, String s) {
        StringBuilder resultBld = new StringBuilder();
        
        int prCount = 0;
        int startDigit = 0;
        for (int idx = 0 ; idx < s.length() ; idx++) {
            Node node = updateBrakets(Character.getNumericValue(s.charAt(idx)), startDigit, prCount, resultBld);
            prCount = node.prCount;
            startDigit = node.startDigit;
            
            if (idx == s.length() - 1) 
                addCloseBrace(prCount, resultBld);
        }
        System.out.println("Case #"+caseNo+": "+resultBld.toString());
    }
    
    public Node updateBrakets(int digit, int startDigit, int prCount, StringBuilder resultBld) {
        int updatedPrCount = 0, updatedStartDigit = 0;
        
        if (digit > startDigit) {
           
            addCloseBrace(prCount, resultBld);
            addOpenBrace(digit, resultBld);
            resultBld.append(String.valueOf(digit));
            
            updatedPrCount = digit;
            updatedStartDigit = digit;
        } else { 
            int diff = digit - prCount;
            if (diff <= 0) { // neg diff
                addCloseBrace(Math.abs(diff), resultBld);
                resultBld.append(String.valueOf(digit));
            } else { // pos diff
                addOpenBrace(diff, resultBld);
                resultBld.append(String.valueOf(digit));
            }
        
            updatedPrCount = prCount + diff;
            updatedStartDigit = startDigit;
        }
        return new Node(updatedPrCount, updatedStartDigit);
    }
    
    public void addOpenBrace (int count, StringBuilder resultBld) {
        for (int idx = 0 ; idx < count ; idx++) {
            resultBld.append("(");
        }
    }
    public void addCloseBrace (int count, StringBuilder resultBld) {
        for (int idx = 0 ; idx < count ; idx++) {
            resultBld.append(")");
        }
    }
    
    class Node {
        int prCount;
        int startDigit;
        public Node (int prCount, int startDigit) {
            this.prCount = prCount;
            this.startDigit = startDigit;
        }
    }
}