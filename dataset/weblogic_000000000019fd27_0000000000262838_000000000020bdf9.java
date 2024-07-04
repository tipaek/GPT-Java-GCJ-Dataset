import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution{
private static final boolean DEBUG = false;

	public class Element{
		public int start;
		public int end;
		public int idx;
		public Element(int start, int end, int idx) {
			this.start = start;
			this.end = end;
			this.idx = idx;
		}
	}
	
	private String solve(int[][] interval) {
		char[] result = new char[interval.length];		
		Element[] e = new Element[interval.length];
		for(int i = 0; i < interval.length; i++) {
			e[i] = new Element(interval[i][0],interval[i][1], i);
		}
		Arrays.sort(e, (Element a, Element b) -> a.start - b.start);		
		char[] cj = {'C','J'};
		int[] end = new int[2];
		Arrays.fill(end, 0);
		int idx = 0;
		
		for(int i  = 0; i < e.length; i++) {
			Element ith = e[i];
			if(end[idx] <= ith.start) {
				end[idx]  = ith.end;
				result[ith.idx] = cj[idx];
			}else {
				idx = (idx+1) % 2;
				if(end[idx] <= ith.start) {
					end[idx] = ith.end;
					result[ith.idx] = cj[idx];
				}else {
					return "IMPOSSIBLE";
				}
			}
		}
		
		return new String(result);
	}

	public static void main(String[] args) throws FileNotFoundException {
		long startTime = System.nanoTime();
		InputStream is = DEBUG ? new FileInputStream("resources/parenting.in") : System.in;
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)));
		int testCount = scanner.nextInt();
		for(int testNum = 1;  testNum <= testCount; testNum++) {
			int n = scanner.nextInt();
			int[][] interval = new int[n][2];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < 2; j++) {
					interval[i][j] = scanner.nextInt();
				}
			}
			String result = new Solution().solve(interval);
			System.out.println("Case #" + testNum + ": " + result);			
		}		
		scanner.close();
		//System.err.println("Solved in: " + ((System.nanoTime() - startTime) / 1e9) + " seconds.");
	}

}
