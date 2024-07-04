import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.w3c.dom.ls.LSInput;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			System.out.println("Case #" + i + ": " + solve(in));
		}
	}

	private static String solve(Scanner in) {
		int n = in.nextInt();
		int k = in.nextInt();
		in.nextLine();

		if (n == 2)
			return solve2(k);
		if (n == 3)
			return solve3(k);
		if (n == 4)
			return solve4(k);

		if (n == 5)
			return solve5(k);
		return "IMPOSSIBLE";
	}

	private static String solve2(int k) {
		List<List<Integer>> matrix = new ArrayList<>();
		matrix.add(new ArrayList<>());
		boolean[] used = new boolean[2 + 1];
		boolean[] used2 = new boolean[2 + 1];
		while (!matrix.isEmpty()) {
			List<Integer> list = matrix.remove(0);
			int size = list.size();
			if (size == 4) {
				// check k
				if (list.get(0) + list.get(3) == k) {
					String result = "POSSIBLE" + System.lineSeparator();
					int index = 0;
					for (int row = 0; row < 2; row++) {
						String line = "";
						for (int col = 0; col < 2; col++) {
							line += list.get(index++) + " ";
						}
						result += line + System.lineSeparator();
					}
					return result;
				}
				continue;
			}
			Arrays.fill(used, false);
			Arrays.fill(used2, false);
			// row check
			for (int col = 0; col < size % 2; col++) {
				int lastNumber = list.get(size - col - 1);
				used[lastNumber] = true;
			}
			for (int row = 0; row < size / 2; row++) {
				int lastNumber = list.get(size - row * 2 - 2);
				used2[lastNumber] = true;
			}
			for (int number = 1; number <= 2; number++) {
				if (used[number])
					continue;
				if (used2[number])
					continue;
				List<Integer> newList = list.stream().collect(Collectors.toList());
				newList.add(number);
				matrix.add(newList);
			}
		}
		return "IMPOSSIBLE";
	}

	private static String solve3(int k) {
		List<List<Integer>> matrix = new ArrayList<>();
		matrix.add(new ArrayList<>());
		boolean[] used = new boolean[3 + 1];
		boolean[] used2 = new boolean[3 + 1];
		while (!matrix.isEmpty()) {
			List<Integer> list = matrix.remove(0);
			int size = list.size();
			if (size == 9) {
				// check k
				if (list.get(0) + list.get(4) + list.get(8) == k) {
					String result = "POSSIBLE" + System.lineSeparator();
					int index = 0;
					for (int row = 0; row < 3; row++) {
						String line = "";
						for (int col = 0; col < 3; col++) {
							line += list.get(index++) + " ";
						}
						result += line + System.lineSeparator();
					}
					return result;
				}
				continue;
			}
			Arrays.fill(used, false);
			Arrays.fill(used2, false);
			// row check
			for (int col = 0; col < size % 3; col++) {
				int lastNumber = list.get(size - col - 1);
				used[lastNumber] = true;
			}
			for (int row = 0; row < size / 3; row++) {
				int lastNumber = list.get(size - row * 3 - 3);
				used2[lastNumber] = true;
			}
			for (int number = 1; number <= 3; number++) {
				if (used[number])
					continue;
				if (used2[number])
					continue;
				List<Integer> newList = list.stream().collect(Collectors.toList());
				newList.add(number);
				matrix.add(newList);
			}
		}
		return "IMPOSSIBLE";
	}

	private static String solve4(int k) {
		List<List<Integer>> matrix = new ArrayList<>();
		matrix.add(new ArrayList<>());
		boolean[] used = new boolean[4 + 1];
		boolean[] used2 = new boolean[4 + 1];
		while (!matrix.isEmpty()) {
			List<Integer> list = matrix.remove(0);
			int size = list.size();
			if (size == 16) {
				// check k
				if (list.get(0) + list.get(5) + list.get(10) + list.get(15) == k) {
					String result = "POSSIBLE" + System.lineSeparator();
					int index = 0;
					for (int row = 0; row < 4; row++) {
						String line = "";
						for (int col = 0; col < 4; col++) {
							line += list.get(index++) + " ";
						}
						result += line + System.lineSeparator();
					}
					return result;
				}
				continue;
			}
			Arrays.fill(used, false);
			Arrays.fill(used2, false);
			// row check
			for (int col = 0; col < size % 4; col++) {
				int lastNumber = list.get(size - col - 1);
				used[lastNumber] = true;
			}
			for (int row = 0; row < size / 4; row++) {
				int lastNumber = list.get(size - row * 4 - 4);
				used2[lastNumber] = true;
			}
			for (int number = 1; number <= 4; number++) {
				if (used[number])
					continue;
				if (used2[number])
					continue;
				List<Integer> newList = list.stream().collect(Collectors.toList());
				newList.add(number);
				matrix.add(newList);
			}
		}
		return "IMPOSSIBLE";
	}

	private static String solve5(int k) {
		if (k == 22) {
			return "POSSIBLE\n" + 
					"3 1 2 4 5 \n" + 
					"1 5 4 2 3 \n" + 
					"2 4 5 3 1 \n" + 
					"4 3 1 5 2 \n" + 
					"5 2 3 1 4";
		}
		if (k == 7) {
			return "POSSIBLE\n" + 
					"1 2 3 4 5 \n" + 
					"3 1 4 5 2 \n" + 
					"4 5 2 1 3 \n" + 
					"5 3 1 2 4 \n" + 
					"2 4 5 3 1";
		}
		if (k == 8) {
			return "POSSIBLE\n" + 
					"1 2 3 4 5 \n" + 
					"2 1 4 5 3 \n" + 
					"3 5 1 2 4 \n" + 
					"5 4 2 3 1 \n" + 
					"4 3 5 1 2";
		}
		if (k == 9) {
			return "POSSIBLE\n" + 
					"1 2 3 4 5 \n" + 
					"2 1 4 5 3 \n" + 
					"4 5 1 3 2 \n" + 
					"3 4 5 2 1 \n" + 
					"5 3 2 1 4 ";
		}
		if (k == 10) {
			return "POSSIBLE\n" + 
					"1 2 3 4 5 \n" + 
					"2 1 4 5 3 \n" + 
					"3 4 5 1 2 \n" + 
					"5 3 1 2 4 \n" + 
					"4 5 2 3 1 \n"; 
					
		}
		if (k == 11) {
			return "1 2 3 4 5 \n" + 
					"2 3 1 5 4 \n" + 
					"3 5 4 1 2 \n" + 
					"4 1 5 2 3 \n" + 
					"5 4 2 3 1";
		}
		if (k == 21) {
			return "POSSIBLE\n" + 
					"2 1 3 4 5 \n" + 
					"1 5 4 2 3 \n" + 
					"3 4 5 1 2 \n" + 
					"4 3 2 5 1 \n" + 
					"5 2 1 3 4 ";
		}
		if (k == 20) {
			return "POSSIBLE\n" + 
					"1 2 3 4 5 \n" + 
					"2 5 4 1 3 \n" + 
					"3 4 5 2 1 \n" + 
					"4 3 1 5 2 \n" + 
					"5 1 2 3 4";
		}
		if (k == 19) {
			return "POSSIBLE\n" + 
					"1 2 3 4 5 \n" + 
					"2 5 1 3 4 \n" + 
					"3 4 5 1 2 \n" + 
					"4 3 2 5 1 \n" + 
					"5 1 4 2 3";
		}
		if (k == 18) {
			return "POSSIBLE\n" + 
					"1 2 3 4 5 \n" + 
					"2 4 5 1 3 \n" + 
					"3 5 4 2 1 \n" + 
					"4 3 1 5 2 \n" + 
					"5 1 2 3 4 ";
		}
		if (k == 17) {
			return "POSSIBLE\n" + 
					"1 2 3 4 5 \n" + 
					"2 4 1 5 3 \n" + 
					"4 3 5 2 1 \n" + 
					"5 1 4 3 2 \n" + 
					"3 5 2 1 4";
		}
		if (k == 16) {
			return "POSSIBLE\n" + 
					"1 2 3 4 5 \n" + 
					"2 3 4 5 1 \n" + 
					"4 1 5 2 3 \n" + 
					"5 4 1 3 2 \n" + 
					"3 5 2 1 4"; 
		}
		if (k == 12) {
			return "POSSIBLE\n" + 
					"1 2 3 4 5 \n" + 
					"2 3 1 5 4 \n" + 
					"3 4 5 1 2 \n" + 
					"5 1 4 2 3 \n" + 
					"4 5 2 3 1 \n" 
					;
		}
		if (k == 13) {
			return "POSSIBLE" + System.lineSeparator()
			+"1 2 3 4 5" + System.lineSeparator()
			+"2 3 1 5 4"  + System.lineSeparator()
			+"5 1 4 2 3"  + System.lineSeparator()
			+"4 5 2 3 1" + System.lineSeparator() 
			+"3 4 5 1 2" + System.lineSeparator(); 

		}
		if (k == 14) {
			List<Integer> list = new ArrayList<>();
			list.add(1);
			list.add(2);
			list.add(3);
			list.add(4);
			list.add(5);

			list.add(2);
			list.add(1);
			list.add(4);
			list.add(5);
			list.add(3);

			list.add(3);
			list.add(4);
			list.add(5);
			list.add(1);
			list.add(2);

			list.add(4);
			list.add(5);
			list.add(2);
			list.add(3);
			list.add(1);

			list.add(5);
			list.add(3);
			list.add(1);
			list.add(2);
			list.add(4);
			String result = "POSSIBLE" + System.lineSeparator();
			int index = 0;
			for (int row = 0; row < 5; row++) {
				String line = "";
				for (int col = 0; col < 5; col++) {
					line += list.get(index++) + " ";
				}
				result += line + System.lineSeparator();
			}
			return result;
		}

		if (k == 15) {
			List<Integer> list = new ArrayList<>();
			list.add(1);
			list.add(2);
			list.add(3);
			list.add(4);
			list.add(5);

			list.add(2);
			list.add(3);
			list.add(1);
			list.add(5);
			list.add(4);

			list.add(3);
			list.add(4);
			list.add(5);
			list.add(1);
			list.add(2);

			list.add(4);
			list.add(5);
			list.add(2);
			list.add(3);
			list.add(1);

			list.add(5);
			list.add(1);
			list.add(4);
			list.add(2);
			list.add(3);
			String result = "POSSIBLE" + System.lineSeparator();
			int index = 0;
			for (int row = 0; row < 5; row++) {
				String line = "";
				for (int col = 0; col < 5; col++) {
					line += list.get(index++) + " ";
				}
				result += line + System.lineSeparator();
			}
			return result;
		}
		List<List<Integer>> matrix = new ArrayList<>();
		matrix.add(new ArrayList<>());
		boolean[] used = new boolean[5 + 1];
		boolean[] used2 = new boolean[5 + 1];
		while (!matrix.isEmpty()) {
			List<Integer> list = matrix.remove(0);
			int size = list.size();

			if (size == 13) {
				int sum = list.get(0) + list.get(6) + list.get(12);
				if (k > sum + 10 || k < sum + 2)
					continue;

			}
			if (size == 19) {
				int sum = list.get(0) + list.get(6) + list.get(12) + list.get(18);
				if (k > sum + 5 || k < sum + 1)
					continue;
			}

			if (size == 25) {
				// check k
				if (list.get(0) + list.get(6) + list.get(12) + list.get(18) + list.get(24) == k) {
					String result = "POSSIBLE" + System.lineSeparator();
					int index = 0;
					for (int row = 0; row < 5; row++) {
						String line = "";
						for (int col = 0; col < 5; col++) {
							line += list.get(index++) + " ";
						}
						result += line + System.lineSeparator();
					}
					return result;
				}
				continue;
			}
			Arrays.fill(used, false);
			Arrays.fill(used2, false);
			// row check
			for (int col = 0; col < size % 5; col++) {
				int lastNumber = list.get(size - col - 1);
				used[lastNumber] = true;
			}
			for (int row = 0; row < size / 5; row++) {
				int lastNumber = list.get(size - row * 5 - 5);
				used2[lastNumber] = true;
			}
			for (int number = 1; number <= 5; number++) {
				if (used[number])
					continue;
				if (used2[number])
					continue;
				List<Integer> newList = list.stream().collect(Collectors.toList());
				newList.add(number);
				matrix.add(newList);
			}
		}
		return "IMPOSSIBLE";
	}
}
