import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		for(int i = 1; i <= t; i++){
			int n = sc.nextInt();
			Event[] e = new Event[n];
			char[] a = new char[n];
			String res = "";
			boolean impossible = false;
			Event c = null;
			Event j = null;
			for(int l = 0; l < n; l++) {
				e[l] = new Event(sc.nextInt(), sc.nextInt(), l);
			}
			Arrays.sort(e);
			for(int l = 0; l < n; l++) {
				int start = e[l].s;
				boolean cs = false;
				if(c != null && c.e <= start) c = null;
				if(j != null && j.e <= start) j = null;
				if(c != null) {
					if(j != null) {
						res = "IMPOSSIBLE";
						impossible = true;
						break;
					}
					else {
						j = e[l];
					}
				}
				else {
					c = e[l];
					cs = true;
				}
				if(cs) a[c.i] = 'C';
				else   a[j.i] = 'J';
			}
			if(!impossible){
				for(int l = 0; l < n; l++) {
					res += a[l];
				}
			}
			System.out.println("Case #" + i + ": " + res);
		}
	}
	static class Event implements Comparable<Event>{
		int s, e, i;
		public Event(int s, int e, int i) {
			this.s = s;
			this.e = e;
			this.i = i;
		}
		public int compareTo(Event o){
			if(s == o.s) return e-o.e;
			return s-o.s;
		}
	}
}