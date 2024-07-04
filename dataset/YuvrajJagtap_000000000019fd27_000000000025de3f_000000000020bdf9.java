import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static String J = "J";
	public static String C = "C";
	public static String IMPOSSIBLE = "IMPOSSIBLE";
	
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		int numberOfTestCases = Integer.parseInt(s);
		int numberOfTask = 0;
		Map<Integer, Map<Integer, String>> noOfItems = new HashMap<Integer, Map<Integer, String>>();
		Map<Integer, String> itemEntry;
		for (int i = 0; i < numberOfTestCases; i++) {
			numberOfTask = Integer.parseInt(in.nextLine());
			itemEntry = new HashMap<Integer, String>();
			for (int j = 0; j < numberOfTask; j++) {
				itemEntry.put(j, in.nextLine());
			}
			noOfItems.put(i, itemEntry);
		}
		String[] startEnd;
		String[] result;
		String resultString = "";
		String[] entries;
		List<Integer> visitedList = new ArrayList<Integer>();
		for (Integer key : noOfItems.keySet()) {
			itemEntry = noOfItems.get(key);
			List<String> startTimes = new ArrayList<String>();
			visitedList = new ArrayList<Integer>();
			result = new String[itemEntry.size()];
			resultString = "";
			for (Integer key1 : itemEntry.keySet()) {
				startEnd = itemEntry.get(key1).split(" ");
				startTimes.add(key1+":"+startEnd[0]);
			}
			
			String startEntry = getNextEntry(-1, startTimes, visitedList);
			//for - C 
			while (startEntry != null) {
				entries = startEntry.split(":");
				visitedList.add(Integer.parseInt(entries[0]));
				result[Integer.parseInt(entries[0])] = C;
				startEntry = getNextEntry(Integer.parseInt(itemEntry.get(Integer.parseInt(entries[0])).split(" ")[1]), startTimes, visitedList);
			}
			startEntry = getNextEntry(-1, startTimes, visitedList);
			//for -J 
			while (startEntry != null) {
				entries = startEntry.split(":");
				visitedList.add(Integer.parseInt(entries[0]));
				result[Integer.parseInt(entries[0])] = J;
				startEntry = getNextEntry(Integer.parseInt(itemEntry.get(Integer.parseInt(entries[0])).split(" ")[1]), startTimes, visitedList);
			}
			for (String r : result) {
				resultString = resultString + r;
			}
			if (resultString.contains("null")) {
				System.out.println("Case #" + (key + 1) + ": " + IMPOSSIBLE);
			} else {
				System.out.println("Case #" + (key + 1) + ": " + resultString);
			}
		}
	}
	

	public static String getNextEntry(int endTime, List<String> startTimes, List<Integer> usedInts) {
		int entryStartTime;
		int entryIndex;
		int leastTime = -1;
		String leastTimeEntry = null;
		String[] startEntry;
		for (String startTime : startTimes) {
			startEntry = startTime.split(":");
			entryStartTime = Integer.parseInt(startEntry[1]);
			entryIndex = Integer.parseInt(startEntry[0]);
			if (entryStartTime >= endTime && (!usedInts.contains(entryIndex))) {
				if (leastTime == -1) {
					leastTime = entryStartTime;
					leastTimeEntry = startTime;
				} else if (entryStartTime <= leastTime) {
					leastTime = entryStartTime;
					leastTimeEntry = startTime;
				}
			}
		}
		return leastTimeEntry;
	}
}
