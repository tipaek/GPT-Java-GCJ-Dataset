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
        	System.out.println("Case #" + i + ": " + scheduleActivity(activityArray[i-1], sizeArray[i-1]));
        }
	}
	
	private static String scheduleActivity(int [][] taskArray, int N){
		TreeMap<Integer, Integer> cameronFreeSlot = new TreeMap<>();
		TreeMap<Integer, Integer> jamieFreeSlot = new TreeMap<>();
		String schedule = "";
		cameronFreeSlot.put(0, 1440);
		jamieFreeSlot.put(0, 1440);
		
		for (int i = 0; i < N; i++) {
			if(addTask(cameronFreeSlot, taskArray[i][0], taskArray[i][1])){
				schedule += "C";
			}
			else if(addTask(jamieFreeSlot, taskArray[i][0], taskArray[i][1])){
				schedule += "J";
			}
			else{
				return "IMPOSSIBLE";
			}
		}
				
		return schedule;
	}
	
	private static boolean addTask(TreeMap<Integer, Integer> freeSlotMap, int taskStart, int taskEnd){
		int slotStart = 0, slotEnd = 0;
		boolean foundSlot = false;
		for(Map.Entry<Integer, Integer> slot : freeSlotMap.entrySet()) {
			slotStart = slot.getKey();
			slotEnd = slot.getValue();
			
			if(slotStart <= taskEnd){
				if(slotStart <= taskStart && taskEnd <= slotEnd){
					foundSlot = true;
					break;
				}
			}
			else{
				break;
			}						
		}
		
		if(foundSlot){
			if(slotStart != taskEnd || taskStart != slotEnd){
				freeSlotMap.put(slotStart, taskStart);
				if(taskEnd < slotEnd){
					freeSlotMap.put(taskEnd, slotEnd);
				}				
			}
			
			return true;
		}	
		
		return false;
	}
}	