
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
			Map<Integer, Integer> intervalStartMap = new LinkedHashMap<Integer, Integer>();
			for (int j = 0; j < inputs; j++) {
				int startTime = sc.nextInt();
				int endTime = sc.nextInt();
				intervalsArr[j] = startTime + "," + endTime;
				startTimeList.add(startTime);
				intervalStartMap.put(startTime, j);
			}
			Collections.sort(startTimeList);
			int jInd=-1,cInd = -1;
			Map<String, String> allocationMap = new LinkedHashMap<>();
			boolean isImpossible = false;
			for(Integer startTime: startTimeList) {
				int intervalInd = intervalStartMap.get(startTime);
				if(jInd == -1 && cInd == -1) {
					jInd = intervalInd;
					allocationMap.put(intervalsArr[intervalInd], "J");
				}
				else if(jInd == -1) {
					jInd = intervalInd;
					allocationMap.put(intervalsArr[intervalInd], "J");
				}
				else if(cInd == -1) {
					cInd = intervalInd;
					allocationMap.put(intervalsArr[intervalInd], "C");
				}
				else {
					int currentStartTime = Integer.valueOf(intervalsArr[intervalInd].split(",")[0]);
					int jEndTime = Integer.valueOf(intervalsArr[jInd].split(",")[1]);
					int cEndTime = Integer.valueOf(intervalsArr[cInd].split(",")[1]);
					if(jEndTime <= currentStartTime) {
						jInd = intervalInd;
						allocationMap.put(intervalsArr[intervalInd], "J");
					}
					else if(cEndTime <= currentStartTime) {
						cInd = intervalInd;
						allocationMap.put(intervalsArr[intervalInd], "C");
					}
					else {
						isImpossible = true;
						break;
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			for(String interval: intervalsArr) {
				sb.append(allocationMap.get(interval));
			}
			System.out.println("Case #" + (i + 1) + ": "+ (isImpossible?"IMPOSSIBLE":sb));
		}
		sc.close();
	}

}
