import java.io.*;
import java.util.*;

class Pair {
	int x;
	int y;
	int index;

	public Pair(int x, int y, int i) {
		this.x = x;
		this.y = y;
		this.index = i;

	}

	public Pair() {

	}
}

class Compare {

	static void compare(Pair arr[], int n) {
		Arrays.sort(arr, new Comparator<Pair>() {
			@Override
			public int compare(Pair p1, Pair p2) {
				return p1.x - p2.x;
			}
		});

//		for (int i = 0; i < n; i++) {
//			System.out.println(arr[i].x + " " + arr[i].y + " " + arr[i].index);
//		}
//		System.out.println();
	}
}

class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		int cs = 1;
		while (t-- > 0) {
			String res = "";
			int n = sc.nextInt();
			Pair arr[] = new Pair[n];
			for (int i = 0; i < n; i++) {
				arr[i] = new Pair();
				arr[i].x = sc.nextInt();
				arr[i].y = sc.nextInt();
				arr[i].index = i;
			}
			Compare obj = new Compare();

			obj.compare(arr, n);
			int end = arr[0].y;
			int start = arr[0].x;
			char[] ch = new char[n];
			Arrays.fill(ch, '0');
			ch[arr[0].index] = 'C';
			int ind = 0;
			for (int i = 1; i < n; i++) {
				if (arr[i].x >= end) {
					ch[arr[i].index] = 'C';
					end = arr[i].y;
				} else if (ind == 0) {
					ind = i;
				}
			}
			ch[arr[ind].index] = 'J';
			end = arr[ind].y;
			for (int i = ind + 1; i < n; i++) {

				if (arr[i].x >= end && ch[arr[i].index] == '0') {
					ch[arr[i].index] = 'J';
					end = arr[i].y;
				}
			}
			for (int i = 0; i < n; i++) {
				if (ch[i] != '0') {
					res += ch[i];
				} else {
					res = "IMPOSSIBLE";
					break;
				}
			}
			System.out.println("Case #" + cs + ": " + res);
			cs++;
		}

	}
}