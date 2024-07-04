import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	private static boolean testMode = false;

	public static void main(String[] args) {
		if (testMode)
			try {
				System.setIn(new FileInputStream(
						System.getProperty("user.dir")+"/src/solution/"+"jam2020_q3.txt"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		Scanner sc = new Scanner(new BufferedReader(
				new InputStreamReader(System.in)));
		int t = sc.nextInt();
		for (int i=1; i<=t; i++){
			int n = sc.nextInt();
			int[][] intervals = new int[n][3];
			for (int j=0; j<n; j++) {
				intervals[j][0] = sc.nextInt();
				intervals[j][1] = sc.nextInt();
				intervals[j][2] = j;
			}
			System.out.println("Case #"+i+": "+solve(intervals));
		}
		sc.close();
	}
	
	private static String solve(int[][] intervals) {
		Arrays.parallelSort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
		char[] res = new char[intervals.length];
		int endJ = -1; int endC = -1;
		for (int i=0; i<intervals.length; i++) {
			int start = intervals[i][0];
			if (endJ<=start) {
				endJ = intervals[i][1];
				res[intervals[i][2]] = 'J';
			} else if (endC<=start) {
				endC = intervals[i][1];
				res[intervals[i][2]] = 'C';
			} else
				return "IMPOSSIBLE";
		}
		return String.valueOf(res);
	}
}
