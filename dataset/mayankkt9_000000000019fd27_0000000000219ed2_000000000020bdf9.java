
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		int itr = 1;
		while (t > 0) {
			int n = in.nextInt();

			int interval[][] = new int[n][2];
			PriorityQueue<Store> pq = new PriorityQueue<Store>();
			for (int i = 0; i < n; i++) {
				interval[i][0] = in.nextInt();
				interval[i][1] = in.nextInt();
				pq.add(new Store(i, interval[i][0], interval[i][1], 'x'));
			}
			int cend = -1;
			boolean flag = false;
			int jend = -1;
			Map<Integer, Store> mp = new HashMap<>();
			while (!pq.isEmpty()) {
				Store s = pq.poll();
				mp.put(s.index, s);
				//System.out.println(s);
				if (s.start >= cend) {
					s.ch = 'C';
					cend = s.end;
				} else if (s.start >= jend) {
					s.ch = 'J';
					jend = s.end;
				} else {
					flag = true;
					break;
				}
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				sb.append(mp.get(i).ch);
			}
			if (flag)
				System.out.println("Case #" + itr + ": IMPOSSIBLE");
			else
				System.out.println("Case #" + itr + ": " + sb.toString());
			itr++;
			t--;
			mp = null;
			pq = null;
		}
	}
}

class Store implements Comparable<Store> {
	int index;
	int start;
	int end;
	char ch;

	public Store(int i, int s, int e, char c) {
		index = i;
		start = s;
		end = e;
		ch = c;
	}

	@Override
	public int compareTo(Store o) {
		// TODO Auto-generated method stub

		if (start != o.start)
			return start - o.start;
		return end - o.end;

	}

	public String toString() {
		return index + " " + start + " " + end + " " + ch;
	}

}

