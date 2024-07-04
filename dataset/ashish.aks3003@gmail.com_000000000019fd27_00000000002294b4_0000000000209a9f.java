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
		int t = scan.nextInt();
		for(int i = 0; i<t; i++) {
			String str = scan.next();
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int j=0; j<str.length(); j++) {
					list.add(str.charAt(j) - '0');
			}
			StringBuilder res = new StringBuilder();
			for(int k=0; k<list.get(0);k++)
				res.append("(");
			res.append(list.get(0));
			for(int j=1; j<list.size(); j++) {
				int curr = list.get(j);
				int prev = list.get(j-1);
				if(curr>prev) {
					for(int k=0; k<(curr-prev); k++)
						res.append("(");
				}else if(prev>curr) {
					for(int k=0; k<(prev-curr); k++)
						res.append(")");
				}
				res.append(curr);
			}
			for(int k=0; k<list.get(list.size()-1); k++)
				res.append(")");
			System.out.println("Case #"+(i+1)+": "+res);
		}
		
	}
	
	static class InputReader{
		BufferedReader br;
		StringTokenizer st;
		public InputReader(InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));			
		}
		
		String next(){
			while(st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
