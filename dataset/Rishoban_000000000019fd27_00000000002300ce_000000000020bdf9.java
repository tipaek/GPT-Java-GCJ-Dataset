import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	
	public static String shedlues(int[][]arr, int len) {
		
		java.util.Arrays.sort(arr, new java.util.Comparator<int[]>() {
		    public int compare(int[] a, int[] b) {
		        return Integer.compare(a[0], b[0]);
		    }
		});
		
		
		
		String out = "CJ";
		
		for(int g = 2; g < len; g++) {
			int min = arr[g-1][1];
			String addes = "J";
			if(arr[g-2][1] < arr[g-1][1]) {
				min = arr[g-2][1];
				addes = "C";
			}
			if(min > arr[g][0]) {
				return "IMPOSSIBLE";
			}else {
				out = out + addes;
			}
			
			
		}
		
		return out;
	}
	
	
	

	public static void main(String[] args) {

		
		 Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		 int t = in.nextInt();
		 for (int i = 1; i <= t; ++i) {
			 int n = in.nextInt();
			 int[][] arr = new int[n][2];
		      for (int a = 0; a < n; a++) {
		      	for (int b = 0; b < 2; b++) {
		      		arr[a][b] = in.nextInt();
		      	}
		      }System.out.println("Case #" + i + ": " + shedlues(arr,n));
		 }

	}

}
