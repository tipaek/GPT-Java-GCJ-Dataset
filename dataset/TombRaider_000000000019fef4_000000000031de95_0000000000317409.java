
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	// task 1
	
	int x;
	int y; 
	String way;
	
	public Solution (int x, int y, String way) {
		this.x = x;
		this.y = y;
		this.way = way;
	}
	
	public String solve () {
		for (int i = 0; i <= way.length(); i++) {
			if (Math.abs(x)+Math.abs(y) <= i) {
				return i+" ";
			}
			if (i < way.length()) {
				if (way.charAt(i) == 'E') {
					this.x += 1;
				} else 	if (way.charAt(i) == 'W') {
					this.x -= 1;
				}  else if (way.charAt(i) == 'N') {
					this.y += 1;
				} else { // S
					this.y -= 1;
				}
			}
		}
		return "IMPOSSIBLE";
	}
      
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int x = in.nextInt();
			int y = in.nextInt();
			String way = in.next();
			Solution sol = new Solution(x,y,way);
            System.out.println("Case #"+i+": "+sol.solve());
		}
	}
}
