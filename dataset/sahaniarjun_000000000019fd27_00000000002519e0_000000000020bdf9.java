import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
//			try {
				StringBuilder sb = new StringBuilder();
				
				int n=0;
				if(sc.hasNextInt() )
				     n = sc.nextInt(); // if there is another number  
				     
				Map<Integer, Integer> jMap = new HashMap<>();
				Map<Integer, Integer> cMap = new HashMap<>();
				// List<JobTask> jTasks = new ArrayList<>();
				// List<JobTask> cTasks = new ArrayList<>();
				boolean assign = true;
				for (int j = 0; j < n; j++) {
					int start=0;
					if(sc.hasNextInt() )
						start = sc.nextInt(); // if there is another number  
					
					int end = 1440;
					if(sc.hasNextInt() )
						end = sc.nextInt(); // if there is another number 
					for (Entry<Integer, Integer> task : jMap.entrySet()) {
						if (task.getKey() == start || (start > task.getKey() && start < task.getValue())
								|| (end > task.getKey() && end < task.getValue())) {
							assign = false;
							break;
						}
					}
					if (assign) {
						jMap.put(start, end);
						sb.append("J");
						continue;
					}
					assign = true;
					for (Entry<Integer, Integer> task : cMap.entrySet()) {
						if (task.getKey() == start || (start > task.getKey() && start < task.getValue())
								|| (end > task.getKey() && end < task.getValue())) {
							assign = false;
							break;
						}
					}
					if (assign) {
						cMap.put(start, end);
						sb.append("C");
						continue;
					}
					break;
				}
				System.out.println("Case #" + (i + 1) + ": " + (assign ? sb.toString() : "IMPOSSIBLE"));
//			} catch (NoSuchElementException e) {
//				System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
//			}

		}
		sc.close();
	}

}