import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numberTest = in.nextInt();
		for (int i = 0; i < numberTest; i++) {
			boolean failed = false;
			String finalString = "";
			boolean[] cperson = new boolean[24 * 60 + 1];
			boolean[] jperson = new boolean[24 * 60 + 1];
			in.nextLine();
			int crazy = in.nextInt();
			for (int j = 0; j < crazy; j++) {
				in.nextLine();
				int nextValue = in.nextInt();
				int endValue = in.nextInt();
				boolean failing = false;
				for (int k = nextValue; k < endValue; k++) {
					if (!cperson[k]) {
					} else {
						if (!jperson[k]) {
							failing = true;
						} else {
							failed = true;
						}
					}
				}
				for (int k = nextValue; k < endValue; k++) {
					if (failing) {
						jperson[k] = true;
					} else {
						cperson[k] = true;
					}
				}
				if (failing) {
					finalString = finalString + "J";
				} else {
					finalString = finalString + "C";
				}
			}
			
			if (failed) {
				System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
			} else {
				System.out.println("Case #" + (i+1) + ": " + finalString);
			}
		}
	}
}