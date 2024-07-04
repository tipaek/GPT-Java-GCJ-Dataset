import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int _t = 1; _t <= t; ++_t) {
			int n = in.nextInt();
			int[][] activities = new int[n][3];
			for (int i = 0; i < n; i++) {
				activities[i][0] = in.nextInt();
				activities[i][1] = in.nextInt();
				activities[i][2] = i;
			}
			
			Stack<int[]> j = new Stack<int[]>();
			Stack<int[]> c = new Stack<int[]>();
			
			char[] result = new char[n];
			
			activities = sort2DArr(activities);
			c.push(activities[0]);
			result[activities[0][2]] = 'C';
			for (int i = 1; i < n; i++) {
				if (c.peek()[1]-activities[i][0] <= 0) {
					c.push(activities[i]);
					result[activities[i][2]] = 'C';
				} else if (j.isEmpty() ? true : j.peek()[1]-activities[i][0] <= 0) {
					j.push(activities[i]);
					result[activities[i][2]] = 'J';
				} else {
					result = "IMPOSSIBLE".toCharArray();
					break;
				}
			}
			System.out.println("Case #" + _t + ": " + new String(result));
		}
	}
	
	private static int[][] sort2DArr(int[][] data) {
		int temp = 0, _temp = 0, i_temp = 0;
		int n = data.length;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n-1); j++) {
				if (data[j-1][0] > data[j][0]) {
					temp = data[j-1][0];
					_temp = data[j-1][1];
					i_temp = data[j-1][2];
					data[j-1][0] = data[j][0];
					data[j-1][1] = data[j][1];
					data[j-1][2] = data[j][2];
					data[j][0] = temp;
					data[j][1] = _temp;
					data[j][2] = i_temp;
				}
			}
		}
		return data;
	}

}