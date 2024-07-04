import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Solution {

	static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

	static Map<String, List<String>> solution(Map<Integer, List<Integer>> timesMap) {

		int C = 0;
		int J = 0;
		Map<String, List<String>> a = new TreeMap<String, List<String>>();

		Iterator<Entry<Integer, List<Integer>>> i = timesMap.entrySet().iterator();
		List<String> aList;

		while (i.hasNext()) {
			aList = new ArrayList<String>();
			Entry<Integer, List<Integer>> me = i.next();
			if (me.getKey() >= C) {
				C = me.getValue().get(0);
				aList.add("C");
				a.put(me.getKey()+"*"+me.getValue().get(0), aList);
			} else if (me.getKey() >= J) {
				J = me.getValue().get(0);
				aList.add("J");
				a.put(me.getKey()+"*"+me.getValue().get(0), aList);

			} else {
				return null;
			}

			if (me.getValue().size() == 2) {
				if (me.getKey() >= C) {
					C = me.getValue().get(1);
					aList.add("C");
					a.put(me.getKey()+"*"+me.getValue().get(1), aList);
				} else if (me.getKey() >= J) {
					J = me.getValue().get(1);
					aList.add("J");
					a.put(me.getKey()+"*"+me.getValue().get(1), aList);

				} else {
					return null;
				}
			}
			if (me.getValue().size() == 3) {
				return null;
			}

		}
		return a;

	}

	public static void main(String[] args) {
		int T = Integer.parseInt(in.nextLine());
		Map<Integer, List<Integer>> timesMap;
		int N = 0;
		String line;

		for (int i = 1; i <= T; i++) {
			N = Integer.parseInt(in.nextLine());
			timesMap = new TreeMap<Integer, List<Integer>>();
			List<String> order = new ArrayList<String>();
			List<Integer> inMiddle;

			for (int j = 0; j < N; j++) {
				line = in.nextLine();
				String[] times = line.split("\\s+");
				inMiddle = new ArrayList<Integer>();

				if (!timesMap.containsKey(Integer.parseInt(times[0]))) {
					inMiddle.add(Integer.parseInt(times[1]));
					timesMap.put(Integer.parseInt(times[0]), inMiddle);
					order.add(times[0]+"*"+times[1]);
				} else {
					timesMap.get(Integer.parseInt(times[0])).add(Integer.parseInt(times[1]));
					order.add(times[0]+"*"+times[1]);
				}
			}
			Map<String, List<String>> s = solution(timesMap);
			int index = 0;

			StringBuilder solution = new StringBuilder();
			if (s == null) {
				solution.append("IMPOSSIBLE");
			} else {

				for (int j = 0; j < order.size(); j++) {
					if (s.get(order.get(j)).get(0) != "-") {
						solution.append(s.get(order.get(j)).get(0));
						s.get(order.get(j)).add(0, "-");
					} else {
						solution.append(s.get(order.get(j)).get(2));
					} {
						
					}
					
				}

			}


			System.out.println("Case #" + i + ": " + solution.toString().trim());

		}

	}
}
