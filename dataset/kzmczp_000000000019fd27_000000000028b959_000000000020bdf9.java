import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			int n = sc.nextInt();
			List<int[]> tasks = new ArrayList<>(n);
			for (int j = 0; j < n; j++) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				tasks.add(new int[] { s, e, j, ' ' });
			}
			tasks.sort(Comparator.comparingInt(ta -> ta[0]));
			tasks.get(0)[3] = 'C';
			int camEndTime = tasks.get(0)[1];
			boolean impossible = false;
			for (int j = 1; j < n; j++) {
				int[] task = tasks.get(j);
				if (task[0] >= camEndTime) {
					task[3] = 'C';
					camEndTime = task[1];
				} else { // Cameron cannot do task j, let's check if Jamie can
					int[] prev = tasks.get(j - 1);
					if (prev[3] == 'C' || (prev[1] <= task[0])) {
						task[3] = 'J';
					} else {
						impossible = true;
						break;
					}
				}
			}
			tasks.sort(Comparator.comparingInt(ta -> ta[2]));
			String result = impossible ?
					"IMPOSSIBLE" :
					tasks.stream().map(ta -> String.valueOf((char) ta[3])).collect(Collectors.joining());
			System.out.println(String.format("Case #%d: %s", i, result));
		}
	}
}