import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

	static class FastReader {
		BufferedReader bf;
		StringTokenizer st;

		public FastReader()  {
			bf = new BufferedReader(new InputStreamReader(System.in));
			//bf = new BufferedReader(new FileReader("input.txt"));
		}

		String next() {
			while(st == null || !st.hasMoreElements())
				try { st = new StringTokenizer(bf.readLine());
				} catch (IOException e) { e.printStackTrace(); }
			return st.nextToken();
		}

		int nextInt()  { return Integer.parseInt(next()); }

		long nextLong()  { return Long.parseLong(next()); }

		double nextDouble()  { return Double.parseDouble(next()); }

		String nextLine() throws IOException { return bf.readLine(); }

		boolean ready() throws IOException { return bf.ready(); }

		void close() throws IOException {	bf.close(); }
	}

	public static void main(String[] args) throws IOException  {
		FastReader fr = new FastReader();
		Solution m = new Solution();
		m.solve(fr);
		fr.close();
	}

	class Pair implements Comparable<Pair> {
		int x, y;

		public int compareTo(Pair arg0) {
			if (this.x == arg0.x)
				return (this.y - arg0.y);//*(-1);
			return (this.x - arg0.x);//*(-1);
		}

		public Pair(int id, int w) {
			this.x = id;
			this.y = w;
		}

		public String toString() {	
			return "( "+x+" , "+y+" )"; 
		}
	}

	boolean match(int a, int b) {
		if ((a+b)%2 == 0) return false;
		if (a == 0) {
			return (b&(b+1)) == 0;
		}
		if (b == 0) {
			return (a&(a+1)) == 0;
		}
		while (a > 0 || b > 0) {
			if (((a&1)^(b&1)) == 0) {
				return false;
			}
			a>>=1;
			b>>=1;
		} return true;
	}

	public void solve(FastReader fr) throws IOException {
		int t = fr.nextInt();
		int x, y,nx,ny,tx,ty;
		StringBuilder r;
		for(int c = 1; c <= t;c++) {
			x = fr.nextInt();
			tx = x;
			y = fr.nextInt();
			ty = y;
			y = Math.abs(y);
			x = Math.abs(x);
			int cont = 0, temp = x;
			while (temp > 0) {
				temp >>= 1;
				cont++;
			}
			nx = 1<<(cont);
			nx |= (nx - x);
			int cont2 = 0, temp2 = y;
			while(temp2 > 0) {
				temp2 >>= 1;
				cont2++;
			}
			ny = 1<<(cont2);
			ny|= (ny - y);
			if (y == 0) ny = 0;
			if (x == 0) nx = 0;
			//System.out.println(Integer.toBinaryString(ny) + " "+Integer.toBinaryString(y) + " "+Integer.toBinaryString(nx) + " "+Integer.toBinaryString(x));
			r = new StringBuilder();
			if (match(x,y)) {
				while (x > 0 || y > 0) {
					if ((x&1) > 0) {
						if (tx < 0) r.append("W");
						else r.append("E");
					} else  {
						if (ty < 0)	r.append("S");
						else r.append("N");
					}
					x>>=1;
						y>>=1;
				}
			} else if (match(x,ny)) {
				while (x > 0 || ny > 0) {
					if ((x&1)>0) {
						if (tx < 0) r.append("W");
						else r.append("E");

					} else {
						if (ny == 1) {
							if (ty < 0) r.append("S");
							else r.append("N");

						} else {
							if (ty < 0) r.append("N");
							else r.append("S");

						}
					}
					x>>=1;
							ny>>=1;
				}
			} else if (match(nx,y)) {
				while (nx > 0 || y > 0) {
					if ((nx&1) == 1)  {
						if (nx == 1) {
							if(tx < 0)r.append("W");
							else r.append("E");
						} else {
							if(tx < 0)r.append("E");
							else r.append("W");
						}
					} else {
						if (ty < 0) r.append("S");
						else r.append("N");
					}
					nx>>=1;
						y>>=1;
				}
			} else if (match(nx,ny)) {
				while (nx > 0 || ny > 0) {
					if ((nx&1) == 1)  {
						if (nx == 1) {
							if(tx < 0)r.append("W");
							else r.append("E");
						} else {
							if(tx < 0)r.append("E");
							else r.append("W");
						}
					} else {
						if (ny == 1) {
							if (ty < 0) r.append("S");
							else r.append("N");
						} else  {
							if (ty < 0) r.append("S");
							else r.append("N");
						}
					}
					nx>>=1;
							ny>>=1;
				}
			} else {
				r.append("IMPOSSIBLE");
			}
			System.out.println("Case #"+c+": " +r.toString());
		}

	}





}
