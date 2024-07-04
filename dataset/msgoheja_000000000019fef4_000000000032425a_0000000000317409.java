import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {	
	
	static boolean isIntersection(int x, int y, int cX, int cY) {
		return ((x == cX) && (y == cY));
	}
	
	static char checkMovableDirection(int x, int y, int cX, int cY, char ch, char nextCh) {
		char res = '\0';
		if(nextCh != '\0') {
			if(nextCh == 'S' || nextCh == 'N' || cX + 1 < x || cX - 1 > x) {
				if(cX < x) return 'E';
				if(cX > x) return 'W';
			}
			
			if(nextCh == 'W' || nextCh == 'E' || cY + 1 < y || cY - 1 > y) {
				if(cY < y) return 'N';
				if(cY > y) return 'S';
			}
			/*if(nextCh == 'W' && (cX + 1 < x)) return 'E';
			if(nextCh == 'E' && (cX - 1 > x)) return 'W';
			if(nextCh == 'S' && (cY + 1 < y)) return 'N';
			if(nextCh == 'N' && (cY - 1 > y)) return 'S';*/
			
			checkMovableDirection(x, y, cX, cY, ch, '\0');
			
			/*
			if(nextCh == 'W' && (cX + 1 < x)) return 'E';
			if(nextCh == 'E' && (cX - 1 > x)) return 'W';
			
			if(nextCh == 'S' && (cY + 1 < y)) return 'N';
			if(nextCh == 'N' && (cY - 1 > y)) return 'S';
			
			if(cY > y) return 'S';
			if(cY < y) return 'N';
			if(cX > x) return 'W';
			if(cX < x) return 'E';*/
			
			
			
			
			/*if(cX < x && (cX + 1 < x) && nextCh == 'W') return 'E';
			if(cY < y && (cY + 1 < y) && nextCh == 'S') return 'N';
			if(cY > y && (cY - 1 > y) && nextCh == 'N') return 'S';
			if(cX > x && (cX - 1 > x) && nextCh == 'E') return 'W';*/
		}
		else {
			if(cX < x) return 'E';
			if(cY < y) return 'N';
			if(cY > y) return 'S';
			if(cX > x) return 'W';
		}
		return res;
	}
	
	static String solve(int x, int y, String path) {
		int mX = 0, mY = 0;
		int minutes = 0;
		char ch, mCh;
		boolean flag = (path.indexOf('E') > -1 || path.indexOf('W') > -1);
		
		//System.out.println(flag);
		
		for(int i = 0; i < path.length(); i++) {
			ch = path.charAt(i);
			
			if(ch == 'N') { y += 1; };
			if(ch == 'S') { y -= 1; };
			if(ch == 'E') { x += 1; };
			if(ch == 'W') { x -= 1; };
			
			if(!flag) {
				mCh = checkMovableDirection(x, y, mX, mY, ch, '\0');
			} else if(i < path.length() - 1) {
				mCh = checkMovableDirection(x, y, mX, mY, ch, path.charAt(i+1));
			} else {
				mCh = checkMovableDirection(x, y, mX, mY, ch, '\0');
			}
			
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
