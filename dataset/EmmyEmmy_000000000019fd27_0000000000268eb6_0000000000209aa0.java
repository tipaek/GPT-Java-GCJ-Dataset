import java.util.Scanner;

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner((System.in));
		int t = sc.nextInt();

		for (int i = 1; i <= t; i++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			if (k%n == 0) {
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
					System.out.println();
				}
			} else {
				System.out.print("Case #" + i + ": ");
				printResult(n, k);
			}
		}
	}
	
	public static void printResult(int n, int k) {
		int latin[][] = getLatin(n);
		
		for(int a=0; a<n/2; a++) {
			int[] temp = latin[n-a-1];
			latin[n-a-1] = latin[a];
			latin[a] = temp;
		}
		
		int count = 0;
		for(int a=0; a<n; a++) {
			count += latin[a][a];
		}
		if(count == k) {
			System.out.println("POSSIBLE");
			for(int a=0; a<n; a++) {
				for(int b=0; b<n; b++) {
					if(b != n-1) {
						System.out.print(latin[a][b]+" ");
					}else {
						System.out.print(latin[a][b]);
					}
				}
				System.out.println();
			}
			return;
		}
		
		for(int i=1; i<=n; i++) {
			int num1 = i;
			for(int j=i+1; j<=n; j++) {
				int num2=j;
				count = 0;
				for(int a=0; a<n; a++) {
					for(int b=0; b<n; b++) {
						if(latin[a][b] == num1) {
							latin[a][b] = num2;
						}else if(latin[a][b] == num2) {
							latin[a][b] = num1;
						}
					}
					count += latin[a][a];
				}
				if(count == k) {
					System.out.println("POSSIBLE");
					for(int a=0; a<n; a++) {
						for(int b=0; b<n; b++) {
							if(b != n-1) {
								System.out.print(latin[a][b]+" ");
							}else {
								System.out.print(latin[a][b]);
							}
						}
						System.out.println();
					}
					return;
				}
			}
		}
		System.out.println("IMPOSSIBLE");
		
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