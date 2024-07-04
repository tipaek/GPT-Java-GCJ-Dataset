import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int testCases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
	    
		for(int tCase=1; tCase<=testCases; tCase++) {
			int taskCount = in.nextInt();
			List<Task> cTasks = new ArrayList<Task>();
			List<Task> jTasks = new ArrayList<Task>();
			StringBuffer output = new StringBuffer();
			
			for(int t=0; t<taskCount; t++) {
				int startTime = in.nextInt();
				int endTime = in.nextInt();
				Task currentTask = new Task(startTime, endTime);
				
				if(checkAvailability(cTasks, currentTask)) {
					cTasks.add(currentTask);
					output.append("C");
				} else if(checkAvailability(jTasks, currentTask)) {
					jTasks.add(currentTask);
					output.append("J");
				} else {
					break;
				}
			}
			
			System.out.print("Case #"+tCase+": ");
			if(output.length() == taskCount) {
				System.out.println(output);
			} else {
				System.out.println("IMPOSSIBLE");
			}
		}
		
		in.close();

	}
	
	public static boolean checkAvailability(List<Task> tasks, Task currentTask) {		
		for(Task task : tasks) {
			if(currentTask.getStartTime() >= task.getEndTime() || currentTask.getEndTime() <= task.getStartTime()) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

}

class Task {
	private int startTime;
	private int endTime;
	
	Task(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
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
