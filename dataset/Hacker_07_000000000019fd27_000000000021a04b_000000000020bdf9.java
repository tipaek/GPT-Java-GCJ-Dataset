import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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
		List<Integer> c = new ArrayList<>(), j = new ArrayList<>();
		int n = input(reader).get(0);
		while(n-- > 0) {
			List<Integer> be = input(reader);
			int b = be.get(0), e = be.get(1);
			boolean cOccupied = c.stream().anyMatch(i -> i > b && i < e);
			boolean jOccupied = j.stream().anyMatch(i -> i > b && i < e);
			if(cOccupied && jOccupied) {
				return "IMPOSSIBLE";
			}

			if(!cOccupied) {
				stringBuilder.append("C");
				for(int i = b; i <= e; i++) {
					c.add(i);
				}
			} else {
				stringBuilder.append("J");
				for(int i = b; i <= e; i++) {
					j.add(i);
				}
			}
		}

		return stringBuilder.toString();
	}

	private static List<Integer> input(BufferedReader reader) throws IOException {
		return input(reader, Integer::valueOf);
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