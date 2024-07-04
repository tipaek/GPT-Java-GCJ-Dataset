import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\revan\\Desktop\\All Files\\Coding\\Random Code\\CodeChallenges\\src\\CodeJam\\input.txt"));
		int t = Integer.parseInt(reader.readLine());
		for(int idx = 1; idx <= t; idx++) {
			System.out.print("Case #" + idx + ": ");
			solve(reader);
		}

		reader.close();
	}

	private static void solve(BufferedReader reader) throws IOException {
		int n = input(reader).get(0);
		int[][] arr = new int[n][n];
		int dupsRow = 0, dupsCols = 0, sum = 0;
		for(int j = 0; j < n; j++) {
			List<Integer> nums = input(reader);
			for(int k = 0; k < n; k++) {
				arr[j][k] = nums.get(k);
				if(j == k) {
					sum += arr[j][k];
				}
			}
		}

		Set<Integer> r = new HashSet<>();
		Set<Integer> c = new HashSet<>();
		for(int j = 0; j < n; j++) {
			for(int k = 0; k < n; k++) {
				if(r.contains(arr[j][k])) {
					dupsRow++;
					break;
				}

				r.add(arr[j][k]);
			}

			r.clear();
		}

		for(int j = 0; j < n; j++) {
			for(int k = 0; k < n; k++) {
				if(c.contains(arr[k][j])) {
					dupsCols++;
					break;
				}

				c.add(arr[k][j]);
			}

			c.clear();
		}

		System.out.println(sum + " " + dupsRow + " " + dupsCols);
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