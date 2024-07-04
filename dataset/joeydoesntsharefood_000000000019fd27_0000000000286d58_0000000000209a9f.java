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
		  String inp = in.next();
		  int S = inp.length();
		  String tmp = "";
		  
		  int open = 0;
		  char curr = 0;
		  int curr_val = 0;
		  for (int i = 0; i < S; i++){
			  curr = inp.charAt(i);
			  curr_val = Integer.parseInt(String.valueOf(curr));
			  if (curr_val >= open){
				  for (int j = 0; j < curr_val - open; j++){
					  tmp += "(";
				  }
			  } else {
				  for (int j = 0; j < open - curr_val; j++){
					  tmp += ")";
				  }
			  }
			  open = curr_val;
			  tmp += curr;
		  }
		  
		  for (int i = 0; i < open; i++){
			  tmp += ")";
		  }

		  System.out.println("Case #" + t + ": " + tmp);
	  }
}
