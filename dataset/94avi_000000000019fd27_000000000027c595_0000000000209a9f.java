import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {

	public static void main(String[] args) throws Exception {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int testCase = Integer.valueOf(br.readLine());

		for (int test = 1; test <= testCase; test++) {

			String input = br.readLine();
			int[] a = new int[input.length()];
			int i = 0;
			for (String s : input.split("")) {
				a[i] = Integer.parseInt(s);
				i++;
			}
			int start = 0;
			StringBuilder sb = new StringBuilder();

			for (i = 0; i < a.length; i++) {
				if (a[i] > start) {
					for (; start < a[i]; start++)
						sb.append("(");
				}
				if (a[i] < start) {
					for (; start > a[i]; start--)
						sb.append(")");
				}
				sb.append(a[i]);
			}
			
			for(;start>0;start--)
				sb.append(")");

			System.out.println("Case #" + test + ": " + sb.toString());

		}
	}

}