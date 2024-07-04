import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      Integer[][] timeTable = new Integer [n][2];
      List<List<Integer>> cameron = new ArrayList<List<Integer>>();
      List<List<Integer>> jamie = new ArrayList<List<Integer>>();
      for(int x = 0; x < n; x++) {
    	  timeTable[x][0] = in.nextInt();
    	  timeTable[x][1] = in.nextInt();
      }
      StringBuilder output = new StringBuilder();
      for(int x= 0; x<n;x++) {
    	  if(stillRoom(timeTable[x],cameron)) {
    		  cameron.add(Arrays.asList(timeTable[x]));
    		  output.append("C");
    	  }else if(stillRoom(timeTable[x],jamie)) {
    		  jamie.add(Arrays.asList(timeTable[x]));
    		  output.append("J");
    	  }else {
    		  output.setLength(0);
    		  output.append("IMPOSSIBLE");
    		  break;
    	  }
      }
      output.toString();
      //System.out.println(stillRoom(new Integer[] {5,6},new Integer[][] {{5,6}}));
      //System.out.println(Arrays.deepToString(timeTable));
      System.out.println("Case #" + i + ": " + output);
    }
  }
  public static boolean stillRoom(Integer[] toUse, List<List<Integer>> alreadyPlaned) {
	  for(int i = 0; i < alreadyPlaned.size(); i++) {
		  if(toUse[1] > alreadyPlaned.get(i).get(0) && !(toUse[0] >= alreadyPlaned.get(i).get(1))) {
			  return false;
		  }
	  }
	  return true;
  }
}