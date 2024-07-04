import java.util.*;

public class Solution{
	static int sqr[][]=new int[60][60];
	static int n, k, a0;
	static boolean rrr[][]=new boolean[60][60], ccc[][]=new boolean[60][60], solved;

	static void ex(int row, int col, int m) {
	    if (row == n && col == n + 1 && m == k && !solved) {
	        solved = true;
	        System.out.println("Case #" + a0 + ": " +"POSSIBLE\n");
	        for (int i = 1; i <= n; ++i) {
	            for (int j = 1; j <= n; ++j) {
	                System.out.print( sqr[i][j] + " ");
	            }
	             System.out.println();
	        }
	        return;
	    } else if (row > n) {
	        return;
	    } else if (col > n) {
	        ex(row + 1, 1, m);
	    }
	    for (int i = 1; i <= n && !solved; ++i) {
	        if (!rrr[row][i] && !ccc[col][i]) {
	            rrr[row][i] = ccc[col][i] = true;
	            if (row == col) {
	                m += i;
	            }
	            sqr[row][col] = i;

	            ex(row, col + 1, m);

	            rrr[row][i] = ccc[col][i] = false;
	            if (row == col) {
	                m -= i;
	            }
	            sqr[row][col] = 0;
	        }
	    }
	}
	
	

public static void  main(String[] args) 
{
    int t=0;
    
    Scanner sc=new Scanner(System.in);
    t=sc.nextInt();
    for ( a0 = 1; a0 <= t; ++a0) {
    	n=sc.nextInt();
    	k=sc.nextInt();
        ex(1, 1, 0);
        if (!solved) {
           System.out.println( "Case #" + a0 + ": " +"IMPOSSIBLE\n");
        }
        solved = false;
    }
   
}
}