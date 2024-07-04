import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.System.exit;
import static java.util.Arrays.fill;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

	// Discuss this round on Codeforces: https://codeforces.com/blog/entry/81204

	static class LongLongMap {

		static final long EMPTY = Long.MIN_VALUE;

		long data[] = new long[4];
		{
			data[0] = EMPTY;
			data[2] = EMPTY;
		}
		int size = 0;

		boolean isEmpty() {
			return size == 0;
		}

		int size() {
			return size;
		}

		void clear() {
			for (int i = 0; i < data.length; i += 2) {
				data[i] = EMPTY;
			}
			size = 0;
		}

		static int hash(long key) {
			long hash = key * 1000000007;
			hash ^= hash >> 16;
			hash ^= hash >> 24;
			return (int) hash;
		}

		boolean have(long key) {
			if (key == EMPTY) {
				throw new IllegalArgumentException();
			}
			for (int mask = data.length - 2, i = hash(key) & mask;; i = (i - 1) & mask) {
				long cur = data[i];
				if (cur == key) {
					return true;
				} else if (cur == EMPTY) {
					return false;
				}
			}
		}

		long get(long key, long default_) {
			if (key == EMPTY) {
				throw new IllegalArgumentException();
			}
			for (int mask = data.length - 2, i = hash(key) & mask;; i = (i - 1) & mask) {
				long cur = data[i];
				if (cur == key) {
					return data[i + 1];
				} else if (cur == EMPTY) {
					return default_;
				}
			}
		}

		static long[] resize(long data[], int newCapacity) {
			int oldCapacity = data.length;
			long ndata[] = new long[newCapacity];
			for (int i = 0; i < newCapacity; i += 2) {
				ndata[i] = EMPTY;
			}
			for (int mask = newCapacity - 2, i = 0; i < oldCapacity; i += 2) {
				long cur = data[i];
				if (cur == EMPTY) {
					continue;
				}
				for (int j = hash(cur) & mask;; j = (j - 1) & mask) {
					if (ndata[j] == EMPTY) {
						ndata[j] = cur;
						ndata[j + 1] = data[i + 1];
						break;
					}
				}
			}
			return ndata;
		}

		void set(long key, long value) {
			if (key == EMPTY) {
				throw new IllegalArgumentException();
			}
			long data[] = this.data;
			for (int capacity = data.length, mask = capacity - 2, i = hash(key) & mask;; i = (i - 1) & mask) {
				long cur = data[i];
				if (cur == key) {
					data[i + 1] = value;
					return;
				} else if (cur == EMPTY) {
					data[i] = key;
					data[i + 1] = value;
					if (++size > capacity >> 2) {
						this.data = resize(data, capacity << 1);
					}
					return;
				}
			}
		}

		void delete(long key) {
			if (key == EMPTY) {
				throw new IllegalArgumentException();
			}
			long data[] = this.data;
			for (int capacity = data.length, mask = capacity - 2, i = hash(key) & mask;; i = (i - 1) & mask) {
				long cur = data[i];
				if (cur == key) {
					for (int j = i;;) {
						cur = data[j = (j - 1) & mask];
						if (cur == EMPTY) {
							data[i] = EMPTY;
							--size;
							return;
						}
						int k = hash(cur) & mask;
						if ((k >= i) ^ (k < j) ^ (i < j)) {
							data[i] = cur;
							data[i + 1] = data[j + 1];
							i = j;
						}
					}
				} else if (cur == EMPTY) {
					return;
				}
			}
		}

		void expand(int newCapacity) {
			long data[] = this.data;
			int oldCapacity = data.length;
			if (oldCapacity >> 2 < newCapacity) {
				this.data = resize(data, Integer.highestOneBit(newCapacity - 1) << 3);
			}
		}

		void shrink() {
			long data[] = this.data;
			int oldCapacity = data.length;
			if (oldCapacity > 4 && oldCapacity >> 3 >= size) {
				this.data = resize(data, max(Integer.highestOneBit(size - 1) << 3, 4));
			}
		}

		static class Iterator {

			final long data[];
			int position = -2;

			Iterator(long data[]) {
				this.data = data;
				advance();
			}

			boolean hasNext() {
				return position < data.length;
			}

			long getKey() {
				return data[position];
			}

			long getValue() {
				return data[position + 1];
			}

			void advance() {
				do {
					position += 2;
				} while (position < data.length && data[position] == EMPTY);
			}
		}

		Iterator iterator() {
			return new Iterator(data);
		}
	}

	static final int BIT_INDEX[] = {
		0, 1, 2, 7, 3, 13, 8, 19, 4, 25, 14, 28, 9, 34, 20, 40,
		5, 17, 26, 38, 15, 46, 29, 48, 10, 31, 35, 54, 21, 50, 41, 57,
		63, 6, 12, 18, 24, 27, 33, 39, 16, 37, 45, 47, 30, 53, 49, 56,
		62, 11, 23, 32, 36, 44, 52, 55, 61, 22, 43, 51, 60, 42, 59, 58};

	static int bitIndex(long x) {
		return BIT_INDEX[(int) ((x * 0x218a392cd3d5dbfL) >>> 58)];
	}

	static int n;
	static int state[];
	static long freeI, freeV;
	static int groupsI[], nGroupsI, groupsV[], nGroupsV;

	static void setState(int i, int v) {
		int pv = state[i];
		if (pv >= 0) {
			freeI |= 1L << i;
			freeV |= 1L << pv;
		}
		state[i] = v;
		if (v >= 0) {
			freeI &= ~(1L << i);
			freeV &= ~(1L << v);
		}
	}

	static int setGroups(long free, int groups[]) {
		int nGroups = 1;
		while (free != 0) {
			free >>= bitIndex(free & -free);
			int v = bitIndex(~free & (free + 1));
			while (nGroups <= v) {
				groups[nGroups++] = 0;
			}
			++groups[v];
			free >>= v + 1;
		}
		return nGroups;
	}

	static boolean analyzeA() {
		for (int i = 0; i < n - 1; i++) {
			int x = state[i], y = state[i + 1];
			if (x >= 0 && y >= 0) {
				if (abs(x - y) == 1) {
					return true;
				}
			} else {
				int v = x < 0 ? y : x;
				if (v >= 0 && (freeV & ((5L << v) >> 1)) != 0) {
					return true;
				}
			}
		}
		nGroupsI = setGroups(freeI, groupsI);
		nGroupsV = setGroups(freeV, groupsV);
		if (nGroupsI > 3 && nGroupsV > 3) {
			return true;
		}
		if (nGroupsI <= 2 || nGroupsV <= 2) {
			return false;
		}
		if (nGroupsV > 3) {
			int t1[] = groupsI;
			groupsI = groupsV;
			groupsV = t1;
			int t2 = nGroupsI;
			nGroupsI = nGroupsV;
			nGroupsV = t2;
		}
		long key = 0;
		for (int i = 1; i < nGroupsI; i++) {
			int v = groupsI[i];
			if (v != 0) {
				key <<= (i + 1) * v;
				key += (1L << ((i + 1) * v)) - 1;
				key -= (1L << ((i + 1) * v)) / ((1L << (i + 1)) - 1);
			}
		}
		key >>= 1;
		if (nGroupsV > 1) {
			key += (long) groupsV[1] << 51;
		}
		if (nGroupsV > 2) {
			key += (long) groupsV[2] << 57;
		}
		long val = cache.get(key, -1);
		if (val >= 0) {
			return val != 0;
		}
		boolean res = false;
		i: for (int i = 0; i < n; i++) {
			if ((freeI & (1L << i)) != 0) {
				for (int v = 0; v < n; v++) {
					if ((freeV & (1L << v)) != 0) {
						setState(i, v);
						res = analyzeB();
						setState(i, -1);
						if (res) {
							break i;
						}
					}
				}
			}
		}
		cache.set(key, res ? 1 : 0);
		return res;
	}

	static boolean analyzeB() {
		for (int i = 0; i < n - 1; i++) {
			int x = state[i], y = state[i + 1];
			if (x >= 0 && y >= 0) {
				if (abs(x - y) == 1) {
					return true;
				}
			}
		}
		boolean res = true;
		i: for (int i = 0; i < n; i++) {
			if ((freeI & (1L << i)) != 0) {
				for (int v = 0; v < n; v++) {
					if ((freeV & (1L << v)) != 0) {
						setState(i, v);
						res = analyzeA();
						setState(i, -1);
						if (!res) {
							break i;
						}
					}
				}
			}
		}
		return res;
	}

	static final LongLongMap cache = new LongLongMap();
	static boolean debug = false;

	static void solve() throws Exception {
		n = scanInt();
		int a[] = new int[n], b[] = new int[n];
		for (int i = 0; i < n; i++) {
			b[i] = scanInt() - 1;
			a[i] = scanInt() - 1;
		}
		state = new int[n];
		fill(state, -1);
		freeI = freeV = (1L << n) - 1;
		groupsI = new int[n + 1];
		groupsV = new int[n + 1];
		boolean res[] = new boolean[n + 1];
		res[0] = analyzeA();
		for (int i = 0; i < n; i++) {
			setState(a[i], b[i]);
			if (i == 2 && test == 1) {
				debug = true;
			}
			res[i + 1] = i % 2 == 0 ? analyzeB() : analyzeA();
			debug = false;
		}
		int ansA = 0, ansB = 0;
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				if (res[i] && !res[i + 1]) {
					++ansA;
				}
			} else {
				if (!res[i] && res[i + 1]) {
					++ansB;
				}
			}
		}
		printCase();
		out.println(ansA + " " + ansB);
	}

	static int scanInt() throws IOException {
		return parseInt(scanString());
	}

	static long scanLong() throws IOException {
		return parseLong(scanString());
	}

	static String scanString() throws IOException {
		while (tok == null || !tok.hasMoreTokens()) {
			tok = new StringTokenizer(in.readLine());
		}
		return tok.nextToken();
	}

	static void printCase() {
		out.print("Case #" + test + ": ");
	}

	static void printlnCase() {
		out.println("Case #" + test + ":");
	}

	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer tok;
	static int test;

	public static void main(String[] args) {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			int tests = scanInt();
			for (test = 1; test <= tests; test++) {
				solve();
			}
			in.close();
			out.close();
		} catch (Throwable e) {
			e.printStackTrace();
			exit(1);
		}
	}
}