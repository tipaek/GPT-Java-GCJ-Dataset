import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {
	
	static int R, C;
	static Position[][] mat;
	
	public static void main(String[] args) throws IOException {
		MyScanner sc = new MyScanner();
		PrintWriter out = new PrintWriter(System.out);
		int numberOfCases = sc.nextInt();
		for (int caze = 1; caze <= numberOfCases; caze++) {
			R = sc.nextInt();
			C = sc.nextInt();
			mat = new Position[R][C];
			
			int id = 0;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					long tmp = sc.nextInt();
					mat[i][j] = new Position(id++, tmp);
				}
			}
			
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if (in(nx, ny)) {
							mat[i][j].nei[k] = mat[nx][ny];
						}
					}
				}
			}
			
			TreeSet<Position> all = new TreeSet<>();
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					mat[i][j].calcCmpValue();
					all.add(mat[i][j]);
				}
			}
			long round = 1;
			long ans = 0;
			while (!all.isEmpty()) {
				long roundSum = 0;
				List<Position> elim = new ArrayList<>();
				Iterator<Position> iterator = all.iterator();
				while (iterator.hasNext()) {
					Position next =  iterator.next();
					if (next.cmpValue < 0) {
						elim.add(next);
						iterator.remove();
					} else break;
				}
				if (elim.isEmpty()) {
					elim.addAll(all);
					all.clear();
				}
				List<Position> neiOfElim = new ArrayList<>();
				for (Position pos : elim) {
					for (Position nn : pos.nei) {
						if (nn != null) {
							if (all.remove(nn)) neiOfElim.add(nn);
						}
					}
					roundSum += pos.value;
				}
				for (Position pos : elim) {
					pos.remove();
				}
				for (Position pos : neiOfElim) {
					pos.calcCmpValue();
					all.add(pos);
				}
				
				ans += roundSum * round;
				round++;
			}
			
			out.println("Case #" + caze + ": " + ans);
			
			out.flush();
		}
	}
	
	static boolean in(int a, int b) {
		return 0 <= a && a < R && 0 <= b && b < C;
	}
	
	static int[] dx = {0, 1, -1, 0};
	static int[] dy = {1, 0, 0, -1};
	
	static class Position implements Comparable<Position> {
		int id;
		long value;
		long cmpValue;
		Position[] nei;
		
		public Position(int id, long value) {
			this.id = id;
			this.value = value;
			this.nei = new Position[4];
		}
		
		void calcCmpValue() {
			cmpValue = 0;
			for (int i = 0; i < 4; i++) if (nei[i] != null) {
				cmpValue += value - nei[i].value;
			}
		}
		
		void remove() {
			for (int i = 0; i < 4; i++) {
				if (nei[i] != null) {
					nei[i].nei[3-i] = nei[3-i];
				}
			}
		}
		
		@Override
		public int compareTo(Position o) {
			int cmp = Long.compare(cmpValue, o.cmpValue);
			if (cmp != 0) return cmp;
			return Integer.compare(id, o.id);
		}
	}
	
	static class MyScanner {
		private BufferedReader br;
		private StringTokenizer tokenizer;
		
		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}
		
		public int nextInt() {
			return Integer.parseInt(next());
		}
		
		public long nextLong() {
			return Long.parseLong(next());
		}
	}
}
