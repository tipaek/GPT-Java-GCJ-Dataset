import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int length = in.nextInt();
      in.nextLine();
      int trace = 0;
      int rowDoubles = 0;
      int columDoubles = 0;
      Integer[][] square = new Integer [length][length];
      for(int y = 1; y <= length; ++y) {
    	  //String line = in.nextLine();
    	  Integer[] line = stringToInt(in.nextLine().split(" "));
    	  for(int x = 1; x <= length; ++x) {
    		  square[x-1][y-1] = line[x-1]; 
    	  }
    	  trace += line[y-1];
    	  if(duplicates(line)){
    		  rowDoubles += 1;
    	  }
      }
      for(int y = 1; y <= length; ++y) {
    	  if(duplicates(square[y-1])) {
    		  columDoubles += 1;
    	  }
      }
      System.out.println("Case #" + i + ": " + trace + " " + rowDoubles + " " + columDoubles);
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
  
  static boolean duplicates(final Integer[] zipcodelist)
  {
     final int MAXZIP = 99999;
     boolean[] bitmap = new boolean[MAXZIP+1];
     for (int item : zipcodelist)
       if (!(bitmap[item] ^= true)) return true;
     return false;
  }
}