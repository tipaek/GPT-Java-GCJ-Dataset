import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int testNum = 0; testNum < t; ++testNum) {
			int numActivities = in.nextInt();
			Queue<Time> timeQueue = new LinkedList<Time>();
			for (int i = 0; i < numActivities; ++i) {
				int timeStart = in.nextInt();
				int timeEnd = in.nextInt();
				Time time = new Time(timeStart, timeEnd);
				timeQueue.add(time);
			}
			String assignments = "";
			boolean isPossible = true;
			List<Time> cTimes = new LinkedList<Time>(); //priority queue?
			List<Time> jTimes = new LinkedList<Time>();
			while(!timeQueue.isEmpty()) {
				Time TBA = timeQueue.remove();
				boolean assignedToC = false;
				boolean assignedToJ = false;
				for (Time time : cTimes) {
					if (!time.conflicts(TBA)) {
						cTimes.add(TBA);
						assignedToC = true;
						assignments += "C";
						break;
					}
				}
				if (cTimes.isEmpty()) {
					cTimes.add(TBA);
					assignments += "C";
					continue;
				}
				if (assignedToC) {
					continue;
				}
				for (Time time : jTimes) {
					if (!time.conflicts(TBA)) {
						jTimes.add(TBA);
						assignments += "J";
						assignedToJ = true;
						break;
					}
				}
				if (jTimes.isEmpty()) {
					jTimes.add(TBA);
					assignments += "J";
					continue;
				}
				if (!assignedToJ) {
					isPossible = false;
					break;
				}
			}
			
			if (!isPossible) {
				System.out.println("Case #" + (testNum + 1) + ": IMPOSSIBLE");
			} else {
				System.out.println("Case #" + (testNum + 1) + ": " + assignments);
			}
		}
	}
	
	static class Time{
		private int startTime;
		private int endTime;
		
		public Time(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}
		
		public boolean conflicts(Time t2) {
			if (this.startTime >= t2.startTime && this.startTime < t2.endTime) {
				return true;
			} else if (t2.startTime >= this.startTime && t2.startTime < this.endTime) {
				return true;
			}
			return false;
		}

		public int getStartTime() {
			return startTime;
		}

		public void setStartTime(int startTime) {
			this.startTime = startTime;
		}

		public int getEndTime() {
			return endTime;
		}

		public void setEndTime(int endTime) {
			this.endTime = endTime;
		}
	}
}


