import java.util.*;

public class Solution {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int testCasesAmount = scanner.nextInt();


		//getRep(59, true).forEach(System.out::println);


		/*
		for (int i = -4; i <= 4; i++) {
			for (int j = -4; j <= 4; j++) {
				System.out.println(i + " " + j + ":" + getSolution(i, j));
			}
		}
		 */

		for (int test = 1; test <= testCasesAmount; test++) {
			System.out.println("Case #" + test + ": " + getSolution(scanner.nextInt(), scanner.nextInt()));
		}
	}

	private static String getSolution(int aimX, int aimY) {
		List<List<Integer>> possibleRepresentationsX = getRep(Math.abs(aimX), aimX > 0);
		List<List<Integer>> possibleRepresentationsY = getRep(Math.abs(aimY), aimY > 0);

		List<String> possibleOutputs = new ArrayList<>();
		for (List<Integer> representationsX : possibleRepresentationsX) {
			for (List<Integer> integers : possibleRepresentationsY) {
				if (isCompatible(representationsX, integers)) {
					String output = getOutput(representationsX, integers);
					possibleOutputs.add(output);
				}
			}
		}
		
		if (possibleOutputs.size() == 0) {
			return "IMPOSSIBLE";
		} else {
			possibleOutputs.sort(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return o1.length() - o2.length();
				}
			});
			return possibleOutputs.get(0);
		}
	}

	private static List<List<Integer>> getRep(int n, boolean positive) {
		if (n == 0) {
			List<Integer> result = new ArrayList<>();
			List<List<Integer>> resultList = new ArrayList<>();
			resultList.add(result);
			return resultList;
		}

		List<List<Integer>> result = new ArrayList<>();

		if (Integer.toBinaryString(n).chars().filter(c -> c == '1').count() == 1) {
			if (!positive) {
				n *= -1;
			}
			List<Integer> justNumber = new ArrayList<>();
			justNumber.add(n);
			result.add(justNumber);
			return result;
		}

		int lower = (int) Math.pow(2, Integer.toBinaryString(n).length() - 1);
		List<List<Integer>> lowerBack = getRep(n - lower, positive);
		if (!positive) {
			lower *= -1;
		}
		for (List<Integer> resultEL: lowerBack) {
			if (!resultEL.contains(lower) && !resultEL.contains(lower * -1)) {
				resultEL.add(((int) Math.signum(n)) * lower);
				result.add(resultEL);
			}
		}

		int higher = (int) Math.pow(2, Integer.toBinaryString(n).length());
		List<List<Integer>> higherBack = getRep(higher - n, !positive);

		if (!positive) {
			higher *= -1;
		}
		for (List<Integer> resultEL: higherBack) {
			if (!resultEL.contains(higher) && !resultEL.contains(higher * -1)) {
				resultEL.add(((int) Math.signum(n)) * higher);
				result.add(resultEL);
			}

		}
		return result;
	}

	private static boolean isCompatible(List<Integer> a, List<Integer> b) {
		a.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Math.abs(o1) - Math.abs(o2);
			}
		});
		b.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Math.abs(o1) - Math.abs(o2);
			}
		});

		int aPointer = 0;
		int bPointer = 0;
		for (int i = 0; i < a.size() + b.size(); i++) {
			if (aPointer < a.size() && Math.abs(a.get(aPointer)) == Math.pow(2, i)) {
				aPointer++;
			} else if (bPointer < b.size() && Math.abs(b.get(bPointer)) == Math.pow(2, i)) {
				bPointer++;
			} else {
				return false;
			}
		}
		return true;
	}

	private static String getOutput(List<Integer> a, List<Integer> b) {
		//a and b are sorted
		int pointerA = 0;
		int pointerB = 0;

		StringBuilder result = new StringBuilder();

		for (int i = 0; i < a.size() + b.size(); i++) {
			if (pointerA < a.size() && (pointerB == b.size() || Math.abs(a.get(pointerA)) < Math.abs(b.get(pointerB)))) {
				if (a.get(pointerA) > 0) {
					result.append("E");
				} else {
					result.append("W");
				}
				pointerA++;
			} else {
				if (b.get(pointerB) > 0) {
					result.append("N");
				} else {
					result.append("S");
				}
				pointerB++;
			}
		}
		return result.toString();
	}
}
