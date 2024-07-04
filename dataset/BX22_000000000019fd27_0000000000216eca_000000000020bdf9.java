import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			activity [] sch=new activity [n];
			for (int j=0; j<n; j++) {
				int a=in.nextInt ();
				int b=in.nextInt ();
				sch[j]=new activity (a, b, j);
			}
			String [] fin=new String [n];
			for (int k=0; k<n; k++) fin[k]="";
			process (sch);
			for (int l=0; l<n; l++) {
				fin[sch[l].id]=sch[l].person;
			}
			StringBuilder sb=new StringBuilder ();
			for (String k: fin) sb.append (k); 
			if (sb.length()==n)
				System.out.println("Case #" + i + ": "+sb.toString());
			else {
				System.out.println("Case #" + i + ": IMPOSSIBLE");
			}
		}
	}
	public static void process (activity [] sch) {
		Arrays.sort (sch);
		int cEnd=-1;
		int jEnd=-1;
		for (int i=0; i<sch.length; i++) {
			activity act=sch[i];
			if (cEnd<=act.s) cEnd=-1;
			if (jEnd<=act.s) jEnd=-1;
			if (cEnd==-1) {
				cEnd=act.e;
				sch[i].person="C";
			}
			else if (jEnd==-1) {
				jEnd=act.e;
				sch[i].person="J";
			}
			else {
				break;
			}
		}
	}
	static class activity implements Comparable <activity> {
		int s;
		int e;
		int id;
		String person="";
		public activity (int a, int b, int c) {
			s=a;
			e=b;
			id=c;
		}
		public int compareTo(activity o) {
			return this.s-o.s;
		}
	}
}