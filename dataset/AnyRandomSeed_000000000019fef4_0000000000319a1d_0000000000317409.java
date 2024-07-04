import java.io.*;
import java.util.*;

public class Solution{
		private static boolean testMode = false;
		
		public static void main(String[] args) {
			if (testMode)
				try {
					System.setIn(new FileInputStream(
							System.getProperty("user.dir")+"/src/"+"jam2020rb_t1.txt"));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			Scanner sc = new Scanner(new BufferedReader(
					new InputStreamReader(System.in)));
			int t = sc.nextInt();
			for (int i=1; i<=t; i++) {
				Solution inst = new Solution();
				int x = sc.nextInt();
				int y = sc.nextInt();
				String s = sc.nextLine().trim();
				System.out.println("Case #"+i+": "+inst.solve(x,y,s));
			}
			sc.close();
		}
		
		private String solve(int x, int y, String s) {
			int[][] dirs = new int[][] {{0,1},{0,-1}, {-1,0}, {1,0}};
			int px = x;
			int py = y;
			int count = 0;
			for (int i=0; i<=s.length(); i++) {
				if (Math.abs(px)+Math.abs(py)<=count) return count+"";
				if (i>=s.length()) break;
				if (s.charAt(i)=='N') {
					px += dirs[0][0];
					py += dirs[0][1];
				} else if (s.charAt(i)=='S') {
					px += dirs[1][0];
					py += dirs[1][1];
				} else if (s.charAt(i)=='W') {
					px += dirs[2][0];
					py += dirs[2][1];
				} else if (s.charAt(i)=='E') {
					px += dirs[3][0];
					py += dirs[3][1];
				}
				count++;
			}
			return "IMPOSSIBLE";
		}
	}