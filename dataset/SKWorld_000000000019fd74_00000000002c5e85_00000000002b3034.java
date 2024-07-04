import java.io.*;
import java.util.*;

class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		for (int t = 0; t < testCase; t++) {
			int n = Integer.parseInt(br.readLine());
			String arr[] = new String[n];
			String s = br.readLine();
			String answer = s;
			arr[0] = s;
			for (int i = 1; i < n; i++) {
				s = br.readLine();
				arr[1] = s;
				if (s.length() > answer.length())
					answer = s;
			}
			boolean flag = true;
			for (int i = 0; i < n; i++) {

				for (int j = i + 1; j < n; j++) {

					String minimum = arr[i];
					String maximum = arr[j];
					if (arr[i].length() > arr[j].length()) {
						minimum = arr[j];
						maximum = arr[i];
					}

					int len = maximum.length() - 1;
					for (int minLength = minimum.length() - 1; minLength > 0; minLength--) {
						if (minimum.charAt(minLength) == maximum.charAt(len)) {

						} else {
							flag = false;
							break;
						}
						len--;
					}
					if (flag)
						break;
				}
				if (flag)
					break;
			}
			if (flag && answer.length() > 1) {
				System.out.println("Case #" + (t + 1) + ": " + answer.substring(1));
			} else {
				System.out.println("Case #" + (t + 1) + ": " + "*");
			}
		}

	}

}