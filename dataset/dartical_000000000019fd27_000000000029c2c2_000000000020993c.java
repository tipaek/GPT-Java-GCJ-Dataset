import java.util.*;
import java.io.*;

public class Solution{
	public static void main(String[] args){
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int cases = in.nextInt();
		
		for(int loop=1; loop<=cases; loop++){
			
			int n = in.nextInt();
			
			int[][] matrix = new int[n][n];
			
			for(int j=0; j<n; j++){
				for(int k=0; k<n; k++){
					matrix[j][k] = in.nextInt();
				}
			}
			
			
			
			//compute trace
			int sum = 0;
			for(int x=0; x<n; x++){
				sum += matrix[x][x];
			}
			
			int r = 0;
			for(int j=0; j<n; j++){
				if(hasDuplicates(matrix[j]))
					r++;
			}
			
			int c = 0;
			for(int k=0; k<n; k++){
				int[] temp = new int[n];
				for(int j=0; j<n; j++){
					temp[j] = matrix[j][k];
				}
				if(hasDuplicates(temp))
					c++;
			}
			
			
			System.out.printf("Case #%d: %d %d %d\n", loop, sum, r, c);
			
		}
		
	}
		
		public static boolean hasDuplicates(int[] arr){
			for(int x=0; x<arr.length-1; x++){
				for(int y=x+1; y<arr.length; y++){
					if(arr[x]==arr[y])
						return true;
				}
			}
			return false;
		}
		
		
		
}