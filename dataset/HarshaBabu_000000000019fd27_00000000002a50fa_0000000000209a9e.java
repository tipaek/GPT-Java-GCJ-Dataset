import java.io.*;
import java.util.*;

public class Solution {

	public static void main1(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		solve(br);
	}

	public static void solve(BufferedReader br) throws IOException {
		int numberOfTestCases = Integer.parseInt(br.readLine());
		for (int i = 1; i <= numberOfTestCases; i++) {

			int arrLen = Integer.parseInt(br.readLine());

			int queryCount = arrLen;

			List<Integer> pos = new ArrayList<Integer>();

			int[] arr = new int[arrLen];

			for (int p = 1; p <= arrLen; p++) {
				System.out.println(p);

				int bit = Integer.parseInt(br.readLine());

				int o = p % 10;

				if (o == 1) {
					pos.add(p);
				}

				arr[p - 1] = bit;

			}

			pos = rucursiveArrayBuilder(arr, pos, queryCount, br);
			queryCount = queryCount + pos.size();
			while (pos.size() <= 0) {
				rucursiveArrayBuilder(arr, pos, queryCount, br);
				queryCount = queryCount + pos.size();
			}

			StringBuilder bits = new StringBuilder();
			for (int j = 0; j < arr.length; j++) {
				bits.append(arr[j]);
			}

			System.out.println(bits.toString());
		}
	}

	public static List<Integer> rucursiveArrayBuilder(int[] arr, List<Integer> pos, int queryCount, BufferedReader br)
			throws NumberFormatException, IOException {
		List<Integer> nextRecurpos = new ArrayList<Integer>();
		for (int p = 0; p < pos.size(); p++) {
			System.out.println(p);

			int bit = Integer.parseInt(br.readLine());

			int o = (queryCount + p) % 10;

			if (o == 1) {
				nextRecurpos.add(p);
			}

			arr[p - 1] = bit;
		}
		return nextRecurpos;
	}

}
