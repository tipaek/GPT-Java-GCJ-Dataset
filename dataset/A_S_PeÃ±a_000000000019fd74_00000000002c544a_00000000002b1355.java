import java.util.*;


public class Solution {
    
    static Scanner SCNR = new Scanner(System.in);
    
    static int method1(int [][] arr, int R, int C) {
        
        int r, c;
	    int res = 0;
	    int comp = 0;
	    boolean elim = true;
	    int [][] arr2 = new int [R][C];
	    int [][] arr3 = new int [R][C];
	    
	    
	    while (elim == true) {
	        elim = false;
	        
	        for (r = 0; r < R; ++r) {
	            for (c = 0; c < C; ++c) {
	                res += arr[r][c];
	                arr2[r][c] = 0;
	                arr3[r][c] = 0;
	            }
	        }
	        
	        
	        for (r = 0; r < R; ++r) {
	            comp = 0;
	            
	            for (c = 0; c < C; ++c) {
	                if (arr[r][c] > 0) {
	                    arr2[r][c] += comp;
	                    arr3[r][c]+= Math.min(comp, 1);
	                    comp = arr[r][c];
	                }
	            }
	            comp = 0;
	            for (c = C - 1; c >= 0; --c) {
	                if (arr[r][c] > 0) {
	                    arr2[r][c] += comp;
	                    arr3[r][c]+= Math.min(comp, 1);
	                    comp = arr[r][c];
	                }
	                
	                
	            }
	        }
	        
	        for (c = 0; c < C; ++c) {
	            comp = 0;
	            for (r = 0; r < R; ++r) {
	                if (arr[r][c] > 0) {
	                    arr2[r][c] += comp;
	                    arr3[r][c]+= Math.min(comp, 1);
	                    comp = arr[r][c];
	                }
	                
	            }
	            comp = 0;
	            for (r = R - 1; r >= 0; --r) {
	                if (arr[r][c] > 0) {
	                    arr2[r][c] += comp;
	                    arr3[r][c]+= Math.min(comp, 1);
	                    comp = arr[r][c];
	                }
	                
	                
	                
	            }
	            
	            
	            
	            
	            
	        }
	        
	        
	        for (r = 0; r < R; ++r) {
	            for (c = 0; c < C; ++c) {
	                if (arr3[r][c] > 0 && ((double) arr2[r][c] / (double) arr3[r][c]) > (double)arr[r][c]) {
	                    arr[r][c] = 0;
	                    elim = true;
	                }
	            }
	        }
	        
	        
	        
	    }
	    
	    
        
        return res;
    }
    
    
    public static void main (String [] args) {
        
        
        int T = SCNR.nextInt();
        int R, C;
        int i, j, m;
        int res;
        
        for (i = 1; i <= T; ++i) {
            R = SCNR.nextInt();
            C = SCNR.nextInt();

            int [][] arr = new int [R][C];
            for (j = 0; j < R; ++j) {
                for (m = 0; m < C; ++m) {
                    arr[j][m] = SCNR.nextInt();
                }
            }
            
            res = method1(arr, R, C);
            System.out.printf("Case #%d: %d\n", i, res);
        }
        
        SCNR.close();
    }
}