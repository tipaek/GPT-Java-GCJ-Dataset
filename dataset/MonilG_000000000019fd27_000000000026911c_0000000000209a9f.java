import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			for (int i = 0; i < t; i++) {
				String s = br.readLine();
				List<String> strList = new ArrayList<>();

				int lCount = 0;

				int len = s.length();
				for (int j = 0; j < len; j++) {
					char c = s.charAt(j);
					int digit = Character.getNumericValue(c);

					if (lCount < digit) {
						addLeftParan(strList, digit - lCount);
						lCount += (digit - lCount);
					}
					else if (lCount > digit) {
						addRightParan(strList, lCount - digit);
						lCount -= (lCount - digit);
					}
					addDigit(strList, digit);
				}
				if (lCount > 0) {
					addRightParan(strList, lCount);
				}

				System.out.format("Case #%d: %s%n", (i+1), String.join("", strList));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void addLeftParan(List<String> s, int d) {
		while (d != 0) {
			s.add("(");
			d--;
		}
	}

	public static void addDigit(List<String> s, int d) {
		s.add(String.valueOf(d));
	}

	public static void addRightParan(List<String> s, int d) {
		while (d != 0) {
			s.add(")");
			d--;
		}
	}
}
