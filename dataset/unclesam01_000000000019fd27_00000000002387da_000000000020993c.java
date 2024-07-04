import java.util.*;
import java.lang.Math;

class Solution {


	public static int duprow( int[][] a, int n) {
		int dr = 0;
		for( int row = 0 ; row < n ; row++) {
			int i;
			for(i = 0 ; i < n - 1 ; i++) {
				 int j;
				 for(j = i + 1 ; j < n; j++) {
					 if(a[row][i] == a[row][j]) {
						 dr++;
						 break;
					 }
				 }
				 if( j < n) {
					 break;
				 }
			}
			
			if( i < n - 1) {
				continue;
			}
		}
		
		return dr;
	}
	
	public static int dupcol( int[][] a, int n) {
		int dc = 0;
		for( int col = 0 ; col < n ; col++) {
			int i;
			for(i = 0 ; i < n - 1 ; i++) {
				int j;
				for(j = i + 1 ; j < n; j++) {
					if(a[i][col] == a[j][col]) {
					dc++;
					break;
					}
				}
				if( j < n) {
					break;
				}
			}
			if( i < n - 1) {
				continue;
			}
			
		}
		return dc;
	}
	
	public static int dsum(int[][] a, int n ){
		int sum = 0;
		for( int i = 0 ; i < n ; i++) {
			sum += a[i][i];
		}
		return sum;
	}
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		for( int t = 0 ; t < cases ; t++) {
			
			int n = in.nextInt();
			int[][] a = new int[n][n];
			
			for( int i = 0 ; i < n ; i++) {
				for( int j = 0 ; j < n ; j++) {
					a[i][j] = in.nextInt();
				}
			}
			
			System.out.println("Case #"+(t+1)+": " + dsum(a,n)+" "+ duprow(a,n)+" "+dupcol(a,n));
			
		
		
	}

	}
}
