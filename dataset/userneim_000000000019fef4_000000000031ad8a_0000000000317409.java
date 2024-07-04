import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		outerLoop: for (int i = 1; i <= t; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			String str = in.next();
			int M = str.length();
			for(int j = 1; j <= M; j++) {
				char c = str.charAt(j-1);
				switch(c) {
					case 'N':
						y++; break;
					case 'S':
						y--; break;
					case 'E':
						x++; break;
					case 'W':
						x--; break;
				}
				if(Math.abs(x) + Math.abs(y) <= j) {
					System.out.println("Case #" + i + ": " + j);
					continue outerLoop;
				}
			}
			System.out.println("Case #" + i + ": IMPOSSIBLE");
		}
	}
}