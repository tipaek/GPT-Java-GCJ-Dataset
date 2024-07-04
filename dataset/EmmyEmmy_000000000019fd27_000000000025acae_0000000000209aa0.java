import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();

		for (int i = 1; i <= t; i++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			if (k % n == 0 && k >= n && k <= n*n) {
				System.out.println("Case #" + i + ": POSSIBLE");
				int[][] latin = getLatin(n);
				int change = k/n;
				for(int j=0; j<n; j++) {
					for(int m=0; m<n; m++) {
						if(latin[j][m] == change) {
							latin[j][m] = 1;
						}else if(latin[j][m] == 1) {
							latin[j][m] = change;
						}
						if(m != n-1) {
							System.out.print(latin[j][m]+" ");
						} else {
							System.out.print(latin[j][m]);
						}
					}
					if(j != n-1) {
						System.out.println();
					}
				}
			} 
			System.out.println("Case #" + i + ": IMPOSSIBLE");
			
		}
	}
	
	public static int[][] getLatin(int n) { 
		int[][] arr = new int[n][n];
	    int k = n+1; 
	    for (int i = 0; i < n; i++) { 
	    	int temp = k;
	    	int count = 0;
	    	while (temp <= n) { 
	    		arr[i][count] = temp;
	    		count++; 
	            temp++; 
	        } 
	        for (int j = 1; j < k; j++) {
	        	arr[i][count] = j;
	        	count++;
	        }
	        k--; 
	    } 
	    return arr;
	}
}