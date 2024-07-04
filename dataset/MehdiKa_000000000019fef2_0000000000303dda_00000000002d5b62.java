import java.util.*;
import java.io.*;
public class Solution {

	static String solve(int inputX, int inputY, int power) {
		
		int x = inputX;
		int y = inputY;

		char[] path = new char[power+1];

		while((x != 0 || y != 0) && power>=0) {
			int absX = Math.abs(x);
			int absY = Math.abs(y);

			int xSign = x>0 ? 1:-1;
			int ySign = y>0 ? 1:-1;

			if (absX>absY) {
				path[power] = (xSign == 1) ? 'E':'W';
				x -= Math.pow(2, power) * xSign;
			} else {
				path[power] = (ySign == 1) ? 'N':'S';				
				y -= Math.pow(2, power) * ySign;
			}
			power--;
		}

		boolean useAll = true;
		for(int i=power; i>=0; i--) {
			if (path[i] != 'N' && path[i] != 'E' && path[i] != 'S' && path[i] != 'W') {
				useAll = false;
				break;
			}
		}

		if (x==0 && y==0 && useAll)
			return String.valueOf(path);
		
		return "";
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
			int absX = Math.abs(x);
			int absY = Math.abs(y);
			int power = (int)(Math.log(absX+absY) / Math.log(2));
			String result = solve(x, y, power);
			if (result != "")
				System.out.println("Case #" + i + ": " + result);
			else {
				power += 1;
				if (result != "") {
					System.out.println("Case #" + i + ": " + result);
				} else {
					System.out.println("Case #" + i + ": IMPOSSIBLE");
				}
			}
		}
		in.close();
	}

}
