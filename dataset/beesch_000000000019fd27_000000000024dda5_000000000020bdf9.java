import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		try( Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))) ) {
	        int t = in.nextInt();
	        
	        boolean[] c, j;
	        int n, start, end;
	        boolean isImpossible;
	        String result;
	        
	        for (int i = 1; i <= t; ++i) {
	        	c = new boolean[1440];
	        	j = new boolean[1440];
	        	isImpossible = false;
	        	result = "";
	        	
	        	n = in.nextInt();
	        	
	        	for( int a = 0; a < n; a++ ) {
	        		start = in.nextInt();
	        		end = in.nextInt();
	        		
	        		if( isImpossible )
	        			continue;
	        		
	        		if( !checkForCollision(c, start, end) ) {
	        			for( int m = start; m < end; m++ ) {
	        				c[m] = true;
	        			}
	        			result += "C";
	        		} else if( !checkForCollision(j, start, end) ) {
	        			for( int m = start; m < end; m++ ) {
	        				j[m] = true;
	        			}
	        			result += "J";
	        		} else {
	        			isImpossible = true;
	        		}
	        	}
	        	if( isImpossible ) {
	        		System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
	        	} else {
	        		System.out.println("Case #" + i + ": " + result);
	        	}
	        }
		} catch( Exception e ) {
			e.printStackTrace();
		}
	}
	
	private static boolean checkForCollision(boolean[] plan, int start, int end) {
		for( int i = start; i < end; i++ ) {
			if( plan[i] ) {
				return true;
			}
		}
		return false;
	}

}
