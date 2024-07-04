import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		String s = input(reader, e -> e).get(0);
		StringBuilder stringBuilder = new StringBuilder();
		int bracesLeft = 0;
		for(char c : s.toCharArray()) {
			int i = Integer.parseInt(String.valueOf(c));
			if(i == 0) {
				for(int j = bracesLeft; j > 0; j--) {
					stringBuilder.append(")");
				}

				stringBuilder.append(0);
				bracesLeft = 0;
			} else if(i > bracesLeft) {
				for(int j = 0; j < i - bracesLeft; j++) {
					stringBuilder.append("(");
				}

				bracesLeft = i;
				stringBuilder.append(bracesLeft);
			} else if(i < bracesLeft) {
				stringBuilder.append(i);
				for(int j = 0; j < bracesLeft - i; j++) {
					stringBuilder.append(")");
				}

				bracesLeft = i;
			}
		}

		for(int j = 0; j < bracesLeft; j++) {
			stringBuilder.append(")");
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