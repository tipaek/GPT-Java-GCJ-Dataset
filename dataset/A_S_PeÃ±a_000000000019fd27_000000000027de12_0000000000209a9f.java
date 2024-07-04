import java.util.*;


public class Solution {
    
    static Scanner SCNR = new Scanner(System.in);
    
    static String method1(String S) {
        
        String res = "";
        char [] arr = S.toCharArray();
        int N = S.length();
        int i, j;
        int openPar = 0;
        
        for (i = 0; i < N; ++i) {
            
            for (j = openPar; j < arr[i] - '0'; ++j) {
                res += '(';
                ++openPar;
            }
            
            for (j = openPar; j > arr[i] - '0'; --j) {
                res += ')';
                --openPar;
            }
            
            res += arr[i];
            
            
            
            
            
        }
        
        
        for (i = openPar; i > 0; --i) {
            res += ')';
        }
        
        
        
        
        
        
        
        
        
        return res;
    }
    
    
    public static void main (String [] args) {
        
        
        int T = SCNR.nextInt();
        String S;
        int i;
        String res;
        
        for (i = 1; i <= T; ++i) {
            S = SCNR.next();
            res = method1(S);
            System.out.printf("Case #%d: %s\n", i, res);
        }
        
        SCNR.close();
    }
}