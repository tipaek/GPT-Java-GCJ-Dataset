import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		solve();
	}

	private static void solve() {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int t = sc.nextInt();
		for (int i2 = 1; i2 <= t; i2++) {
			int n = sc.nextInt();
			ArrayList<String> list = new ArrayList<String>();
			
			for (int i = 0; i < n; i++) {
				String e = sc.next();
				list.add(e);
			}
			
			System.out.println("Case #" + i2 + ": " + solution(list));
		}

		sc.close();
	}

	private static String solution(ArrayList<String> list) {
		//System.out.println(list);
		HashSet<String> uniq = new HashSet<String>();
		uniq.addAll(list);
		//System.out.println(uniq);
		ArrayList<String> list2 = new ArrayList<String>(uniq);
		//System.out.println(list2);

		list2.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.length()-o1.length();
			}
		});
		String test = list2.get(0).substring(1);
		//System.out.println(list2 + " " + test);
		for (String p : list2) {
			if (!test.endsWith(p.substring(1))) {
				return "*";
			}
			
		}
		return test;
	}



}
