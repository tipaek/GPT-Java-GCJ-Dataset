import java.io.*;
import java.util.*;
import java.lang.*;
public class Solution {
    
    static Scanner sc;
    
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Integer n = Integer.valueOf(sc.nextLine());
        for(int casenum = 1; casenum <= n; casenum++) {
            solve(casenum);
         }
    }
    
    //021 0((2)1)
    private static void solve(int casenum) {
        String s = sc.nextLine();;
        StringBuilder result = new StringBuilder();
        int countOpen = 0;
        for (int i=0; i<s.length(); i++) {
            int d = Character.getNumericValue(s.charAt(i));
            
            if (countOpen > d) {
                for (int j=0; j<(countOpen-d); j++){
                    result.append(")");    
                }
                
            } 
            
            if (countOpen < d) {
                for (int j=0; j<(d-countOpen); j++){
                    result.append("(");    
                }
                
            }
            countOpen = d;
            result.append(d);
        }
        
        for (int i=0; i<countOpen; i++){
            result.append(")");    
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("Case #");
        sb.append(casenum);
        sb.append(": ");
        sb.append(result);
        System.out.println(sb);
    }
    
    private static boolean isOne(char c) {
        return c == '1';
    }
}