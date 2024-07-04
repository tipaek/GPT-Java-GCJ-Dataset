import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numTestCase = in.nextInt();
        int [][][] activityArray = new int[numTestCase][][];
        int []sizeArray = new int[numTestCase];
        int N;
        for(int i = 0; i < numTestCase; ++i) {
        	N = in.nextInt();
        	activityArray[i] = new int[N][2];
        	for (int j = 0; j < N; j++) {
        		for (int k = 0; k < 2; k++) {
        			activityArray[i][j][k] = in.nextInt();
        		}
        	}
        	sizeArray[i] = N;
        }
        in.close();
        
        
        for(int i = 1; i <= numTestCase; ++i) {
        	System.out.println("Case #" + i + ": " + scheduleActivity(activityArray[i-1]));
        }
	}
	
	private static String scheduleActivity(int [][] taskArray){
		TreeMap<Integer, ArrayList<Integer>> taskMap = new TreeMap<>();
		char [] schedule = new char[taskArray.length]; 
		int cameronTaskEnd = 0;
		int jamieTaskEnd = 0;
		ArrayList<Integer> endTimeList;
		for (int i = 0; i < taskArray.length; i++) {
			if(taskMap.containsKey(taskArray[i][0])){
				taskMap.get(taskArray[i][0]).add(i);
			}
			else{
				endTimeList = new ArrayList<>();
				endTimeList.add(i);
				taskMap.put(taskArray[i][0], endTimeList);
			}
		}
		
		for(Map.Entry<Integer, ArrayList<Integer>> task : taskMap.entrySet()) {
			endTimeList = task.getValue();
			for (int i = 0; i < endTimeList.size(); i++) {
				if(cameronTaskEnd <= task.getKey()){
					schedule[endTimeList.get(i)] = 'C';
					cameronTaskEnd = taskArray[endTimeList.get(i)][1];
				}
				else if(jamieTaskEnd <= task.getKey()){
					schedule[endTimeList.get(i)] = 'J';
					jamieTaskEnd = taskArray[endTimeList.get(i)][1];
				}
				else{
					return "IMPOSSIBLE";
				}
			}
			
		}
		
		return String.valueOf(schedule);
	}
}	