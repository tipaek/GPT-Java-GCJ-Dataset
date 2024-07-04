import java.util.*;

public class Solution {
	
	static String path = "";
	
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 0; i < t; i++) {
        	long x = scan.nextLong();
        	long y = scan.nextLong();
        	solve(0, 0, x, y, 1, "", (long)Math.sqrt((x * x) + (y * y)));
        	if (path.length() == 0) path = "IMPOSSIBLE";
        	System.out.println("Case #" + (i + 1) + ": " + path);
        	path = "";
        }
    }
	
	public static void solve(long sX, long sY, long gX, long gY, long moveL, String p, long max) {
		if (sX == gX && sY == gY) {
			if (path.equals("")) path = p;
			else if (p.length() < path.length()) path = p;
		}
		else if (moveL > max * 2) return;
		else {
			solve(sX, sY + moveL, gX, gY, moveL * 2, p +"N", max);
			solve(sX, sY - moveL, gX, gY, moveL * 2, p + "S", max);
			solve(sX + moveL, sY, gX, gY, moveL * 2, p + "E", max);
			solve(sX - moveL, sY, gX, gY, moveL * 2, p + "W", max);
		}
	}
}
