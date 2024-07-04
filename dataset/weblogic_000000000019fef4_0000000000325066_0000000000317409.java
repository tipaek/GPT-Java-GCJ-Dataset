
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class Solution {

private static final boolean DEBUG = false;

	
	private String solve(int x, int y, String path) {
		int len = path.length();
		int maxDiff = Integer.MAX_VALUE;
		int ct = 0;
		for(char c: path.toCharArray()) {
			ct++;
			if(c == 'E') x++;
			if(c == 'W') x--;
			if(c == 'S') y--;
			if(c == 'N') y++;
			int diff = Math.abs(x) + Math.abs(y);
			if(diff <= ct) {
				return String.valueOf(ct);
			}			
		}	
	
		return "IMPOSSIBLE";
		
		
	}

	public static void main(String[] args) throws FileNotFoundException {
		long startTime = System.nanoTime();
		InputStream is = DEBUG ? new FileInputStream("resources\\B.in") : System.in;
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)));
		int testCount = scanner.nextInt();
		for(int testNum = 1;  testNum <= testCount; testNum++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			String path = scanner.next();			
			String result = new Solution().solve(x,y,path);
			System.out.println("Case #" + testNum + ": " + result);			
		}		
		scanner.close();
		System.err.println("Solved in: " + ((System.nanoTime() - startTime) / 1e9) + " seconds.");
	}

}
