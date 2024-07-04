import java.util.*;

class Task {
	int id;
	int start;
	int end;
}

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.nextLine());
		
		for(int x=1; x <= t; x++) {
			int n = Integer.parseInt(sc.nextLine());
			
			List<Task> taskList = new ArrayList<>();
			
			for(int i=0; i < n; i++) {
				String[] input = sc.nextLine().split(" ");
				Task task = new Task();
				task.id = i;
				task.start = Integer.parseInt(input[0]);
				task.end = Integer.parseInt(input[1]);
				
				taskList.add(task);
			}
			
			//Collections.sort(taskList, (a, b) -> a.start - b.start);
			List<Task> jag = new ArrayList<>();
			List<Task> cag = new ArrayList<>();
			StringBuilder result = new StringBuilder();
			boolean success = true;
			for(int i=0; i < n; i++) {
				Task current = taskList.get(i);
				
				boolean cflag = true;
				for(Task task : cag) {
					if((current.start > task.start && current.start < task.end) || (current.end > task.start && current.end < task.end)) {
						cflag = false;
					}
				}
				
				if(cflag) {
					cag.add(current);
					result.append("C");
					continue;
				}
				boolean jflag = true;
				for(Task task : jag) {
					if((current.start > task.start && current.start < task.end) || (current.end > task.start && current.end < task.end)) {
						jflag = false;
					}
					
				}
				
				if(jflag) {
					jag.add(current);
					result.append("J");
					continue;
				}
				
				
				success = false;
				System.out.println("Case #"+ x +": IMPOSSIBLE");
				break;
				
			}
			if(success)
			System.out.println("Case #"+ x +": "+ result.toString());
		}
	}

}