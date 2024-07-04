import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
	
	static class Pair {
		int s;
		int e;
		int i;
		Pair(int s, int e, int i) {
			this.s = s;
			this.e = e;
			this.i = i;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int n;
		
		
		for (int t = 1; t <= T; ++t) {
			n = sc.nextInt();
			Pair[] p = new Pair[n];
			
			for(int i=0; i<n; ++i) {
				p[i] = new Pair(sc.nextInt(), sc.nextInt(), i);
			}
			
			Arrays.sort(p, new Comparator<Pair>() {

				@Override
				public int compare(Pair o1, Pair o2) {
					// TODO Auto-generated method stub
					return o1.s - o2.s;
				}});
			
			int jl = 0;
			int cl = 0;
			
			char[] ch = new char[n];
			boolean possible = true;
			
			for(int i=0; i<n; ++i) {
				if(cl <= p[i].s) {
					ch[p[i].i] = 'C';
					cl = p[i].e;
				}
				else if(jl <= p[i].s) {
					ch[p[i].i] = 'J';
					jl = p[i].e;
				}
				else {
					possible = false;
					break;
				}
			}
			
			String s = possible?
					new String(ch):
					"IMPOSSIBLE";		
			System.out.println(String.format("Case #%d: %s", t, s));
		}
	}
}
