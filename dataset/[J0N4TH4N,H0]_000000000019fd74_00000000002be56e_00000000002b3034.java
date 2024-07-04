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
			out.print("Case #" + (i+1) + ": ");
			st = new StringTokenizer(f.readLine());
			int N = Integer.parseInt(st.nextToken());
			ArrayList<String> starts = new ArrayList<String>();
			ArrayList<String> ends = new ArrayList<String>();
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(f.readLine());
				String curr = st.nextToken();
				starts.add(curr.substring(0, curr.indexOf('*')));
				ends.add(curr.substring(curr.indexOf('*')+1));
			}
			Collections.sort(starts, Comparator.comparing(String::length));
			Collections.sort(ends, Comparator.comparing(String::length));
			boolean works = true;
			for (int j = 0; j < N-1; j++) {
				works = works && starts.get(N-1).startsWith(starts.get(j));
			}
			for (int j = 0; j < N-1; j++) {
				works = works && ends.get(N-1).endsWith(ends.get(j));
			}
			
			if (works) {
				out.println(starts.get(N-1)+""+ends.get(N-1));
			} else {
				out.println("*");
			}
		}
		
		out.close();
	}
}


