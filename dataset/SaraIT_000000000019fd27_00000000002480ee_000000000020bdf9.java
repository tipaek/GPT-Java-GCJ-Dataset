import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

	static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

	static String solution(Map<Integer, Integer> timesMap, Map<Integer, Integer> secondMap) {
		int J = 0;
		int C = 0;
		StringBuilder solution = new StringBuilder();

		Iterator<Entry<Integer, Integer>> i = timesMap.entrySet().iterator();

		while (i.hasNext()) {
			Map.Entry<Integer, Integer> me = i.next();
			if (me.getKey() >= J) {
				J = me.getValue();
				solution.append("J");
			} else if (me.getKey() >= C) {
				C = me.getValue();
				solution.append("C");
			} else {
				return "IMPOSSIBLE";
			}
		}
		return solution.toString();
	}

	public static void main(String[] args) {
		int T = Integer.parseInt(in.nextLine());
		Map<Integer, Integer> timesMap;
		Map<Integer, Integer> secondMap;
		int N = 0;
		String line;

		for (int i = 1; i <= T; i++) {
			N = Integer.parseInt(in.nextLine());
			secondMap = new TreeMap<Integer, Integer>();
			timesMap = new TreeMap<Integer, Integer>();
			boolean isImpo = false;

			for (int j = 0; j < N; j++) {
				line = in.nextLine();
				String[] times = line.split("\\s+");

				if (!timesMap.containsKey(Integer.parseInt(times[0]))) {
					timesMap.put(Integer.parseInt(times[0]), Integer.parseInt(times[1]));
				} else {
					if (secondMap.containsKey(Integer.parseInt(times[0]))) {
						isImpo = true;
					} else {
						secondMap.put(Integer.parseInt(times[0]), Integer.parseInt(times[1]));
					}
				}
			}
			String s = solution(timesMap, secondMap);

			System.out.println("Case #" + i + ": " + s);
		}

	}

}
