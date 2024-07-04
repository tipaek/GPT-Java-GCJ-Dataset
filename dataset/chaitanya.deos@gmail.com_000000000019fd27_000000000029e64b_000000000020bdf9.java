import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		// Scanner scanner = new Scanner(new BufferedReader(new FileReader("test.in")));
		Solution solution = new Solution();
		while (scanner.hasNext()) {
			int T = scanner.nextInt();

			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < T; i++) {
				builder.setLength(0);
				int N = scanner.nextInt();
				List<Interval> intervals = new ArrayList<>(N);
				for (int j = 0; j < N; j++) {
					intervals.add(solution.new Interval(scanner.nextInt(), scanner.nextInt()));
				}

				List<Interval> cameron = new ArrayList<>();
				List<Interval> jamie = new ArrayList<>();
				List<Interval> overlapped = new ArrayList<>();

				for(Interval interval : intervals)
				{
					if(isOverlapping(cameron, interval) && isOverlapping(jamie, interval))
					{
						overlapped.add(interval);
					}
					else if(!isOverlapping(cameron, interval) && !isOverlapping(jamie, interval))
					{
						if(cameron.size() <=jamie.size())
						{
							builder.append('C');
							cameron.add(interval);
						}
						else
						{
							builder.append('J');
							jamie.add(interval);
						}
					}
					else if(!isOverlapping(cameron, interval) && isOverlapping(jamie, interval))
					{
						builder.append('C');
						cameron.add(interval);
					}
					else if(isOverlapping(cameron, interval) && !isOverlapping(jamie, interval))
					{
						builder.append('J');
						jamie.add(interval);
					}
				}

				if(!overlapped.isEmpty())
				{
					builder.setLength(0);
					builder.append("IMPOSSIBLE");
				}
				
				System.out.println(String.format("Case #%d: %s", (i + 1), builder.toString()));
			}
		}
		scanner.close();
	}

	private static boolean isOverlapping(List<Interval> list, Interval interval) {
		
		return list.stream().anyMatch(item -> overlaps(item, interval));
	}

	private static boolean overlaps(Interval first, Interval second) {
		return first.getStart() < second.getEnd() && second.getStart() < first.getEnd();
	}

	class Interval {
		private int start;

		@Override
		public String toString() {
			return "[start=" + start + ", end=" + end + "]";
		}

		private int end;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public void setStart(int start) {
			this.start = start;
		}

		public void setEnd(int end) {
			this.end = end;
		}

		public int getStart() {
			return start;
		}

		public int getEnd() {
			return end;
		}

		@Override
		public int hashCode() {
			return 587 * start + 997 * end;
		}

		@Override
		public boolean equals(Object object) {
			if (object == this)
				return true;
			if (object instanceof Interval) {
				Interval other = (Interval) object;
				return this.start == other.getStart() && this.end == other.getEnd();
			}
			return false;
		}
	}

}
