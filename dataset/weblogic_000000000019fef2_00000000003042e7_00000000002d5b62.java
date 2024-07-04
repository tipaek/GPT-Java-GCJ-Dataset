
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	private static final boolean DEBUG = false;
	String result = "";

	private boolean dfs(int start, int end, int x, int y, int i, StringBuilder sb) {

		if(start == x && end == y) {
			if(result.equals("")) result = sb.toString();
			else if(sb.length() < result.length()) result = sb.toString();
			return true;
		}
		
		if(Math.abs(start) > Math.abs(x) || Math.abs(end) > Math.abs(y) ) {
			return false;
		}
		
		int power = (int) Math.pow(2, i);		
		sb.append('S');

		boolean rs = false;
		rs |= dfs(start, end - power, x, y, i + 1,  sb);
		sb.deleteCharAt(sb.length() - 1);
		sb.append('E');
		rs |= dfs(start + power, end, x, y, i + 1,  sb);
		sb.deleteCharAt(sb.length() -1);
		sb.append('N');
		rs |= dfs(start, end + power, x, y, i + 1,  sb);
		sb.deleteCharAt(sb.length() -1);
		sb.append('W');
		rs |= dfs(start - power, end, x, y, i + 1,  sb);
		sb.deleteCharAt(sb.length() -1);

		return rs;
	}
	
	private String solve(int x, int y) {
		StringBuilder sb = new StringBuilder();
		boolean res = dfs(0, 0, x, y, 0, sb);
		return res == true ? result : "IMPOSSIBLE";
	}

	public static void main(String[] args) throws FileNotFoundException {
		long startTime = System.nanoTime();
		InputStream is = DEBUG ? new FileInputStream("resources\\A.in") : System.in;
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)));
		int testCount = scanner.nextInt();
		for(int testNum = 1;  testNum <= testCount; testNum++) {
			int x = 0;
			int y= 0;
			x = scanner.nextInt();
			y = scanner.nextInt();
			String result = new Solution().solve(x,y);
			System.out.println("Case #" + testNum + ": " + result);			
		}		
		scanner.close();
		System.err.println("Solved in: " + ((System.nanoTime() - startTime) / 1e9) + " seconds.");
	}
}
