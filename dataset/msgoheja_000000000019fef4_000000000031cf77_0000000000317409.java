import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {	
	
	static boolean isIntersection(int x, int y, int cX, int cY) {
		return ((x == cX) && (y == cY));
	}
	
	static char checkMovableDirection(int x, int y, int cX, int cY, char ch) {
		char res = '\0';
		if(cX < x) return 'E';
		if(cY < y) return 'N';
		if(cY > y) return 'S';
		if(cX > x) return 'W';
		return res;
	}
	
	static String solve(int x, int y, String path) {
		int mX = 0, mY = 0;
		int minutes = 0;
		char ch, mCh;
		for(int i = 0; i < path.length(); i++) {
			ch = path.charAt(i);
			
			if(ch == 'N') { y += 1; };
			if(ch == 'S') { y -= 1; };
			if(ch == 'E') { x += 1; };
			if(ch == 'W') { x -= 1; };
			
			mCh = checkMovableDirection(x, y, mX, mY, ch);
			
			if(mCh == 'N') { mY += 1; };
			if(mCh == 'S') { mY -= 1; };
			if(mCh == 'E') { mX += 1; };
			if(mCh == 'W') { mX -= 1; };
			
			minutes++;
			
			if(isIntersection(x, y, mX, mY)) break;
		}
		
		if(!isIntersection(x, y, mX, mY)) {
			return "IMPOSSIBLE";
		}
		
		return ""+minutes;
	}
	
	
	public static void main(String[] args) throws Exception{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		String path = "", output = "";
		int X, Y;
		int T = in.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			X = in.nextInt();
			Y = in.nextInt();
			path = in.next();
			
			output = solve(X, Y, path);
			
			System.out.println("Case #" + tc + ": " + output);
		}
		in.close(); 
	}

}
