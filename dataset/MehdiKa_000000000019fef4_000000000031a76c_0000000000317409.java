import java.util.*;
import java.io.*;
public class Solution {

	static int solve(int x, int y, String m) {
		int t = 1; 
		for (int i=0; i<m.length(); i++) {
			switch (m.charAt(i)) {
				case 'N':
					y++;
					break;
				case 'S':
					y--;
					break;
				case 'E':
					x++;
					break;
				case 'W':
					x--;
					break;
			}
			int d = Math.abs(x) + Math.abs(y);
			if (t>=d) {
				return t;
			}
			t++;
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner in;
		try {
			in = new Scanner(new BufferedReader(new FileReader("bin/myinput.txt")));
		} catch (IOException e) {
			// e.printStackTrace();
			 in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));			
		}
		
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int x = in.nextInt();
			int y = in.nextInt();
			String m = in.next();
			int result = solve(x, y, m);
			System.out.println("Case #" + i + ": " + (result>0 ? result:"IMPOSSIBLE"));
		}
		in.close();
	}

}
