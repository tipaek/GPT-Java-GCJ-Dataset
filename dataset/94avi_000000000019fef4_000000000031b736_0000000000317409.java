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

			for (String step : path) {
				if (x == 0 && y == 0) {
					break;
				}
				if (x != 0) {
					if (step.equals("S")) {
						y = y - 1;
						x = x - 1;

					} else {
						y = y + 1;
						x = x - 1;
					}
				} else if (y != 0) {
					if (step.equals("S")) {
						if(y<0)
						{
							
						}
						else if (y - 2 < 0) {
							y = y - 1;
						} else {
							y = y - 2;
						}

					}
				}
				count++;

			}

			if (x == 0 && y == 0)
				System.out.println("Case #" + test + ": " + count);
			else
				System.out.println("Case #" + test + ": IMPOSSIBLE");

		}
	}
}
