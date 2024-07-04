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
		  int N = in.nextInt();
		  System.out.println("Case #" + t + ": ");
		  
		  if (N <= 50){
			  for (int i = 0; i < N; i++){
				  System.out.println((i + 1) + " 1");
			  }
			  return;
		  }
		  
		  int M = N - 30;
		  int leftovers = 0;
		  boolean left = true;
		  
		  for (int i = 0; i < 30; i++){
			  if ((M & (1 << i)) > 0){
				  if (left){
					  for (int j = 0; j <= i; j++){
						  System.out.println((i + 1) + " " + (j + 1));
					  }
				  } else {
					  for (int j = 0; j <= i; j++){
						  System.out.println((i + 1) + " " + (i - j + 1));
					  }
				  }
				  leftovers++;
				  left = !left;
			  } else {
				  if (left){
					  System.out.println((i + 1) + " 1");
				  } else {
					  System.out.println((i + 1) + " " + (i + 1));
				  }
			  }
		  }
		  
		  for (int i = 0; i < leftovers; i++){
			  if (left){
				  System.out.println((30 + i + 1) + " 1");
			  } else {
				  System.out.println((30 + i + 1) + " " + (30 + i + 1));
			  }
		  }
	  }
}
