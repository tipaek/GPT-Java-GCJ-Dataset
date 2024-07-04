import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	int t = in.nextInt();
	in.nextLine();
	for (int i = 1; i <= t; ++i) {
				int tasks = in.nextInt();
				int[] startTimes = new int[tasks];
				int[] endTimes = new int[tasks];
				int[] origStartTimes = new int[tasks];
				int[] origEndTimes = new int[tasks];
				List<Integer> cTaskStartTimes = new ArrayList<Integer>();
				List<Integer> cTaskEndTimes = new ArrayList<Integer>();
				List<Integer> jTaskStartTimes = new ArrayList<Integer>();
				List<Integer> jTaskEndTimes = new ArrayList<Integer>();
				for(int j = 0; j < tasks; ++j) {
					int startTime = in.nextInt();
					int endTime = in.nextInt();
					startTimes[j] = startTime;
					endTimes[j] = endTime;
					origStartTimes[j] = startTime;
					origEndTimes[j] = endTime;
				}
				for(int s = 0; s < tasks; s++) {
					for(int e=1; e < (tasks-s); e++){  
                        if(startTimes[e-1] > startTimes[e]){   
                               int temp = startTimes[e-1];  
                               startTimes[e-1] = startTimes[e];  
                               startTimes[e] = temp;  
                               int temp2 = endTimes[e-1];  
                               endTimes[e-1] = endTimes[e];  
                               endTimes[e] = temp2;  
                       }  
                        
					}  
				}
				String output = "";
				for(int l = 0; l < tasks; l++) {
					if(l == 0) {
						cTaskStartTimes.add(startTimes[l]);
						cTaskEndTimes.add(endTimes[l]);
					}
					else{
						if(cTaskEndTimes.get(cTaskEndTimes.size()-1) <= startTimes[l]) {
							cTaskStartTimes.add(startTimes[l]);
							cTaskEndTimes.add(endTimes[l]);
						}
						else {
							if(jTaskStartTimes.size() == 0) {
								jTaskStartTimes.add(startTimes[l]);
								jTaskEndTimes.add(endTimes[l]);
							}
							else {
								if(jTaskEndTimes.get(jTaskEndTimes.size()-1) <= startTimes[l]) {
									jTaskStartTimes.add(startTimes[l]);
									jTaskEndTimes.add(endTimes[l]);
								}
								else {
									output = "IMPOSSIBLE";
								}
							}
						}
					}
					if(output.equals("IMPOSSIBLE")) {
						break;
					}
				}
				if(!output.equals("IMPOSSIBLE")){
					for(int v = 0; v < tasks; v++) {
						boolean cTask = false;
						int w = 0;
						for(int task : cTaskStartTimes) {
							//int endInex = cTaskStartTimes.indexOf(task);
							int endInex = w;
							if(task == origStartTimes[v] && origEndTimes[v] == cTaskEndTimes.get(endInex)) {
								output += "C";
								cTask = true;
								break;
							}
							w++;
						}
						if(!cTask) {
							output += "J";
						}
					}
				}
				System.out.println("Case #"+i+": "+output);
			}
      
  }
}