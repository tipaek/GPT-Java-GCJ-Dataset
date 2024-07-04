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
				out.println("1 1");
				out.println("2 1");
				out.println("3 2");
				out.println("3 1");
				for (int j = 4; j < N-1; j++) {
					out.println(j + " " + 1);
				}
			}
		}
		
		out.close();
	}
}


