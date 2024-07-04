import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(scan.readLine());

		outer: for (int cases = 1; cases <= t; cases++) {
			String[] inp = scan.readLine().split(" ");
			int N = Integer.parseInt(inp[0]);
			int D = Integer.parseInt(inp[1]);

			Long[] slices = new Long[N];
			inp = scan.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				slices[i] = Long.parseLong(inp[i]);
			}
			if (D == 2) {
				HashSet<Long> set = new HashSet<>();
				for (int i = 0; i < N; i++) {
					if (set.contains(slices[i])) {
						System.out.println("Case #" + cases + ": " + 0);
						continue outer;
					}
					set.add(slices[i]);
				}
				System.out.println("Case #" + cases + ": " + 1);
				continue outer;
			} else {
				HashMap<Long, Integer> map = new HashMap<>();
				for (int i = 0; i < N; i++) {
					if (!map.containsKey(slices[i])) {
						map.put(slices[i], 0);
					}
					
					map.put(slices[i], map.get(slices[i]) + 1);
					if (map.get(slices[i]) == 3) {
						System.out.println("Case #" + cases + ": " + 0);
						continue outer;
					}
				}

				for (Long key : map.keySet()) {
					if (map.get(key) == 2) {
						System.out.println("Case #" + cases + ": " + 1);
						continue outer;
					}
				}

				for (Long key : map.keySet()) {
					for (Long key2 : map.keySet()) {
						if (key == key2 * 2) {
							System.out.println("Case #" + cases + ": " + 1);
							continue outer;
						}
					}

				}
				System.out.println("Case #" + cases + ": " + 2);
				continue outer;

			}

		}

	}

}
