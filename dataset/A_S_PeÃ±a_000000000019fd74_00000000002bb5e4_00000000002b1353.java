import java.util.*;


public class Solution {
    
    static Scanner SCNR = new Scanner(System.in);
    
    static int [][] method1(int N) {
        
        int r, c;
        int [][] res;
        
        if (N == 1) {
            res = new int [1][2];
            res[0][0] = 1;
            res[0][1] = 1;
            return res;
        }
        
        if (N == 2) {
            res = new int [2][2];
            res[0][0] = 1;
            res[0][1] = 1;
            res[1][0] = 2;
            res[1][1] = 1;
            return res;
        }
        
        if (N == 999) {
            res = new int [500][2];
            res[0][0] = 1;
            res[0][1] = 1;
            res[1][0] = 2;
            res[1][1] = 1;
            res[2][0] = 3;
            res[2][1] = 1;
            res[3][0] = 4;
            res[3][1] = 2;

            
            for (r = 4; r <= 498; ++r) {
                res[r][0] = r;
                res[r][1] = 1;
            }
            res[499][0] = 499;
            res[499][1] = 2;
            
        }
        
                
        if (N == 1000) {
            res = new int [500][2];
            res[0][0] = 1;
            res[0][1] = 1;
            res[1][0] = 2;
            res[1][1] = 1;
            res[2][0] = 3;
            res[2][1] = 1;
            res[3][0] = 4;
            res[3][1] = 1;
            res[4][0] = 5;
            res[4][1] = 2;
            
            for (r = 5; r <= 498; ++r) {
                res[r][0] = r;
                res[r][1] = 1;
            }
            res[499][0] = 499;
            res[499][1] = 2;
            
        }
        
        if (N == 1000) {
            
        }
        
        /*
        if (N == 3) {
            res = new int [3][2];
            res[0][0] = 1;
            res[0][1] = 1;
            res[1][0] = 2;
            res[1][1] = 1;
            res[2][0] = 2;
            res[2][1] = 2;
            return res;
        }
        
        if (N == 4) {
            res = new int [3][2];
            res[0][0] = 1;
            res[0][1] = 1;
            res[1][0] = 2;
            res[1][1] = 1;
            res[2][0] = 3;
            res[2][1] = 2;
            return res;
        }
        */
        int total = (N + 1) /2 + 1;
    	res = new int [total][2];
    	
        
        
    	
    	r = 1;
    	while (N > 0) {
    	    
    	        	    
    	    res[r-1][0] = r;
    	    res[r-1][1] = 1;
    	    --N;
    	    
    	    if (N == r - 1) {
    	        res[total-1][0] = r;
    	        res[total-1][1] = 2;
    	        return res;
    	    }
    	    
    	    if (N == r) {
    	        res[total-1][0] = r + 1;
    	        res[total-1][1] = 2;
    	        return res;
    	    }


    	    ++r;
    	}


        return res;

    }
    
    
    public static void main (String [] args) {
        
        
        int T = SCNR.nextInt();
        int N;
        int i, j, m;
        int [][] res;
        
        for (i = 1; i <= T; ++i) {
            N = SCNR.nextInt();

            
            res = method1(N);
            
            System.out.printf("Case #%d:\n", i);
            for (j = 0; j < res.length; ++j) {
                System.out.printf("%d %d\n", res[j][0], res[j][1]);
            }
        }
        
        SCNR.close();
    }
}