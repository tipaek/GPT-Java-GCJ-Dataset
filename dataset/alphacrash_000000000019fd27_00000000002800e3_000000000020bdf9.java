import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int x = 1; x <= t; x++) {
			int n = sc.nextInt();
			int originalStart[] = new int[n];
			int originalFinish[] =new int[n];
			
			for(int i=0; i<n; i++) {
				originalStart[i] = sc.nextInt();
				originalFinish[i] = sc.nextInt();
			}
			
			int s[] = new int[n];
			int f[] = new int[n];
			for (int i = 0; i < originalStart.length; i++) {
				s[i] = originalStart[i];
				f[i] = originalFinish[i];
			}
			Activity act[] = new Activity[n];
			for (int i = 0; i < n; i++) {
				act[i] = new Activity(i, s[i], f[i]);
			}
			Arrays.sort(act);

			// For Cameron
			for (int i = 0; i < n; i++) {
				s[i] = act[i].s;
				f[i] = act[i].f;
			}
			Object cameron[] = getMaxActivities(s, f, n);

			int m = n - cameron.length;
			Activity remaining[] = new Activity[m];
			int j = 0;
			for (int i = 0; i < n; i++) {
				if (!inList(i, cameron)) {
					remaining[j] = new Activity(i, s[i], f[i]);
					j++;
				}
			}

			int start[] = new int[m];
			int finish[] = new int[m];
			// For James
			for (int i = 0; i < m; i++) {
				start[i] = remaining[i].s;
				finish[i] = remaining[i].f;
			}
			Object james[] = getMaxActivities(start, finish, m);

			// Result
			int possibleActivity;
			if (m == 0) {
				possibleActivity = cameron.length;
			} else {
				possibleActivity = cameron.length + james.length;
			}

			ReSort re[] = new ReSort[n];
			System.out.print("Case #" + x + ": ");
			if (possibleActivity == n) {
				for (int i = 0; i < n; i++) {
					if (inList(i, cameron)) {
						re[i] = new ReSort('C', act[i]);
					} else {
						re[i] = new ReSort('J', act[i]);
					}
				}
				String message = getResult(re);
				System.out.print(message);
			} else {
				System.out.print("IMPOSSIBLE");
			}
			System.out.println();
		}
	}

	public static Object[] getMaxActivities(int s[], int f[], int n) {
		int i = 0, j;

		ArrayList<Integer> selected = new ArrayList<Integer>();
		selected.add(i);

		for (j = 1; j < n; j++) {
			if (s[j] >= f[i]) {
				selected.add(j);
				i = j;
			}
		}
		return selected.toArray();
	}

	public static boolean inList(int num, Object[] objects) {
		for (Object o : objects) {
			if (num == (int) o) {
				return true;
			}
		}
		return false;
	}

	public static String getResult(ReSort[] x) {
		Arrays.sort(x);
		String result = "";
		for(int i=0; i<x.length; i++) {
			result += x[i].c;
		}
		return result;
	}
}

class Activity implements Comparable<Activity> {
	int i;
	int s;
	int f;

	public Activity(int i, int s, int f) {
		this.i = i;
		this.s = s;
		this.f = f;
	}

	public int compareTo(Activity x) {
		if (this.f == x.f)
			return 0;
		else if (this.f > x.f)
			return 1;
		else
			return -1;
	}

	@Override
	public String toString() {
		return "Activity [i=" + i + ", s=" + s + ", f=" + f + "]";
	}
}

class ReSort implements Comparable<ReSort> {
	char c;
	Activity a;
	
	public ReSort(char c, Activity a) {
		this.c = c;
		this.a = a;
	}
	
	public int compareTo(ReSort x) {
		if(this.a.i == x.a.i) {
			return 0;
		} else if(this.a.i > x.a.i) {
			return 1;
		} else {
			return -1;
		}
	}
}