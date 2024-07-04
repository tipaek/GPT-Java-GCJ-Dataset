import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
	static class Activity implements Comparable<Activity> {
		Integer start;
		Integer end;
		
		Activity(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Activity activity) {
			return this.start.compareTo(activity.start);
		}
		
		@Override
		public String toString() {
			return "Activity{" +
					       "start=" + start +
					       ", end=" + end +
					       '}';
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = scanner.nextInt();
		
		for (int i1 = 1; i1 <= t; ++i1) {
			int n = scanner.nextInt();
			ArrayList<Activity> list = new ArrayList<>();
			
			for (int i = 0; i < n; ++i) {
				list.add(new Activity(scanner.nextInt(), scanner.nextInt()));
			}
			
			Collections.sort(list);
			
			StringBuilder stringBuilder = new StringBuilder();
			int c = 0;
			int j = 0;
			
			for (Activity activity : list) {
				if (c <= activity.start) {
					stringBuilder.append("C");
					c = activity.end;
				} else if (j <= activity.start) {
					stringBuilder.append("J");
					j = activity.end;
				} else {
					stringBuilder.delete(0, stringBuilder.length());
					stringBuilder.append("IMPOSSIBLE");
					break;
				}
			}
			
			System.out.println("Case #" + i1 + ": " + stringBuilder.toString());
		}
	}
}