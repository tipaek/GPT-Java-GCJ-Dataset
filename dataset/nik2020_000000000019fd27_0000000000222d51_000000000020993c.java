import java.util.Scanner;


public class Solution {
	
	
	public static void solve(int[][] arr,int n,int k) {
		
		//finding Diagnol
		int diagnol = 0;
		int i =0;int j =0;
		while(i<n&&j<n) {
			diagnol+=arr[i][j];
			i++;
			j++;
		}
		
		// Row check
		int row =0;
		for(int r =0;r<n;r++) {
			int[] memory = new int[n+1];
			for(int c =0;c<n;c++) {
				if(memory[arr[r][c]]!=0) {
					row++;
					break;
				}else {
					memory[arr[r][c]]++;
				}
			}
		}
		
		int col = 0;
		
		for(int c =0;c<n;c++) {
			int[] memory = new int[n+1];
			for(int r =0;r<n;r++) {
				if(memory[arr[r][c]]!=0) {
					col++;
					break;
				}else {
					memory[arr[r][c]]++;
				}
				
			}
		}
		
		System.out.println("Case #"+ k +": "+diagnol+" "+row+" "+col);
		
	}
    
	public static void main(String[] args) {
	
	Scanner s = new Scanner(System.in);
	
	int  t= s.nextInt();
	int k = t;
	while(t>0) {
		int n = s.nextInt();
		int[][] arr = new int[n][n];
		
		for(int i =0;i<n;i++) {
			
			for(int j =0;j<n;j++) {
				arr[i][j] = s.nextInt();
				
			}
		}
		
		solve(arr, n, k-t+1);
		
		t--;
	}
	s.close();
	
	
	}

}