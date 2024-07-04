
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

	private static final String VALUES_TO_SKIP = "(\r\n|[\n\r\u2028\u2029\u0085])?";

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numberOfCases = in.nextInt();
		in.skip(VALUES_TO_SKIP);

		for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
			String[] rowItems = in.nextLine().split(" ");
			int integersCeiling = Integer.parseInt(rowItems[0]);
			int desiredTrace = Integer.parseInt(rowItems[1]);

			int[] numbers = Stream.iterate(1, i -> i + 1)
					.limit(integersCeiling)
					.collect(Collectors.toList())
					.stream()
					.mapToInt(Integer::intValue)
					.toArray();

			List<List<Integer>> permutations = createNaturalLatinSquare(numbers);
			int diagonalSum = getDiagonalSum(permutations);

			if(desiredTrace != diagonalSum) {
				System.out.println("Case #" + caseIndex + ": IMPOSSIBLE");
			} else {
				System.out.println("Case #" + caseIndex + ": POSSIBLE");

				for(List<Integer> l : permutations) {
					System.out.println(l.stream().map(i -> String.valueOf(i)).collect(Collectors.joining(" ")));
				}
			}
		}
	}

	private static int getDiagonalSum(List<List<Integer>> permutations) {
		int diagonalSum = 0;
		for(int i = 0; i < permutations.size(); i++) {
				diagonalSum += permutations.get(i).get(i);
		}
		return diagonalSum;
	}

	private static List<List<Integer>> createNaturalLatinSquare(int[] integers) {
		List<List<Integer>> result = new ArrayList<>();
		Queue<List<Integer>> permutations = new LinkedList<>();
		permutations.add(new ArrayList<>());
		for (int currentNumber : integers) {
			int n = permutations.size();
			for (int i = 0; i < n; i++) {
				List<Integer> oldPermutation = permutations.poll();
				for (int j = 0; j <= oldPermutation.size(); j++) {
					List<Integer> newPermutation = new ArrayList<>(oldPermutation);
					newPermutation.add(j, currentNumber);
					if (newPermutation.size() == integers.length)
						result.add(newPermutation);
					else
						permutations.add(newPermutation);
				}
			}
		}

		Set<Integer> seenPositions = new HashSet<>();
		List<List<Integer>> finalResult = new ArrayList<>();

		for(List<Integer> l : result) {
			int position = l.indexOf(1);
			if(!seenPositions.contains(position)) {
				seenPositions.add(position);
				finalResult.add(new ArrayList<>(l));
			}
		}

		int diagonalSum = getDiagonalSum(finalResult);
		int targetDiagonal = diagonalSum / finalResult.size();

		return finalResult.stream()
				.map(l -> new LatinSquareRows(l, l.indexOf(targetDiagonal)))
				.collect(Collectors.toList())
				.stream()
				.sorted((l1,l2) -> l1.indexOfSpecialNum - l2.indexOfSpecialNum)
				.map(l -> l.row).collect(Collectors.toList());



	}
}

class LatinSquareRows {
	List<Integer> row;
	int indexOfSpecialNum;

	public LatinSquareRows(List<Integer> row, int indexOfSpecialNum) {
		this.row = row;
		this.indexOfSpecialNum = indexOfSpecialNum;
	}
}
