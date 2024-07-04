import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	static String t0 = "4\r\n" + 
			"3\r\n" + 
			"360 480\r\n" + 
			"420 540\r\n" + 
			"600 660\r\n" + 
			"3\r\n" + 
			"0 1440\r\n" + 
			"1 3\r\n" + 
			"2 4\r\n" + 
			"5\r\n" + 
			"99 150\r\n" + 
			"1 100\r\n" + 
			"100 301\r\n" + 
			"2 5\r\n" + 
			"150 250\r\n" + 
			"2\r\n" + 
			"0 720\r\n" + 
			"720 1440\r\n" + 
			"";
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt();
		//System.out.println("T Initialized to " + T + " testcases");
		in.nextLine();
		int caseNumber = 1;
		


		
		
		//start processing test cases
		while(in.hasNextLine()) {
			//System.out.println("Starting new case");
			boolean feasible = true;
			List<Task> herTasks = new ArrayList<Task>();
			List<Task> hisTasks = new ArrayList<Task>();
			StringBuilder sb = new StringBuilder();
			int N = in.nextInt();
			//System.out.println("N Initialized to " + N + " tasks");
			in.nextLine();
			
			while(N > 0) {
				String currentTask = in.nextLine();
				Scanner taskScanner = new Scanner(currentTask);
				//System.out.println("Current Task String : " + currentTask);
				
				//System.out.println("Creating New Task...");
				Task task = new Task(taskScanner.nextInt(), taskScanner.nextInt());
				//System.out.println(task);
				N--;
				
				boolean assigned = false;
				boolean fits = true;

				for(Task t: herTasks) {
					if(task.conflicts(t)) {
						fits = false;
					}
				}
				
				if(fits) {
					herTasks.add(task);
					assigned = true;
					sb.append("C");
					//System.out.println("Assinging Task to C");
				} else {
					fits = true;
					for(Task t : hisTasks) {
						if(task.conflicts(t)) {
							fits = false;
						}
					}
					
					if(fits) {
						hisTasks.add(task);
						assigned = true;
						sb.append("J");
						//System.out.println("Assinging Task to J");
					}
				}
				
				if(!assigned) {
					//System.out.println("IMPOSSIBLE");
					feasible = false;
				}
				
				//System.out.println("Task List A Size = " + herTasks.size());
				//System.out.println("Task List B Size = " + hisTasks.size());
			}
			
			if(!feasible) {
				System.out.println("Case #" + caseNumber++ + ": " + "IMPOSSIBLE");
				herTasks.clear();
				hisTasks.clear();
			} else {
				System.out.println("Case #" + caseNumber++ + ": " + sb);
				herTasks.clear();
				hisTasks.clear();
			}
			
		}
		
		
		
		
	}
	
	public static class Task{
		int start;
		int end;
		
		public Task(int s, int e) {
			start = s;
			end = e;
		}
		
		public boolean conflicts(Task b) {
			boolean event_before = this.start < b.start && this.end < b.start;
			boolean ends_during = this.start <= b.start && this.end > b.start && b.end > this.end;
			boolean starts_before_ends_after = this.start <= b.start && this.end >= b.end;
			boolean starts_after_ends_before = this.start > b.start && this.end <= b.end;
			
			boolean starts_during = this.start > b.start && this.start < b.end && this.end > b.end;
			boolean starts_after = this.start >= b.end && this.end > b.end;
			
			boolean conflicts = ends_during || starts_during || starts_before_ends_after || starts_after_ends_before;
		//	System.out.println("Comparing " + this + "\t" + b + "\t::" + conflicts);
			return conflicts;
		}

		@Override
		public String toString() {
			return "Start : " + start + "\tEnd : " + end;
		}
		
		
	}
}