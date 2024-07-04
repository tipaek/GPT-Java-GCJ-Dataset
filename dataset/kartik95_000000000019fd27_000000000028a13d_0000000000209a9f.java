import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new
			        InputStreamReader(System.in));
			int noOfTestCase = Integer.parseInt(br.readLine());
			for (int i = 0; i < noOfTestCase; i++) {
				String s = br.readLine();
				String[] c = s.split("");
				int a[] = new int[c.length];
				for (int j = 0; j < c.length; j++) {
					a[j] = Integer.parseInt(c[j]);
				}
				getResult(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

	static void getResult(int[] a) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < a.length; i++) {
			prependBrackets(i, a, sb);
			sb.append(a[i]);
			appendBrackets(i, a, sb);
		}
		System.out.println(sb.toString());
	}

	private static void appendBrackets(int i, int a[], StringBuilder sb) {
		if (i == a.length - 1 && a[i] > 0) {
			for (int j = 0; j < a[i]; j++)
				sb.append(")");
		} else if (a[i] > 0 && a[i] - a[i + 1] > 0) {
			for (int j = 0; j < a[i] - a[i + 1]; j++)
				sb.append(")");
		}
	}

	private static void prependBrackets(int i, int a[], StringBuilder sb) {
		if (i == 0 && a[i] > 0) {
			for (int j = 0; j < a[i]; j++)
				sb.append("(");
		} else if (a[i] > 0 && a[i] - a[i - 1] > 0) {
			for (int j = 0; j < a[i] - a[i - 1]; j++)
				sb.append("(");
		}
	}

}
