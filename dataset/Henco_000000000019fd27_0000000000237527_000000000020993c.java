import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		run(scanner);
	}

	private static void run(Scanner scanner) {
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			solveCase(i, scanner);
		}
	}

	private static void solveCase(int i, Scanner scanner) {
		int n = scanner.nextInt();
		int dupRows = 0;
		int diagSum = 0;
		List<Set<Integer>> colNums = Stream.generate(() -> new HashSet<Integer>()).limit(n)
				.collect(Collectors.toList());
		List<Integer> colDup = Stream.generate(() -> 0).limit(n).collect(Collectors.toList());
		for (int row = 0; row < n; row++) {
			Map<Integer, Integer> rowCount = new HashMap<>();
			List<Integer> rowNums = new ArrayList<>();
			for (int col = 0; col < n; col++) {
				int num = scanner.nextInt();
				if (row == col) {
					diagSum += num;
				}
				rowNums.add(num);
				rowCount.compute(num, (k, v) -> v == null ? 1 : v+1);
				Set<Integer> colNumSet = colNums.get(col);
				if (colNumSet.contains(num)) {
					colDup.set(col, 1);
				}
				colNumSet.add(num);
			}
//			System.out.println(rowCount);
			if (rowCount.values().stream().anyMatch(v -> v > 1)) {
				dupRows++;
			}
		}
		int dupCols = colDup.parallelStream().mapToInt(Integer::valueOf).sum();
		printCase(i, diagSum + " " + dupRows + " " + dupCols);
	}

	private static void printCase(int i, String str) {
		System.out.println("Case #" + (i + 1) + ": " + str);
	}

}
