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
				
				String answer_fst = null;
				String answer_part = null;
				String answer_lst = null;
				
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
					}

					/*
					System.out.println(fst);
					System.out.println(part);
					System.out.println(lst);
					*/
					
					if(answer_fst == null) {
						answer_fst = fst.toString();
					}else if(answer_fst.contains(fst.toString())){
						//
					}else if(fst.toString().contains(answer_fst)) {
						answer_fst = fst.toString();
					}else {
						answer_fst = null;
						break;
					}
					
					if(answer_lst == null) {
						answer_lst = lst.toString();
					}else if(answer_lst.contains(lst.toString())){
						
					}else if(lst.toString().contains(answer_lst)) {
						answer_lst = lst.toString();
					}else {
						answer_lst = null;
						break;
					}
				}
				
				String answer = null;
				if(answer_fst != null) { answer = answer_fst.toString(); }
				if(answer_lst != null) { answer += answer_lst.toString(); }
				
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
