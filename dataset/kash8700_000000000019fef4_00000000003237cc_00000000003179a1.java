

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
	static int max = 10;

	// modifies c to next permutation or returns null if such permutation does
	// not exist
	private static char[] nextPermutation(final char[] a) {
		// 1. finds the largest k, that c[k] < c[k+1]
		int first = getFirst(a);
		if (first == -1)
			return null; // no greater permutation
		// 2. find last index toSwap, that c[k] < c[toSwap]
		int toSwap = a.length - 1;
		while (a[first] >= a[toSwap])
			--toSwap;
		// 3. swap elements with indexes first and last
		swap(a, first++, toSwap);
		// 4. reverse sequence from k+1 to n (inclusive)
		toSwap = a.length - 1;
		while (first < toSwap)
			swap(a, first++, toSwap--);
		return a;
	}

	// finds the largest k, that c[k] < c[k+1]
	// if no such k exists (there is not greater permutation), return -1
	private static int getFirst(final char[] a) {
		for (int i = a.length - 2; i >= 0; --i)
			if (a[i] < a[i + 1])
				return i;
		return -1;
	}

	// swaps two elements (with indexes i and j) in array
	private static void swap(final char[] a, final int i, final int j) {
		final char tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(r);
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		int tc = 0;
		while (t-- > 0) {
			tc++;
			int u = Integer.parseInt(br.readLine());

			TreeSet<Character> tset = new TreeSet<>();
			long m[] = new long[max];
			String s[] = new String[max];
			for (int i = 0; i < max; i++) {
				String str[] = br.readLine().split(" ");
				m[i] = Long.parseLong(str[0]);
				s[i] = str[1];
				if (s[i].length() == 1) {
					tset.add(s[i].charAt(0));
				}
			}
			for (int i = 0; i < max; i++) {
				for (char ch : s[i].toCharArray()) {
					if (!tset.contains(ch)) {
						tset.add(ch);
					}
				}
			}
			char a[] = new char[10];
			int idx = 0;
			for (char key : tset) {
				a[idx] = key;
				idx++;
			}

			while ((a) != null) {
				int val[] = new int[26];
				for (int i = 0; i < 10; i++) {
					val[a[i] - 'A'] = i;
				}
				boolean ok = true;
				A: for (int i = 0; i < max; i++) {
					long no = 0;
					for (char ch : s[i].toCharArray()) {
						no = no * 10 + val[ch - 'A'];
					}
					if (no != m[i]) {
						ok = false;
						break A;
					}
				}

				if (ok) {
					break;
				}
				a = nextPermutation(a);
			}
			sb.append("Case #" + tc + ": " + (new String(a)) + "\n");
		}
		System.out.println(sb);

	}

}
