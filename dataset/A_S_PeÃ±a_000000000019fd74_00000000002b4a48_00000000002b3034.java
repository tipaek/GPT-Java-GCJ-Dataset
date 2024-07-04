import java.util.*;


public class Solution {
    
    static Scanner SCNR = new Scanner(System.in);
    
    static String method1(String [] arr, int N) {
        
        int i, j;
	    int longest = 0;
	    String longestString = "";
	    String res = "";
	    
	    for (String s : arr) {
	        longest = Math.max(longest, s.length());
	        if (longest == s.length()) {
	            longestString = s;
	        }
	        
	    }
	    
	    char [] longestArr = longestString.toCharArray();
        
        for (String s : arr) {
            char [] c = s.toCharArray();
	        int lenC = c.length;
	        
	        for (i = 1; i < lenC; ++i) {
	            if (c[i] != longestArr[i + longest - lenC]) {
	                return "*";
	            }
	        }
	        
	    }
        
        for (i = 1; i < longest; ++i) {
            res += longestArr[i];
        
        }
        
        return res;
    }
    
    
    public static void main (String [] args) {
        
        
        int T = SCNR.nextInt();
        int N;
        int i, j;
        String res;
        
        for (i = 1; i <= T; ++i) {
            N = SCNR.nextInt();

            String [] arr = new String [N];
            for (j = 0; j < N; ++j) {
                arr[j] = SCNR.next();
            }
            
            res = method1(arr, N);
            System.out.printf("Case #%d: %s\n", i, res);
        }
        
        SCNR.close();
    }
}