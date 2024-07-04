import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		for(int i = 1; i <= t; i++){
			int n = sc.nextInt();
			Event[] e = new Event[n];
			String res = "";
			Event c = null;
			Event j = null;
			for(int l = 0; l < n; l++) {
				e[l] = new Event(sc.nextInt(), sc.nextInt());
			}
			Arrays.sort(e);
			for(int l = 0; l < n; l++) {
				int start = e[l].s;
				char chosen = ' ';
				if(c != null && c.e <= start) c = null;
				if(j != null && j.e <= start) j = null;
				if(c != null) {
					if(j != null) {
						res = "IMPOSSIBLE";
						break;
					}
					else {
						j = e[l];
						chosen = 'J';
					}
				}
				else {
					c = e[l];
					chosen = 'C';
				}
				res += chosen;
			}
			System.out.println("Case #" + i + ": " + res);
		}
	}
	static class Event implements Comparable<Event>{
		int s, e;
		public Event(int s, int e) {
			this.s = s;
			this.e = e;
		}
		public int compareTo(Event o){
			if(s == o.s) return e-o.e;
			return s-o.s;
		}
	}
}