import java.io.*;
import java.util.*;

public class Solution {
	static long x;
	static long y;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			x = Long.parseLong(st.nextToken());
			y = Long.parseLong(st.nextToken());
			
			String ans = find(0,0,0,"");
			bw.write("Case #" + t + ": " + ans+"\n");
		}


		bw.flush();
		br.close();
		bw.close();
	}
	
	public static String find(long a, long b, long step, String ans) {
		if(a == x && b == y) {
			return ans;
		}
		else {
			if(step>10) {
				return "IMPOSSIBLE";
			}
			else {
				String ans1 = find(a+(long)Math.pow(2, step),b, step+1, ans+"E");
				String ans2 = find(a-(long)Math.pow(2, step),b, step+1, ans+"W");
				String ans3 = find(a, b+(long)Math.pow(2, step), step+1, ans+"N");
				String ans4 = find(a, b-(long)Math.pow(2, step), step+1, ans+"S");
				
				if(!ans1.equals("IMPOSSIBLE")||!ans2.equals("IMPOSSIBLE")||!ans3.equals("IMPOSSIBLE")||!ans4.equals("IMPOSSIBLE")) {
					String m = findmin(ans1,ans2,ans3,ans4);
					return m;
					
				}
				else {
					return "IMPOSSIBLE";
				}
			}
		}
	}
	
	public static String findmin(String a1, String a2, String a3, String a4) {
		int ret = Integer.MAX_VALUE;
		String ans = "";
		
		if(!a1.equals("IMPOSSIBLE") && ret>a1.length()) {
			ret = a1.length();
			ans = a1;
		}
		if(!a2.equals("IMPOSSIBLE") && ret>a2.length()) {
			ret = a2.length();
			ans = a2;
		}
		if(!a3.equals("IMPOSSIBLE") && ret>a3.length()) {
			ret = a3.length();
			ans = a3;
		}
		if(!a4.equals("IMPOSSIBLE") && ret>a4.length()) {
			ret = a4.length();
			ans = a4;
		}
		return ans;
	}
}


