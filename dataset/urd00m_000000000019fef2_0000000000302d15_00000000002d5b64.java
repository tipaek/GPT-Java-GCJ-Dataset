//package round1b2020;

/*
ID: urd00m
LANG: JAVA
TASK: rhyme
 */
import java.io.*;
import java.util.*;

public class Solution {
	static int t;
	static int r, s;

	public static void main(String args[]) throws IOException {
		// input
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in));
		StringTokenizer input;
		t = Integer.parseInt(f.readLine());
		for (int cn = 1; cn < t + 1; cn++) {
			// do the rank bottom up
			input = new StringTokenizer(f.readLine());
			r = Integer.parseInt(input.nextToken());
			s = Integer.parseInt(input.nextToken());

			int[] items = new int[r * s];
			int id = 0;
			for (int i = 1; i <= s; i++) {
				for (int j = 1; j <= r; j++) {
					items[id++] = j;
				}
			}
			ArrayList<String> ret = new ArrayList<String>();
			int ceil = r * s - 1;
			while (true) {
				int max = 0;
				int loc = -1;
				while (true) {
					for (int i = 0; i < ceil; i++) {
						if (items[i] >= max) {
							max = items[i];
							loc = i;
						}
					}
					if(loc != ceil-1) break; 
					else ceil -= 1; 
				}
				// shifting
				int[] temp = new int[r * s];
				id = 0;
				for (int i = loc + 1; i < ceil; i++) {
					temp[id++] = items[i];
				}
				for (int i = 0; i < loc + 1; i++) {
					temp[id++] = items[i];
				}
				for (int i = ceil; i < r * s; i++) {
					temp[id++] = items[i];
				}
				ret.add((loc + 1) + " " + (ceil - loc - 1));
				ceil--;
				items = temp;
				if (ceil == s)
					break;
			}

			System.out.println("Case #" + cn + ": " + ret.size());
			for (String item : ret)
				System.out.println(item);

		}
	}

}
