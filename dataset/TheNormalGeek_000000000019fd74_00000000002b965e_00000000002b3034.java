import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

	public void realMain() throws Exception {

		BufferedReader fin = new BufferedReader(new InputStreamReader(System.in), 1000000);

		String in = fin.readLine();

		int T = Integer.parseInt(in);

		for(int t = 1; t <= T; t++) {
				in = fin.readLine();
				int n = Integer.parseInt(in);

			String[] patterns = new String[n];

			boolean[] worried = new boolean[n];

			for(int i = 0; i < n; i++) {
				in = fin.readLine();
				patterns[i] = in;
				worried[i] = true;
			}

			String prefix = "";
			String suffix = "";

			boolean fails = false;

			for(int letter = 0; letter < 102; letter++) {
				char curval = 'a';
				
				for(int i = 0; i < n; i++) {
					if(!worried[i]) {
						continue;
					}

					if(patterns[i].charAt(letter) == '*') {
						worried[i] = false;
						continue;
					}

					if(curval == 'a') {
						curval = patterns[i].charAt(letter);
					} else if(curval != patterns[i].charAt(letter)) {
						fails = true;
					}
				}

				if(curval != 'a') {
					prefix = prefix + curval;
				} else {
					break;
				}
			}

			for(int i = 0; i < n; i++) {
				worried[i] = true;
			}

			for(int letter = 0; letter < 102; letter++) {
				char curval = 'a';

				for(int i = 0; i < n; i++) {
					if(!worried[i]) {
						continue;
					}

					if(patterns[i].length() - 1 - letter < 0) {
						worried[i] = false;
						continue;
					}

					if(patterns[i].charAt( patterns[i].length() - 1 - letter ) == '*') {
						worried[i] = false;
						continue;
					}

					if(curval == 'a') {
						curval = patterns[i].charAt( patterns[i].length() - 1 - letter );
					} else if(curval != patterns[i].charAt( patterns[i].length() - 1 - letter )) {
						fails = true;
					}
				}

				if(curval != 'a') {
					suffix = curval + suffix;
				} else {
					break;
				}
			}

		
			//add middles

			StringBuilder middle = new StringBuilder("");

			for(int i = 0; i < n; i++) {
				int leftboundary = 0;
				int rightboundary = 0;

				for(int j = 0; j < patterns[i].length(); j++) {
					if(patterns[i].charAt(j) == '*') {
						leftboundary = j;
						break;
					}
				}

				for(int j = patterns[i].length() - 1; j >= 0; j--) {
					if(patterns[i].charAt(j) == '*') {
						rightboundary = j;
						break;
					}
				}

				for(int j = leftboundary; j <= rightboundary; j++) {
					if(patterns[i].charAt(j) != '*') {
						middle.append(patterns[i].charAt(j));
					}
				}
			}

			

			if(fails) {
				System.out.println("Case #" + t + ": *");
			} else {
				System.out.println("Case #" + t + ": " + prefix + middle + suffix);
			}

		}

	}


	public static void main(String[] args) throws Exception {
		Solution s = new Solution();
		s.realMain();
	}
}