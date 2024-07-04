import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			for(int i = 1; i <= t; i++) {
				int n = scanner.nextInt();
				scanner.nextLine();
				//Taking schedule
				List<int[]> schedulesList = new ArrayList<>();
				for(int j = 0; j < n; j++) {
					int[] schedules = Arrays.stream(scanner.nextLine().split(" "))
											.mapToInt( s -> Integer.parseInt(s))
											.toArray();
					schedulesList.add(schedules);
				}
				
				//Creating Persons
				PersonSchedule cameron = new PersonSchedule();
				PersonSchedule jamie = new PersonSchedule();
				
				String schedulePlan = "";
				for (int[] schedule : schedulesList) {
					if(cameron.isFree(schedule[0], schedule[1])) {
						schedulePlan +="C";
						cameron.addSchedule(schedule[0], schedule[1]);
					} else if(jamie.isFree(schedule[0], schedule[1])) {
						schedulePlan += "J";
						jamie.addSchedule(schedule[0], schedule[1]);
					} else {
						schedulePlan = "IMPOSSIBLE";
						break;
					}
				}
				System.out.println("Case #" + i + ": " + schedulePlan);
			}
		}
	}
}

class PersonSchedule {
	
	private Map<Integer, Integer> scheduleMap = new HashMap<>();
	
	/**
	 * Books schedule for the person.
	 * 
	 * @param startTime
	 * @param endTime
	 */
	public void addSchedule(int startTime, int endTime) {
		scheduleMap.put(startTime, endTime);
	}
	
	/**
	 * Checks if person is free or not in the given schedule.
	 * 
	 * @param startTime
	 * @param endTime
	 * @return true if person's schedule does not overlap, else false
	 */
	public boolean isFree(int startTime, int endTime) {
		//Checking if person has any entry in schedule
		//If not then telling that person is free
		if(scheduleMap.isEmpty()) {
			return true;
		}
		
		//else checking if schedule overlaps
		boolean flag = true;
		for (Entry<Integer, Integer> e : scheduleMap.entrySet()) {
			if(!(endTime <= e.getKey() || startTime >= e.getValue())) {
				return false;
			}
		}
		return flag;
	}
}