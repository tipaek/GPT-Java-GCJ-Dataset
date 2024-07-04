import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());

		List<String> inputs = new ArrayList<>();
		List<String> outputs = new ArrayList<>();

		for (int i = 0; i < t; i++) {
			String input = br.readLine().trim();
			inputs.add(input);

		}

		br.close();

		int i = 0;

		for (String input : inputs) {

			StringBuilder output = new StringBuilder("Case #" + (i + 1) + ": ");
			String[] inpArr = input.split(" ");

			int x = Integer.parseInt(inpArr[0]);
			int y = Integer.parseInt(inpArr[1]);

			char[] path = inpArr[2].toCharArray();

			int time = 0;
			int result = -1;

			for (Character ch : path) {
				time += 1;

				switch (ch) {
				case 'N':
					y += 1;
					break;
				case 'S':
					y -= 1;
					break;
				case 'E':
					x += 1;
					break;
				case 'W':
					x -= 1;
					break;
				default:
					break;
				}

				if (mod(x) + mod(y) <= time) {
					result = time;
					break;
				}
			}

			if (result == -1) {
				output.append("IMPOSSIBLE");
			}

			else {
				output.append(String.valueOf(time));
			}

			outputs.add(output.toString());
			
			i += 1;
		}

		for (String output : outputs) {
			System.out.println(output);
		}
	}

	private static int mod(int n) {
		return n < 0 ? n * -1 : n;
	}

}
