

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Solution {

	void getFormattedString(String s, int caseNo) {
		StringBuffer sbr = new StringBuffer("");
		char[] ch = s.toCharArray();
		int count = 0;

		for (int i = 0; i < ch.length; i++) {
			int no = ch[i] - '0';

			if (count < no) {
				while (count < no) {
					count++;
					sbr.append('(');
				}
			} else if (count > no) {
				while (count > no) {
					count--;
					sbr.append(')');
				}
			}

			if (count == no)
				sbr.append(no);
		}

		while (count > 0) {
			count--;
			sbr.append(')');
		}
		System.out.println("Case #" + caseNo + ": " + sbr);
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(
				System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			String str = in.next();
			obj.getFormattedString(str, i);
		}
	}
}
