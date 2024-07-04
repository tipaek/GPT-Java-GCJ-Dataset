import java.util.*;

public class Solution {
	static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 1; i <= t; ++i) {
			System.out.print("Case #" + i + ": ");
			solve();
		}
	}
	static void solve() {
		int n = sc.nextInt();
		sc.nextLine();
		String start = "", mid = "", end = "";
		int fl = 0;
		for(int i = 0; i < n; ++i) {
			String cur = sc.nextLine();
			if(fl == 1)continue;
			int sz = cur.length();
			char st = cur.charAt(0), en = cur.charAt(sz-1);
			if(st == '*' && en == '*') {
				mid += cur.replace("*", "");
			}else {
				int si = -1, ei = -1;
				for(int j = 0; j < sz; ++j) {
					if(cur.charAt(j) == '*')ei = j;
				}
				for(int j = 0; j < sz; ++j) {
					if(cur.charAt(j) == '*') {
						si = j;
						break;
					}
				}
				mid += cur.substring(si, ei).replace("*","");
				if(ei != sz-1) {
					String ce = cur.substring(ei+1);
					if(suff(end, ce)) {
						if(end.length()<ce.length())end = ce;
					}else fl = 1;
				}
				if(si != 0) {
					String cs = cur.substring(0, si);
					if(pre(start, cs)) {
						if(start.length()<cs.length())start = cs;
					}else fl = 1;
				}
			}
		}
		if(fl == 1)System.out.println("*");
		else System.out.println(start + mid + end);
	}
	static boolean pre(String a, String b) {
		int sz = Math.min(a.length(), b.length());
		for(int i = 0; i < sz; ++i) {
			if(a.charAt(i) != b.charAt(i))return false;
		}
		return true;
	}
	static boolean suff(String a, String b) {
		int sz = Math.min(a.length(), b.length());
		a = rev(a);
		b = rev(b);
		for(int i = 0; i < sz; ++i) {
			if(a.charAt(i) != b.charAt(i))return false;
		}
		return true;
	}
	static String rev(String s) {
		String ans = "";
		int sz = s.length();
		for(int i = 0; i < sz; ++i) {
			ans += s.charAt(sz-i-1);
		}
		return ans;
	}
}
