import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.valueOf(in.nextLine());
        for (int i = 1; i <= t; ++i) {
        	String str = in.nextLine();
        	StringTokenizer line = new StringTokenizer(str);
        	int x = -1 * Integer.valueOf(line.nextToken());
        	int y = Integer.valueOf(line.nextToken());
        	String moves = line.nextToken();
          
        	int min = process(x, y, 0, 0, 0, moves, -1);
        	if (min == Integer.MAX_VALUE) {
        		System.out.println("Case #" + i + ": IMPOSSIBLE");
        	}
        	else {
        		System.out.println("Case #" + i + ": " + min);
        	}
        }
	}
	
	static int process(int x, int y, int xc, int yc, int count, String moves, int poz) {
		if (x == xc && y == yc) {
			return count;
		}
		if (poz >= moves.length() - 1) {
			return Integer.MAX_VALUE;
		}
		
		char c = moves.charAt(poz + 1);
		switch (c) {
		case 'N': ++y; break;
		case 'S': --y; break;
		case 'E': --x; break;
		case 'W': ++x; break;
		}
		
		int min = Integer.MAX_VALUE;
		if (min > Math.abs(x - (xc + 1)) + Math.abs(y - yc)) {
			min = Math.abs(x - (xc + 1)) + Math.abs(y - yc);
		}
		if (min > Math.abs(x - (xc - 1)) + Math.abs(y - yc)) {
			min = Math.abs(x - (xc - 1)) + Math.abs(y - yc);
		}
		if (min > Math.abs(x - xc) + Math.abs(y - (yc + 1))) {
			min = Math.abs(x - xc) + Math.abs(y - (yc + 1));
		}
		if (min > Math.abs(x - xc) + Math.abs(y - (yc - 1))) {
			min = Math.abs(x - xc) + Math.abs(y - (yc - 1));
		}
		if (min > Math.abs(x - xc) + Math.abs(y - yc)) {
			min = Math.abs(x - xc) + Math.abs(y - yc);
		}
		
		int res = Integer.MAX_VALUE;
		if (min == Math.abs(x - (xc + 1)) + Math.abs(y - yc)) {
			res = Math.min(res, process(x, y, xc + 1, yc, count + 1, moves, poz + 1));
		}
		if (min == Math.abs(x - (xc - 1)) + Math.abs(y - yc)) {
			res = Math.min(res, process(x, y, xc - 1, yc, count + 1, moves, poz + 1));
		}
		if (min == Math.abs(x - xc) + Math.abs(y - (yc + 1))) {
			res = Math.min(res, process(x, y, xc, yc + 1, count + 1, moves, poz + 1));
		}
		if (min == Math.abs(x - xc) + Math.abs(y - (yc - 1))) {
			res = Math.min(res, process(x, y, xc, yc - 1, count + 1, moves, poz + 1));
		}
		if (min == Math.abs(x - xc) + Math.abs(y - yc)) {
			res = Math.min(res, process(x, y, xc, yc, count + 1, moves, poz + 1));
		}
		
		return res;
	}

}
