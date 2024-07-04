import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static String findSchedule(int[][] arr, int n) {
		StringBuilder str = new StringBuilder();
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr[0].length-1;j++) {
				int low = arr[i][j];
				int high = arr[i][j+1];
				str.append('C');
				if(arr[i+1][j]>low && arr[i+1][j]<high) {
					str.append('J');
					break;
				}
				else if(arr[i+1][j]>low && arr[i+1][j]>high) {
					str.append('C');
					break;
				}
			}
		}
		return str.length()==0?"IMPOSSIBLE":str.toString();
	}
	
	public static void main(String[] args) {
		//int n = 3;
		//int[][] arr = {{360,480},{420,540},{600,660}};
		//findSchedule(arr,n);
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();
          
           int[][] arr = new int[n][n]; 
           
           for(int row = 0; row< arr.length; row++){ 
                 for(int col = 0 ;col< arr[row].length; col++){ 
                     arr[row][col] = in.nextInt(); 
                  } 
             } 
           
         System.out.println("Case #" + i + ": " + findSchedule(arr,n));
        }
	}
}