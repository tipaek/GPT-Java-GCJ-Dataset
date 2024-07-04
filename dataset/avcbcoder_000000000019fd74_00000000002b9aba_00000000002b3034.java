import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author avcbcoder last modified @11-Apr-2020 @6:12:20 AM codejam 2020 - TODO
 */

class Solution {
	public static void main(String[] args) throws Exception {
		int t = new Integer(br.readLine());
		for (int i = 1; i <= t; i++) {
			System.out.print("Case #" + i + ": ");
			solve();
		}
	}

	// **SOLUTION**
	public static void solve() throws Exception {
		int n = new Integer(br.readLine());
		String[][] arr = new String[n][4];

		String bigPre = "";
		String bigSuf = "";
		StringBuilder allMid = new StringBuilder("");

		for (int i = 0; i < arr.length; i++) {
			arr[i][0] = br.readLine();

			StringBuilder pre = new StringBuilder("");
			StringBuilder suf = new StringBuilder("");
			StringBuilder mid = new StringBuilder("");

			int j = 0;
			while (j < arr[i][0].length() && arr[i][0].charAt(j) != '*') {
				pre.append(arr[i][0].charAt(j));
				j++;
			}
			int k = arr[i][0].length() - 1;
			while (k >= 0 && arr[i][0].charAt(k) != '*') {
				suf.append(arr[i][0].charAt(k));
				k--;
			}

			suf = suf.reverse();

			for (int x = j; x <= k; x++) {
				if (arr[i][0].charAt(x) != '*')
					mid.append(arr[i][0].charAt(x));
			}

			arr[i][1] = pre.toString();
			arr[i][2] = suf.toString();
			arr[i][3] = mid.toString();

			if (arr[i][1].length() >= bigPre.length())
				bigPre = arr[i][1];
			if (arr[i][2].length() >= bigSuf.length())
				bigSuf = arr[i][2];
			allMid.append(mid);
		}

		boolean misMatch = false;

		for (int x = 0; x < arr.length; x++) {
			String p = arr[x][1];
			for (int i = 0; i < p.length(); i++)
				if (p.charAt(i) != bigPre.charAt(i))
					misMatch = true;
			String s = arr[x][2];
			int d = bigSuf.length() - s.length();
			for (int i = 0; i < s.length(); i++)
				if (s.charAt(i) != bigSuf.charAt(i + d))
					misMatch = true;
		}

		if (misMatch) {
			System.out.println("*");
			return;
		}
		StringBuilder ans = new StringBuilder("");
		ans.append(bigPre);
		ans.append(allMid);
		ans.append(bigSuf);
		System.out.println(ans);
	}

	public static InputStreamReader r = new InputStreamReader(System.in);

	public static BufferedReader br = new BufferedReader(r);

	public static Scanner sc = new Scanner(System.in);
}
