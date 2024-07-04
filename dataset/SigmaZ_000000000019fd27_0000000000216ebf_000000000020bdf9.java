import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		for(int ts = 0; ts < tc; ts++) {
			int n = in.nextInt();
			Pair p[] = new Pair[n];
			for(int i = 0; i < n; i++)
				p[i] = new Pair(in.nextInt(), in.nextInt(), i);
			Arrays.parallelSort(p);
			int t[] = new int[2];
			int j[] = new int[n];
			boolean ch = false;
			System.out.print("Case #" + (ts + 1) + ": ");
			for(int i = 0; i < n; i++) {
				if(t[0] <= p[i].a) {
					j[p[i].c] = 1;
					t[0] = p[i].b;
				} else if(t[1] <= p[i].a) {
					j[p[i].c] = 2;
					t[1] = p[i].b;
				} else {
					System.out.print("IMPOSSIBLE");
					ch = true;
					break;
				}
			}
			if(!ch)
				for(int i = 0; i < n; i++) {
					if(j[i] == 1)
						System.out.print("C");
					else
						System.out.print("J");
				}
			System.out.println();
		}
		in.close();
	}
	
	public static class Pair implements Comparable<Pair>{
		
		int a, b, c;
		
		public Pair(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public int compareTo(Pair o) {
			return a - o.a;
		}
		
		
	}

}
