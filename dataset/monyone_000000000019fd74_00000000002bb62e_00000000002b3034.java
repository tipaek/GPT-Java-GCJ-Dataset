import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
	
	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			final int T = sc.nextInt();
			
			LOOP:
			for(int tt = 0; tt < T; tt++){
				final int N = sc.nextInt();
			
				final String[] strs = new String[N];
				for(int i = 0; i < N; i++) {
					strs[i] = sc.next();
				}
				
				String[] fsts = new String[N];
				String[] lsts = new String[N];
				
				StringBuilder answer_part = new StringBuilder();
				
				for(int i = 0; i < N; i++) {
					int count = 0;
					for(int j = 0; j < strs[i].length(); j++) {
						if(strs[i].charAt(j) == '*') { count++; }
					}
					
					int c = 0;
					StringBuilder fst = new StringBuilder();
					StringBuilder part = new StringBuilder();
					StringBuilder lst = new StringBuilder();
					
					for(int j = 0; j < strs[i].length(); j++) {
						if(strs[i].charAt(j) == '*') {
							c++;
							continue;
						}
						
						if(c >= count) {
							lst.append(strs[i].charAt(j));
						}else if(c == 0) {
							fst.append(strs[i].charAt(j));
						}else {
							part.append(strs[i].charAt(j));
						}
						
						fsts[i] = fst.toString();
						lsts[i] = lst.toString();
					}
					
					answer_part.append(part);
				}
				
				String answer_fst = null, answer_lst = null;
				
				FST:
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++) {
						if(!fsts[i].startsWith(fsts[j])) { continue FST; }
					}
					
					answer_fst = fsts[i];
				}
				
				LST:
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++) {
						if(!lsts[i].endsWith(lsts[j])) { continue LST; }
					}
					
					answer_lst = lsts[i];
				}
				
				String answer = null;
				if(answer_fst == null || answer_lst == null) {
					answer = null;
				}else {
					answer = answer_fst + answer_part.toString() + answer_lst;
				}
				System.out.printf("Case #%d: %s\n", tt + 1, answer != null ? answer : "*");
			}
		}
	}
	
	public static class Scanner implements Closeable {
		private BufferedReader br;
		private StringTokenizer tok;
		
		public Scanner(InputStream is) {
			br = new BufferedReader(new InputStreamReader(is));
		}
 
		private void getLine() {
			try {
				while (!hasNext()) {
					tok = new StringTokenizer(br.readLine());
				}
			} catch (IOException e) { /* ignore */
			}
		}
 
		private boolean hasNext() {
			return tok != null && tok.hasMoreTokens();
		}
 
		public String next() {
			getLine();
			return tok.nextToken();
		}
 
		public int nextInt() {
			return Integer.parseInt(next());
		}
 
		public long nextLong() {
			return Long.parseLong(next());
		}
 
		public double nextDouble() {
			return Double.parseDouble(next());
		}
 
		public void close() {
			try {
				br.close();
			} catch (IOException e) { /* ignore */
			}
		}
	}
}
