
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		int testCaseCount = Integer.parseInt(sc.nextLine());
		if (testCaseCount > 100)
			testCaseCount = 100;

		if (testCaseCount < 1)
			return;

		for (int k = 0; k < testCaseCount; k++) {
			Map<Interval, String> map = new HashMap<>();

			int N = Integer.parseInt(sc.nextLine());
			// int arr[][] = new int[N][N];

			Interval arr[] = new Interval[N];
			boolean breakLoop = false;
			for (int l = 0; l < N; ++l) {

				String r = sc.nextLine();

				String row[] = r.split("\\s+");

				int start = Integer.parseInt(row[0]);
				int end = Integer.parseInt(row[1]);

				if (start > end || (start > 24 * 60) || end > 24 * 60) {

					// map.put(new Interval(start,end), "NA");
					System.out.print("Case #" + (k + 1) + ": IMPOSSIBLE");
					breakLoop = true;
					break;
				} else
					arr[l] = new Interval(start, end);

			}

			// System.out.println(Arrays.deepToString(arr));

			// sort interval on basing on end time.
			if(!breakLoop) {
				Interval[] originalArray = arr.clone();

			Arrays.sort(arr, Interval::compareThem);

			List<Interval> set = new ArrayList<>();

			for (Interval t : arr) {
				set.add(t);
			}

			int currentMeetingNumber = 0;
			for (int i = 0; i < arr.length; i++) {
				if (i == 0) {
					// System.out.println("Meeting for C "+arr[currentMeetingNumber].toString());
					set.remove(arr[currentMeetingNumber]);
					map.put(arr[currentMeetingNumber], "C");
				}

				if (arr[currentMeetingNumber].getEnd() <= arr[i].getStart()) {
					currentMeetingNumber = i;
					set.remove(arr[i]);
					map.put(arr[i], "C");

					// System.out.println("Meeting for C "+arr[currentMeetingNumber].toString());

				}
			}

			// System.out.println("Map fr C"+map);
			// System.out.println(set);
			Interval[] arrJ = new Interval[set.size()];
			arrJ = set.toArray(arrJ);

			int currentMeetingNumberForJ = 0;

			for (int i = 0; i < arrJ.length; i++) {
				if (i == 0) {
					// System.out.println("Meeting for J
					// "+arrJ[currentMeetingNumberForJ].toString());
					set.remove(arrJ[currentMeetingNumberForJ]);
					map.put(arrJ[currentMeetingNumberForJ], "J");
				}

				if (arrJ[currentMeetingNumberForJ].getEnd() <= arrJ[i].getStart()) {
					currentMeetingNumberForJ = i;
					set.remove(arrJ[i]);
					map.put(arrJ[i], "J");

					// System.out.println("Meeting for J
					// "+arrJ[currentMeetingNumberForJ].toString());

				}
			}
			// System.out.println("Final set"+set);

			if (set.isEmpty())

			{

				System.out.print("Case #" + (k + 1) + ": ");
				Arrays.stream(originalArray).forEach(f -> {

					System.out.print(map.get(f));

				});
			} else
				System.out.print("Case #" + (k + 1) + ": IMPOSSIBLE");

			if (k < testCaseCount - 1)
				System.out.println();

		}
		}
		sc.close();

	}

}

class Interval {
	Integer start, end;

	Interval(int start, int end) {

		this.start = start;
		this.end = end;
	}

	@Override
	public String toString() {
		return "Interval [start=" + start + ", end=" + end + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Interval other = (Interval) obj;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		return true;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public static int compareThem(Interval a, Interval b) {
		return a.getEnd().compareTo(b.getEnd());
	}
}
