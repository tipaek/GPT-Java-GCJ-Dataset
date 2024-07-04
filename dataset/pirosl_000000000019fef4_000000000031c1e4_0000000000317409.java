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
          
        	int min = process(x, y, moves);
        	if (min == Integer.MAX_VALUE) {
        		System.out.println("Case #" + i + ": IMPOSSIBLE");
        	}
        	else {
        		System.out.println("Case #" + i + ": " + min);
        	}
        }
	}
	
	static int process(int x, int y, String moves) {
		int[] px = new int[moves.length() + 1];
		int[] py = new int[moves.length() + 1];
		
		int idx = 0;
		px[idx] = x;
		py[idx] = y;
		++idx;
		
		for (int i = 0; i < moves.length(); ++i) {
			char c = moves.charAt(i);
			switch (c) {
			case 'N': ++y; break;
			case 'S': --y; break;
			case 'E': --x; break;
			case 'W': ++x; break;
			}
			px[idx] = x;
			py[idx] = y;
			++idx;
		}
		
		for (int i = 0; i < idx; ++i) {
			if (Math.abs(px[i]) + Math.abs(py[i]) <= i) {
				return i;
			}
		}
		
		return Integer.MAX_VALUE;
	}

}
