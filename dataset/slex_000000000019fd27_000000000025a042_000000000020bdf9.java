import java.util.*;
import static java.lang.Math.*; 
import static java.util.Arrays.*;

import java.io.FileInputStream;

import static java.lang.Character.*;
import static java.lang.Double.*;


public class Solution {

	Scanner scan = new Scanner(System.in);
	
	static class act implements Comparable<act>{
		int s, e, idx;
		act(int st, int en, int i){s=st;e=en;idx=i;}
		@Override
		public int compareTo(act arg0) {
			if(s!=arg0.s)return s - arg0.s;
			return 0;
		}
	}
	
	String solve() {
		int n = scan.nextInt();
		act[]A = new act[n];
		for(int i=0;i<n;i++) {
			A[i]=new act(scan.nextInt(), scan.nextInt(), i);
		}
		sort(A);
		int cc =-1;int cj=-1;
		char[]r = new char[n];
		for(act a:A) {
			if(a.s >=cc) {
				cc = a.e;
				r[a.idx]='C';
			}else if(a.s >=cj) {
				cj = a.e;
				r[a.idx]='J';
			}else {
				return "IMPOSSIBLE";
			}
		}
		return new String(r);
	}
	
	public static void main(String[] args) {
		Solution me = new Solution();
		try{
			Class.forName("SlexTemplate");
			String sample ="C.in";
			me.scan = new Scanner(new FileInputStream(sample));
		}catch (Exception e) {
			System.err.println(e);
		}
		int n = me.scan.nextInt();
		for(int i=1;i<=n;i++) {
			String res = me.solve();
			System.out.format("Case #%d: %s\n", i, res);
		}
	}
}
