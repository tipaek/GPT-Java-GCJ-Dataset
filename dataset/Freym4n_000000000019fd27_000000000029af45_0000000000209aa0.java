import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;


public class Solution {

	static class FastReader {
		BufferedReader bf;
		StringTokenizer st;

		public FastReader()  {
			bf = new BufferedReader(new InputStreamReader(System.in));
			//bf = new BufferedReader(new FileReader("p.txt"));
		}

		String next() {
			while(st == null || !st.hasMoreElements())
				try {
					st = new StringTokenizer(bf.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		int nextInt()  {
			return Integer.parseInt(next());
		}
		long nextLong()  {
			return Long.parseLong(next());
		}
		double nextDouble()  {
			return Double.parseDouble(next());
		}
		String nextLine() throws IOException {
			return bf.readLine();
		}
		boolean ready() throws IOException {
			return bf.ready() || (st != null && st.hasMoreElements());
		}
	}

	static int m[][];
	static int n,k;
	static int diag[];
	static int dif[][];

	static void make_dif() {
		for(int i = 0; i < n; i++) {
			for(int j = i+1; j < n; j++) {
				dif[i][j] = gen_dif(i,j);
			}
		}
	}

	static int[] random_change() {
		int a = (int) Math.ceil( (Math.random()* (double) n))-1; 
		int b = a;
		while (b == a) {
			b = (int) Math.ceil( (Math.random()* (double) n))-1;
		}
		int r[] = {a,b};
		return r;
	}

	static int gen_dif(int x, int y) {
		return (m[x][y] + m[y][x]) - (m[x][x] + m[y][y]);
	}

	static boolean solve1() {
		int d = k/n;
		m = new int[n][n];
		dif = new int[n][n];
		diag = new int[n*2 - 1];
		diag[n/2] = d;
		boolean v[] = new boolean[n+1];
		v[d] = true;
		int cont = 1;
		for(int i = 0; i < n-1; i++) {
			if (v[cont]) cont++;
			diag[i] = diag[i+n] = cont;
			cont++;
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				m[i][n-j-1] = diag[i+j];
				if (m[i][n-j-1] == 0) m[i][n-j-1] = d;
			}
		}
		int target = d*n;
		int min = k*k,ans;
		int x = 0, y = 0,t;
		int rep = 0;
		int arr[];
		int ch[];
		while (target != k && rep <= 250) {
			make_dif();
			min = k*k;
			t = 0;
			ans = 0;
			for(int i = 0; i < n ; i++) {
				for(int j = i+1; j < n; j++) {
					t = (Math.abs(k - target - dif[i][j]));
					if ( min > t) {
						min = t;
						x = i;
						y = j;
						ans = dif[i][j];
					}
				}
			}
			arr = m[x];
			m[x] = m[y];
			m[y] = arr;
			target += ans;
			rep++;
		}
		if (rep > 250) return false;

		return true;

	}

	static Queue<Integer> gen_queue(int a) {
		boolean v[] = new boolean[n+1];
		Queue<Integer> q=  new LinkedList<Integer>();
		v[a] = true;
		for(int i = 1; i <=n; i++) {
			if (v[i]) continue;
			q.add(i);
		}
		return q;
	}

	static boolean solve2() {
		int m1, m2;
		if (n < 4) return false;
		m1 = n/2;
		m2 = n/2 + ((n&1)== 1?1:0);
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if (i*m1 + j*m2 == k) {
					solve2(i,j);
					return true;
				}
			}
		}
		return false;
	}

	static void special_case() {
		int temp[][] = {{2,1,3,4},{1,3,4,2},{4,2,1,3},{3,4,2,1}};
		m = temp;
	}

	static void solve2(int a, int b) {
		int id[] = new int[n+1];	
		id[1] = a;
		id[2] = b;
		m = new int[n][n];
		Set<Integer> s[] = new HashSet[n];
		for(int i = 0; i < n; i++) {
			s[i] = new HashSet<Integer>();
		}
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 0; i < n/2; i++) {
			m[i][i] = 1;
			s[i].add(1);
		}
		for(int i = n/2; i < n; i++) {
			m[i][i] = 2;
			s[i].add(2);
		}
		int top;
		for(int i = 0; i < n; i++) {
			q = gen_queue(i< n/2?1:2);
			for(int j = n-1; j >= 0; j--) {
				if (m[i][j] != 0) continue;
				top =q.poll();
				while (s[j].contains(top)) {
					q.add(top);
					top = q.poll();
				}
				m[i][j] = top;
				s[j].add(top);
			}
		}
		Set<Integer> set = new HashSet<Integer>();
		set.add(a);
		set.add(b);
		int cont  = 1;
		for(int i = 1; i <= n; i++) {
			if (id[i]!=0) continue;
			while (set.contains(cont)) cont ++;
			id[i]= cont;
			set.add(cont);
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				m[i][j] = id[m[i][j]];
			}
		}
	}

	static void output(int c, boolean r) {
		System.out.print("Case #" + c + ": ");

		if (r) {
			System.out.println("POSSIBLE");
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					System.out.print(m[i][j]);
					if (j < n - 1) System.out.print(" ");
				} System.out.println();
			}
		} else {
			System.out.println("IMPOSSIBLE");
		}
	}

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		int t = fr.nextInt();
		boolean p;
		for(int c = 1; c <= t; c++) {
			n = fr.nextInt();
			k = fr.nextInt();
			p = solve1();
			if (n == 4 && k == 7) {
				special_case();
				output(c,true);
			} else if (p) {
				output(c,true);
			} else {
				p = solve2();
				if (p) {
					output(c,true);
				} else {
					output(c,false);
				}

			}
		}
	}
}
