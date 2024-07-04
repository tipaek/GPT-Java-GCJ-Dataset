import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int testCase = Integer.valueOf(br.readLine());

		for (int test = 1; test <= testCase; test++) {
			String input[] = br.readLine().split(" ");
			String path[] = input[2].split("");
			int x = Integer.valueOf(input[0]);
			int y = Integer.valueOf(input[1]);
			int count = 0;
			boolean possible = false;

			for (String step : path) {

				if (step.equals("S"))
					y = y - 1;
				if (step.equals("N"))
					y = y + 1;
				if (step.equals("W"))
					x = x - 1;
				if (step.equals("E"))
					x = x + 1;

				if (Math.abs(x) + Math.abs(y) <= count + 1) {
					possible = true;
					break;
				}

				count++;

			}

			if (possible)
				System.out.println("Case #" + test + ": " + (count + 1));
			else
				System.out.println("Case #" + test + ": IMPOSSIBLE");

		}
	}
}
