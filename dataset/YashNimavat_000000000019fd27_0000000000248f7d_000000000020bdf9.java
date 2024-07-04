import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();
		for(int i=1;i<=testCases;i++) {
			int numberOfActivities = s.nextInt();
			List<IntervelPeriod> scheduleList = new ArrayList<IntervelPeriod>();
			for(int j=1;j<=numberOfActivities;j++) {
				scheduleList.add(new IntervelPeriod(s.nextInt(),s.nextInt(),j));
			}
			StringBuffer outputBuffer = new StringBuffer();
			boolean isImposible = false;
			for(int j=0;j<scheduleList.size();j++) {
				boolean isCAvailable = true,isJAvailable = true;
				for(int k=0;k<j;k++) {
					if(isInRange(scheduleList.get(j).start,scheduleList.get(j).end,scheduleList.get(k).start,scheduleList.get(k).end)) {
						if(scheduleList.get(k).assignTo=='C') {
							isCAvailable = false;
						}
						else {
							isJAvailable = false;
						}
						if(!isCAvailable && !isJAvailable) {
							isImposible = true;
							break;
						}
					}
				}
				if(isImposible) {
					outputBuffer = new StringBuffer("IMPOSSIBLE");
					break;
				}
				if(isCAvailable) {
					scheduleList.get(j).assignTo = 'C';
				}
				else {
					scheduleList.get(j).assignTo = 'J';
				}
			}
			if(!isImposible) {
				for(int l=0;l<scheduleList.size();l++) {
					outputBuffer.append(scheduleList.get(l).assignTo);
				}
			}
			System.out.println("Case #"+i+": "+outputBuffer.toString());
		}
	}
	
	private static boolean isInRange(int eleStart,int eleEnd,int start,int end) {
		if(eleStart>=start && eleStart<end) {
			return true;
		}
		else if(eleEnd>start && eleEnd<end) {
			return true;
		}
		return false;
	}
	
	static class IntervelPeriod {
		public int start,end,taskNo;
		public char assignTo;
		public IntervelPeriod(int start,int end,int taskNo) {
			this.start = start;
			this.end = end;
			this.taskNo = taskNo;
		}
	}
}