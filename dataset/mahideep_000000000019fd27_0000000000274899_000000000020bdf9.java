

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
String a="C";
String b="J";
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

			int currentMeetingNumberC = 0;
			int currentMeetingNumberj = 0;
				boolean im=false;
			for (int i = 0; i < arr.length; i++) {
				if (i == 0) {
					
					map.put(arr[currentMeetingNumberC], a);
				}

				else if (i>0 &&arr[currentMeetingNumberC].getEnd() <= arr[i].getStart()) {
					 currentMeetingNumberC = i;
					map.put(arr[i], a);


				}
				
				 else if(i>0&& currentMeetingNumberj==0 ) {
				
					 currentMeetingNumberj = i;
						map.put(arr[i], b);
				 }
				 else if(i>0 &&arr[currentMeetingNumberj].getEnd() <= arr[i].getStart()) {
					 currentMeetingNumberj = i;
						map.put(arr[i], b);
				 }
				 else {
						System.out.print("Case #" + (k + 1) + ": IMPOSSIBLE");
						im=true;
						break;
				 }
				 
			}

		//System.out.println(map);
				if(!im) {
				    if(a.equals("C"))
					a="J";
					else
					a="C";
					if(b.equals("C"))
					b="J";
					else
					b="C";
				System.out.print("Case #" + (k + 1) + ": ");
				Arrays.stream(originalArray).forEach(f -> {


					System.out.print(map.get(f));

				});
				}
			} else
				System.out.print("Case #" + (k + 1) + ": IMPOSSIBLE");

			if (k < testCaseCount - 1)
				System.out.println();

		
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
