import java.io.*;
import java.util.*;

/**
 * ParentingPartneringReturns
 * @author: av-sharma
 */

public class Solution {

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		int T = fr.nextInt();
		int t = 0;

		while (t++ < T) {
			// code
			int n = fr.nextInt();
			int[] start = new int[n];
			int[] finish = new int[n];
			int[] assigned = new int[n];	// -1 = NONE, 0 = C, 1 = J
			int[] indices = new int[1441];
			for (int i = 0; i < n; i++) {
				start[i] = fr.nextInt();
				finish[i] = fr.nextInt();
				indices[start[i]] = i;
			}

			for (int i = 0; i < n; i++) {
				int index = i;
				for (int j = i + 1; j < n; j++) if (start[j] < start[index]) index = j;
				if (index != i) {
					start[i] ^= start[index];
					start[index] ^= start[i];
					start[i] ^= start[index];
					finish[i] ^= finish[index];
					finish[index] ^= finish[i];
					finish[i] ^= finish[index];
				}
			}
			
			boolean flag = true;
			int cFree = 0, jFree = 0;
			for (int i = 0; i < n; i++) {
				if (start[i] >= cFree) {
					assigned[indices[start[i]]] = 0;
					cFree = finish[i];
				} else if (start[i] >= jFree) {
					assigned[indices[start[i]]] = 1;
					jFree = finish[i];
				} else {
					flag = false;
				}
			}

			System.out.print("CASE #" + t + ": ");
			if (!flag) {
				System.out.println("IMPOSSIBLE");
			} else {
				for (int i = 0; i < n; i++) System.out.print(assigned[i] == 0 ? 'C' : 'J');
				System.out.println();
			}
		}
	}
}

// FastReader Util Class
class FastReader {
	BufferedReader br;
	StringTokenizer st;

	public FastReader() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	String next() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	String nextLine() {
		String str = "";
		try {
			str = br.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

	int nextInt() {
		return Integer.parseInt(next());
	}

	Long nextLong() {
		return Long.parseLong(next());
	}

	Double nextDouble() {
		return Double.parseDouble(next());
	}
}