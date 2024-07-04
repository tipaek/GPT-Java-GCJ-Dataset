import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int a = in.nextInt();
      in.nextLine();
      int[][] times = new int[a][2];
      for (int j = 0; j < a; j++) {
    	  String activities = in.nextLine();
    	  String[] startAndEnd = activities.split(" ");
    	  int start = Integer.parseInt(startAndEnd[0]);
    	  int end = Integer.parseInt(startAndEnd[1]);
    	  times[j] = new int[]{start, end};
      }
      
      Arrays.sort(times, (a1, a2) -> a1[0] - a2[0]);
      
      StringBuilder order = new StringBuilder("");
      int end1 = -1;
      int end2 = -1;
      boolean impossible = false;
      for (int j = 0; j < a; j++) {
    	  int start = times[j][0];
    	  int end = times[j][1];
    	  if (end1 > start && end2 > start) {
    		  impossible = true;
    	  } else if (end1 <= start) {
    		  end1 = end;
    		  order.append("C");
    	  } else {
    		  end2 = end;
    		  order.append("J");
    	  }
      }
      
      String output = (!impossible) ? order.toString() : "IMPOSSIBLE";

      System.out.println("Case #" + i + ": " + output);    
    }
  }
}
