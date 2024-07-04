
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testcases = sc.nextInt();
		for (int t = 0; t < testcases; t++) {
			int N = sc.nextInt();

			Map<Integer, List<Integer>> activities = new TreeMap<>();
			List<Integer> originalStartTimes = new ArrayList<Integer>();
			for (int i = 0; i < N; i++) {
				int startTime = sc.nextInt();
				int endTime = sc.nextInt();
				List<Integer> endTimeList = activities.getOrDefault(startTime, new ArrayList<Integer>());
				endTimeList.add(endTime);
				activities.put(startTime, endTimeList);
				originalStartTimes.add(startTime);
			}

			int CEndtime = 0;
			int JEndTime = 0;
			boolean impossible = false;

			Map<Integer, List<Character>> assignMap = new TreeMap<>();
			outer: for (Entry<Integer, List<Integer>> activity : activities.entrySet()) {
				int actStartTime = activity.getKey();
				List<Integer> actEndTimeList = activity.getValue();

				if (actEndTimeList.size() <= 2) {
					for (int i = 0; i < actEndTimeList.size(); i++) {
						List<Character> charList = assignMap.getOrDefault(actStartTime, new ArrayList<Character>());

						if (actStartTime >= CEndtime) {
							charList.add('C');
							assignMap.put(actStartTime, charList);
							CEndtime = actEndTimeList.get(i);
						} else if (actStartTime >= JEndTime) {
							charList.add('J');
							assignMap.put(actStartTime, charList);
							JEndTime = actEndTimeList.get(i);
						} else {
							impossible = true;
							break outer;
						}
					}
				} else {
					impossible = true;
					break;
				}

			}
			
			

			if (impossible) {
				System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
			} else {
				
				StringBuilder outputStr = new StringBuilder();
				for (int i = 0; i < originalStartTimes.size(); i++) {
					List<Character> person = assignMap.get(originalStartTimes.get(i));
					if(person!=null && person.size()!=0) {
						outputStr.append(person.remove(0));
					}
				}
				
				System.out.println("Case #" + (t + 1) + ": "+ outputStr);
			}
		}
		sc.close();
	}

}