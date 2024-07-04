import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
	  
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); //Number of cases
    String unused = in.nextLine();
    for (int i = 1; i <= t; ++i) {//iterate over number of cases
	  String answer = "";
	  int open = 0;
	  for(char c : in.nextLine().toCharArray()) {
		  int num = Character.getNumericValue(c);
		  String addition = "" + c;
		  while(num > open) {
			  addition = "(" + addition;
			  open++;
		  }
		  while(num < open) {
			  addition = ")" + addition;
			  open--;
		  }
		  answer = answer + addition;
	  }
	  while(open > 0) {
		  answer = answer + ")";
		  open--;
	  }
      System.out.println("Case #" + i + ": " + answer);     
    }
    in.close();
  }
}