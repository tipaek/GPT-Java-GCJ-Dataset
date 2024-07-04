import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int q = 1; q <= t; ++q) {
      int x = in.nextInt();
      int y = in.nextInt();
      
      Boolean xrev = false;
      Boolean yrev = false;
      
      if(x<0) {
          x = -x;
          xrev = true;
      }
      
      if(y<0) {
          y = -y;
          yrev = true;
      }
      
	  Boolean[] xb = new Boolean[40];
	  Boolean[] yb = new Boolean[40];
	  int last = -1;
	  
	  for(int i = 0; i < 40; i++) {
		  if (x % 2 == 1) {
			  xb[i] = true;
			  last = i;
		  } else {
			  xb[i] = false;
		  }
		  x /= 2;
		  if (y % 2 == 1) {
			  yb[i] = true;
			  last = i;
		  } else {
			  yb[i] = false;
		  }
		  y /= 2;
	  }
	  
	  String ret = "";
	  Boolean imp = false;
	  
	  for(int i = 0; i <= last; i++) {
		  if(!xb[i] && !yb[i]) {
			  imp = true;
			  break;
		  }
		  if(xb[i] && yb[i]) {
			  imp = true;
			  break;
		  }
		  if(xb[i]) {
			  if(i==last) {
				 ret = ret + (xrev ? "W" : "E"); 
			  } else {
				  if(!xb[i+1] && !yb[i+1]) {
					  ret = ret + (xrev ? "E" : "W");
					  xb[i] = false;
					  xb[i+1]=true;
				  }
				  else if(xb[i+1] && !yb[i+1]) {
					  ret = ret + (xrev ? "W" : "E");
					  xb[i] = false;
				  }
				  else if(!xb[i+1] && yb[i+1]) {
					  ret = ret + (xrev ? "W" : "E");
					  xb[i] = false;
				  }
				  else if(xb[i+1] && yb[i+1]) {
					  ret = ret + (xrev ? "E" : "W");
					  xb[i] = false;
					  for(int j = i+1; j <= last; j++) {
						  if(!xb[j]) {
							  xb[j]=true;
							  break;
						  } else {
							  xb[j] = false;
							  if(last == j) last++;
						  }
						  
					  }
				  }
			  }
		  }
		  if(yb[i]) {
			  if(i==last) {
				 ret = ret + (xrev ? "S" : "N"); //WE -> SN
			  } else {
				  if(!yb[i+1] && !xb[i+1]) {
					  ret = ret + (yrev ? "N" : "S");
					  yb[i] = false;
					  yb[i+1]=true;
				  }
				  else if(yb[i+1] && !xb[i+1]) {
					  ret = ret + (yrev ? "S" : "N");
					  yb[i] = false;
				  }
				  else if(!yb[i+1] && xb[i+1]) {
					  ret = ret + (yrev ? "S" : "N");
					  yb[i] = false;
				  }
				  else if(yb[i+1] && xb[i+1]) {
					  ret = ret + (yrev ? "N" : "S");
					  yb[i] = false;
					  for(int j = i+1; j <= last; j++) {
						  if(!yb[j]) {
							  yb[j]=true;
							  break;
						  } else {
							  yb[j] = false;
							  if(last == j) last++;
						  }
						  
					  }
				  }
			  }
		  }
		  
	  }
	  
      if(imp) System.out.println("Case #" + q + ": " + "IMPOSSIBLE");
      else System.out.println("Case #" + q + ": " + ret);
      

    }
  }
}