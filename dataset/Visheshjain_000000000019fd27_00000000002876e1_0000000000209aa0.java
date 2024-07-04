
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		int k1 = 1;
		while (t-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[][] arr = new int[n][n];
			int[] row1 = new int[n];
			int[] col1 = new int[n];
			if (check(0 , n, k, 0, 0, arr, row1, col1)) {
				System.out.println("Case #"+k1+": "+"POSSIBLE");
				for(int[] key : arr) {
					for(int val : key) {
						System.out.print(val+" ");
					}
					System.out.println();
				}
			} else {
				System.out.println("Case #"+k1+": "+"IMPOSSIBLE");
			}
			k1++;
		}
	}

	static int[][] ans;

	private static boolean check(int sum , int n, int k, int r, int c, int[][] arr, int[] row, int[] col) {
		// TODO Auto-generated method stub
		if(c==n) {
			return check(sum,n, k, r+1, 0, arr, row, col);
		}
		if(r==n && c == 0) {
			     if(sum!=k)
			    	 return false;
				for(int j = 0 ; j < n ; j++) {
				if(row[j]!=Math.pow(2, n)-1) 
					return false;
				}
				
				for(int j = 0 ; j < n ; j++) {
					if(col[j]!=Math.pow(2, n)-1) {
						return false;
					}
				}
				ans = arr;
			return true;
		}
		
		if (r >= n || c >= n) {
			return false;
		}
		
		for(int i = 1; i <= n ; i++) {
			if((row[r]&(1<<(i-1)) )==0 && (col[c]& (1<<(i-1)))==0) {
				row[r] = (row[r]|(1<<(i-1)) );
				col[c] = (col[c]| (1<<(i-1)));
				arr[r][c] = i;
				int temp = sum;
				if(r==c)
					temp+=i;
			    boolean res=check(temp,n, k, r, c+1, arr, row, col);
			     if(res) {
		    	   return true;
		       }arr[r][c] = 0;
			    row[r] = (row[r]^(1<<(i-1)) );
				col[c] = (col[c]^ (1<<(i-1)));
		      
			}
		}
		return false;
	}
}
