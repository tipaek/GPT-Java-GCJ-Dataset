import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = null;
		try {
			in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
			int testCases = in.nextInt();
			for (int i = 1; i <= testCases; ++i) {
				int lines = in.nextInt();

				List<Timings> timingList = new ArrayList<Timings>();

				StringBuilder out = new StringBuilder();

				for (int x = 0; x < lines; x++) {
					Timings t = new Timings();
					t.setStart(in.nextInt());
					t.setEnd(in.nextInt());
					t.setIndex(x);
					timingList.add(t);
					out.append('C');
				}
				timingList.sort(new Comparator<Timings>() {

					@Override
					public int compare(Timings o1, Timings o2) {
						return o1.getStart() - o2.getStart();
					}
				});

				int c = 0;
				int j = 0;

				for (Timings timing : timingList) {
					if (c <= timing.start) {
						out.replace(timing.getIndex(), timing.getIndex() + 1, "C");
						c = timing.getEnd();
					} else if (j <= timing.start) {
						out.replace(timing.getIndex(), timing.getIndex() + 1, "J");
						j = timing.getEnd();
					} else {
						out.delete(0, out.length());
						out.append("IMPOSSIBLE");
						break;
					}
				}
				output(i, out.toString());
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}

	private static class Timings {
		private int start;
		private int end;
		private int index;

		public int getStart() {
			return start;
		}

		public void setStart(int start) {
			this.start = start;
		}

		public int getEnd() {
			return end;
		}

		public void setEnd(int end) {
			this.end = end;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		@Override
		public String toString() {
			return "Timings [start=" + start + ", end=" + end + ", index=" + index + "]";
		}

	}

	private static void output(int caseNumber, String out) {
		System.out.println("Case #" + caseNumber + ": " + out);
	}
}