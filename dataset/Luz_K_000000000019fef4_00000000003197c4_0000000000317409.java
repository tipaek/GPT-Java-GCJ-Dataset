import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int x = in.nextInt();
      int y = in.nextInt();
      String[] moves = in.nextLine().split("");
      int movesYouMake = 0;
      boolean gotHim = false;
      for(int z = 1;z < moves.length;z++) {
    	  //System.out.println(x + " " + y + " " + movesYouMake);
    	  if(Math.abs(x) + Math.abs(y) <= movesYouMake) {
    		  System.out.println("Case #" + i + ": " + movesYouMake);
    		  gotHim = true;
    		  break;
    	  }else {
    		  if(moves[z].equals("S")) {
    			  y --;
    		  }else if(moves[z].equals("N")) {
    			  y++;
    		  }
    		  else if(moves[z].equals("W")) {
    			  x--;
    		  }else if(moves[z].equals("E")) {
    			  x++;
    		  }
    	  }
    	  movesYouMake ++;
      }
      if(Math.abs(x) + Math.abs(y) <= movesYouMake) {
		  System.out.println("Case #" + i + ": " + movesYouMake);
		  gotHim = true;
		  break;
	  }
      if(!gotHim) {
    	  System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
      }
      
    }
  }
}