import java.io.*;
import java.util.*;

/**
 * PatternMatching
 * @author: av-sharma
 */

public class Solution {

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		int t = fr.nextInt();

		while (t-- > 0) {
			int n = fr.nextInt();
			String[] strs = new String[n];
			String longest = "";
			int testCase = -1;
			for (int i = 0; i < n; i++) {
				strs[i] = fr.nextLine();
				if (strs[i].length() > longest.length()) longest = strs[i];
				if (strs[i].length() - strs[i].replaceAll("\\*", "").length() > 1) {
					testCase = 3;
				} else if (testCase == -1 && strs[i].indexOf("*") > 0) {
					testCase = 2;
				}
			}
			if (testCase == -1) testCase = 1;

			if (testCase == 1){
				boolean flag = true;
				for (int i = 0; i < n && flag; i++) 
					if (!longest.contains(strs[i].substring(1))) flag = false;

				System.out.println(flag ? longest.substring(1) : "*");
			} else if (testCase == 2) {
				boolean flag = true;
				String longestHalfL = "", longestHalfR = "";
				for (int i = 0; i < n; i++) {
					String[] split = strs[i].split("\\*");

					if (split.length == 1) {
						// either left only or right only
						int indexStar = strs[i].indexOf("*");
						if (indexStar == 0 && split[0].trim().length() > longestHalfR.length()) longestHalfR = split[0].trim();
						else if (indexStar == strs[i].length()-1 && split[0].trim().length() > longestHalfL.length()) longestHalfL = split[0].trim();
						continue;
					}
					if (split[0].trim().length() > longestHalfL.length()) longestHalfL = split[0].trim();
					if (split[1].trim().length() > longestHalfR.length()) longestHalfR = split[1].trim();
				}
				
				for (int i = 0; i < n && flag; i++) {
					String[] split = strs[i].split("\\*");
					if (split.length == 1) {
						// either left only or right only
						int indexStar = strs[i].indexOf("*");
						if (indexStar == 0 && !longestHalfR.contains(split[0].trim())) flag = false;
						else if (indexStar == strs[i].length()-1 && !longestHalfL.contains(split[0].trim())) flag = false;
						continue;
					}
					if (!longestHalfL.contains(split[0].trim())) flag = false;
					if (!longestHalfR.contains(split[1].trim())) flag = false;
				}
				System.out.println(flag ? longestHalfL + longestHalfR : "*");
			}
		}
	}
}

// FastReader Util Class
class FastReader {
	BufferedReader br;
	StringTokenizer st;

	public FastReader() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	String next() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	String nextLine() {
		String str = "";
		try {
			str = br.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

	int nextInt() {
		return Integer.parseInt(next());
	}

	Long nextLong() {
		return Long.parseLong(next());
	}

	Double nextDouble() {
		return Double.parseDouble(next());
	}
}