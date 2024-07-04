import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args){
		try(Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))){
			int t = Integer.parseInt(in.nextLine());

    		Solution s = new Solution();
		    for (int i = 1; i <= t; ++i) {
		    	int numberOfTasks = in.nextInt();
		    	in.nextLine();
		    	
		    	List<Task> tasks = new ArrayList<>();
		    	
		    	for(int j = 0; j < numberOfTasks; j++){
		    		String[] line = in.nextLine().split(" ");
		    		tasks.add(s.new Task(Integer.parseInt(line[0]), Integer.parseInt(line[1]), j));
		    	}
		    	
		    	Collections.sort(tasks, Comparator.comparingInt(Task::getStart));
		    	
				System.out.println("Case #" + i + ": " + findAssignedTasksString(tasks));
		    }
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static String findAssignedTasksString(List<Task> tasks){
    	Task cameronTask = null;
    	Task jamieTask = null;
    	
		String[] assignedTasks = new String[tasks.size()];
    	
    	for(Task task: tasks){
    		if(cameronTask == null || cameronTask.end <= task.start){
    			cameronTask = task;
    			assignedTasks[task.index] = "C";
    		}
    		else if(jamieTask == null || jamieTask.end <= task.start){
    			jamieTask = task;
    			assignedTasks[task.index] = "J";
    		}
    		else{
    			return "IMPOSSIBLE";
    		}
    	}
    	
    	return String.join("", assignedTasks);
	}
	
	private class Task{
		int start;
		int end;
		int index;
		Task(int start, int end, int index){
			this.start = start;
			this.end = end;
			this.index = index;
		}
		public int getStart() {
			return start;
		}
	}
}
