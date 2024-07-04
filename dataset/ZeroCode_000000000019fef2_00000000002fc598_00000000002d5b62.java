/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
	private static Character[] way = new Character[20];
	
	private static boolean recurse(int turn, long x, long y) {
		if(x==0 && y == 0) return true;
		if(turn>18) return false;
		if((x&(1L<<turn)) == (y&(1L<<turn))) return false;
		
		if((x&(1<<turn))>0) {
			way[turn] = 'E';
			if(recurse(turn +1 , x- (1L<<turn), y)) return true;
			way[turn] = 'W';
			return recurse(turn +1 , x + (1L<<turn), y);
		}
		else {
			way[turn] = 'N';
			if(recurse(turn+1, x, y - (1L<<turn))) return true;
			way[turn] = 'S';
			return recurse(turn +1, x, y + (1L<<turn));
		}
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int x = in.nextInt();
          int y = in.nextInt();
          
          long tempX = x<0? -x : x;
          long tempY = y<0? -y : y;
          
          for(int j=0 ; j<20; j++) {
          	way[j] = 'O';
          }
          
          if(recurse(0, tempX, tempY)) {
          	if(x<0) {
          		for(int j=0; way[j]!='O'; j++) {
          			if(way[j]=='E') way[j] = 'W';
          			else if(way[j]=='W') way[j] = 'E';
          		}
          	}
          	if(y<0) {
          		for(int j=0; way[j]!='O'; j++) {
          			if(way[j]=='N') way[j] = 'S';
          			else if (way[j]=='S') way[j] = 'N';
          		}
          	}
          	StringBuilder sb = new StringBuilder();
          	for(int j = 0 ; way[j] !='O'; j++) {
          		sb.append(way[j]);
          	}
          	System.out.println("Case #" + i + ": " + sb.toString());
          }
          else {
          	System.out.println("Case #" + i + ": IMPOSSIBLE");
          }
          
        }
	}
}