import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Solution {
	  public static void main(String[] args) {
		  Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		  int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		  for (int i = 1; i <= t; i++) {
			  solve(i, in);
		  }
	  }
	  
	  public static void solve(int t, Scanner in){
		  int N = in.nextInt();
		  int r = 0;
		  int c = 0;
		  int k = 0;
		  
		  int[][] row_counts = new int[N][N];
		  int[][] col_counts = new int[N][N];
		  
		  for (int i = 0; i < N; i++){
			  for (int j = 0; j < N; j++){
				  row_counts[i][j] = 0;
				  col_counts[i][j] = 0;
			  }
		  }
		  
		  int tmp = 0;
		  for (int i = 0; i < N; i++){
			  for (int j = 0; j < N; j++){
				  tmp = in.nextInt() - 1;
				  row_counts[i][tmp]++;
				  col_counts[j][tmp]++;
				  
				  if (i == j){
					  k += (tmp + 1);
				  }
			  }
		  }
		  
		  for (int i = 0; i < N; i++){
			  for (int j = 0; j < N; j++){
				  if (row_counts[i][j] > 1){
					  r++;
					  break;
				  }
			  }
			  
			  for (int j = 0; j < N; j++){
				  if (col_counts[i][j] > 1){
					  c++;
					  break;
				  }
			  }
		  }
		  
		  System.out.println("Case #" + t + ": " + k + " " + r + " " + c);
	  }
}