import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = input.nextInt();
    input.nextLine();
    for (int i = 1; i <= t; ++i) {
      String xAndY = input.nextLine();
      int x = Integer.parseInt(xAndY.split(" ")[0]);
      int y = Integer.parseInt(xAndY.split(" ")[1]);
      String m = xAndY.split(" ")[2];
      
      int time = 1;
      if (x == 0 && y == 0) {
    	  System.out.println("Case #" + i + ": " + 0);
      } else {
	      int minTime = -1;
	      boolean impossible = true;
	      for (int j = 0; j < m.length(); j++) {
	    	  if (m.charAt(j) == 'S') {
	    		  y -= 1;
	    	  } else if (m.charAt(j) == 'N') {
	    		  y+= 1;
	    	  } else if (m.charAt(j) == 'E') {
	    		  x += 1;
	    	  } else {
	    		  x-= 1;
	    	  }
	    	  
	    	  if (impossible && Math.abs(x) + Math.abs(y) <= time) {
	    		  minTime = time;
	    		  impossible = false;
	    		  break;
	    	  }
	    	  time++;
	      }
	      if (minTime != -1) {
	    	  System.out.println("Case #" + i + ": " + minTime);
	      } else {
	    	  System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
	      }
      }
      
    }
  }
}