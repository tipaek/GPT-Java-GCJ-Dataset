import java.util.*;
import java.io.*;

public class Solution {
	final static int MOD = 1000000007;
	final static int intMax = 1000000000;
	final static int intMin = -1000000000;
	final static int[] DX = { 0, 0, -1, 1 };
	final static int[] DY = { -1, 1, 0, 0 };

	static int T;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for(int t = 1; t <= T; ++t) {
			System.out.print("Case #" + t + ": ");
			String str = br.readLine();
			int[] arr = new int[str.length()];
			for(int i = 0; i != str.length(); ++i) {
				arr[i] = Integer.parseInt(str.substring(i, i+1));
			}
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i != arr[0]; ++i) {
				sb.append("(");
			}
			sb.append(arr[0]);
			for(int i = 1; i != arr.length; ++i) {
				if(arr[i] > arr[i - 1]) {
					for(int j = arr[i - 1]; j < arr[i]; ++j) {
						sb.append("(");
					}
				}
				else if(arr[i] < arr[i - 1]) {
					for(int j = arr[i]; j < arr[i - 1]; ++j) {
						sb.append(")");
					}
				}
				sb.append(arr[i]);
			}
			for(int i = 0; i != arr[arr.length - 1]; ++i) {
				sb.append(")");
			}
			System.out.print(sb.toString());
			if(t != T) System.out.println();
		}
		br.close();	
	}
}