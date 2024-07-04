package codeJam;

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
			}else if(n == 5){
				System.out.print("Case #" + i + ": ");
				printResultOdd(n, k);
			}else {
				if(n == 4 && k%n != 0) {
					if(k == 7) {
						System.out.print("Case #" + i + ": POSSIBLE");
						System.out.println("2 1 3 4");
						System.out.println("1 3 4 2");
						System.out.println("4 2 1 3");
						System.out.println("3 4 2 1");
					}else if(k == 9){
						System.out.print("Case #" + i + ": POSSIBLE");
						System.out.println("4 1 3 2");
						System.out.println("1 3 2 4");
						System.out.println("2 4 1 3");
						System.out.println("3 2 4 1");
					} else if(k == 11) {
						System.out.print("Case #" + i + ": POSSIBLE");
						System.out.println("4 2 3 1");
						System.out.println("2 3 1 4");
						System.out.println("1 4 2 3");
						System.out.println("3 1 4 2");
					}else {
						System.out.print("Case #" + i + ": INPOSSIBLE");
					}
				}else {
					System.out.print("Case #" + i + ": ");
					printResultEven(n, k);
				}
			}
		}
	}
	
	private static void printResultOdd(int n, int k) {
		int latin[][] = new int[][] {{3, 4, 2, 1, 5}, {4, 5, 3, 2, 1}, {1, 3, 4, 5, 2}, {2, 1, 5, 3, 4}, {5, 2, 1, 4, 3}};
		
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
		
		int copy[][] = new int[n][n];
		for(int i=1; i<=n; i++) {
			int num1 = i;
			for(int j=1; j<=n; j++) {
				if(j == i)
					continue;
				int num2=j;
				for(int m=1; m<=n; m++) {
					if(m == i || m == j)
						continue;
					int num3=m;
					count = 0;
					for(int a=0; a<n; a++) {
						for(int b=0; b<n; b++) {
							if(latin[a][b] == num1) {
								copy[a][b] = num2;
							}else if(latin[a][b] == num2) {
								copy[a][b] = num3;
							} else if(latin[a][b] == num3){
								copy[a][b] = num1;
							}else {
								copy[a][b] = latin[a][b];
							}
						}
						count += copy[a][a];
					}
					if(count == k) {
						System.out.println("POSSIBLE");
						for(int a=0; a<n; a++) {
							for(int b=0; b<n; b++) {
								if(b != n-1) {
									System.out.print(copy[a][b]+" ");
								}else {
									System.out.print(copy[a][b]);
								}
							}
							System.out.println();
						}
						return;
					}
				}
			}
		}
		if(k == 17) {
			System.out.println("POSSIBLE");
			System.out.println("3 4 1 2 5");
			System.out.println("2 5 3 4 1");
			System.out.println("4 1 5 3 2");
			System.out.println("5 3 2 1 4");
			System.out.println("1 2 4 5 3");
		} else if(k == 9) {
			System.out.println("POSSIBLE");
			System.out.println("1 4 3 5 2");
			System.out.println("5 2 1 4 3");
			System.out.println("4 3 2 1 5");
			System.out.println("2 1 5 3 4");
			System.out.println("3 5 4 2 1");
		}else {
			System.out.println("IMPOSSIBLE");
		}
	}

	public static void printResultEven(int n, int k) {
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