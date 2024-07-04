import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

//javac Solution2.java
//python interactive_runner.py python.exe testing_tool.py 0 -- java Solution2
//change name before submit

public class Solution {

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		int b = input.nextInt();
		for (int i = 1; i <= T; i++) {
			int[] res = new int[b];
			for (int ii = 0; ii < b; ii++) {
				res[ii] = -1;
			}
			int same = -1;
			int dif = -1;
			int pom = 0;
			boolean first = true;
			for (int ii = 0; ii < 150; ii++) {
				if (ii % 10 == 0) {
					if (same != -1) {
						System.out.println(same + 1);
						int s = input.next().charAt(0) - 48;
						if (res[same] != s) {
							for (int iii = 0; iii < b / 2; iii++) {
								if (res[iii] == res[b - iii - 1]) {
									if (res[iii] == 0) {
										res[iii] = 1;
										res[b - iii - 1] = 1;
									} else {
										res[iii] = 0;
										res[b - iii - 1] = 0;
									}
								}
							}
						}
					} else {
						System.out.println(1);
						input.next();
					}
				} else if (ii % 10 == 1) {
					if (dif != -1) {
						System.out.println(dif + 1);
						int s = input.next().charAt(0) - 48;
						if (res[dif] != s) {
							for (int iii = 0; iii < b / 2; iii++) {
								if (res[iii] != res[b - iii - 1]) {
									int k = res[iii];
									res[iii] = res[b - iii - 1];
									res[b - iii - 1] = k;
								}
							}
						}
					} else {
						System.out.println(1);
						input.next();
					}
				} else {
					if (first) {
						System.out.println(pom + 1);
						int s = input.next().charAt(0) - 48;
						if (pom < b / 2) {
							res[pom] = s;
							first = false;
						}
					} else {
						System.out.println(b - pom);
						int s = input.next().charAt(0) - 48;
						res[b - pom - 1] = s;
						first = true;
						if (same == -1 && res[pom] == res[b - pom - 1]) {
							same = pom;
						}
						if (dif == -1 && res[pom] != res[b - pom - 1]) {
							dif = pom;
						}
						pom++;
					}
				}
			}
			StringBuilder s = new StringBuilder("");
			for (int ii = 0; ii < b; ii++) {
				s.append(res[ii]);
			}
			System.out.println(s.toString());
			String ss = input.next();
			if (ss.equals("N")) {
				return;
			}
		}
	}
}