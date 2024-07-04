import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      Integer[][] timeTable = new Integer [n][3];
      List<List<Integer>> cameron = new ArrayList<List<Integer>>();
      List<List<Integer>> jamie = new ArrayList<List<Integer>>();
      Integer[] answer = new Integer [n];
      for(int x = 0; x < n; x++) {
    	  timeTable[x][0] = in.nextInt();
    	  timeTable[x][1] = in.nextInt();
    	  timeTable[x][2] = x;
      }
      Arrays.sort(timeTable, (a, b) -> Integer.compare(a[0], b[0]));
      StringBuilder output = new StringBuilder();
      //System.out.println(stillRoom(new Integer[] {5,6},new Integer[][] {{5,6}}));
      
      for(int x= 0; x<n;x++) {
    	  if(stillRoom(timeTable[x],cameron)) {
    		  cameron.add(Arrays.asList(timeTable[x]));
    		  answer[timeTable[x][2]] = 1;
    	  }else if(stillRoom(timeTable[x],jamie)) {
    		  jamie.add(Arrays.asList(timeTable[x]));
    		  answer[timeTable[x][2]] = 2;
    	  }else {
    		  answer[timeTable[x][2]] = 3;
    	  }
      }
      for(int x = 0; x < n; x++) {
    	  if(answer[x] == 1) {
    		  output.append("J"); 
    	  }else if(answer[x] == 2) {
    		  output.append("C");
    	  }else {
    		output.setLength(0);
    		output.append("IMPOSSIBLE");
    		break;  
    	  }
      }   
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