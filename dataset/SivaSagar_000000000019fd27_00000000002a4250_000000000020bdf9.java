
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int i = 0; i < testCases; i++) {
			int inputs = sc.nextInt();
			String[] intervalsArr = new String[inputs];
			List<Integer> startTimeList = new ArrayList<>();
			Map<Integer, List<Integer>> intervalStartMap = new LinkedHashMap<Integer, List<Integer>>();
			Map<String, Integer> intervalMap = new LinkedHashMap<>();
			for (int j = 0; j < inputs; j++) {
				int startTime = sc.nextInt();
				int endTime = sc.nextInt();
				intervalsArr[j] = startTime + "," + endTime;
				startTimeList.add(startTime);
				List<Integer> indexList = new ArrayList<>();
				if (intervalStartMap.containsKey(startTime)) {
					indexList = intervalStartMap.get(startTime);
				}
				indexList.add(j);
				intervalStartMap.put(startTime, indexList);
				
				if(intervalMap.containsKey(intervalsArr[j])) {
					intervalsArr[j] = intervalsArr[j] +","+j;
					startTimeList.remove(startTimeList.size()-1);
				}
				intervalMap.put(intervalsArr[j], j);
			}
			Collections.sort(startTimeList);
			int jInd = -1, cInd = -1;
			Map<String, String> allocationMap = new LinkedHashMap<>();
			boolean isImpossible = false;
			for (Integer startTime : startTimeList) {
				List<Integer> intervalsList = intervalStartMap.get(startTime);
				for (Integer intervalInd : intervalsList) {
					if (!allocationMap.containsKey(intervalsArr[intervalInd]) || !allocationMap.containsKey(intervalsArr[intervalInd]+","+intervalInd)) {
						String key = intervalsArr[intervalInd];
						if(allocationMap.containsKey(intervalsArr[intervalInd])){
							key +=","+intervalInd;
						}
						
						if (jInd == -1 && cInd == -1) {
							cInd = intervalInd;
							allocationMap.put(key, "C");
						} else {
							int currentStartTime = Integer.valueOf(intervalsArr[intervalInd].split(",")[0]);
							int cEndTime = cInd == -1 ? Integer.MAX_VALUE
									: Integer.valueOf(intervalsArr[cInd].split(",")[1]);
							int jEndTime = jInd == -1 ? Integer.MAX_VALUE
									: Integer.valueOf(intervalsArr[jInd].split(",")[1]);

							if (cInd != -1 && jInd == -1) {
								if (cEndTime <= currentStartTime) {
									cInd = intervalInd;
									allocationMap.put(key, "C");
								} else {
									jInd = intervalInd;
									allocationMap.put(key, "J");
								}
							} else if (cInd == -1 && jInd != -1) {
								if (jEndTime <= currentStartTime) {
									jInd = intervalInd;
									allocationMap.put(key, "J");
								} else {
									cInd = intervalInd;
									allocationMap.put(key, "C");
								}
							} else if (cInd != -1 && jInd != -1) {
								if (cEndTime <= currentStartTime) {
									cInd = intervalInd;
									allocationMap.put(key, "C");
								} else if (jEndTime <= currentStartTime) {
									jInd = intervalInd;
									allocationMap.put(key, "J");
								} else {
									isImpossible = true;
									break;
								}
							}
						}
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			if (!isImpossible) {
				for (String interval : intervalsArr) {
					sb.append(allocationMap.get(interval));
				}
			}
			System.out.println("Case #" + (i + 1) + ": " + (isImpossible ? "IMPOSSIBLE" : sb));
		}
		sc.close();
	}

}
