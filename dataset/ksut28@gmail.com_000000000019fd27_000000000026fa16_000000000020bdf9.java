
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {

	static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public Reader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public Reader(String file_name) throws IOException {
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public String readLine() throws IOException {
			byte[] buf = new byte[64]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (neg)
				return -ret;
			return ret;
		}

		public long nextLong() throws IOException {
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		public double nextDouble() throws IOException {
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();

			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (c == '.') {
				while ((c = read()) >= '0' && c <= '9') {
					ret += (c - '0') / (div *= 10);
				}
			}

			if (neg)
				return -ret;
			return ret;
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		Reader s = new Reader();
		int testCases = s.nextInt();

		for (int test = 1; test <= testCases; test++) {
			System.out.print("Case #" + test + ": ");

			long size = s.nextInt();
			Map<Integer, Integer> mp = new HashMap<>();
			Map<Pair<Integer, Integer>, Queue<Integer>> mpp = new HashMap<>();
			List<Pair<Integer, Integer>> v = new ArrayList<>();

			int a[] = new int[(int) size];
			for (int i = 0; i < size; i++) {
				a[i] = s.nextInt();
				int x = s.nextInt();
				mpp.computeIfAbsent(new Pair(a[i], x), k -> new LinkedList<>()).add(i);
				v.add(new Pair(a[i], x));
			}
			Collections.sort(v, new Comparator<Pair>() {
				@Override
				public int compare(Pair p1, Pair p2) {
					return (int) p1.getFirst() - (int) p2.getFirst();
				}
			});
			int q = 0, w = 0;
			boolean b = true;
			char ans[] = new char[(int) size];
			for (int i = 0; i < size; i++) {
				if (q <= v.get(i).getFirst()) {
					q = v.get(i).getSecond();
					ans[mpp.get(new Pair(v.get(i).getFirst(), v.get(i).getSecond())).peek()] = 'C';
					mpp.computeIfAbsent(new Pair(v.get(i).getFirst(), v.get(i).getSecond()), k -> new LinkedList<>())
							.poll();
				} else if (w <= v.get(i).getFirst()) {
					w = v.get(i).getSecond();
					ans[mpp.get(new Pair(v.get(i).getFirst(), v.get(i).getSecond())).peek()] = 'J';
					mpp.computeIfAbsent(new Pair(v.get(i).getFirst(), v.get(i).getSecond()), k -> new LinkedList<>())
							.poll();
				} else {
					b = false;
					break;
				}
			}
			if (b) {
				for (int i = 0; i < size; i++) {
					System.out.print(ans[i]);
				}
				System.out.println();
			}
			else {
				System.out.println("IMPOSSIBLE");
			}
		}

	}

}

class Pair<A, B> {
	private A first;
	private B second;

	public Pair(A first, B second) {
		super();
		this.first = first;
		this.second = second;
	}

	public int hashCode() {
		int hashFirst = first != null ? first.hashCode() : 0;
		int hashSecond = second != null ? second.hashCode() : 0;

		return (hashFirst + hashSecond) * hashSecond + hashFirst;
	}

	public boolean equals(Object other) {
		if (other instanceof Pair) {
			Pair otherPair = (Pair) other;
			return ((this.first == otherPair.first
					|| (this.first != null && otherPair.first != null && this.first.equals(otherPair.first)))
					&& (this.second == otherPair.second || (this.second != null && otherPair.second != null
							&& this.second.equals(otherPair.second))));
		}

		return false;
	}

	public String toString() {
		return "(" + first + ", " + second + ")";
	}

	public A getFirst() {
		return first;
	}

	public void setFirst(A first) {
		this.first = first;
	}

	public B getSecond() {
		return second;
	}

	public void setSecond(B second) {
		this.second = second;
	}
}
