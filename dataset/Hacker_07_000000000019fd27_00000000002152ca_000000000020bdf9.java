import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\revan\\Desktop\\All Files\\Coding\\Random Code\\CodeChallenges\\src\\CodeJam\\input.txt"));
		int t = Integer.parseInt(reader.readLine());
		for(int idx = 1; idx <= t; idx++) {
			output(idx, solve(reader));
		}

		reader.close();
	}

	private static String solve(BufferedReader reader) throws IOException {
		StringBuilder stringBuilder = new StringBuilder();
		List<Integer> remaining = IntStream.rangeClosed(0, 1441).boxed().collect(Collectors.toList()), c = new ArrayList<>(), j = new ArrayList<>();
		int n = input(reader).get(0);
		while(n-- > 0) {
			List<Integer> be = input(reader);
			int b = be.get(0), e = be.get(1);
			boolean cOccupied = (c.contains(b + 1) || c.contains(e - 1));
			boolean jOccupied = (j.contains(b + 1) || j.contains(e - 1));
			if(cOccupied && jOccupied) {
				return "IMPOSSIBLE";
			}

			List<Integer> range = IntStream.rangeClosed(b, e).boxed().collect(Collectors.toList());
			remaining.removeAll(range);
			if(!cOccupied) {
				stringBuilder.append("C");
				c.addAll(range);
			} else {
				stringBuilder.append("J");
				j.addAll(range);
			}
		}

		return stringBuilder.toString();
	}

	private static List<Integer> input(BufferedReader reader) throws IOException {
		return input(reader, Integer::valueOf);
	}

	private static int[] input(BufferedReader reader, boolean isArray) throws IOException {
		return Arrays.stream(reader.readLine().split(" "))
					 .mapToInt(Integer::valueOf)
					 .toArray();
	}

	private static <T> List<T> input(BufferedReader reader, Function<String, T> function) throws IOException {
		return Arrays.stream(reader.readLine().split(" "))
					 .map(function)
					 .collect(Collectors.toList());
	}

	private static <T> void output(int idx, T answer) {
		System.out.println(
				String.format(
						"Case #%d: %s",
						idx,
						answer.toString()
				)
		);
	}
}