import java.util.*;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		List<String> output = new ArrayList<>();

		int testCases = scanner.nextInt();

		for(int i=0; i<testCases; i++) {

			int activities = scanner.nextInt();

			//startMap<startTime, index>
			Map<Integer, Integer> startMap = new HashMap<>();

			//endMap<index, endTime>
			Map<Integer, Integer> endMap = new HashMap<>();

			for(int j=0; j<activities; j++) {

				startMap.put(scanner.nextInt(), j);
				endMap.put(j, scanner.nextInt());
			}

			output.add(solve(startMap, endMap));
		}

		scanner.close();

		for(String s : output) {
			System.out.println(s);
		}

	}

	//startMap<startTime, index>
	//endMap<index, endTime>
	public static String solve(Map<Integer, Integer> startMap, Map<Integer, Integer> endMap) {

		String solution = "C";

		//sort startMap by key
		Map<Integer, Integer> sortedMap = startMap.entrySet().stream()
	            .sorted(Map.Entry.comparingByKey())
	            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
	            (oldValue, newValue) -> oldValue, LinkedHashMap::new));

		Integer[] arrKeys = sortedMap.keySet().toArray(new Integer[0]);

		for(int i=0; i<arrKeys.length-2; i++) {

			//overlap
			if(arrKeys[i+1] - endMap.get(startMap.get(arrKeys[i])) < 0) {

				//check if IMPOSSIBLE
				if((arrKeys[i+2] - endMap.get(startMap.get(arrKeys[i])) < 0) && (arrKeys[i+2] - endMap.get(startMap.get(arrKeys[i+1])) < 0) ) {

					solution = "IMPOSSIBLE";
					return solution;
				}

				solution = modifyString(solution, true);

			//no overlap
			}else {
				solution = modifyString(solution, false);
			}
		}

		//handle last task case
		if(arrKeys[arrKeys.length-1] - endMap.get(startMap.get(arrKeys[arrKeys.length-2])) < 0) {

			solution = modifyString(solution, true);
		}else {
			solution = modifyString(solution, false);
		}

		return solution;
	}

	public static String modifyString(String s, boolean overlap) {

		if(overlap) {

			if(s.charAt(s.length()-1) == 'C') {
				s += 'J';
			}else {
				s += 'C';
			}
		}else {
			s += s.charAt(s.length() - 1);
		}

		return s;
	}
}
