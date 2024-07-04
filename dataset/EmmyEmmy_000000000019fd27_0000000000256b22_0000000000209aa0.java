import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			if (k % n == 0) {
				System.out.println("Case #" + (i + 1) + ": POSSIBLE");
				int[][] latin = getLatin(n);
				int change = k/n-1;
				for(int j=0; j<n; j++) {
					for(int m=0; m<n; m++) {
						latin[j][m] += change;
						if(latin[j][m] > n) {
							latin[j][m] -= n;
						}
						System.out.print(latin[j][m]+" ");
					}
					System.out.println();
				}
			} else {
				System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
			}

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