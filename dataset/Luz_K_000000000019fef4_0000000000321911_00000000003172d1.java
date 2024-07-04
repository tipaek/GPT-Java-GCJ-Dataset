import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int sliceNumber = in.nextInt();
      int diners = in.nextInt();
      in.nextLine();
      String[] tempSlices = in.nextLine().split(" ");
      long[] slices = new long[tempSlices.length];
      for (int x = 0; x < tempSlices.length; x++) {
    	  slices[x] = Long.parseLong(tempSlices[x]);
      }
      Arrays.sort(slices);
      if(diners == 2) {
    	  List<Long> sameOne = xSame(2,slices);
    	  if(sameOne.size() > 0) {
    		  System.out.println("Case #" + i + ": " + 0);
    	  }else {
    		  System.out.println("Case #" + i + ": " + 1);
    	  }
      }else if(diners == 3){
    	  List<Long> sameOne = xSame(3,slices);
    	  if(sameOne.size() > 0) {
    		  System.out.println("Case #" + i + ": " + 0);
    	  }else {
    		  sameOne = xSame(2,slices);
    		  boolean foundOne = false;
    		  for(long toTest: sameOne) {
    			  for(long bigger: slices) {
    				  if(toTest < bigger) {
    					  System.out.println("Case #" + i + ": " + 1);
    					  foundOne = true;
    					  break;
    				  }
    			  }
    		  }
    		  if(!foundOne && oneDouble(slices)) {
    			  System.out.println("Case #" + i + ": " + 1);
    			  foundOne = true;
    		  }
    		  if(!foundOne) {
    			  System.out.println("Case #" + i + ": " + 2);
    		  }
    	  }
      }
      //System.out.println("Case #" + i + ": " + (n + m) + " " + (n * m));
    }
  }
  
  public static List<Long> xSame(int x,long[] slices) {
	  List<Long> returnSlices =new ArrayList<Long>();  
	  int inARow = 1;
	  for(int i = 1; i < slices.length;i++) {
		  //System.out.println(inARow);
		  if(slices[i] == slices[i-1]) {
			  inARow ++;
		  }else {
			  inARow = 1;
		  }
		  if(inARow == x) { 
			  returnSlices.add(slices[i]);
		  }
		  
	  }
	  return returnSlices;
  }
  public static boolean oneDouble(long[] slices) {
	  for(long toTest: slices) {
		  for(long doubled: slices) {
			  if(toTest * 2 == doubled) {
				  return true;
			  }
		  }
	  }
	  return false;
  }
}