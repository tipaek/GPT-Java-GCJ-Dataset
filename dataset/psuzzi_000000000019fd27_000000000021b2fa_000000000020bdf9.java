import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.function.Consumer;

public class Solution {

	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
		//scan("problem/qual.p3/input1.txt", in -> {
			int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
			for (int i = 1; i <= t; ++i) {
				int n = in.nextInt();
				List<Activity> activities = new ArrayList<>();
				for (int l = 0; l < n; l++) {
					activities.add(new Activity(l, in.nextInt(), in.nextInt()));
				}

				System.out.println("Case #" + i + ": " + solve(n, activities));
			}
		//});
		 in.close();
	}

	static class Activity implements Comparable<Activity> {
		public Activity(int id, int start, int end) {
			this.id = id;
			this.start = start;
			this.end = end;
		}

		int id;
		int start;
		int end;

		@Override
		public int compareTo(Activity o) {
			return Integer.compare(this.end, o.end);
		}

	}

	private static String solve(int n, List<Activity> as) {
		StringBuilder sb = new StringBuilder();
		Activity ca = null, ja = null;
		char[] res = new char[n]; 

		as.sort((a, b) -> Integer.compare(a.end, b.end));
		for (Activity a : as) {

			if (ca == null) {
				ca = a;
				res[a.id] = 'C';
			} else if (ja == null) {
				ja = a;
				res[a.id] = 'J';
			} else if (a.start >= ca.end) {
				ca = a;
				res[a.id] = 'C';
			} else if (a.start >= ja.end) {
				ja = a;
				res[a.id] = 'J';
			} else {
				return "IMPOSSIBLE";
			}
		}
		return new String(res);
	}

	static void scan(String filename, Consumer<Scanner> consumer) {
		try (Scanner sc = new Scanner(new File(filename))) {
			consumer.accept(sc);
		} catch (FileNotFoundException e) {
			System.err.printf("Error scanning %s", filename);
			e.printStackTrace();
		}
	}

}