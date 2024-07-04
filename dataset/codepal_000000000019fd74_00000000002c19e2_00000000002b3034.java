
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	static String first = "", last = "";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = scn.nextInt();
		for (int i = 0; i < t; i++) {
			int n = scn.nextInt();
			first = "";
			last = "";
			ArrayList<String> al = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				al.add(scn.next());
			}
			int x = 1;
			for (int j = 0; j < n; j++) {
				String sb = al.get(j);
				//System.out.println(first + " " + last);
				if (sb.charAt(0) == '*') {
					x = solve(sb, 0) & x;
				} else if (sb.charAt(sb.length() - 1) == '*') {
					x = solve(sb, 1) & x;
				} else {
					x = solve(sb, 2) & x;
				}
			}
			if (x == 1) {
				String ans = first;
				//System.out.println(first + " " + last);

				int j = 0, k = 0;
				for (j = 0, k = 0; j < first.length();) {
					if (first.charAt(j) == last.charAt(k)) {
						j++;
						k++;
					} else {
						j++;
						k = 0;
					}
				}
				ans += last.substring(k);
				System.out.println("Case #"+(i+1)+": "+ans);
			} else {
				System.out.println("Case #"+(i+1)+": *");
			}
		}
	}

	public static int solve(String str, int x) {
		//System.out.println(str);
		if (x == 0) {
			int i = 0, j = 0;
			for (i = str.length() - 1, j = last.length() - 1; i >= 0 && j >= 0;) {
				if (str.charAt(i) == last.charAt(j)) {
					i--;
					j--;
				} else if (str.charAt(i) != '*') {
					// System.out.println("kkkkk"+i+" "+j+" "+str+" "+last);
					return 0;
				} else {
					break;
				}
			}
			if (j < 0 && str.length()>1) {
				String s = str.substring(1, i + 1);
				last = s + last;
			}
		} else if (x == 1) {
			int i = 0, j = 0;
			for (i = 0, j = 0; i < str.length() && j < first.length();) {
				if (str.charAt(i) == first.charAt(j)) {
					i++;
					j++;
				} else if (str.charAt(i) != '*') {
					return 0;
				} else {
					break;
				}
			}
			if (j == first.length()&&i<str.length()) {
				String s = str.substring(i, str.length()-1);
				first += s ;
			}
		} else {
			int i = 0, j = 0;
			while (str.charAt(i) != '*' && j < first.length()) {
				if (str.charAt(i) == first.charAt(j)) {
					i++;
					j++;
				} else if (str.charAt(i) != '*') {
					 //System.out.println("kkkkk"+i+" "+j+" "+str+" "+first);
					return 0;
				} else {
					break;
				}
			}

			int k = i;
			if(k<str.length()) {
				while (str.charAt(k) != '*') {
					k++;
				}
				String s = str.substring(i, k);
				first += s;
			}

			i = str.length() - 1;
			j = last.length() - 1;
			while (str.charAt(i) != '*' && j >= 0) {
				if (str.charAt(i) == last.charAt(j)) {
					i--;
					j--;
				} else if (str.charAt(i) != '*') {
					// System.out.println("kkkkk"+i+" "+j+" "+str+" "+last);

					return 0;
				} else {
					break;
				}
			}

			k = i;
			if(k>=0) {
				while (str.charAt(k) != '*') {
					k--;
				}
				String s = str.substring(k + 1, i+1);
				s += last;
				last = s;
			}
		}

		return 1;
	}
}
