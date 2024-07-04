import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int T = Integer.parseInt(sc.nextLine());

			for (int t = 1; t <= T; t++) {
				List<Integer> inputList = Arrays.stream(sc.nextLine().split("")).map(Integer::parseInt)
						.collect(Collectors.toList());
				System.out.println("Case #" + t + " " + solve(inputList));
			}
		}
	}

	private static String solve(List<Integer> inputList) {
		int open = 0;
		String solution = "";
		for (Integer number : inputList) {
			for (int i = 0; i < Math.abs(number - open); i++) {
				if (open > number) {
					solution += ")";
				} else {
					solution += "(";
				}
			}
			solution += number;
			open = number;
		}
		for (int i = 0; i < open; i++) {
			solution += ")";
		}
		return solution;
	}
}
