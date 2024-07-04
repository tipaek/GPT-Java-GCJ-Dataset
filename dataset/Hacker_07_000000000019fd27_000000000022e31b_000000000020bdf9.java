import java.io.BufferedReader;
import java.io.FileReader;
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
		int n = input(reader).get(0);
		List<List<Integer>> slots = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			slots.add(input(reader));
		}

		List<Integer> j = new ArrayList<>(), c = new ArrayList<>();
		StringBuilder schedule = new StringBuilder();
		for(List<Integer> times : slots) {
			if(!isOccupied(j, times.get(0), times.get(1))) {
				schedule.append("J");
				j.addAll(times);
			} else if(!isOccupied(c, times.get(0), times.get(1))) {
				schedule.append("C");
				c.addAll(times);
			} else {
				return "IMPOSSIBLE";
			}
		}

		return schedule.toString();
	}

	private static boolean isOccupied(List<Integer> times, int start, int end) {
		for(int i = 0; i < times.size(); i += 2) {
			if(times.get(i) < end && end <= times.get(i + 1)) {
				return true;
			}

			if(times.get(i) <= start && start < times.get(i + 1)) {
				return true;
			}
		}

		return false;
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