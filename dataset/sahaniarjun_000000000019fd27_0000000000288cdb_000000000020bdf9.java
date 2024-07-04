import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		boolean nonFirst = false;
		for (int i = 0; i < t; i++) {
			int[][] inputs;
			int n;
			n = Integer.parseInt(br.readLine());
			inputs = new int[n][4];
			for (int j = 0; j < n; j++) {
				String[] input = br.readLine().split(" ");
				inputs[j][0] = Integer.parseInt(input[0]);
				inputs[j][1] = Integer.parseInt(input[1]);
				inputs[j][2] = j;
			}
			sortbyColumn(inputs, 0);
			String output = findPath(inputs);

			if (nonFirst)
				System.out.println();
			else
				nonFirst = true;

			System.out.print("Case #" + (i + 1) + ": " + output);
		}
	}

	private static String findPath(int[][] inputs) {
		Map<Integer, Integer> jMap = new HashMap<>();
		Map<Integer, Integer> cMap = new HashMap<>();
		for (int i = 0; i < inputs.length; i++) {
			int start = inputs[i][0];
			int end = inputs[i][1];
			if (noConflict(start, end, jMap)) {
				jMap.put(start, end);
				inputs[i][3] = 0;
				continue;
			}
			if (noConflict(start, end, cMap)) {
				cMap.put(start, end);
				inputs[i][3] = 1;
				continue;
			}
			return "IMPOSSIBLE";
		}
		String output = "";
		sortbyColumn(inputs, 2);
		for (int i = 0; i < inputs.length; i++) {
			output += (inputs[i][3] == 0 ? "J" : "C");
		}
		return output;

	}

	public static void sortbyColumn(int arr[][], int col) {
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(final int[] entry1, final int[] entry2) {

				if (entry1[col] > entry2[col])
					return 1;
				else
					return -1;
			}
		});
	}

	private static boolean noConflict(int start, int end, Map<Integer, Integer> tasks) {
		for (Entry<Integer, Integer> task : tasks.entrySet()) {
			if (task.getKey() == start || start < task.getValue()) {
				return false;
			}
		}
		return true;
	}

}
