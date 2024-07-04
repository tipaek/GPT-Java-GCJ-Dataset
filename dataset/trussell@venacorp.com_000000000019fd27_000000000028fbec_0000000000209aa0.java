import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
	public static void main(String[] argv) {
		Scanner in = new Scanner(System.in);
		int numCases = in.nextInt();
		for (int i = 0; i < numCases; i++) {
			int matrixSize = in.nextInt();
			int trace = in.nextInt();
			List<List<Integer>> combinations = getCombinations(trace, matrixSize);
			List<List<Integer>> latinMatrix = computeLatinMatrix(matrixSize, combinations);
			printMatrix(i + 1, latinMatrix);
		}
	}

	private static List<List<Integer>> computeLatinMatrix(int size, List<List<Integer>> combinations) {
		if (combinations.size() == 0) {
			return null;
		}

		List<List<Integer>> solution = null;
		for(List<Integer> combo : combinations) {
			solution = new ArrayList<>();
			Map<Integer, Set<Integer>> columnElementsMap = new HashMap<>();
			for (int i = 0; i < size; i++) {
				List<Integer> row = new ArrayList<>(Collections.nCopies(size, null));
				row.set(i, combo.get(i));
				solution.add(row);
				columnElementsMap.put(i, new HashSet<>());
				columnElementsMap.get(i).add(combo.get(i));
			}

			boolean isValid = true;
			for (int j = 0; j < size; j++) {
				List<Integer> row = solution.get(j);
				for (int k = 0; k < size; k++) {
					if (row.get(k) != null) {
						continue;
					}
					for (int m = 1; m <= size; m++) {
						if (row.contains(m) || columnElementsMap.get(k).contains(m)) {
							// Do Nothing
						} else {
							row.set(k, m);
							columnElementsMap.get(k).add(m);
						}
					}
				}
				if (row.contains(null)) {
					isValid = false;
					break;
				}
			}

			if (isValid) {
				return solution;
			}
		}

		return null;
	}

	private static void printMatrix(int caseNum, List<List<Integer>> matrix) {
		String isPossible = matrix != null ? "POSSIBLE" : "IMPOSSIBLE";
		System.out.println(String.format("Case #%d: %s", caseNum, isPossible));
		if (matrix == null) {
			return;
		}
		for (List<Integer> row : matrix) {
			System.out.println(row.stream().map(n -> String.valueOf(n)).collect(Collectors.joining(" ")));
		}
	}

	public static List<List<Integer>> getCombinations(int target, int matrixSize) {
		int[] candidates = new int[matrixSize];
		for (int i = 1; i <= matrixSize; i++) {
			candidates[i - 1] = i;
		}
		List<List<Integer>> ret = new ArrayList<>();
		recursivelyFindCombos(candidates, 0, target, new ArrayList<>(), ret);
		return ret;
	}

	public static void recursivelyFindCombos(int [] nums, int index, int sum, List<Integer> temp ,List<List<Integer>> ret) {
		if(sum == 0) {
			if (temp.size() == nums.length) {
				ret.add(new ArrayList<>(temp));
			}
			return;
		}
		for(int i = index; i < nums.length && nums[i] <= sum; i++) {
			temp.add(nums[i]);
			recursivelyFindCombos(nums, i, sum - nums[i], temp, ret);
			temp.remove(temp.size() - 1);
		}
	}
}