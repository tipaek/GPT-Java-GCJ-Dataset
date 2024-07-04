
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			int r = sc.nextInt();
			int s = sc.nextInt();

			List<String> res = process(r, s);
			System.out.println("Case #" + i + ": " + res.size());
			for (String st : res)
				System.out.println(st);
		}
		sc.close();
	}

	private static List<String> process(int r, int s) {
		List<String> res = new ArrayList<>();
		A a[] = new A[r * s];

		int k = 0;
		for (int i = 1; i <= s; i++) {
			for (int j = 1; j <= r; j++)
				a[k++] = new A(j, i);
		}

		int i = a.length - 1;
		while (true) {
			int j = i - 1;
			while (j >= 0 && a[j].r != a[i].r) {
				j--;
			}
			reverse(a, 0, j);
			reverse(a, j + 1, i - 1);
			reverse(a, 0, i - 1);
			String st = "";
			st += (j - 0 + 1) + " ";
			st += (i - j - 1);
			res.add(st);
			if (isValid(a, r, s))
				break;
			while (i > 0 && a[i - 1].r == a[i].r)
				i--;
			if ((a.length - i) % s == 0)
				i--;
		}
		return res;
	}

	private static boolean isValid(A[] a, int r, int s) {

		int rank = 1;
		int i = 0;
		while (i < a.length) {
			if (a[i].r != rank)
				return false;
			i++;
			if (i % s == 0) {
				rank++;
			}
		}
		return true;
	}

	public static void reverse(A a[], int l, int r) {

		while (l < r) {
			A temp = a[l];
			a[l] = a[r];
			a[r] = temp;
			l++;
			r--;
		}
	}

}

class A {
	int r;
	int s;

	A(int r, int s) {
		this.r = r;
		this.s = s;
	}

	public String toString() {

		return r + "," + s;

	}
}
