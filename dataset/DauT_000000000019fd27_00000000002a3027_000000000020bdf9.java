import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Scanner;

public class Solution {

	public static class Task{
		int startTime;
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
		int endTime;
		public Task(int startTime , int endTime) {
			this.startTime= startTime;
			this.endTime = endTime;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int k =0;k<t;k++) {
        	int n = in.nextInt();
        	List<Task> taskList = new ArrayList();
        	for(int i = 0;i<n;i++) {
        		int startTime = in.nextInt();
        		int endTime = in.nextInt();
        		Task task = new Task(startTime,endTime);
        		taskList.add(task);
        	}
        	String sol =  findSol(taskList, k+1);
        	System.out.println(sol);
        	
          
        }
	}
	
	static String findSol(List<Task> taskList, int caseNo) {
		String sol = "";
		
		boolean[] cTime = new boolean[24*60 +1];
		boolean[] jTime = new boolean[24*60 +1];
		
		for(Task t : taskList) {
			int startTime = t.getStartTime();
			int endTime = t.getEndTime();
			
			boolean cOccupied = false;
			boolean jOccupied = false;
			for(int i= startTime+1; i<endTime;i++) {
				if(cTime[i]){
					cOccupied= true;
				}
			}
			if(!cOccupied) {
				sol+="C";
				for(int i= startTime; i<=endTime;i++) {
					cTime[i] = true;
				}
			}
			
			if(cOccupied) {
				for(int i= startTime+1; i<endTime;i++) {
					if(jTime[i]){
						jOccupied= true;
					}
				}
				if(!jOccupied) {
					sol+="J";
					for(int i= startTime; i<=endTime;i++) {
						jTime[i] = true;
					}
				}
			}
			if(cOccupied&&jOccupied) {
				String sol1 = "Case #"+caseNo+": " +"IMPOSSIBLE";
				return sol1;
			}
		
			
		}
		
		String sol1 = "Case #"+caseNo+": " +sol;
		return sol1;
	}
}
