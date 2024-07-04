import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		
//		BufferedReader f = new BufferedReader(new  FileReader (new  File("sample.txt")));	
//		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sample.txt")));
//		StringTokenizer st = new StringTokenizer(f.readLine());

		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));	
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < T; i++) {
			out.println("Case #" + (i+1) + ":");
			st = new StringTokenizer(f.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			if (N <= 500) {
				for (int j = 1; j <= N; j++) {
					out.println(j + " " + 1);
				}
			} else {
				int row = binarySearch(0, N, N);
				for (int j = 0; j < row; j++) {
					out.println((j+1) + " " + 1);
				}
				
				for (int j = 1; j <= row+1; j++) {
					out.println((row+1) + " " + j);
				}
				
				int r = row+2;
				for (int j = (int)(Math.pow(2, row)+row); j < N; j++) {
					out.println(r + " " + r);
					r++;
				}
			}
		}
		
		out.close();
	}
	
	public static int binarySearch(int low, int high, int N) {
//		System.out.println(low + " " + high);
		if (high >= low) {
			int mid = low+(high-low)/2;
			if (Math.pow(2, mid)+mid==N) {
				return mid;
			}
			
			if (Math.pow(2, mid)+mid > N) {
				return binarySearch(low, mid-1, N);
			}
			
			return binarySearch(mid+1, high, N);
		}
		return high;
	}
}


