

import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStream;

class Solution {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}

	static class TaskA {
		class pair {
			int si;
			int ei;
			String s;

			pair(int si, int ei) {
				this.si = si;
				this.ei = ei;
			}
		}

		public void solve(int testNumber, InputReader in, PrintWriter out) {
			int t = in.nextInt();
			int c = 0;
			while (c++ < t) {
				int n = in.nextInt();
				int arr[][] = new int[n][2];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < 2; j++) {
						arr[i][j] = in.nextInt();
					}
				}
				ArrayList<pair> list = new ArrayList<>();
				for (int i = 0; i < n; i++) {
					pair p = new pair(arr[i][0], arr[i][1]);
					list.add(p);
				}

				ArrayList<pair> dummy = new ArrayList<>();
				for (int i = 0; i < list.size(); i++) {
					dummy.add(list.get(i));
				}
				Collections.sort(list, new sicomparator());
				int start[] = new int[list.size()];
				int end[] = new int[list.size()];
				for (int i = 0; i < list.size(); i++) {
					start[i] = list.get(i).si;
					end[i] = list.get(i).ei;
				}
				if ((maxOverlapIntervalCount(start, end)) > 2) {
					out.println("Case #" + (c) + ": " + "IMPOSSIBLE");
					continue;
				}
				ArrayList<pair> A = new ArrayList<>();
				ArrayList<pair> B = new ArrayList<>();
				list.get(0).s = "C";
				A.add(list.get(0));
				for (int i = 1; i < list.size(); i++) {
					pair op = list.get(i);
					int s = op.si;
					int e = op.ei;
					int flaga = 0;
					int flagb = 0;
					for (int j = 0; j < A.size(); j++) {
						pair fp = A.get(j);
						if (fp.si < s && fp.ei > e) {
							flaga = 1;
							break;
						} else if (fp.ei > s) {
							flaga = 1;
							break;
						}
					}
					for (int k = 0; k < B.size(); k++) {
						pair sp = B.get(k);
						if (sp.si < s && sp.ei > e) {
							flagb = 1;
							break;
						} else if (sp.ei > s) {
							flagb = 1;
							break;
						}
					}
					if (flaga == 1) {
						op.s = "J";
						B.add(op);
					} else if (flagb == 1) {
						op.s = "C";
						A.add(op);
					} else {
						op.s = "C";
						A.add(op);
					}
				}
				ArrayList<pair> finallist = new ArrayList<>();
				for (int i = 0; i < A.size(); i++) {
//					out.print(A.get(i).si + " " + A.get(i).ei + " " + A.get(i).s);
					finallist.add(A.get(i));
				}
				for (int i = 0; i < B.size(); i++) {
//					out.print(B.get(i).si + " " + B.get(i).ei + " " + B.get(i).s);
					finallist.add(B.get(i));
				}
				String sb = "";
				for (int i = 0; i < dummy.size(); i++) {
					for (int j = 0; j < list.size(); j++) {
						if (dummy.get(i).si == finallist.get(j).si && dummy.get(i).ei == finallist.get(j).ei) {
							sb += finallist.get(j).s;
						}
					}
				}
				out.println("Case #" + (c) + ": " + sb);

			}
		}

		private class sicomparator implements Comparator<pair> {

			@Override
			public int compare(pair o1, pair o2) {
				return o1.si - o2.si;
			}

		}

		public static int maxOverlapIntervalCount(int[] start, int[] end) {
			int maxOverlap = 0;
			int currentOverlap = 0;

			Arrays.sort(start);
			Arrays.sort(end);

			int i = 0;
			int j = 0;
			int m = start.length, n = end.length;
			while (i < m && j < n) {
				if (start[i] < end[j]) {
					currentOverlap++;
					maxOverlap = Math.max(maxOverlap, currentOverlap);
					i++;
				} else {
					currentOverlap--;
					j++;
				}
			}

			return maxOverlap;
		}

	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String nextLine() {
			// TODO Auto-generated method stub
			return null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
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
