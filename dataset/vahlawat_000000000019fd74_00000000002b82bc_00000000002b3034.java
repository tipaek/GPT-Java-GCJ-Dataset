import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
//		Scanner in = null;
//		try {
//			in = new Scanner(new File("test.txt"));
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int testcase = 1; testcase <= t; ++testcase) {
			int N = in.nextInt();
			in.nextLine();
			String maxStr = in.nextLine();
			maxStr = maxStr.substring(1);
			boolean matchFound = true;
			for (int i = 0; i < N - 1; i++) {
				String str = in.nextLine();
				int firstIndex = str.indexOf('*');
				int secondIndex = str.indexOf('*', firstIndex + 1);
				if (str.charAt(0) == '*' && secondIndex == -1) {
					// first test set
					str = str.substring(1);
					if (maxStr.length() <= str.length()) {
						if (str.contains(maxStr)) {
							maxStr = str;
						} else {
							matchFound = false;
						}
					} else {
						if (!maxStr.contains(maxStr)) {
							matchFound = false;
						}
					}
				} else {
					if (firstIndex == secondIndex) {
						// second test set
						
					} else {
						// third test set
					}
				}
			}
			if (matchFound) {
				System.out.println("Case #" + testcase + ": " + maxStr);
			} else {
				System.out.println("Case #" + testcase + ": *");
			}
			
		}
	}
}