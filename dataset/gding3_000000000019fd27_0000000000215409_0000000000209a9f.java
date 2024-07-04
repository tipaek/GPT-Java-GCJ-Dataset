import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numberTest = in.nextInt();
		for (int i = 0; i < numberTest; i++) {
			in.nextLine();
			String next = in.next();
			String array[] = next.split("(?!^)");
			String finalString = "";
			if (next.length() > 0) {
				for (int j = 0; j < Integer.parseInt(array[0]); j++) {
					finalString = "(" + finalString;
				}
				finalString = finalString + array[0];
			}
			for (int j = 1; j < next.length(); j++) {
				int prev = Integer.parseInt(array[j - 1]);
				int current = Integer.parseInt(array[j]);
				// int after = Integer.parseInt(array[j+1]);
				//System.out.println(finalString);
				if (current > prev) {
					for (int k = 0; k < (current - prev); k++) {
						finalString = finalString + "(";
					}
				} else if (current < prev) {
					for (int k = 0; k < (prev - current); k++) {
						finalString = finalString + ")";
					}
				}

				finalString = finalString + array[j];
			}
			for (int j = 0; j < Integer.parseInt(array[next.length() - 1]); j++) {
				finalString = finalString + ")";
			}

			System.out.println("Case #" + (i + 1) + ": " + finalString);
		}
	}
}