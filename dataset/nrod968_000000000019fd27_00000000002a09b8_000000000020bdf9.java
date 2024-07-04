import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int testNum = 0; testNum < t; ++testNum) {
			int numActivities = in.nextInt();
			List<Time> times = new LinkedList<Time>();
			for (int i = 0; i < numActivities; ++i) {
				int timeStart = in.nextInt();
				int timeEnd = in.nextInt();
				Time time = new Time(timeStart, timeEnd);
				times.add(time);
			}
			String assignments = findSolutions(times, new LinkedList<Time>(), new LinkedList<Time>(), "");
			
			if (assignments.equals("")) {
				System.out.println("Case #" + (testNum + 1) + ": IMPOSSIBLE");
			} else {
				System.out.println("Case #" + (testNum + 1) + ": " + assignments);
			}
		}
	}
	
	public static String findSolutions(List<Time> times, List<Time> cTimes, List<Time> jTimes, String solutionSoFar) {
		if (times.isEmpty()) {
			return solutionSoFar;
		}
		Time TBA = times.remove(0);
		
		boolean assignedToC = false;
		boolean assignedToJ = false;
		String assignments;
		for (Time time : cTimes) {
			if (!time.conflicts(TBA)) {
				cTimes.add(TBA);
				solutionSoFar += "C";
				assignedToC = true;
				break;
			}
		}
		if (cTimes.isEmpty()) {
			cTimes.add(TBA);
			solutionSoFar += "C";
			assignedToC = true;
		}
		
		if (assignedToC) {
			assignments = findSolutions(times, cTimes, jTimes, solutionSoFar);
			if (!assignments.equals("")) {
				return assignments;
			}
			cTimes.remove(TBA); //Possible holdup
			solutionSoFar.substring(0, solutionSoFar.length() - 1);
		}
		
		for (Time time : jTimes) {
			if (!time.conflicts(TBA)) {
				jTimes.add(TBA);
				solutionSoFar += "J";
				assignedToJ = true;
				break;
			}
		}
		if (jTimes.isEmpty()) {
			jTimes.add(TBA);
			solutionSoFar += "J";
			assignedToJ = true;
		}
		
		if (!assignedToJ) {
			return "";
		}
		
		assignments = findSolutions(times, cTimes, jTimes, solutionSoFar);
		if (!assignments.equals("")) {
			return assignments;
		}
		jTimes.remove(TBA);
		solutionSoFar.substring(0, solutionSoFar.length() - 1);
		return "";
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


