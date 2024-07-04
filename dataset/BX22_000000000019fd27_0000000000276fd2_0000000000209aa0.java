import java.util.*;
import java.io.*;
/*
 * permutation and combination afterwards
 */
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int trace = in.nextInt();
			ArrayList <String> choose=new ArrayList <String> ();
			for (int j=1; j<=n; j++) {
				choose.add(String.valueOf(j));
			}
			ArrayList <String> perms=new ArrayList <String> ();
			perm (perms, choose, "", n);
			ArrayList <String> ans=new ArrayList <String> ();
			var ("", n, trace, perms, ans, false);
			if (ans.size()==0) {
				System.out.println("Case #" + i + ": IMPOSSIBLE");
			}
			else {
				System.out.println("Case #" + i + ": POSSIBLE");
				String psb=ans.get(0);
				for (int k=0; k<psb.length(); k++) {
					String tp=perms.get(Integer.parseInt(String.valueOf(psb.charAt(k))));
					for (int m=0; m<tp.length(); m++) {
						System.out.print (tp.charAt(m)+" ");
					}
					System.out.println ();
				}
			}
		}
	}
	public static void perm (ArrayList <String> perms, ArrayList <String> choose, String construction, int max) {
		if (construction.length()==max) {
			perms.add(construction);
		}
		else {
			for (int i=0; i<choose.size(); i++) {
				construction+=choose.remove(i);
				perm (perms, choose, construction, max);
				choose.add(i, Character.toString(construction.charAt (construction.length()-1)));
				construction=construction.substring(0, construction.length()-1);
			}
		}
	}
	public static void var (String cons, int length, int trace, ArrayList <String> perms, ArrayList <String> ans, boolean terminate) {
		if (!terminate&&cons.length()==length) {
			int ttl=0;
			for (int i=0; i<cons.length(); i++) {
				int index=Integer.parseInt(String.valueOf(cons.charAt(i)));
				int val=Integer.parseInt(String.valueOf (perms.get(index).charAt (i)));
				ttl+=val;
			}
			if (ttl==trace) {
				ans.add (cons);
				terminate=true;
			}
		}
		else {
			for (int i=0; i<perms.size(); i++) {
				if (check (cons, perms, i)) {
					String k=cons+String.valueOf (i);
					var (k, length, trace, perms, ans, terminate);
				}
			}
		}
	}
	public static boolean check (String cons, ArrayList <String> perms, int index) {
		String str=perms.get(index);
		for (int i=0; i<cons.length(); i++) {
			int tp=Integer.parseInt(String.valueOf(cons.charAt(i)));
			String comp=perms.get(tp);
			for (int j=0; j<comp.length(); j++) {
				if (comp.charAt(j)==str.charAt(j)) return false;
			}
		}
		return true;
	}

}