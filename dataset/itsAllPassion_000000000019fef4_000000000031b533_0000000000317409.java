import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) {
		InputStream in = System.in;
		InputReader scan = new InputReader(in);
		int test = scan.nextInt();
		for(int t=1;t<=test;t++) {
			StringBuilder sb = new StringBuilder();
			sb.append("Case #").append(t).append(": ");
			int x = scan.nextInt();
			int y = scan.nextInt();
			String str = scan.next();
			int m = str.length();
			int traversed = 0;
			int ans = -1;
			int currX = x;
			int currY = y;
			for(int i=0;i<m;i++) {
				if(str.charAt(i)=='E') {
					currX++;
				} else if (str.charAt(i)=='W') {
					currX--;
				} else if (str.charAt(i)=='N') {
					currY++;
				} else if (str.charAt(i)=='S') {
					currY--;
				} 
				traversed++;
				if((Math.abs(currX)+Math.abs(currY))<=traversed) {
					ans = traversed;
					break;
				}
				
			}
			if((currX+currY)<=traversed) {
				ans = traversed;
			}
			if(ans==-1) {
				sb.append("IMPOSSIBLE");
			} else {
				sb.append(ans);
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
