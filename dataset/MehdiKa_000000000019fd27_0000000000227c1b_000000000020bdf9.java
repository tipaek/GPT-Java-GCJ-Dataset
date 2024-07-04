import java.util.*;
import java.io.*;
public class Solution {

	static String solve(int[][] schedule) {
		char[] result = new char[schedule.length];
		int endC = 0;
		int endJ = 0;

		java.util.Arrays.sort(schedule, new java.util.Comparator<int[]>() {
		    public int compare(int[] a, int[] b) {
		        return Double.compare(a[1], b[1]);
		    }
		});
		
		for(int i=0; i<schedule.length; i++) {
			if (schedule[i][1] >= endC) {
				result[schedule[i][0]] = 'C';
				endC = schedule[i][2];
			} else {
				if (schedule[i][1] >= endJ) {
					result[schedule[i][0]] = 'J';
					endJ = schedule[i][2];
				} else {
					return "IMPOSSIBLE";
				}
			}
		}
		return String.valueOf(result);
	}

	public static void main(String[] args) {
		Scanner in;
		try {
			in = new Scanner(new BufferedReader(new FileReader("bin/myinput.txt")));
		} catch (IOException e) {
			// e.printStackTrace();
			 in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));			
		}
		
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int[][] schedule = new int[n][3];
			for (int j = 0; j<n; ++j) {
				schedule[j][0] = j;
				schedule[j][1] = in.nextInt();
				schedule[j][2] = in.nextInt();
			}
			System.out.println("Case #" + i + ": " + solve(schedule));
		}
		in.close();
	}

}
