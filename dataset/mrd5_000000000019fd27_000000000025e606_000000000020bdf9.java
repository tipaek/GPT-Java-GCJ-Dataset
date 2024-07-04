import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));) {

			int t = Integer.parseInt(br.readLine());
			for (int x = 0; x < t; x++) {

				int n = Integer.parseInt(br.readLine());
				List<Activity> list = new ArrayList<>();
				for (int i = 0; i < n; i++) {
					String[] s = br.readLine().split("\\s+");
					list.add(new Activity(i, Integer.parseInt(s[0]),
							Integer.parseInt(s[1])));
				}

				Collections.sort(list);
				char[] act = new char[n];

				int c = -1;
				int j = -1;
				boolean flag = true;
				for (Activity a : list) {
					if (c <= a.start) {
						c = a.end;
						act[a.index] = 'C';
					} else if (j <= a.start) {
						j = a.end;
						act[a.index] = 'J';
					} else {
						flag = false;
						break;
					}
				}
				System.out.print("Case #" + (x + 1) + ": ");
				System.out.println(flag ? new String(act) : "IMPOSSIBLE");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	static class Activity implements Comparable<Activity> {
		int index;
		int start;
		int end;

		Activity(int i, int s, int e) {
			index = i;
			start = s;
			end = e;
		}

		public int compareTo(Activity a) {
			if (this.start != a.start)
				return this.start - a.start;
			return this.end - a.end;
		}
	}

}
