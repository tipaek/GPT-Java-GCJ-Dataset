import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
	static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

	static List<String> solution(List<String> timesMap, List<String> order) {
		int C = 0;
		int J = 0;
		Collections.sort(timesMap);
		List<String> solution = new ArrayList<String>();
		for (int i = 0; i < timesMap.size(); i++) {
			String[] lineSplit = timesMap.get(i).split("\\s+");
			
			if (Integer.parseInt(lineSplit[0]) >= C) {
				C = Integer.parseInt(lineSplit[1]);
				solution.add(order.indexOf(timesMap.get(i)), "C");
				
			} else if (Integer.parseInt(lineSplit[0]) >= J) {
				C = Integer.parseInt(lineSplit[1]);
				solution.add(order.indexOf(timesMap.get(i)), "J");

			} else {
				return null;
			}
		}
		return solution;
	}

	public static void main(String[] args) {
		int T = Integer.parseInt(in.nextLine());
		List<String> timesList;
		int N = 0;
		String line;

		for (int i = 1; i <= T; i++) {
			N = Integer.parseInt(in.nextLine());
			timesList = new ArrayList<String>();
			List<String> order = new ArrayList<String>();

			for (int j = 0; j < N; j++) {
				line = in.nextLine();				
				timesList.add(line);
				order.add(line);
			}
			
			List<String> s = solution(timesList, order);
			int index = 0;

			StringBuilder solution = new StringBuilder();
			if (s == null) {
				solution.append("IMPOSSIBLE");
			} else {
				for (int j = 0; j < s.size(); j++) {
					solution.append(s.get(j));
				}
			}
			System.out.println("Case #" + i + ": " + solution.toString().trim());

		}

	}
}
