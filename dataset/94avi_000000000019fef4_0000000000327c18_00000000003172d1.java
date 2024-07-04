import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution2 {

	public static void main(String[] args) throws Exception {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int testCase = Integer.valueOf(br.readLine());

		for (int test = 1; test <= testCase; test++) {
			String input[] = br.readLine().split(" ");
			String degrees[] = br.readLine().split(" ");
			int slice = Integer.valueOf(input[0]);
			int table = Integer.valueOf(input[1]);
			List<Long> degreeList = Arrays.asList(degrees).stream().map(x -> Long.parseLong(x))
					.collect(Collectors.toList());
			Collections.sort(degreeList);

			Map<Integer, List<Long>> map = new HashMap<>();
			int count = 1;
			for (int i = 0; i < degreeList.size() - 1; i++) {
				if (degreeList.get(i) == degreeList.get(i + 1)) {
					count++;
				} else {
					List<Long> degree = null;
					if (map.get(count) == null) {
						degree = new ArrayList<>();
					} else {
						degree = map.get(count);
					}
					degree.add(degreeList.get(i));
					map.put(count, degree);
					count = 1;
				}
			}
			List<Long> degree = null;
			if (map.get(count) == null) {
				degree = new ArrayList<>();
			} else {
				degree = map.get(count);
			}
			degree.add(degreeList.get(slice - 1));
			map.put(count, degree);
			int cuts = findRepeated(map, table);
			if (cuts == table) {
				System.out.println("Case #" + test + ": 0");
			} else if (cuts == -1) {
				System.out.println("Case #" + test + ": " + (table - 1));
			} else {
				if (slice - 1 - degreeList.lastIndexOf(map.get(cuts)) >= 0)
					System.out.println("Case #" + test + ": " + (table - cuts - 1));
			}

		}
	}

	private static int findRepeated(Map<Integer, List<Long>> map, int table) {
		if (table == 1)
			return -1;
		if (map.get(table) != null) {
			return table;
		}

		return findRepeated(map, table - 1);
	}
}