import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.abs;

//javac Solution2.java
//python interactive_runner.py python.exe testing_tool.py 0 -- java Solution2
//change name before submit

public class Solution {

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		int a = input.nextInt();
		int b = input.nextInt();
		for (int i = 1; i <= T; i++) {
			int x = 0;
			int y = 0;
			for (int ii = 0; ii < 100; ii++) {
				System.out.println((-1000000000 + ii) + " 0");
				String s = input.next();
				if (s.equals("MISS")) {
					x++;
				}
			}
			for (int ii = 0; ii < 100; ii++) {
				System.out.println("0 " + (1000000000 - ii));
				String s = input.next();
				if (s.equals("MISS")) {
					y++;
				}
			}
			int pomX = 0;
			x = x - 5;
			y = y + 5;
			while (true) {
				if (a == b && a == 999999995){
					System.out.println((-5 + x) + " " + (5 - y));
				} else {
					System.out.println((-50 + x) + " " + (50 - y));
				}
				pomX++;
				x++;
				if (pomX == 10) {
					x = x - 10;
					y = y - 1;
					pomX = 0;
				}
				String s = input.next();
				if (s.equals("WRONG")) {
					return;
				}
				if (s.equals("CENTER")) {
					break;
				}
			}
		}
	}
}