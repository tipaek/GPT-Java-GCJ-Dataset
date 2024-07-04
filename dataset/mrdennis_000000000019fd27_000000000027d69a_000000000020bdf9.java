import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int testCases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
	    
		for(int tCase=1; tCase<=testCases; tCase++) {
			int taskCount = in.nextInt();
			List<Task> tasks = new ArrayList<Task>();
			
			for(int t=0; t<taskCount; t++) {
				int startTime = in.nextInt();
				int endTime = in.nextInt();
				Task currentTask = new Task(t,startTime, endTime);
				tasks.add(currentTask);
			}
			
			//Sort tasks by their start time
			tasks.sort(Comparator.comparing(Task::getStartTime));
			Task cTask = null;
			Task jTask = null;
			boolean impossible = false;
			for(Task task: tasks) {
				if(cTask == null || cTask.getEndTime()<=task.getStartTime()) {
					task.setOwner("C");
					cTask = task;
				} else if(jTask == null || jTask.getEndTime()<=task.getStartTime()) {
					task.setOwner("J");
					jTask = task;
				} else {
					impossible = true;
					break;
				}
			}
			
			System.out.print("Case #"+tCase+": "); 
			if(impossible) {
				System.out.println("IMPOSSIBLE");  
			} else { 
				tasks.sort(Comparator.comparing(Task::getIndex));
				StringBuffer output = new StringBuffer();
				for(Task task:tasks) {
					output.append(task.getOwner());
				}
				System.out.println(output);
			}
			 
		}
		
		in.close();
	}
}

class Task {
	private int index;
	private int startTime;
	private int endTime;
	private String owner;
	
	Task(int index, int startTime, int endTime) {
		this.index = index;
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

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
}
