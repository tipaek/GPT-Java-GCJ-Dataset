
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String ns = in.readLine();
		int n = Integer.parseInt(ns);
		for (int i = 0; i < n; i++) {
			String string = in.readLine();
			String handeled = handle(string);
			System.out.println("Case #" + (i+1) + ": " + handeled);
		}
	}

	private static String handle(String string) {
		String[] s = string.split("");
		int[] list = new int[s.length];
		for (int i = 0; i < string.length(); i++) {
			list[i] = Integer.parseInt(s[i]);
		}
		int count = 0;
		int prev = 0;
		String output = "";
		while (true) {
			if (count == list.length) {
				break;
			}
			int curr = list[count];
			int diff = prev - curr;
			if (diff < 0) {
				for (int i = 0; i < Math.abs(diff); i++) {
					output += "(";
				}
			} else if (diff > 0) {
				for (int i = 0; i < diff; i++) {
					output += ")";
				}
			}
			prev = curr;
			output += curr;
			count++;
		}
		for (int i = 0; i < prev; i++) {
			output += ")";
		}
		return output;
	}

}
