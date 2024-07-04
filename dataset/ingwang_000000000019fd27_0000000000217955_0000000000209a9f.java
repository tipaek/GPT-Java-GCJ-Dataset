
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static class MyScanner {
		BufferedReader bf;
		StringTokenizer st;

		MyScanner() {
			bf = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(bf.readLine());
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}
	static StringBuilder answer;
	static String solve(String s) {
		int c= s.charAt(0)-'0';
		String result = new String();
		for(int i =0 ;i <c;i++) {
			result+="(";
		}
		result+=solver(s,0,0);
	
		return result;
	}
	
	
	private static String solver(String s, int idx, int repeat_count) {
	//	System.out.printf(" s=%s idx =%d repeat_count=%d\n",s,idx,repeat_count);
		String ret = s.substring(idx,idx+1);
		
		if(idx==s.length()-1) {
	//		System.out.println("ë");
			int r = s.charAt(idx)-'0';
			for(int i=0;i<r;i++) {
				ret+=")";
			}
			return ret;
		}
		
		if(s.charAt(idx+1)==s.charAt(idx)) {
	//		System.out.println("ê°™ìŒ");
			ret+=solver(s,idx+1,repeat_count+1);
		}
		else if(s.charAt(idx)>s.charAt(idx+1)) {
	//		System.out.println("ë‚´ê°€ ë’¤ë³´ë‹¤ ë” í¼");
			int diff= s.charAt(idx)-s.charAt(idx+1);
			for(int i =0 ;i <diff;i++) {
				ret+=")";
			}
			ret+=solver(s,idx+1,0);
		}
		else {
		//	System.out.println("ë‚´ê°€ ë’¤ë³´ë‹¤ ì‘ìŒ");
			int diff= -(s.charAt(idx)-s.charAt(idx+1));
			for(int i =0 ;i <diff;i++) {
				ret+="(";
			}
			ret+=solver(s,idx+1,0);
		}
	//	System.out.printf("ret=%s",ret);
		return ret;
	}


	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		int T=sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			String S = sc.next();
			
			answer = new StringBuilder();

			
			answer.append(solve(S));
			
			System.out.printf("Case #%d: %s\n",tc,answer.toString());
		}

	}

}
