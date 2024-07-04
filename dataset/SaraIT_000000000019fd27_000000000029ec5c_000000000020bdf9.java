import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

	static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

	static Map<String, String> solution(Map<Integer, List<Integer>> timesMap) {

		int C = 0;
		int J = 0;
		Map<String, String> a = new TreeMap<String, String>();

		Iterator<Entry<Integer, List<Integer>>> i = timesMap.entrySet().iterator();

		while (i.hasNext()) {
			Entry<Integer, List<Integer>> me = i.next();
			if (me.getKey() >= C) {
				C = me.getValue().get(0);
				a.put(me.getKey()+"*"+me.getValue().get(0), "C");
			} else if (me.getKey() >= J) {
				J = me.getValue().get(0);
				a.put(me.getKey()+"*"+me.getValue().get(0), "J");

			} else {
				return null;
			}

			if (me.getValue().size() == 2) {
				if (me.getKey() >= C) {
					C = me.getValue().get(1);
					a.put(me.getKey()+"*"+me.getValue().get(1), "C");
				} else if (me.getKey() >= J) {
					J = me.getValue().get(1);
					a.put(me.getKey()+"*"+me.getValue().get(1), "J");

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
			Map<String, String> s = solution(timesMap);

			StringBuilder solution = new StringBuilder();
			if (s == null) {
				solution.append("IMPOSSIBLE");
			} else {

				for (int j = 0; j < order.size(); j++) {
					System.out.println(order.get(j));
					solution.append(s.get(order.get(j)));
				}

			}


			System.out.println("Case #" + i + ": " + solution.toString().trim());

		}

	}
}
