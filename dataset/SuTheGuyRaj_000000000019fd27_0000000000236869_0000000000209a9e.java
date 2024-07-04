import java.io.*;
import java.util.*;

public class QualEsab {
	public static int next(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}

	static int T, B;
	static BufferedReader sc;
	static ArrayList<Clump> c;
	static int[] ans;
	public static void main(String[] args) throws Exception {
		sc = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(sc.readLine());
		T = next(st); B = next(st);
		ans = new int[B];
		for(int tt = 0; tt < T; tt++) {
			c = new ArrayList<Clump>();
			for(int i = 0; i < B/2; i+=5) {
				int len = Math.min(5, B/2 + B%2 - i + 1);
				Clump newC = new Clump(i, len);
				for(int e = i; e < B/2 + B%2 && e-i < 5; e++) {
					Pair p = get(e);
					newC.insertPair(e-i, p);
				}
				c.add(newC);
			}
			for(Clump cl : c) checkClump(cl);
			for(Clump cl : c) {
				for(Pair p : cl.pairs) {
					if(p != null) {
						ans[p.ind] = p.one ? 1 : 0;
						ans[B-p.ind-1] = p.one ^ p.same ? 0 : 1;
					}
				}
			}
			for(int i = 0; i < B; i++) {
				System.out.print(ans[i]);
			}
			System.out.println();
			System.out.flush();
			String s = sc.readLine();
			if(!s.equals("Y")) System.exit(0);
		}
		
		sc.close();
	}
	
	public static void checkClump(Clump c) throws Exception{
		if(!c.same.isEmpty()) {
			Pair p = c.pairs[c.same.get(0)];
			System.out.println(p.ind+1);
			System.out.flush();
			int o = Integer.parseInt(sc.readLine());
			if((o == 1) ^ p.one) {
				for(int ind : c.same) {
					c.pairs[ind].one = !c.pairs[ind].one;
				}
			}
		}
		if(!c.diff.isEmpty()) {
			Pair p = c.pairs[c.diff.get(0)];
			System.out.println(p.ind+1);
			System.out.flush();
			if((Integer.parseInt(sc.readLine()) == 1) ^ p.one) {
				for(int ind : c.diff) {
					c.pairs[ind].one = !c.pairs[ind].one;
				}
			}
		}
	}
	
	public static Pair get(int ind) throws Exception {
		System.out.println(ind+1);
		System.out.flush();
		boolean one = Integer.parseInt(sc.readLine()) == 1;
		System.out.println(B-ind);
		System.out.flush();
		boolean same = (Integer.parseInt(sc.readLine()) == 1) == one;
		return new Pair(ind, same, one);
	}
	
	static class Pair{
		int ind;
		boolean same, one;
		
		public Pair(int ii, boolean ss, boolean oo) {
			ind = ii;
			same = ss;
			one = oo;
		}
	}
	
	static class Clump{
		Pair[] pairs;
		int ind;
		ArrayList<Integer> same;
		ArrayList<Integer> diff;
		
		public Clump(int ii) {
			this(ii, 5);
		}
		
		public Clump(int ii, int len) {
			same = new ArrayList<Integer>();
			diff = new ArrayList<Integer>();
			ind = ii;
			pairs = new Pair[len];
		}
		
		public void insertPair(int i, Pair p) {
			pairs[i] = p;
			if(p.same) same.add(i);
			else       diff.add(i);
		}
	}
}