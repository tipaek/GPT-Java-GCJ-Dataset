//2020 Code Jam Qualification Round   20200403 - 20200405 UTC
//Problem:  Parenting Partnering Returns
//Submitted by jm5D

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
			}
			Arrays.sort(tasks);
			
			String taskAssignment = assignTasks(tasks);
			
			writer.println("Case #" + caseNumber + ": " + taskAssignment);
			writer.flush();
			caseNumber++;
		}
		reader.close();
		writer.close();
		
	}
	
	private static String assignTasks(Task[] tasks) {
		
		int cameronTimeFree = tasks[0].getEndTime();
		int jamieTimeFree = tasks[1].getEndTime();
		StringBuilder taskAssignment = new StringBuilder("CJ");
		
		if (tasks.length > 2) {
			for (int i = 2; i < tasks.length; i++) {
				if (tasks[i].getStartTime() >= cameronTimeFree) {
					taskAssignment = taskAssignment.append('C');
					cameronTimeFree = tasks[i].getEndTime();
				}
				else if (tasks[i].getStartTime() >= jamieTimeFree) {
					taskAssignment = taskAssignment.append('J');
					jamieTimeFree = tasks[i].getEndTime();
				}
				else return "IMPOSSIBLE";
			}
		}
		taskAssignment.trimToSize();
		return taskAssignment.toString();
		
		
	}
	
	private static class Task implements Comparable<Task> {
		
		private int startTime;
		private int endTime;
		
		Task(int start, int finish) {
			startTime = start;
			endTime = finish;
		}
		
		public int getStartTime() {return startTime;}
		
		public int getEndTime() {return endTime;}
		
		public int compareTo(Task otherTask) {
			
			if (this.startTime < otherTask.startTime) return -1;
			else if (this.startTime == otherTask.startTime) return 0;
			else return 1;
		}
 	}
}
	
