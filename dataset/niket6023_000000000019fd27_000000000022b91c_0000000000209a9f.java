
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner nik = new Scanner(System.in);
		int t = nik.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			char[] s = nik.next().toCharArray();
			int n = s.length;
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = s[i] - '0';
			}

			StringBuilder st = new StringBuilder();
			ArrayList<StringBuilder> a1 = new ArrayList<>();
			int c = 0;
			int max = a[0];
			int temp = 0;
			for (int i = 0; i < n; i++, temp++) {

				if (a[i] == 0) {
					st.append(0);
					a1.add(st);
					st = new StringBuilder();
				} else if (st.length() == 0) {
					appendkar(st, a[i], 0);
					st.append(a[i]);
					ultaappend(st, a[i]);
				} else if (a[i] >= a[i - 1] && c == 0) {
					max = max > a[i - 1] ? max : a[i - 1];
					appendkar(st, a[i] - a[i - 1], max + temp);
					st.insert(st.length() - a[i] + (a[i] - a[i - 1]), a[i]);
					ultaappend(st, a[i] - a[i - 1]);

				} else if (a[i] < a[i - 1]) {
					c++;
					st.insert(st.length() - a[i], a[i]);
				} else {
					a1.add(st);
					st = new StringBuilder();
					appendkar(st, a[i], 0);
					st.append(a[i]);
					ultaappend(st, a[i]);
					max = a[i];
					temp = 0;
					c = 0;
				}
			}

			a1.add(st);
			st = new StringBuilder();
			for (int i = 0; i < a1.size(); i++) {
				st.append(a1.get(i));
			}
			System.out.println("Case #"+tc+": "+st);

		}
	}

	private static void ultaappend(StringBuilder st, int n) {
		for (int i = 0; i < n; i++) {
			st.append(')');
		}
	}

	private static void appendkar(StringBuilder st, int n, int k) {
		int i = 0;
		while (i < n) {
			st.insert(k + i, '(');
			i++;
		}
	}

}