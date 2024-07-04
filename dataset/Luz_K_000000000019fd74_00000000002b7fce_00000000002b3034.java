import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int matches = in.nextInt();
      in.nextLine();
      List<String> beginning = new ArrayList<String>();
      List<String> middle = new ArrayList<String>();
      List<String> end = new ArrayList<String>();
      boolean foundMismatch = false;
      for(int z = 0; z < matches;z++ ) {
          String[] charList = in.nextLine().split("");
          int firstAsterix = findFirst(charList);
          int lastAsterix = findLast(charList);
          for(int x = 0; x < lastAsterix; x++) {
        	  if(x < firstAsterix) {
        		  if(x < beginning.size()) {
        			  if(!beginning.get(x).equals(charList[x])){
        				  foundMismatch = true;
        				  break;
        			  }
        		  }else {
        			  beginning.add(charList[x]);
        		  }
        	  }else {
        		  if(!charList[x].equals("*")) {
        			  middle.add(charList[x]);
        		  }
        	  }
          }
          for(int x = charList.length - 1; x > lastAsterix; x--) {
        	  if(charList.length - 1 - x < end.size()) {
    			  if(!end.get(charList.length - 1 - x).equals(charList[x])){
    				  foundMismatch = true;
    				  break;
    			  }
    		  }else {
    			  end.add(charList[x]);
    		  }
          }
      }
      StringBuilder output = new StringBuilder();
      for(int a = 0; a < beginning.size();a++) {
    	  output.append(beginning.get(a));
      }
      for(int a = 0; a < middle.size();a++) {
    	  output.append(middle.get(a));
      }
      for(int a = end.size()-1; a >= 0;a--) {
    	  output.append(end.get(a));
      }
      if(foundMismatch) {
    	  System.out.println("Case #" + i + ": " + "*");
      }else {
    	  System.out.println("Case #" + i + ": " + output.toString());
      }
      //System.out.println(Arrays.toString(beginning.toArray()));
      //System.out.println(Arrays.toString(middle.toArray()));
      //System.out.println(Arrays.toString(end.toArray()));
      //System.out.println("Case #" + i + ": " + (n + m) + " " + (n * m));
    }
  }
  public static int findFirst(String[] charList) {
	  int place = 0;
	  while(true) {
		  if(charList[place].equals("*")) {
			  return place;
		  }
		  place ++;
	  }
  }
  public static int findLast(String[] charList) {
	  int place = charList.length - 1;
	  while(true) {
		  if(charList[place].equals("*")) {
			  return place;
		  }
		  place --;
	  }
  }
}