import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args){
		Kattio scan = new Kattio(System.in);
		int T = scan.getInt();
		
		for(int t = 1; t<= T; t++){
			String s = scan.getWord();
			StringBuilder out = new StringBuilder();
			int current = 0;
			for(int i = 0; i<s.length(); i++){
				int k = Integer.parseInt(""+s.charAt(i));
				if(k>current){
					for(int j = 0; j<k-current; j++){
						out.append("(");
					}
					out.append(k);
					current = k;
				} else if(k<current){
					for(int j = 0; j<current-k; j++){
						out.append(")");
					}
					out.append(k);
					current = k;
				}else{
					out.append(k);
				}
				
				
			}
			for(int j = 0; j<current; j++){
				out.append(")");
			}
			System.out.println("Case #" + t + ": " + out.toString());
			
		}
		
		
		
	}
	
	private static class Kattio extends PrintWriter {
		public Kattio(InputStream i) {
			super(new BufferedOutputStream(System.out));
			r = new BufferedReader(new InputStreamReader(i));
		}

		public Kattio(InputStream i, OutputStream o) {
			super(new BufferedOutputStream(o));
			r = new BufferedReader(new InputStreamReader(i));
		}

		public boolean hasMoreTokens() {
			return peekToken() != null;
		}

		public int getInt() {
			return Integer.parseInt(nextToken());
		}

		public double getDouble() {
			return Double.parseDouble(nextToken());
		}

		public long getLong() {
			return Long.parseLong(nextToken());
		}

		public String getWord() {
			return nextToken();
		}

		private BufferedReader r;
		private String line;
		private StringTokenizer st;
		private String token;

		private String peekToken() {
			if (token == null)
				try {
					while (st == null || !st.hasMoreTokens()) {
						line = r.readLine();
						if (line == null)
							return null;
						st = new StringTokenizer(line);
					}
					token = st.nextToken();
				} catch (IOException e) {
				}
			return token;
		}

		private String nextToken() {
			String ans = peekToken();
			token = null;
			return ans;
		}
	}


}
