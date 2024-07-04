import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    in.nextLine();
    for (int i = 1; i <= t; ++i) {
      StringBuilder output = new StringBuilder();
      String input = in.nextLine();
      Integer[] toBuild = stringToInt(input.split(""));
      int insideParan = 0;
      for(int y = 0; y < toBuild.length; y++) {
    	  while(toBuild[y] > insideParan) {
    		  output.append("(");
    		  insideParan ++;
    	  }
    	  while(toBuild[y] < insideParan) {
    		  output.append(")");
    		  insideParan --;
    	  }
          output.append(toBuild[y] + "");
      }
      while(insideParan > 0) {
    	  output.append(")");
    	  insideParan --;
      }
      output.toString();
      System.out.println("Case #" + i + ": " + output);
    }
  }
  public static Integer[] stringToInt(String[] input){
	  Integer[] output = new Integer[input.length];
	  for(int i = 0; i < input.length;i++){
		  try{
			  output[i] = Integer.parseInt(input[i]);
			} catch(NumberFormatException ex){}  
	  }
	  return output;
  }
}