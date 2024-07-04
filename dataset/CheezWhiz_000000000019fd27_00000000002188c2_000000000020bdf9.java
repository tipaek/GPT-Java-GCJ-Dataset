import java.util.*;

public class Solution {
	static class time implements Comparable<time> {
		int a;
		int b;

		public time(int A, int B) {
			a = A;
			b = B;
		}

		public int compareTo(time o) {
			return this.a - o.a;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			time[] arr = new time[n];
			for (int j = 0; j < n; j++) {
				int a = sc.nextInt(), b = sc.nextInt();
				arr[j] = new time(a, b);
			}
			Arrays.sort(arr);
			time cameron = new time(0, 0);
			time james = new time(0, 0);
			String ans = "";
			cameron = new time(arr[0].a, arr[0].b);
			ans += "C";
			for (int j = 1; j < n; j++) {
				if (arr[j].a >= cameron.b) {
					ans += "C";
					cameron = arr[j];
				} else if (arr[j].a >= james.b) {
					ans += "J";
					james = arr[j];
				} else {
					System.out.println("Case #" + t + ": IMPOSSIBLE");
				}
			}
			System.out.println("Case #" + t + ": " + ans);
		}
	}

}