import java.util.*;
public class Solution {
	
	public static String close(int n) {
		String ans = "";
		for(int i = 0 ; i < n ; i++) {
			ans += ")";
		}
		return ans;
	}
	
	public static String start(int n) {
		String ans = "";
		for(int i = 0 ; i < n ; i++) {
			ans += "(";
		}
		return ans;
	}

	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for(int l = 0 ; l < t ; l++) {
			String q = s.next();
			int o = 0;
			int n = Integer.valueOf(q.charAt(0) + "");
			String ans = start(n) + q.charAt(0);
			o += n;
			for(int i = 1 ; i < q.length() ; i++) {
				int a = Integer.valueOf(q.charAt(i - 1) + "");
				int b = Integer.valueOf(q.charAt(i) + "");
				if(b < a) {
					int d = a - b;
					ans += close(d);
					o -= d;
					ans += q.charAt(i);
				}else if(b > a) {
					int d = b - a;
					ans += start(d);
					o += d;
					ans += q.charAt(i);
				}else {
					ans += q.charAt(i);
				}
			}
			ans += close(o);
			System.out.println("Case #" + (l + 1) + ":" + " " + ans);
		}
	}
}