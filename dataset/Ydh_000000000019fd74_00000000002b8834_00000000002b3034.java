

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int tc = scan.nextInt();

		for (int test_case = 1; test_case <= tc; test_case++) {
			int n = scan.nextInt();

			ArrayList<String> Left = new ArrayList<String>();
			ArrayList<String> Right = new ArrayList<String>();

			int lmax = 0;
			int rmax = 0;

			for (int i = 0; i < n; i++) {
				String input = scan.next();
				String[] splitinput = input.split("\\*");

				if (splitinput[0].length() > lmax) {
					lmax = splitinput[0].length();
				}

				if (splitinput.length == 1) {
					Left.add(splitinput[0]);
				} else {

					if (rmax < splitinput[1].length())
						rmax = splitinput[1].length();
					if (splitinput[0].equals("")) {
						Right.add(splitinput[1]);
					} else {
						Left.add(splitinput[0]);
						Right.add(splitinput[1]);
					}
				}

			}

			String left = "";

			for (int i = 0; i < lmax; i++) {
				char cur = 'a';
				boolean equals = true;
				for (int j = 0; j < Left.size(); j++) {
					if (Left.get(j).length() <= i)
						continue;

					if (cur == 'a') {
						cur = Left.get(j).charAt(i);
					} else if (cur != Left.get(j).charAt(i)) {
						equals = false;
					}
				}
				if (!equals) {
					left = "*";
					break;
				} else {
					left += cur;
				}
			}

			String right = "";

			for (int i = 0; i < rmax; i++) {
				char cur = 'a';
				boolean equals = true;

				for (int j = 0; j < Right.size(); j++) {
					if (Right.get(j).length() - i - 1 < 0)
						continue;

					if (cur == 'a') {
						cur = Right.get(j).charAt(Right.get(j).length() - i - 1);
					} else if (cur != Right.get(j).charAt(Right.get(j).length() - i - 1)) {
						equals = false;
					}
				}

				if (!equals) {
					right = "*";
					break;
				} else {
					right = cur + right;
				}
			}

			if (left.equals("*") || right.equals("*")) {
				System.out.println("Case #"+test_case+": *");
			} else {
				System.out.println("Case #"+test_case+": "+left + right);
			}
		}

	}

}
