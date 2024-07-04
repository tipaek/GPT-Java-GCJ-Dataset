import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int desiredSize = in.nextInt();
			int desiredTrace = in.nextInt();
			System.out.println("Case #" + i + ": " + possibleToGenerate(desiredSize, desiredTrace));
		}
	}

	private static String possibleToGenerate(int desiredSize, int desiredTrace) {
		if (desiredSize > desiredTrace) {
			return "IMPOSSIBLE";
		}
		if (desiredSize == 1 && desiredTrace != 1) {
			return "IMPOSSIBLE";
		}
		if (desiredSize == 2 && (desiredTrace != 2 || desiredTrace != 4)) {
			return "IMPOSSIBLE";
		}
		List<Integer> allTraces = new ArrayList<>();
		for (int i = 1; i <= desiredTrace;i++) {
			allTraces.add(i * desiredSize);
		}
		allTraces.add(IntStream.range(1, desiredSize + 1).sum());
		boolean result = allTraces.contains(desiredTrace);
		return result ? "POSSIBLE" : "IMPOSSIBLE";
	}

}