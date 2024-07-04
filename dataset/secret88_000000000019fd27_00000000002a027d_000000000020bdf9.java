import java.util.*;
import java.io.*;

class Solution {

	public static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> hm) {
		// Create a list from elements of HashMap
		List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(hm.entrySet());

		// Sort the list
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		// put data from sorted list to hashmap
		HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
		for (Map.Entry<Integer, Integer> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		return temp;
	}

	public static void main(String[] args) {
		// declare the necessary variables
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt();

		for (int test = 0; test < T; test++) {
			// int N = in.nextInt();
			int N = in.nextInt();

			HashMap<Integer, Integer> startTimes = new HashMap<>();
			HashMap<Integer, Integer> endTimes = new HashMap<>();

			int jamie = 0;
			int cameron = 0;

			for (int itr = 0; itr < N; itr++) {

				int start = in.nextInt();
				int end = in.nextInt();

				startTimes.put(Integer.valueOf(itr), Integer.valueOf(start));
				endTimes.put(Integer.valueOf(itr), Integer.valueOf(end));
			}

			startTimes = sortByValue(startTimes);

			String joinedString = null;
			String[] newString = new String[N];

			for (Map.Entry<Integer, Integer> entry : startTimes.entrySet()) {
				int index = entry.getKey();
				int startTime = entry.getValue();
				int endTime = endTimes.get(index);

				if (jamie == 0) {
					newString[index] = "J";
					jamie = endTime;
				} else if (jamie <= startTime) {
					newString[index] = "J";
					jamie = endTime;
				} else if (cameron == 0) {
					newString[index] = "C";
					cameron = endTime;
				} else if (cameron <= startTime) {
					newString[index] = "C";
					cameron = endTime;
				} else {
					joinedString = "IMPOSSIBLE";
					break;
				}

				// do what you have to do here
				// In your case, another loop.
			}

			if (joinedString == null)
				joinedString = String.join(" ", newString);

			System.out.println("Case #" + (test + 1) + ": " + joinedString);
		}

		in.close();

	}
}