import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		int dummy = 0;
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		int n, s, e;
		for (int i = 0; i < t; i++) {
			n = scanner.nextInt();
			ArrayList<Activity> arr = new ArrayList<Activity>();
			for (int j = 0; j < n; j++) {
				s = scanner.nextInt();
				e = scanner.nextInt();
//				Activity activity = ;
//				activity.index = j;
				arr.add(new Activity(s, e, j, "J"));
			}

			Collections.sort(arr, new Comparator<Activity>() {
				@Override
				public int compare(Activity o1, Activity o2) {
					return o1.s - o2.s;
				}
			});

			ArrayList<Activity> arr2 = new ArrayList<Activity>();

			for (int j = 0; j < arr.size(); j++) { // for the main array (C)

				try { // remove that start at same time
					while (arr.get(j).s == arr.get(j + 1).s) {
						arr2.add(new Activity(arr.get(j + 1).s, arr.get(j + 1).e, arr.get(j + 1).index, "C"));
						arr.remove(arr.get(j + 1));
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}

				try { // remove that overlap at the end time
					while (!(arr.get(j).e <= arr.get(j + 1).s)) {
						arr2.add(new Activity(arr.get(j + 1).s, arr.get(j + 1).e, arr.get(j + 1).index, "C"));
						arr.remove(arr.get(j + 1));
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}

			for (int j = 0; j < arr2.size(); j++) { // for the second array (J)

				try { // remove that start at same time
					while (arr2.get(j).s == arr2.get(j + 1).s) {

						arr2.remove(arr2.get(j + 1));
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}

				try { // remove that overlap at the end time
					while (!(arr2.get(j).e <= arr2.get(j + 1).s)) {
						arr2.remove(arr2.get(j + 1));
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}

			dummy = i + 1;
			if (arr.size() + arr2.size() < n) {
				System.out.println("Case #" + dummy + ": IMPOSSIBLE");
			} else {

				ArrayList<Activity> mergedList = new ArrayList<Activity>();

				mergedList.addAll(arr);
				mergedList.addAll(arr2);

				Collections.sort(mergedList, new Comparator<Activity>() {
					@Override
					public int compare(Activity o1, Activity o2) {
						return o1.index - o2.index;
					}
				});

				String str = "";
				for (int j = 0; j < mergedList.size(); j++) {
					str += mergedList.get(j).name;
				}

				System.out.println("Case #" + dummy + ": "+str); 

			}
		}

	}

}

class Activity {
	int s, e, index;
	String name = "J";

	public Activity(int x, int y, int in, String n) {
		s = x;
		e = y;
		index = in;
		name = n;
	}
}