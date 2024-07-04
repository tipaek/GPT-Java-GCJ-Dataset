import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Math.min;
import static java.lang.System.exit;
import static java.util.Arrays.copyOf;
import static java.util.Arrays.fill;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

	// Discuss this round on Codeforces: https://codeforces.com/blog/entry/81204

	static class MaxFlow {

		// Flow network structures

		static int n;
		static int edgesLen[], edges[][], capsLen, caps[];

		static void init() {
			edgesLen = new int[n];
			edges = new int[n][6];
			capsLen = 0;
			caps = new int[6];
		}

		static int addEdge(int from, int to, int capacity, int reverseCapacity) {
			int cap = capsLen;
			if (caps.length == cap) {
				caps = copyOf(caps, (cap << 1) + 2);
			}
			caps[cap] = capacity;
			caps[cap + 1] = reverseCapacity;
			capsLen = cap + 2;
			int e1s[] = edges[from], e1 = edgesLen[from];
			if (e1s.length == e1) {
				e1s = edges[from] = copyOf(e1s, (e1 << 1) + 2);
			}
			e1s[e1] = to;
			e1s[e1 + 1] = cap;
			edgesLen[from] = e1 + 2;
			int e2s[] = edges[to], e2 = edgesLen[to];
			if (e2s.length == e2) {
				e2s = edges[to] = copyOf(e2s, (e2 << 1) + 2);
			}
			e2s[e2] = from;
			e2s[e2 + 1] = cap + 1;
			edgesLen[to] = e2 + 2;
			return cap;
		}

		static int dinic(int source, int sink) {
			int dist[] = new int[n];
			int curEdge[] = new int[n];
			int queue[] = new int[n];
			int flow = 0;
			while (true) {
				fill(dist, -1);
				dist[source] = 0;
				queue[0] = source;
				int queueHead = 0;
				int queueTail = 1;
				do {
					int cur = queue[queueHead++];
					int ndist = dist[cur] + 1;
					for (int i = 0, e[] = edges[cur], en = edgesLen[cur]; i < en; i += 2) {
						if (caps[e[i + 1]] == 0) {
							continue;
						}
						int to = e[i];
						if (dist[to] < 0) {
							dist[to] = ndist;
							queue[queueTail++] = to;
						}
					}
				} while (queueHead < queueTail);
				if (dist[sink] < 0) {
					return flow;
				}
				fill(curEdge, 0);
				int stackSize = 0;
				int cur = source;
				int eNum = 0;
				cur: while (true) {
					if (cur == sink) {
						int curFlow = Integer.MAX_VALUE;
						for (int i = 0; i < stackSize; i++) {
							int c = queue[i];
							curFlow = min(curFlow, caps[edges[c][curEdge[c] + 1]]);
						}
						for (int i = 0; i < stackSize; i++) {
							int c = queue[i];
							int cap = edges[c][curEdge[c] + 1];
							caps[cap] -= curFlow;
							caps[cap ^ 1] += curFlow;
						}
						flow += curFlow;
						stackSize = 0;
						cur = source;
						eNum = curEdge[source];
						continue;
					}
					int ndist = stackSize + 1;
					for (int e[] = edges[cur], en = edgesLen[cur]; eNum < en; eNum += 2) {
						int next = e[eNum];
						if (caps[e[eNum + 1]] != 0 && dist[next] == ndist) {
							curEdge[cur] = eNum;
							queue[stackSize++] = cur;
							cur = next;
							eNum = curEdge[cur];
							continue cur;
						}
					}
					curEdge[cur] = eNum;
					if (stackSize == 0) {
						break;
					}
					cur = queue[--stackSize];
					eNum = curEdge[cur] + 2;
				}
			}
		}
	}

	static long e[];

	static int toCode(char c) {
		if ('A' <= c && c <= 'Z') {
			return c - 'A';
		} else if ('a' <= c && c <= 'z') {
			return c - 'a' + 26;
		} else if ('0' <= c && c <= '9') {
			return c - '0' + 52;
		} else {
			throw new AssertionError();
		}
	}

	static void solve() throws Exception {
		String s = scanString();
		int n = scanInt();
		e = new long[62];
		for (int i = 0; i < n; i++) {
			String r = scanString();
			e[toCode(r.charAt(0))] |= 1L << toCode(r.charAt(1));
		}
		seen = 0;
		exit = new int[62];
		exitPos = 0;
		for (int i = 0; i < 62; i++) {
			dfs1(i);
		}
		nComps = 0;
		comp = new int[62];
		fill(comp, -1);
		needHole = 0;
		ce = new long[62];
		for (int i = 61; i >= 0; i--) {
			if (comp[exit[i]] < 0) {
				dfs2(exit[i]);
				nComps++;
			}
		}
		int ans = 0;
		long have = 0;
		for (int i = 0; i < s.length(); i++) {
			int c = toCode(s.charAt(i));
			if ((have & (1L << c)) == 0) {
				have |= 1L << c;
				++ans;
			}
		}
		int nHoles[] = new int[nComps];
		for (int i = 0; i < 62; i++) {
			if ((have & (1L << i)) == 0) {
				++nHoles[comp[i]];
			}
		}
		MaxFlow.n = 2 * nComps + 2;
		MaxFlow.init();
		int needFlow = 0;
		for (int i = 0; i < nComps; i++) {
			int enter = nHoles[i], exit = 0;
			if ((needHole & (1L << i)) != 0 && enter == 0) {
				enter = exit = 1;
			}
			if (enter != 0) {
				MaxFlow.addEdge(2 * nComps, 2 * i + 1, enter, 0);
			}
			if (exit != 0) {
				MaxFlow.addEdge(2 * i, 2 * nComps + 1, exit, 0);
			}
			needFlow += exit;
			MaxFlow.addEdge(2 * i, 2 * i + 1, 2 * 62, 0);
			for (int j = 0; j < i; j++) {
				if ((ce[i] & (1L << j)) != 0) {
					MaxFlow.addEdge(2 * i + 1, 2 * j, 2 * 62, 0);
				}
			}
		}
		ans -= needFlow - MaxFlow.dinic(2 * nComps, 2 * nComps + 1);
		printCase();
		out.println(ans);
	}

	static long seen;
	static int exit[], exitPos;

	static void dfs1(int cur) {
		if ((seen & (1L << cur)) != 0) {
			return;
		}
		seen |= 1L << cur;
		for (int next = 0; next < 62; next++) {
			if ((e[cur] & (1L << next)) != 0) {
				dfs1(next);
			}
		}
		exit[exitPos++] = cur;
	}

	static int nComps, comp[];
	static long needHole, ce[];

	static void dfs2(int cur) {
		comp[cur] = nComps;
		for (int next = 0; next < 62; next++) {
			if ((e[next] & (1L << cur)) != 0) {
				if (comp[next] < 0) {
					dfs2(next);
				}
				needHole |= 1L << comp[next];
				ce[nComps] |= 1L << comp[next];
			}
		}
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