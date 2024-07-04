//2020 Code Jam Qualification Round   20200403 - 20200405 UTC
//Problem:  Parenting Partnering Returns
//Submitted by jm5D v3

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
//import java.io.FileReader;
import java.util.Arrays;
//import java.io.FileWriter;
import java.util.StringTokenizer;


public class Solution {

	public static void main(String[] args) throws Exception{
		
		//BufferedReader reader = new BufferedReader(new FileReader("testData2020QualProbC"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		writer.flush();
		String inputString = reader.readLine();
		int numberOfCases = Integer.parseInt(inputString);
		int caseNumber = 1;
		while (caseNumber <= numberOfCases) {
			
			inputString = reader.readLine();
			int totalTasks = Integer.parseInt(inputString);
			Task[] tasks = new Task[totalTasks];
				
			for (int i = 0; i < totalTasks; i++) {
				inputString = reader.readLine();
				StringTokenizer tokenizer = new StringTokenizer(inputString, " ");
				int startTime = Integer.parseInt(tokenizer.nextToken());
				int endTime = Integer.parseInt(tokenizer.nextToken());
				tasks[i] = new Task(startTime, endTime);
				tasks[i].setTaskNumber(i);
			}
			Arrays.sort(tasks);
			assignTasks(tasks);
			
			String[] schedule = new String[totalTasks];
			boolean schedulePossible = true;
			//need to print person handling each task in an order that corresponds to the task input order
			//i.e. the task input order was changed when the tasks array was sorted to facilitate task assignment
			for (int i = 0; i < totalTasks; i++) {
				int taskNumber = tasks[i].getTaskNumber();
				schedule[taskNumber] = tasks[i].getTaskHandler();
				if (schedule[taskNumber] == "I") schedulePossible = false;
			}
			
			if (schedulePossible) {
				StringBuilder schedule2 = new StringBuilder(totalTasks);
				for (int i = 0; i <totalTasks; i++) {
					schedule2.append(schedule[i]);
				}
				writer.println("Case #" + caseNumber + ": " + schedule2.toString());
			}
			else writer.println("Case #" + caseNumber + ": " + "IMPOSSIBLE");
			writer.flush();
			caseNumber++;
		}
		reader.close();
		writer.close();
		
	}
	
	private static void assignTasks(Task[] tasks) {
		
		int cameronTimeFree = tasks[0].getEndTime();
		tasks[0].setTaskHandler("C");
		int jamieTimeFree = tasks[1].getEndTime();
		tasks[1].setTaskHandler("J");
		
		if (tasks.length > 2) {
			for (int i = 2; i < tasks.length; i++) {
				if (tasks[i].getStartTime() >= cameronTimeFree) {
					tasks[i].setTaskHandler("C");
					cameronTimeFree = tasks[i].getEndTime();
				}
				else if (tasks[i].getStartTime() >= jamieTimeFree) {
					tasks[i].setTaskHandler("J");
					jamieTimeFree = tasks[i].getEndTime();
				}
				else tasks[i].setTaskHandler("I");  //Impossible to assign task due to time overlap
			}
		}
	}
	
	private static class Task implements Comparable<Task> {
		
		private int startTime;
		private int endTime;
		private int taskNumber;
		private String taskHandler;
		
		Task(int start, int finish) {
			startTime = start;
			endTime = finish;
			taskNumber = -1;
			taskHandler = null;
		}
		
		public int getStartTime() {return startTime;}
		
		public int getEndTime() {return endTime;}
		
		public void setTaskNumber(int taskNum) {taskNumber = taskNum;}
		
		public int getTaskNumber() {return taskNumber;}
		
		public void setTaskHandler(String handler) {taskHandler = handler;}
		
		public String getTaskHandler() {return taskHandler;}
		
		public int compareTo(Task otherTask) {
			
			if (this.startTime < otherTask.startTime) return -1;
			else if (this.startTime == otherTask.startTime) return 0;
			else return 1;
		}
 	}
}
	
