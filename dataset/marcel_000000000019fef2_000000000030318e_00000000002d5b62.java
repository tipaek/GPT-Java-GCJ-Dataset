import static java.lang.Math.abs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;

public class Solution {

	private static int x, y;
	
	public static void main(String[] args) {
		Locale.setDefault(Locale.ENGLISH);
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		solve(in, System.out);
		in.close();
	}

	protected static void solve(Scanner in, PrintStream out) {
		int numtests = in.nextInt();
		for (int t = 1; t <= numtests; ++t) {
			x = in.nextInt();
			y = in.nextInt();
			String ret = solveLine();
			out.printf(Locale.ENGLISH, "Case #%d: %s%n", t, ret);
		}
	}

	private static String solveLine() {
		if (((abs(x) + abs(y)) & 1) == 0) return "IMPOSSIBLE"; 
		if (x == 0 && y == 0) return "";
		String ans = "";
		int steps = 1;
		for (int mask = 1; mask < abs(x) + abs(y) - 1; mask <<= 1) {
			steps++;
		}
		for (int laststep = steps; ans.length() == 0; laststep++) {
			ans = getTarget(0, 0, x, y, 1, laststep);
		}
		if (ans.length() == 0) return "IMPOSSIBLE";
		return ans;
	}

	static String getTarget(int curx, int cury, int targetx, int targety, int step, int laststep) {
		String ans = "";
		String[] cand = {"","","",""};
		String[] ret = {"E","W","N","S"};
		if (step == 1) {
			if ((x & 1) == 1){
				cand[0] = getTarget(1, 0, x, y, 2, laststep);
				cand[1] = getTarget(-1, 0, x, y, 2, laststep);
			} else {
				cand[2] = getTarget(0, 1, x, y, 2, laststep);
				cand[3] = getTarget(0, -1, x, y, 2, laststep);
			}
		} else {
			int dist = (1 << (step - 1));
			if (curx == targetx && abs(targety - cury) == dist) return targety > cury ? "N" : "S";
			if (cury == targety && abs(targetx - curx) == dist) return targetx > curx ? "E" : "W";
			if (abs(curx) > abs(targetx) || abs(cury) > abs(targety)) return "";
			if (step == laststep) return "";
			if (curx == targetx) {
				cand[2] = getTarget(curx, cury + dist, targetx, targety, step + 1, laststep);
				cand[3] = getTarget(curx, cury - dist, targetx, targety, step + 1, laststep);
			} else if (cury == targety) {
				cand[0] = getTarget(curx + dist, cury, targetx, targety, step + 1, laststep);
				cand[1] = getTarget(curx - dist, cury, targetx, targety, step + 1, laststep);
			} else {
				cand[0] = getTarget(curx + dist, cury, targetx, targety, step + 1, laststep);
				cand[1] = getTarget(curx - dist, cury, targetx, targety, step + 1, laststep);
				cand[2] = getTarget(curx, cury + dist, targetx, targety, step + 1, laststep);
				cand[3] = getTarget(curx, cury - dist, targetx, targety, step + 1, laststep);
			}
		}
		for (int i = 0; i < 4; i++) {
			String str = cand[i];
			if (str.length() > 0 && (ans.length() == 0 || str.length() <= ans.length())) ans = ret[i] + str;
		}
		return ans;
	}
		
}
