import java.io.*;
import java.math.*;
import java.util.*;
public class Solution {
    
    static Scanner sc;
    
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int casenum = 1; casenum <= n; casenum++) {
            solve(casenum);
         }
    }
    
    private static void solve(int casenum) {
        String s = sc.nextLine();
        StringBuilder result = new StringBuilder();
        boolean existOpen = false;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (isOne(c) && !existOpen) {
                result.append("(");
                existOpen = true;
            } 
            
            if (!isOne(c) && existOpen) {
                result.append(")");
                existOpen = false;
            }
            result.append(c);
        }
        
        if (existOpen) {
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