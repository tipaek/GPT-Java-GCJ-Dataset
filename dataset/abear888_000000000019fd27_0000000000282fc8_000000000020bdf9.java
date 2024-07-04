import java.io.*;
import java.util.*;

// public class C {
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int cases = 1; cases <= t; cases++) {
            int N = sc.nextInt();
            Activity[] a = new Activity[N];
			Activity[] unsorted = new Activity[N];
            for (int i = 0; i < N; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                a[i] = new Activity(start, end);
				unsorted[i] = new Activity(start, end);
            }
            Arrays.sort(a);
            int[] ans = new int[N];
            int[] occupied = new int[2];
            boolean good = false;
            for (int i = 0; i < N; i++) {
                good = false;
                for (int j =0; j < 2; j++) {
                    if (occupied[j] <= a[i].start) { // Are free
                        ans[i] = j;
                        occupied[j] = a[i].end;
                        good = true;
                        break;
                    }
                }
                if (!good) break;
            }
            if (good) {
                System.out.print("Case #" + cases + ": ");
				// Suboptimal but good enough
				boolean[] used = new boolean[N]; // In case we have identical tasks
                for (int i = 0; i < N; i++) {
					// Find the task in the sorted array.
					for (int j = 0; j < N; j++) {
						if (!used[j] && a[j].start == unsorted[i].start && a[j].end == unsorted[i].end) {
							if (ans[j] == 0) System.out.print("C");
							if (ans[j] == 1) System.out.print("J");
							used[j] = true;
							break;
						}
					}
                }
                System.out.println();
            } else {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", cases));
            }
        }
    }
}

class Activity implements Comparable<Activity> {
    int start;
    int end;

    Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int compareTo(Activity other) {
        return this.start - other.start;
    }

}
