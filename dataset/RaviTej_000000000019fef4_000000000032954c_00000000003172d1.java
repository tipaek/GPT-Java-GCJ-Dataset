//package codejam2020.round1c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int x = 1; x <= t; x++) {

			Integer n = sc.nextInt();
			Integer d = sc.nextInt();

			List<Long> slices = new ArrayList<>();

			IntStream.range(0, n).forEach(s -> slices.add(sc.nextLong()));

			Map<Long, Integer> sliceCount = new TreeMap<>();

			slices.forEach(s -> sliceCount.put(s, sliceCount.get(s) == null ? 1 : sliceCount.get(s) + 1));

			List<Entry<Long, Integer>> finalList = sliceCount.entrySet().stream().collect(Collectors.toList());

			Collections.sort(finalList, (a, b) -> b.getValue().compareTo(a.getValue()) == 0
					? b.getKey().compareTo(a.getKey()) : b.getValue().compareTo(a.getValue()));

			if (d == 2) {
				if (finalList.get(0).getValue() >= 2) {
					System.out.println("Case #" + x + ": " + 0);
				} else {
					System.out.println("Case #" + x + ": " + 1);
				}
				continue;
			} else if (d == 3) {
				if (finalList.get(0).getValue() >= 3) {
					System.out.println("Case #" + x + ": " + 0);
				} else if (finalList.get(0).getValue() > 1) {
					if (n > 2) {
						// check if highest
						if (finalList.get(1).getValue() > 1 || finalList.get(1).getKey() > finalList.get(0).getKey()
								|| sliceCount.get(finalList.get(0).getKey() / 2) != null) {
							System.out.println("Case #" + x + ": " + 1);
						} else {
							System.out.println("Case #" + x + ": " + 2);
						}

						// else
					} else {
						System.out.println("Case #" + x + ": " + 2);
					}
				} else {

					boolean breakflag = false;
					for (Entry<Long, Integer> e : finalList) {
						if (sliceCount.get(e.getKey() / 2) != null) {
							System.out.println("Case #" + x + ": " + 1);
							breakflag = true;
							break;
						}
					}
					if (breakflag != true) {
						System.out.println("Case #" + x + ": " + 2);
					}
				}
				continue;
			}

			System.out.println("Case #" + x + ": " + 0);
		}

	}
}
