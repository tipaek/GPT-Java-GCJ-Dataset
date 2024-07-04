
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution{
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		int t = Integer.parseInt(br.readLine());
		int t1 = t;
		while (t -- > 0) {
//			int xor = 0;
			int trace = 0;
			int n = Integer.parseInt(br.readLine());
			boolean[] r_xor = new boolean[n];
			boolean[] c_xor = new boolean[n];
			int[][] r_check = new int[n][n];
			int[][] c_check = new int[n][n];
			for (int i = 0;i<n;i++) {
				String[] temp = br.readLine().trim().split(" ");
				for (int j = 0;j<n;j++) {
					int tem = Integer.parseInt(temp[j]);
					r_check[i][tem-1]++;
					c_check[j][tem-1]++;
					if (i == j) {
						trace += tem;
					}
					if (r_check[i][tem-1] >= 2) {
						r_xor[i] = true;
					}
					if (c_check[j][tem-1] >= 2) {
						c_xor[j] = true;
					}
				}
//				xor = xor^(i+1);
			}
			
			int r = 0;
			int c = 0;
			for (int i = 0;i<n;i++) {
				if ((r_xor[i])) {
					r++;
				}
				if ((c_xor[i])) {
					c++;
				}
			}
			System.out.println("Case #" + (t1-t) + ": "+trace + " " + r + " " + c);
		}
    }
}