

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		final String[] settings = in.nextLine().split(" ");
		final int t = Integer.parseInt(settings[0]);
		final int b = Integer.parseInt(settings[1]);
	    for (int c = 1; c <= t; ++c) {
	        processCase(in, b);
	    }
	    in.close();
	}
	
	// Let's get that single point before I even start thinking about this...
	// Making sure the interactive setup works as expected.
	private static void processCase(final Scanner in, final int bytes) {
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= 10; i++) {
			System.out.println(i);
			sb.append(in.nextLine());
		}
		System.out.println(sb.toString());
		in.nextLine();
	}
}