
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	
	static class Interval {
		Integer start;
		Integer end;

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
			} else if (!end.equals(other.end)) {
				return false;
			}
			if (start == null) {
				if (other.start != null) {
					return false;
				}
			} else if (!start.equals(other.start)) {
				return false;
			}
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

		public  static int compareThem(Interval a, Interval b) {
			return a.getEnd().compareTo(b.getEnd());
		}

	}


	public static void main(String args[]) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCaseCount = Integer.parseInt(in.nextLine());
		//System.out.println("TC"+testCaseCount);
		if(testCaseCount >= 1 && testCaseCount <= 100) {
			for (int k = 0; k < testCaseCount; ++k ) {
				boolean breakLoop=false;
				int timeSlots = Integer.parseInt(in.nextLine());
				Interval[] slots = new Interval[timeSlots];
				for(int i = 0; i < timeSlots; i++) {
					String r = in.nextLine();
					String[] row = r.split("\\s+");
					int start=Integer.parseInt(row[0]);
					int end=Integer.parseInt(row[1]);
					if(start< 0 || end >24*60 || start>end || start==end || end>1440  ) {
						System.out.println("Case #" + (k+1) + ": " + "IMPOSSIBLE");
						 breakLoop = true;
						break;
					}else
					slots[i] = new Interval(start,end);
				}
				if(!breakLoop) {
				Interval[] originalArray = slots.clone();
				Arrays.sort(slots, Interval::compareThem);
				//System.out.println(Arrays.deepToString(slots));
				//System.out.println("K "+k);
					Map<Interval, String> allotedSlotsMap = new HashMap<>();
					int cAt = 0;
					int jAt = 0;
					for (int i = 0; i < slots.length; i++) {
						if (i == 0) {
							allotedSlotsMap.put(slots[i], "C");
						} else if (i > 0 && slots[cAt].getEnd() <= slots[i].getStart()) {
							cAt = i;
							allotedSlotsMap.put(slots[i], "C");
						 } else if ((i > 0 && jAt == 0) || (slots[jAt].getEnd() <= slots[i].getStart())) {
							 jAt = i;
							allotedSlotsMap.put(slots[i], "J");
						}
						//System.out.println(allotedSlotsMap);
					}
					if( allotedSlotsMap.size() != slots.length ) {
						System.out.println("Case #" + (k+1) + ": " + "IMPOSSIBLE");
					} else {
						System.out.print("Case #" + (k + 1) + ": ");
						Arrays.stream(originalArray).forEach(f -> {
						System.out.print(allotedSlotsMap.get(f));
						});
						System.out.println();
					}
				
			}
			}
		}
		
		
	}
}
