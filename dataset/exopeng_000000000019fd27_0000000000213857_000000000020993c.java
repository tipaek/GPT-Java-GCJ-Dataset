import java.io.*;
import java.util.*;



public class Solution {
	public static void main(String[] args) throws IOException {
		//get input separately
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter p = new PrintWriter(new BufferedOutputStream(System.out));
		StringTokenizer s = new StringTokenizer(b.readLine());
		int cases = Integer.parseInt(s.nextToken());
		//store the answers in an int array
		for (int i = 0; i < cases; i++) {
			s = new StringTokenizer(b.readLine());
			String ans = "";
			int n = Integer.parseInt(s.nextToken());
			int[][] arr = new int[n][n];
			for (int j = 0; j < n; j++) {
				s = new StringTokenizer(b.readLine());
				for (int y = 0; y < n; y++) {
					arr[j][y] = Integer.parseInt(s.nextToken());
				}
			}
			ans += "Case #" + (i+1) + ": " + trace(arr) + " " + repRow(arr) + " " + repCol(arr);
			
			p.println(ans);
			
		}
		p.close();
		

	}
	
	// you should actually read the stuff at the bottom
	public static int repRow(int[][] arr) {
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
			for (int j = 0; j < arr.length; j++) {
				
				if (map.containsKey(arr[i][j])) {
					ans++;
					break;
				}
				map.put(arr[i][j], true);
			}
			
		}
		return ans;

	}
	public static int repCol(int[][] arr) {
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
			for (int j = 0; j < arr.length; j++) {
				if (map.containsKey(arr[j][i])) {
					ans++;
					break;
				}
				map.put(arr[j][i], true);

			}
			
		}
		return ans;

	}
	public static int trace(int[][] arr) {
		int sum = 0;
		for (int i = 0, j = 0; i < arr.length; i++, j++) {
			sum += arr[i][j];
		}
		return sum;
	}
}
/* REMINDERS
 * PLANNING!!!!!!!! Concrete plan before code
 * DON'T MAKE ASSUMPTIONS
 * DON'T OVERCOMPLICATE
 * NAIVE SOL FIRST
 * CHECK INT VS LONG, IF YOU NEED TO STORE LARGE NUMBERS
 * CHECK CONSTRAINTS, C <= N <= F...
 * CHECK SPECIAL CASES, N = 1...
 * CHECK ARRAY BOUNDS, HOW BIG ARRAY HAS TO BE
 * TO TEST TLE/MLE, PLUG IN MAX VALS ALLOWED AND SEE WHAT HAPPENS
 * ALSO CALCULATE BIG-O, OVERALL TIME COMPLEXITY
 */
