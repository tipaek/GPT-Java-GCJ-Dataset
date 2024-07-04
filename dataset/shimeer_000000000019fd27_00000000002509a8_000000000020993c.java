import java.util.Scanner;

class Vestigium {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int test=1; test<=t; test++) {
			int n = sc.nextInt();
			int arr[][] = new int[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int trace = calculateTrace(arr, n);
			int vertical = checkVertical(arr, n);
			int horizontal = checkHorizontal(arr, n);
			System.out.println("Case #" + t + ": " + trace + " " + horizontal + " " + vertical );
		
		}
		
	}
	
	static int calculateTrace(int arr[][], int n) {
		int trace = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i == j) {
					trace += arr[i][j];
				}
			}
		}
		
		return trace;
	}
	
	static int checkHorizontal(int arr[][], int n) {
		int countHorizontal = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n-1; j++ ) {
				for(int k=j+1; k<n; k++) {
					if(arr[i][j] == arr[i][k]) {
						countHorizontal++;
						break;
					}
				}
				if(countHorizontal > 0) {
					break;
				}
			}
		}
		return countHorizontal;
	}
	
	static int checkVertical(int arr[][], int n) {
		int countVertical = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n-1; j++ ) {
				for(int k=j+1; k<n; k++) {
					if(arr[j][i] == arr[k][i]) {
						countVertical++;
						break;
					}
				}
				if(countVertical > 0) {
					break;
				}
			}
		}
		return countVertical;
	}
}
