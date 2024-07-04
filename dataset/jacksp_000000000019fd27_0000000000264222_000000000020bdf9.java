import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {

	public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {

			int n = sc.nextInt();
			HashMap<Integer, Set<Integer>> map = new HashMap<>();
			int[] arrival = new int[n];
			int[] ending = new int[n];
			for (int j = 0; j < n; j++) {
				arrival[j] = sc.nextInt();
				ending[j] = sc.nextInt();

				if (map.containsKey(arrival[j])) {
					Set<Integer> set = map.get(arrival[j]);
					set.add(ending[j]);
					map.put(arrival[j], set);

				} else {
					Set<Integer> set=new HashSet<>();
					set.add(ending[j]);
					map.put(arrival[j],set);

				}
			}

			Arrays.sort(arrival);
			Arrays.sort(ending);

			int one = 0, another = 0;
			char free = 'J';
			int jack_key = -1;
			int carr_key = -1;
			int count = 0;
			int flag = 0;
			StringBuilder ans = new StringBuilder();
			while (one < n) {
				if (arrival[one] >= ending[another]) {
					if (map.containsKey(jack_key) && map.get(jack_key).contains(ending[another])) {
						free = 'J';
					} else if (map.containsKey(carr_key) &&  map.get(carr_key).contains(ending[another])) {
						free = 'C';
					}
					another++;
					count--;
				} else {
					count++;
					if (count > 2) {
						flag = 1;

						break;
					}
					ans.append(free);
					if (free == 'J') {
						jack_key = arrival[one];
						free = 'C';
					} else {
						carr_key = arrival[one];
						free = 'J';
					}
					one++;

				}

			}
			System.out.print("Case #");
			System.out.print((i + 1) + ": ");
			if (flag == 0) {
				System.out.print(ans);
			} else {
				System.out.print("IMPOSSIBLE");
			}
			System.out.println();

		}
	}
}
