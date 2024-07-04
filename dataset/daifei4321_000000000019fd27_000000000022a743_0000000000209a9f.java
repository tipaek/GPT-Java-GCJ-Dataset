import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 0; t < T; t++) {
			String src = in.next();
			Segs dst = Segs.from(src);
			System.out.println("CASE #" + (t + 1) + ": " + dst);
		}
	}
	private static class Segs {
		private List<Segs> children = new ArrayList<>();
		public String toString() {
			StringBuilder buffer = new StringBuilder();
			toString(buffer, 0);
			return buffer.toString();
		}

		private void toString(StringBuilder buffer, int outer) {
			for (Segs child : children) {
				if (null == child) {
					buffer.append(outer);
				} else {
					buffer.append('(');
					child.toString(buffer, outer + 1);
					buffer.append(')');
				}
			}
		}

		public static Segs from(String src) {
			int length = src.length();
			List<Integer> ds = new ArrayList<>(length);
			for (int i = 0; i < length; i++) {
				int v = src.charAt(i) - '0';
				if (v < 0 || v > 9) {
					throw new IllegalArgumentException();
				}
				ds.add(v);
			}
			return from(ds, 0);
		}

		private static Segs from(List<Integer> ds, int outer) {
			Segs segs = new Segs();
			List<Segs> children = segs.children;
			int start = 0;
			int curr = 0;
			int dCount = ds.size();
			while (curr < dCount) {
				int d = ds.get(curr);
				if (d == outer) {
					if (start < curr) {
						children.add(from(ds.subList(start, curr), outer + 1));
					}
					children.add(null);
					curr++;
					start = curr;
				} else {
					curr++;
				}
			}
			if (start < curr) {
				children.add(from(ds.subList(start, curr), outer + 1));
			}
			return segs;
		}
	}
}
