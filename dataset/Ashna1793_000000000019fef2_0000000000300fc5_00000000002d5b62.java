import java.util.*;
import java.io.*;

public class Solution {
	static String ans;
	public static String rec(int X, int Y) {
		ans = "";
		StringBuilder res = new StringBuilder();
		recHelper(0,0,X,Y,res, 1);
		return ans == "" ? "IMPOSSIBLE": ans;
	}
	
	public static void recHelper(int x, int y, int X, int Y, StringBuilder res, int step){
		if(x == X && y == Y){
			String resNew = new String(res);
			if(ans == "" || resNew.length() < ans.length()){
				ans = resNew;
			}
			return;

		}
		if(Math.abs(x) > Math.abs(X) || Math.abs(y) > Math.abs(Y)) return;
		int stepVal = (int)Math.pow(2, step - 1);
		//go North
		step ++;
		recHelper(x, y + stepVal, X, Y,res.append('N'), step);
		res.deleteCharAt(res.length() - 1);
		// go South
		recHelper(x, y - stepVal, X, Y, res.append('S'), step);
		res.deleteCharAt(res.length() - 1);
		//go East
		recHelper(x + stepVal, y, X, Y, res.append('E'), step);
		res.deleteCharAt(res.length() - 1);
		//go West
		recHelper(x - stepVal, y, X, Y, res.append('W'), step);
		res.deleteCharAt(res.length() - 1);
		
		return;
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt();
		for(int i = 1; i <= T; i++){
			int X = in.nextInt();
			int Y = in.nextInt();
			String ans = rec(X,Y);
			System.out.println("Case #" + i+ ": "+ans);
		}
	}
	
}
