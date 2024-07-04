import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;

// B
public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		new Solution();
	}

	public Solution() throws FileNotFoundException {
		FasterScanner sc = new FasterScanner(System.in);

		int amountOfTasks = sc.nextInt();
		for (int task = 1; task <= amountOfTasks; task++) {
			int c = sc.nextInt();
			int d = sc.nextInt();
			ArrayList<Pair> distances = new ArrayList<Pair>();
			HashMap<Integer, HashSet<Integer>> amountBefore = new HashMap<Integer, HashSet<Integer>>();
			for (int i = 0; i < c-1; i++) {
				int val = sc.nextInt();
				if (val < 0) {
					if (! amountBefore.containsKey(-val)) amountBefore.put(-val, new HashSet<Integer>());
					amountBefore.get(-val).add(i+2);
				} else {
					distances.add(new Pair(val, i+2));
				}
			}
			Collections.sort(distances);
			int listIndex = 0;
			
			HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
			int[][] edges = new int[d][2];
			int[][] dists = new int[c+1][c+1];
			int[] dis = new int[c+1];
			for (int i = 0; i <= c; i++) {
				dis[i] = -1;
			}
			dis[1] = 0;
			for (int i = 0; i < d; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				edges[i][0] = a;
				edges[i][1] = b;
				if (!map.containsKey(a)) map.put(a, new HashSet<Integer>());
				if (!map.containsKey(b)) map.put(b, new HashSet<Integer>());
				map.get(a).add(b);
				map.get(b).add(a);
			}
			
			HashSet<Integer> done = new HashSet<Integer>();
			done.add(1);
			ArrayList<Integer> assignedDists = new ArrayList<Integer>();
			assignedDists.add(0);
			for (int i = 1; i < c; i++) {
				if (amountBefore.containsKey(i)) {
					HashSet<Integer> vals = amountBefore.get(i);
					for (int val: vals){
						int targetDist = assignedDists.get(i-1)+1;
						for (int neigh: map.get(val)) {
							if (done.contains(neigh)) {
								dists[val][neigh] = targetDist - dis[neigh];
								dists[neigh][val] = targetDist - dis[neigh];
							}
						}
						done.add(val);
						assignedDists.add(targetDist);
						dis[val] = targetDist;
					}
					i += (vals.size()-1);
				} else {
					Pair p = distances.get(listIndex);
					listIndex++;
					int targetDist = p.value;
					int val = p.index;
					for (int neigh: map.get(val)) {
						if (done.contains(neigh)) {
							dists[val][neigh] = targetDist - dis[neigh];
							dists[neigh][val] = targetDist - dis[neigh];
						}
					}
					done.add(val);
					assignedDists.add(targetDist);
					dis[val] = targetDist;
				}
			}
			
			//print
			StringBuffer sol = new StringBuffer();
			for (int i = 0; i < d; i++) {
				sol.append(' ');
				int a = edges[i][0];
				int b = edges[i][1];
				int solu = dists[a][b];
				if (solu == 0) solu = 100000;
				sol.append(solu);
			}
			
			String solution = "Case #" + task + ":" + sol;
			System.out.println(solution);
		}

		sc.close();
	}

	class Pair implements Comparable<Pair> {
		int value;
		int index;

		public Pair(int v, int i) {
			this.value = v;
			this.index = i;
		}

		public int compareTo(Pair p) {
			if (this.value < p.value) {
				return -1;
			} else if (this.value > p.value) {
				return 1;
			} else
				return this.index - p.index;
		}
	}

	public class FasterScanner {
		private InputStream mIs;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public FasterScanner() {
			this(System.in);
		}

		public FasterScanner(InputStream is) {
			mIs = is;
		}

		public int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = mIs.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public String nextLine() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isEndOfLine(c));
			return res.toString();
		}

		public String nextString() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public long nextLong() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public int nextInt() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public boolean isEndOfLine(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}

		public void close() {
			try {
				mIs.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}