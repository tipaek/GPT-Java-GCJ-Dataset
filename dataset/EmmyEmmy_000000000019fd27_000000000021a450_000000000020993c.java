import java.util.Scanner;

class Solution{
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i=0; i<t; i++) {
			int n = sc.nextInt();
			int [][] arr = new int[n][n];
			for(int j=0; j<n; j++) {
				for(int m=0; m<n; m++) {
					arr[j][m] = sc.nextInt();
				}
			}
			
			int k = 0;
			int c = 0;
			int r = 0;
			for(int j=0; j<n; j++) {
				k += arr[j][j];
				r += isSetR(arr[j]);
				c += isSetC(arr, j);
			}
			
			System.out.println("Case #"+(i+1)+": "+k+" "+r+" "+c);
		}
	}

	private static int isSetC(int[][] arr, int n) {
		for(int i=0; i<arr.length; i++) {
			for(int k=i+1; k<arr.length; k++) {
				if(arr[i][n] == arr[k][n])
					return 1;
			}
		}
		return 0;
	}

	private static int isSetR(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i] == arr[j])
					return 1;
			}
		}
		return 0;
	}
}