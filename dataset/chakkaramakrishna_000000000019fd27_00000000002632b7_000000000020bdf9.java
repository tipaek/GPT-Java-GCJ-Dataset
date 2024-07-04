import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String nextLine = null;
		// Read number of test cases
		nextLine = scanner.nextLine();
		int n = Integer.parseInt(nextLine);
		int taskCount = 0;
		String [] output = new String[n];
		for(int i=0; i < n; i++) {
			// Read task count for test case i+1;
			nextLine = scanner.nextLine();
			taskCount = Integer.parseInt(nextLine);
			output[i] = "Case #" + (i+1) + ": " + scheduleTasks(scanner, taskCount);
		}
	
		//Print output
		for(int i=0; i < n; i++) {
			System.out.println(output[i]);
		}
		
		//close scanner
		scanner.close();
	}
	
	private static String scheduleTasks(Scanner scanner, int size) {

		String nextLine = null;
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int startTime = 0;
		int endTime = 0;
		List <Task> taskList = new ArrayList<Task>();
		Task task = null;
		//Read values for matrix and build it
		for(int i=0; i < size; i++) {
			nextLine = scanner.nextLine();
			st = new StringTokenizer(nextLine, " ");
			startTime = Integer.parseInt(st.nextToken());
			endTime = Integer.parseInt(st.nextToken());
			task = new Task(startTime, endTime, ' ');
			taskList.add(task);
		}
		List <Task> taskListOriginalOrder = new ArrayList<Task>();
		taskListOriginalOrder.addAll(taskList);
		Collections.sort(taskList);
		boolean isOverlap = false;
		Task tempTask = null;
		for(int i=0; i < taskList.size(); i++) {
			task = taskList.get(i);
			isOverlap = false;
			// Check overlap with C
			for(int j=0; j < i; j++) {
				tempTask = taskList.get(j);
				if(tempTask.getTaskOwner() == 'J') continue;
				if ((task.getStartTime() < tempTask.getStartTime() && tempTask.getStartTime() < task.getEndTime()) 
						|| (task.getStartTime() < tempTask.getEndTime() && tempTask.getEndTime() < task.getEndTime())
						|| (tempTask.getStartTime() < task.getStartTime() && task.getStartTime() < tempTask.getEndTime())
						|| (tempTask.getStartTime() < task.getEndTime() && task.getEndTime() < tempTask.getEndTime())) {
					isOverlap = true;
					break;
				}
			}
			if(!isOverlap) {
				task.setTaskOwner('C');
				continue;
			}
			// Check overlap with J
			isOverlap = false;
			for(int j=0; j < i; j++) {
				tempTask = taskList.get(j);
				if(tempTask.getTaskOwner() == 'C') continue;
				if ((task.getStartTime() < tempTask.getStartTime() && tempTask.getStartTime() < task.getEndTime()) 
						|| (task.getStartTime() < tempTask.getEndTime() && tempTask.getEndTime() < task.getEndTime())
						|| (tempTask.getStartTime() < task.getStartTime() && task.getStartTime() < tempTask.getEndTime())
						|| (tempTask.getStartTime() < task.getEndTime() && task.getEndTime() < tempTask.getEndTime())) {
					isOverlap = true;
					break;
				}
			}
			if(!isOverlap) { 
				task.setTaskOwner('J');
			} else {
				return "IMPOSSIBLE";
			}
		}
		Iterator<Task> iter = taskListOriginalOrder.iterator();
		while(iter.hasNext()) {
			sb.append(iter.next().getTaskOwner());
		}		
		return sb.toString();
	}
}

class Task implements Comparable<Task>{
	
	Task(int startTime, int endTime, char taskOwner) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.taskOwner = taskOwner;
	}
	
	int startTime;
	int endTime;
	char taskOwner;
	
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
	
	public char getTaskOwner() {
		return taskOwner;
	}
	
	public void setTaskOwner(char taskOwner) {
		this.taskOwner = taskOwner;
	}

	@Override
	public int compareTo(Task o) {
		if (this.startTime == o.startTime) return 0;
		if (this.startTime > o.startTime) 
			return 1;
		else
			return -1;
	}
}
