import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      String nums = in.next();
      String[] explode = nums.split("");
      int[] digits = new int[explode.length];
      for(int j = 0; j < digits.length; j++) {
    	  	digits[j] = Integer.parseInt(explode[j]);
    	  	//System.out.println(Arrays.toString(digits));
      }
      String answer = "";
      int cur = 0;
      int tot = 0;
      for(int j = 0; j < digits.length; j++) {
    	  	if(digits[j] > cur) {
    	  		for(int k = 0; k < (digits[j] - cur); k++) {
    	  			answer += "(";
    	  			tot++;
    	  		}
    	  	}
    	  	if(digits[j] < cur) {
    	  		for(int k = 0; k < (cur - digits[j]); k++) {
    	  			answer += ")";
    	  			tot--;
    	  		}
    	  	}
    	  	answer += digits[j];
    	  	cur = digits[j];
      }
      for(int j = 0; j < tot; j++) {
    	  	answer+=")";
      }
      System.out.println("Case #" + i + ": " + answer);
    }
  }
}
  
