import java.util.*;
import java.util.Map.Entry;

import java.math.*;
import java.io.*;

public class Solution {
	static List<Long> list1;
	static List<String> list2;

	public static void main(String[] args) throws FileNotFoundException {
		// InputReader in = new InputReader(System.in);
		// Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		// Scanner in = new Scanner(new File("sample.in.txt"));
		PrintWriter out = new PrintWriter(System.out);
		// InputReader in = new InputReader(new
		// File("ethan_traverses_a_tree.txt"));
		// PrintWriter out = new PrintWriter(new
		// File("ethan_traverses_a_tree-output.txt"));

		int pi = in.nextInt();
		for (int qi = 1; qi <= pi; qi++) {
			list1 = new ArrayList<Long>();
			list2 = new ArrayList<String>();

			int u = in.nextInt();
			for (int i = 0; i < 10000; i++) {
				list1.add(in.nextLong());
				list2.add(in.next());
			}

			if (list1.get(0) < 0) {
				String ans = slove3();
				out.printf("Case #%d: %s\n", qi, ans);
			} else {
				String ans = slove12();
				out.printf("Case #%d: %s\n", qi, ans);
			}
		}

		out.close();
	}

	public static String slove3() {
		int n = list1.size();

		Set<Character> all = new HashSet<Character>();
		Set<Character> not0 = new HashSet<Character>();

		for (int i = 0; i < n; i++) {
			String sstr = list2.get(i);

			for (int j = 0; j < sstr.length(); j++) {
				all.add(sstr.charAt(j));
			}

			not0.add(sstr.charAt(0));
		}

		char[] ans = new char[10];
		int index = 0;
		for (Character ch : all) {
			ans[index] = ch;
			index++;
		}

		while (index < 10) {
			for (char ch = 'A'; ch <= 'Z'; ch++) {
				if (!all.contains(ch)) {
					ans[index] = ch;
					all.add(ch);
					index++;
					break;
				}
			}
		}

		for (int i = 1; i < 10; i++) {
			if (!not0.contains(ans[i])) {
				char tmp = ans[i];
				ans[i] = ans[0];
				ans[0] = tmp;
				break;
			}
		}

		return String.valueOf(ans);
	}

	public static String slove12() {
		List<Integer> constInts = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			constInts.add(i);
		}

		Map<Character, Set<Integer>> possbile = new HashMap<Character, Set<Integer>>();

		int n = list1.size();
		for (int i = 0; i < n; i++) {
			String istr = list1.get(i).toString();
			String sstr = list2.get(i);

			for (int j = 0; j < sstr.length(); j++) {
				if (!possbile.containsKey(sstr.charAt(j))) {
					possbile.put(sstr.charAt(j), new HashSet<Integer>(constInts));
				}
			}

			char ch = sstr.charAt(0);
			if (istr.length() == sstr.length()) {
				for (int j = istr.charAt(0) - '0' + 1; j < 10; j++) {
					possbile.get(ch).remove(j);
				}
			}
			possbile.get(ch).remove(0);
		}

		char[] ans = slove(possbile);
		return String.valueOf(ans);
	}

	public static char[] slove(Map<Character, Set<Integer>> possbile) {
		char[] ans = new char[10];
		List<Character> list = new ArrayList<Character>(possbile.keySet());
		dfs(possbile, ans, list, 0);
		return ans;
	}

	public static boolean dfs(Map<Character, Set<Integer>> possbile, char[] ans, List<Character> list, int pos) {
		if (pos == 10) {
			return check(ans);
		}
		char ch = list.get(pos);
		for (Integer i : possbile.get(ch)) {
			if (ans[i] == 0) {
				ans[i] = ch;
				if (dfs(possbile, ans, list, pos + 1)) {
					return true;
				}
				ans[i] = 0;
			}
		}
		return false;
	}

	public static boolean check(char[] ans) {
		Map<Character, Character> map = new HashMap<Character, Character>();
		for (int i = 0; i < 10; i++) {
			map.put(ans[i], (char) (i + '0'));
		}

		int n = list1.size();
		for (int i = 0; i < n; i++) {
			long k = list1.get(i);
			String sstr = list2.get(i);
			char[] a = new char[sstr.length()];

			for (int j = 0; j < sstr.length(); j++) {
				a[j] = map.get(sstr.charAt(j));
			}

			long k2 = Long.valueOf(String.valueOf(a));

			if (k2 > k) {
				return false;
			}
		}

		return true;
	}

	static class InputReader {
		BufferedReader br;
		StringTokenizer st;

		public InputReader(File f) {
			try {
				br = new BufferedReader(new FileReader(f));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		public InputReader(InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));
		}

		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		public boolean hasNext() {
			while (st == null || !st.hasMoreTokens()) {
				String s = null;
				try {
					s = br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (s == null)
					return false;
				st = new StringTokenizer(s);
			}
			return true;
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}