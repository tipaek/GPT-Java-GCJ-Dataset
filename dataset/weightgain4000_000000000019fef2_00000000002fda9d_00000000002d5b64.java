import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * cd /Users/ottsjo/dev/spec/codejam/target
 * cd classes && java Solution && cd ..
 *
 * python interactive_runner.py python testing_tool_XX.py 0 -- java Solution
 */
class Solution {

	public static void main(String[] args) {
		Solution problem = new Solution();
		problem.solve();
	}

	/*

5
2 2
3 2
2 3
1 4
4 1

	 */

	// paste from here :)

	private int numberOfRanks;
	private int numberOfSuits;

	private void solve() {
		Executor.executeDefault(this::getCaseResult);
	}

	private String getCaseResult(Scanner scanner) {
		int[] meta = ScannerExtensions.getIntArray(scanner);
		numberOfRanks = meta[0];
		numberOfSuits = meta[1];

		List<Card> cards = getCards(numberOfRanks, numberOfSuits);
		List<Integer[]> transformations = new ArrayList<>();

		int counter = 0;
		while (true) {
			int positionB = getNextBPosition(cards);
			if (positionB == -1) {
				break; // done :)
			}
			int positionA = getNextAPosition(cards, getExpectedRankAtIndex(positionB), positionB);

			transformations.add(new Integer[] {positionA+1, positionB-positionA});

			List<Card> A = new ArrayList<>(cards.subList(0, positionA+1));
			List<Card> B = new ArrayList<>(cards.subList(positionA+1, positionB+1));
			List<Card> C = new ArrayList<>(cards.subList(positionB+1, cards.size()));

			cards = B;
			cards.addAll(A);
			cards.addAll(C);

			counter++;
		}

		String trans = transformations.stream().map(x -> x[0] + " " + x[1]).collect(Collectors.joining(System.lineSeparator()));

		if (counter == 0) {
			return "0";
		}
		return counter + System.lineSeparator() + trans;
	}

	private int getNextAPosition(List<Card> cards, int rank, int maxIndex) {
		for (int i = 0; i <= maxIndex; i++) {
			if (cards.get(i).rank == rank) {
				return i;
			}
		}
		return -1;
	}

	private int getNextAPositionOld(List<Card> cards, int rank, int maxIndex) {
		for (int i = maxIndex; i >= 0; i--) {
			if (cards.get(i).rank == rank) {
				return i;
			}
		}
		return -1;
	}

	private int getNextBPosition(List<Card> cards) {
		for (int i = cards.size()-1; i >= 0; i--) {
			if (cards.get(i).rank != getExpectedRankAtIndex(i)) {
				return i;
			}
		}
		return -1;
	}

	private int getExpectedRankAtIndex(int i) {
		return 1+i/numberOfSuits;
	}

	private List<Card> getCards(int numberOfRanks, int numberOfSuits) {
		List<Card> cards = new ArrayList<>();
		for (int suit = 0; suit < numberOfSuits; suit++) {
			for (int rank = 0; rank < numberOfRanks; rank++) {
				cards.add(new Card(rank+1, suit+1));
			}
		}
		return cards;
	}

	private static class Card {
		private final int rank;
		private final int suit;

		public Card(int rank, int suit) {
			this.rank = rank;
			this.suit = suit;
		}

		@Override
		public String toString() {
			return rank + " " + suit;
		}
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
