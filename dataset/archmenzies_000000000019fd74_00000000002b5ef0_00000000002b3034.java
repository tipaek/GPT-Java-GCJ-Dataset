import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] a) {
		try {
			BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
			int testCases = parseInt(inputReader.readLine());

			for (int t = 1; t <= testCases; t++) {
				int N = parseInt(inputReader.readLine());

				int maxLength = 0;
				List<String> patterns = new ArrayList<>();
				for (int n = 0; n < N; n++) {
					String pattern = inputReader.readLine();
					if (pattern.length() > maxLength) {
						maxLength = pattern.length();
					}
					patterns.add(pattern);
				}

				byte[] name = new byte[maxLength-1];
				boolean matches = true;
				for (int i = 0; i < maxLength-1; i++) {
					boolean setByte = false;
					for (String pattern : patterns) {
						if (pattern.length() > i && pattern.getBytes()[pattern.length() - 1 - i] != '*') {
							byte patternChar = pattern.getBytes()[pattern.length() - 1 - i];
							if (setByte && name[maxLength - 2 -i] != patternChar) {
								matches = false;
								break;
							} else {
								setByte = true;
								name[maxLength - 2 -i] = patternChar;
							}
						}
					}
				}

				String output = matches
						? new String(name)
						: "*";
				System.out.printf("Case #%d: %s\n", t, output);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
