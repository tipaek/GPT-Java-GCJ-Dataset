import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) {
		InputStream in = System.in;
		InputReader scan = new InputReader(in);
		int test = scan.nextInt();
		for(int t=1;t<=test;t++) {
			ArrayList<ArrayList<Integer>> timeOpenIndices = new ArrayList<>();
			for(int i=0;i<=(24*60);i++) {
				timeOpenIndices.add(new ArrayList<>());
			}
			int n = scan.nextInt();
			int[][] openClose = new int[n][2];
			for(int i=0;i<n;i++) {
				int start = scan.nextInt();
				int end = scan.nextInt();
				openClose[i][0] = start;
				openClose[i][1] = end;
				timeOpenIndices.get(start).add(i);
			}
			char[] answer = new char[n];
			boolean possible = true;
			int jamieAssignedIndex = -1;
			int cameronAssignedIndex = -1;
			loop1:for(int time=0;time<=(24*60);time++) {
				if(jamieAssignedIndex!=-1) {
					if(openClose[jamieAssignedIndex][1]==time) {
						jamieAssignedIndex = -1;
					}
				}
				if (cameronAssignedIndex != -1) {
					if (openClose[cameronAssignedIndex][1] == time) {
						cameronAssignedIndex = -1;
					}
				}
				for(int index : timeOpenIndices.get(time)) {
					if(jamieAssignedIndex==-1) {
						jamieAssignedIndex = index;
						answer[index] = 'J';
					} else if(cameronAssignedIndex==-1) {
						cameronAssignedIndex = index;
						answer[index] = 'C';
					} else {
						possible = false;
						break loop1;
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("Case #").append(t).append(": ");
			if(possible) {
				for(int i=0;i<n;i++) {
					sb.append(answer[i]);
				}
			} else {
				sb.append("IMPOSSIBLE");
			}
			System.out.println(sb.toString());
		}
	}
	
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
		
		public long nextLong() {
			return Long.parseLong(next());
		}
	}
}
