import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Solution {
	  public static void main(String[] args) {
		  Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		  int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		  for (int i = 1; i <= t; i++) {
			  solve(i, in);
		  }
	  }
	  
	  public static void solve(int t, Scanner in){
		  int R = in.nextInt();
		  int C = in.nextInt();
		  
		  long val = 0;
		  int[][] array = new int[R][C];
		  double[][] avgs = new double[R][C];
		  
		  for (int i = 0; i < R; i++){
			  for (int j = 0; j < C; j++){
				  array[i][j] = in.nextInt();
				  avgs[i][j] = 0;
			  }
		  }
		  
		  boolean change = true;
		  double tmp;
		  int nbrs;
		  while (change){
			  change = false;
			  
			  for (int i = 0; i < R; i++){
				  for (int j = 0; j < C; j++){
					  if (array[i][j] >= 0){
						  tmp = 0;
						  nbrs = 0;
						  for (int z = i + 1; z < R; z++){
							  if (array[z][j] >= 0){
								  tmp += array[z][j];
								  nbrs++;
								  break;
							  }
						  }
						  for (int z = i - 1; z >= 0; z--){
							  if (array[z][j] >= 0){
								  tmp += array[z][j];
								  nbrs++;
								  break;
							  }
						  }
						  for (int z = j + 1; z < C; z++){
							  if (array[i][z] >= 0){
								  tmp += array[i][z];
								  nbrs++;
								  break;
							  }
						  }
						  for (int z = j - 1; z >= 0; z--){
							  if (array[i][z] >= 0){
								  tmp += array[i][z];
								  nbrs++;
								  break;
							  }
						  }
						  if (nbrs > 0){
							  avgs[i][j] = tmp/nbrs;
						  } else {
							  avgs[i][j] = -1;
						  }
					  } else {
						  avgs[i][j] = -1;
					  }
				  }
			  }
		
			  for (int i = 0; i < R; i++){
				  for (int j = 0; j < C; j++){
					  if (array[i][j] >= 0){
						  val += array[i][j];
						  if (array[i][j] < avgs[i][j]){
							  array[i][j] = -1;
							  change = true;
						  }
					  }
				  }
			  }
		  }

		  System.out.println("Case #" + t + ": " + val);
	  }
}
