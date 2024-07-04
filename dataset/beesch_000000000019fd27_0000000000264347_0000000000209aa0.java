import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		try( Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))) ) {
	        int t = in.nextInt();
	        
	        for (int i = 1; i <= t; ++i) {
	        	int n = in.nextInt();
	        	int k = in.nextInt();
	        	
	        	int[][] matrix = new int[n][n];
	        	
	        	int trace = 0;
	        	
	        	for( int x = 0; x < n; x++ ) {
	        		for( int y = 0; y < n; y++ ) {
	        			
	        			matrix[x][y] = matrix[x][y] + 1;
	        			
	        			if( x == y ) 
	        				trace = calcTrace(matrix, n);
	        			
	        			if( matrix[x][y] > n
	        					|| !checkIfPossible(matrix, x, y, n)
	        					||  !( x != y || ( x != n-1 && trace < k ) || ( x == n-1 && trace == k ) ) ) {
	        				
	        				if( matrix[x][y] >= n ) {
		        				matrix[x][y] = 0;
		        				if( y - 2 < -1 ) {
		        					y = n-2;
		        					x--;
		        				} else {
		        					y -= 2;
		        				}
		        			} else
		        				y--;
		        		}
	        		}
	        	}
	        
	        	for( int x = 0; x < n; x++ ) {
	        		String row = "";
	        		for( int y = 0; y < n; y++ ) {
	        			row += matrix[x][y] + " ";
	        		}
	        		System.out.println(row);
		        }
	        
	        }
		} catch( Exception e ) {
			e.printStackTrace();
		}
	}
	
	private static int calcTrace(int[][] matrix, int n) {
		int trace = 0;
		for( int _x = 0; _x < n; _x++ ) {
    		for( int _y = 0; _y < n; _y++ ) {
    			if( _x == _y )
    				trace += matrix[_x][_y];
    		}
		}
		return trace;
	}
	
	private static boolean checkIfPossible(int[][] matrix, int row, int col, int length) {
		for( int i = 0; i < length; i++ ) {
			if( matrix[row][i] == matrix[row][col] && i != col )
				return false;
			if( matrix[i][col] == matrix[row][col] && i != row )
				return false;
		}
		return true;
	}
}
