import java.util.*;
import static java.lang.Math.*; 
import static java.util.Arrays.*;

import java.io.FileInputStream;

import static java.lang.Character.*;
import static java.lang.Double.*;


public class Solution {

	Scanner scan = new Scanner(System.in);
	
	
	String solve() {
		StringBuffer sb = new StringBuffer();
		int n = scan.nextInt();
		String[]A = new String[n];
		for(int i=0;i<A.length;i++)A[i]=scan.next();
		String pref="";
		String suf="";
		for(String s:A) {
			if(s.charAt(0)!='*') {
				String p = s.substring(0, s.indexOf('*'));
				if(p.length()>pref.length()) {
					if(!p.startsWith(pref))return "*";
					pref = p;
				} else {
					if(!pref.startsWith(p))return "*";
				}
			}
			if(s.charAt(s.length()-1)!='*') {
				String p = s.substring(s.lastIndexOf('*')+1);
				if(p.length()>suf.length()) {
					if(!p.endsWith(suf))return "*";
					suf = p;
				}else {
					if(!suf.endsWith(p))return "*";
				}
			}
		}
		sb.append(pref);
		for(String s:A) {
			if(s.indexOf('*')==s.lastIndexOf('*'))continue;
			String mid = s.substring(s.indexOf('*')+1, s.lastIndexOf('*'));
			mid = mid.replace("*", "");
			sb.append(mid);
		}
		sb.append(suf);
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Solution me = new Solution();
		try{
			Class.forName("SlexTemplate");
			String sample =me.getClass().getName()+".in";
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
