import java.util.*;
import java.io.*;

public class Solution {

	public static void main (String[] args) {

		Scanner in = new Scanner(new BufferedReader (new InputStreamReader (System.in)));
		int t = in.nextInt ();
		
		for (int i = 0; i < t; i++) {
			int x = in.nextInt ();
			int y = in.nextInt ();
			char[] path = in.next ().toCharArray ();
			int pic = 0;

			for (int j = 0; j < path.length; j++) {

				if (path [j] == 'N') y++;
				else if (path [j] == 'S') y--;
				else if (path [j] == 'E') x++;
				else if (path [j] == 'W') x--;

				if (manhattanDistance (x, y) <= j + 1) {
					pic = j + 1;
					break;
				}
			}
			System.out.println ("Case #" + i + ": " + (pic == 0 ? "IMPOSSIBLE" : pic));
		}
	}

	static int manhattanDistance (int x, int y) {
		return Math.abs (x) + Math.abs (y);
	}
}