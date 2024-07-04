import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		s.solution();
	}
	
	public void solution() {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int i = 1; i <= t; ++i) {
	      int x = in.nextInt();
	      int y = in.nextInt();
	      String path = in.next();
	      
	      int minutes = path.length();
	      try {
	    	  int ans = canReach(x, y, path, minutes, 0, 0);
	    	  System.out.println("Case #" + i + ": " + ans);
	    	  
	      } catch (Exception e) {
	    	  System.out.println("Case #" + i + ": IMPOSSIBLE");
	    	  
	      }
	    }
	    in.close();

	}

	
	private int canReach(int x, int y, String path, int minutes, int minutesPassed, int index) {
		
		if (Math.abs(x) + Math.abs(y) <= minutesPassed) {
			return 0;
		}
		if (index >= path.length() ) throw new RuntimeException("");

		switch (path.charAt(index)) {
		case 'N':
			y++;
			break;
		case 'S':
			y--;
			break;
		case 'W':
			x--;
			break;
		case 'E':
			x++;
			break;

		default:
			break;
		}
		
		
		return 1 + canReach(x, y, path, minutes, minutesPassed + 1, index + 1 );
	}
}
