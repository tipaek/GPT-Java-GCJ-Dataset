
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
	static Scanner scan;

	public static void main(String[] args) {
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		long t = scan.nextInt();
		for (long it = 1; it <= t; ++it) {
			int numCake = scan.nextInt();
			int diner = scan.nextInt();
			List<Long> sizeCakes = new ArrayList<>();
			for (int j = 1; j <= numCake; ++j) {
				long sizeCake = scan.nextLong();
				sizeCakes.add(sizeCake);
			}
			String res = cal(numCake, diner, sizeCakes);
			System.out.println("Case #" + it + ": " + res);
		}
		scan.close();
	}

	private static String cal(int numCake, int diner, List<Long> sizeCakes) {
		if (diner == 2) {
			Map<Long, Long> sizeToCount = sizeCakes.stream()
					.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
			boolean hasDup = sizeToCount.values().stream().anyMatch(v -> v > 1);
			return hasDup ? "0" : "1";
		}
		if (diner == 3) {
			Map<Long, Long> sizeToCount = sizeCakes.stream()
					.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
			boolean hasDup = sizeToCount.values().stream().anyMatch(v -> v > 2);
			if (hasDup) {
				return "0";
			}
			for (Long size : sizeCakes) {
				if (size % 2 != 0) {
					continue;
				}
				Long halfSize = size / 2;
				boolean anyHalf = sizeCakes.stream().anyMatch(s -> s == halfSize);
				if (anyHalf) {
					return "1";
				}
			}
			return "2";
		}
		return "he";
	}

}