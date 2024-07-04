import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int T = 1; T <= t; ++T) {
			int x = in.nextInt(), y = in.nextInt();
			String m = in.next();
			int a = -1;
			for (int i = 0; i < m.length(); ++i) {
				if (m.charAt(i) == 'E' || m.charAt(i) == 'W')
					if (m.charAt(i) == 'E') ++x;
					else --x;
				else
					if (m.charAt(i) == 'N') ++y;
					else --y;
					
				if (Math.abs(x) + Math.abs(y) <= i+1) {
					a = i+1;
					break;
				}
			}
			
			if (a == -1) System.out.println("Case #" + T + ": IMPOSSIBLE");
			else System.out.println("Case #"+ T + ": " + a);
		}
	}
}