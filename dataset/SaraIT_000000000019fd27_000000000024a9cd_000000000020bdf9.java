import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

	static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

	static Map<Integer, String> solution(Map<Integer, Integer> timesMap, Map<Integer, Integer> secondMap) {
		int J = 0;
		int C = 0;
		StringBuilder solution = new StringBuilder();
		Map<Integer, String> a = new TreeMap<Integer, String>();

		Iterator<Entry<Integer, Integer>> i = timesMap.entrySet().iterator();

		while (i.hasNext()) {
			Map.Entry<Integer, Integer> me = i.next();
			if (me.getKey() >= J) {
				J = me.getValue();
				solution.append("J");
				a.put(me.getKey(), "J");
			} else if (me.getKey() >= C) {
				C = me.getValue();
				solution.append("C");
				a.put(me.getKey(), "C");

			} else {
				return null;
			}
		}
		return a;
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
			List<Integer> order = new ArrayList<Integer>();
			boolean isImpo = false;

			for (int j = 0; j < N; j++) {
				line = in.nextLine();
				String[] times = line.split("\\s+");
				order.add(Integer.parseInt(times[0]));
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
			StringBuilder solution = new StringBuilder();

			if (isImpo) {
				solution.append("IMPOSSIBLE");
			} else {
			Map<Integer, String> s = solution(timesMap, secondMap);

			if (s == null) {
				solution.append("IMPOSSIBLE");
			} else {

				for (int j = 0; j < order.size(); j++) {
					solution.append(s.get(order.get(j)));
				}
				
			}
			}
			System.out.println("Case #" + i + ": " + solution);

		}

	}
}