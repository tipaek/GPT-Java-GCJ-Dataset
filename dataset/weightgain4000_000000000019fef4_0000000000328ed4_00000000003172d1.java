import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * cd /Users/ottsjo/dev/spec/codejam/target
 * cd classes && java Solution && cd ..
 *
 * python interactive_runner.py python testing_tool_XX.py 0 -- java Solution
 */
class Solution {

	private static final String IMPOSSIBLE = "IMPOSSIBLE";

	public static void main(String[] args) {
		Solution problem = new Solution();
		problem.solve();
	}

	// paste from here :)

	// paste from here :)

	/*
6
1 3
1
5 2
10 5 359999999999 123456789 10
2 3
8 4
3 2
1 2 3
6 3
1 7 7 9 11 13
4 3
1 3 5 5
4 3
1 3 5 5 5
	 */

	private void solve() {
		Executor.executeDefault(this::getCaseResult);
	}

	private String getCaseResult(Scanner scanner) {
		int[] meta = ScannerExtensions.getIntArray(scanner);
		int numberOfSlices = meta[0];
		int numberOfDiners = meta[1];
		double[] angles = ScannerExtensions.getDoubleArray(scanner);
		List<Double> allSlices = DoubleStream.of(angles).boxed().collect(Collectors.toList());

		Set<Double> targetSizes = allSlices.stream()
				.flatMap(s -> getParts(s, numberOfDiners))
				.collect(Collectors.toSet());

		int minCuts = Integer.MAX_VALUE;
		for (Double targetSize : targetSizes) {
			int cuts = minNumberOfCutsRequiredToGetSize(allSlices, numberOfDiners, targetSize);
			if (cuts < minCuts) {
				minCuts = cuts;
			}
		}

		return String.valueOf(minCuts);
	}

	private Stream<Double> getParts(Double sliceSize, int maxParts) {
		ArrayList<Double> parts = new ArrayList<>();
		return IntStream.rangeClosed(1, maxParts)
				.asDoubleStream()
				.map(n -> sliceSize/n).boxed();
	}

	private int minNumberOfCutsRequiredToGetSize(List<Double> allSlices, int targetSlices, double targetSize) {
		int cuts = 0;
		int requiredSlices = targetSlices;
		List<Double> withRightSize = allSlices.stream().filter(s -> s.equals(targetSize)).collect(Collectors.toList());
		List<Double> divisibleSlices = allSlices.stream()
				.filter(s -> s > targetSize)
				.filter(s -> isZero(s % targetSize, 0.0000001))
				.sorted()
				.collect(Collectors.toList());

		requiredSlices -= withRightSize.size();
		if (requiredSlices == 0) {
			return cuts;
		}

		for (Double divisible : divisibleSlices) {
			int maxCuts = ((int)(divisible / targetSize)) - 1;
			cuts += Math.min(maxCuts, requiredSlices);
			requiredSlices -= Math.min(requiredSlices, maxCuts+1);

			if (requiredSlices == 0) {
				return cuts;
			}
		}

		return Integer.MAX_VALUE;
	}

	public boolean isZero(double value, double threshold){
		return value >= -threshold && value <= threshold;
	}

	private void test() {
		//		HashMap<Double, Integer> duplicates = findDuplicates(allSlices);
		//
		//		if (!duplicates.isEmpty()) {
		//
		//			for (Map.Entry<Double, Integer> entry : duplicates.entrySet()) {
		//				if (numberOfDiners <= entry.getValue()) {
		//					return String.valueOf(0);
		//				}
		//
		//				List<Double> smallerSlices = allSlices.stream()
		//						.filter(s -> s < entry.getValue())
		//						.collect(Collectors.toList());
		//
		//
		//			}
		//		}
	}

	private <T> HashMap<T, Integer> findDuplicates(Collection<T> collection) {
		HashMap<T, Integer> duplicates = new HashMap<T, Integer>();
		Set<T> uniques = new HashSet<>();

		for(T t : collection) {
			if(!uniques.add(t)) {
				if (duplicates.containsKey(t)) {
					duplicates.computeIfPresent(t, (item, i) -> i++);
				}
				else {
					duplicates.put(t, 2);
				}
			}
		}
		return duplicates;
	}

	private static class Executor {

		static void executeDefault(Function<Scanner, String> getCaseResult) {
			Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
			execute(input, getCaseResult, System.out::println);
		}

		private static void execute(Scanner reader, Function<Scanner, String> getCaseResult, Consumer<String> resultConsumer) {
			int numberOfCases = ScannerExtensions.getInt(reader);
			for (int i = 0; i < numberOfCases; i++) {
				String result = getCaseResult.apply(reader);
				String caseString = createCaseString(i+1, result);
				resultConsumer.accept(caseString);
			}
		}

		static String createCaseString(long caseNumber, String result) {
			return "Case #" + caseNumber + ": " + result;
		}
	}

	private static class ScannerExtensions {

		private ScannerExtensions() {}

		static int getInt(Scanner scanner) {
			return Integer.parseInt(scanner.nextLine());
		}

		static long getLong(Scanner scanner) {
			return Long.parseLong(scanner.nextLine());
		}

		static double getDouble(Scanner scanner) {
			return Double.parseDouble(scanner.nextLine());
		}

		static int[] getIntArray(Scanner scanner) {
			return Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		static long[] getLongArray(Scanner scanner) {
			return Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
		}

		static double[] getDoubleArray(Scanner scanner) {
			return Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
		}
	}
}
