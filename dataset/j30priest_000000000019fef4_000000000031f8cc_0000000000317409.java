import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 0; i < t; ++i) {
			int x = in.nextInt();
			int y = in.nextInt();
			String path = in.next();
			solve(x, y, path, i+1);
		}
	}

	private static void solve(int x, int y, String path, int testCase) {
		String[] pathArray = path.split("");
		String solution = "IMPOSSIBLE";
		for(int i = 0; i< pathArray.length; i++) {
			if(pathArray[i].equals("N")) {
				y++;
			} else if(pathArray[i].equals("S")) {
				y--;
			} else if(pathArray[i].equals("W")) {
				x--;
			} else {
				x++;
			}

			if((Math.abs(x) + Math.abs(y)) <= i+1) {
				solution = String.valueOf(i+1);
				break;
			}
		}
		System.out.println("Case #"+ testCase + ": " + solution);	
	}
}