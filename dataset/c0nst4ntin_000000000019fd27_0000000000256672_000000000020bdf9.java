import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int _t = 1; _t <= t; ++_t) {
			int n = in.nextInt();
			int[][] a = new int[n][3];
			for (int i = 0; i < n; i++) {
				a[i][0] = in.nextInt();
				a[i][1] = in.nextInt();
				a[i][2] = i;
			}
			a = sort2DArr(a);
			char[] ans = new char[n];
			char[] c = {'C', 'J'};
			int p1 = 0, p2 = 1;
			int[] l = new int[2];
			l[0]=l[1]=Integer.MAX_VALUE;
			for(int i = n-1; i >= 0; i--) {
				boolean assigned = false;
				if(l[p1]>l[p2]) {
					int tmp = p1;
					p1 = p2;
					p2 = tmp;
				}
				if (a[i][1]<=l[p1]) {
					assigned = true;
					ans[a[i][2]] = c[p1];
					l[p1] = a[i][0];
				}
				if (!assigned && a[i][1] <= l[p2]) {
					assigned = true;
					ans[a[i][2]] = c[p2];
					l[p2] = a[i][0];
				}
				if (!assigned) 
					ans = "IMPOSSIBLE".toCharArray();
			}
			System.out.println("Case #" + _t + ": " + new String(ans));
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