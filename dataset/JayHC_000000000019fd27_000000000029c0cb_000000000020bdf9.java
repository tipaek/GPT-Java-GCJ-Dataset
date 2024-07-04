import java.util.*;
import java.util.stream.Collectors;

public class Solution {

	public static List<Integer> indexes;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		List<String> output = new ArrayList<>();

		int testCases = scanner.nextInt();

		for(int i=0; i<testCases; i++) {

			int activities = scanner.nextInt();

			String solution = "";
			indexes = new ArrayList<Integer>();

			//startMap<startTime, index>
			Map<Integer, Integer> startMap = new HashMap<>();

			//endMap<index, endTime>
			Map<Integer, Integer> endMap = new HashMap<>();

			for(int j=0; j<activities; j++) {

				startMap.put(scanner.nextInt(), j);
				endMap.put(j, scanner.nextInt());
			}

			String helper = solve(startMap, endMap);

			if(helper.equals("IMPOSSIBLE")) {
				output.add("IMPOSSIBLE");
				continue;
			}

			if(helper.length()==2) {
				output.add(helper);
				continue;
			}

			for(int j=0;j<indexes.size(); j++) {

				solution += helper.charAt(indexes.get(j)-1);
			}

			output.add(solution);
		}

		scanner.close();

		for(int i=0; i<output.size(); i++) {
			System.out.println("Case #"+(i+1)+": "+output.get(i));
		}

	}

	//startMap<startTime, index>
	//endMap<index, endTime>
	public static String solve(Map<Integer, Integer> startMap, Map<Integer, Integer> endMap) {

		//handle minimum length case
		if(startMap.keySet().size()==2) {
			return "CJ";
		}

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
				indexes.add(startMap.get(arrKeys[i])+1);

			//no overlap
			}else {
				solution = modifyString(solution, false);
				indexes.add(startMap.get(arrKeys[i])+1);
			}
		}

		//handle last tasks case

		if(arrKeys.length >= 3) {
			if(arrKeys[arrKeys.length-2] - endMap.get(startMap.get(arrKeys[arrKeys.length-3])) < 0) {

				solution = modifyString(solution, true);
				indexes.add(startMap.get(arrKeys[arrKeys.length-2])+1);
			}else {
				solution = modifyString(solution, false);
				indexes.add(startMap.get(arrKeys[arrKeys.length-2])+1);
			}
		}

		if(arrKeys[arrKeys.length-1] - endMap.get(startMap.get(arrKeys[arrKeys.length-2])) < 0) {

			solution = modifyString(solution, true);
			indexes.add(startMap.get(arrKeys[arrKeys.length-1])+1);
		}else {
			solution = modifyString(solution, false);
			indexes.add(startMap.get(arrKeys[arrKeys.length-1])+1);
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