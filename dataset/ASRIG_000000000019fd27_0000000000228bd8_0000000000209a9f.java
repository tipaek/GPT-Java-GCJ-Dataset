import java.io.*;
import java.util.*;

public class Solution {

	static class MyScanner{
		BufferedReader br;
		StringTokenizer st;
		
		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		public String next() { 
			while(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
	
	static int T;
	static Stack<Character> s;
	
	public static void main(String[] args) throws IOException{
		MyScanner sc = new MyScanner();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		
		T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			s = new Stack<>();
			char str[] = sc.br.readLine().toCharArray();
			int strLength = str.length;
			for(int i = 0; i < strLength; i++) {
				int strNum = str[i] - '0';
				if(i == 0) {
					for(int j = 0; j < strNum; j++) s.add('(');
					s.add(str[i]);
				}else {
					int a = s.peek() - '0', b = str[i] - '0';
					if(a > b) {
						for(int j = 0; j < a - b; j++) s.add(')');
						s.add(str[i]);
					}else if(a == b) {
						s.add(str[i]);
					}else {
						for(int j = 0; j < b - a; j++) s.add('(');
						s.add(str[i]);
					}
				}
				if(i == strLength-1) {
					int k = s.peek() - '0';
					for(int j = 0; j < k; j++) s.add(')');
				}
			}
			
			out.printf("Case #%d: ", tc);
			for(char k : s) {
				out.print(k);
			}out.println();
			out.flush();
		}
		
		
		
		
	}

}
