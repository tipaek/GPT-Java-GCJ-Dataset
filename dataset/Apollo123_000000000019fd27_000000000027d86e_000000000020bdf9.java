import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args){
		Kattio scan = new Kattio(System.in);
		int T = scan.getInt();
		
		for(int t = 1; t<=T; t++){
			ArrayList<Item> list = new ArrayList<>();
			int n = scan.getInt();
			
			for(int i = 0; i<n; i++){
				int s= scan.getInt();
				int e = scan.getInt();
				Item item = new Item(s, e, i);
				list.add(item);
			}
			
			
			int J = 0;
			int C = 0;
			int[] out = new int[n];
			Collections.sort(list, (a,b)->a.start-b.start);
			boolean impossible = false;
			for(int i = 0; i<list.size(); i++){
				Item item = list.get(i);
				if(item.start>=J){
					J = item.end;
					out[item.order] =0; 
				} else if(item.start>=C){
					C = item.end;
					out[item.order] =1; 
				}else{
					impossible = true;
					break;
				}
				
				
			}
			
			if(impossible){
				System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
			}else{
				StringBuilder o = new StringBuilder();
				for(int i = 0; i<n; i++){
					if(out[i] == 0){
						o.append("J");
					}else{
						o.append("C");
					}
				}
				System.out.println("Case #" + t + ": " + o.toString());
			}
			
			
		}
		
		
		
	}
	
	private static class Item{
		int start;
		int end;
		int order;
		
		Item(int s, int e, int i){
			start = s;
			end = e;
			order = i;
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
