import java.io.*;
import java.util.*;

//change to solution
public class Solution {
	
					// E  N  W   S
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static HashMap<Character, Integer> map = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		map.put('E', 0);
		map.put('N', 1);
		map.put('W', 2);
		map.put('S', 3);
		int t = sc.nextInt();
		outer: for (int test = 1; test <= t; test++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			String tour = sc.next();
			for (int i = 0; i <= tour.length(); i++) {
				if (Math.abs(x) + Math.abs(y) <= i) {
					System.out.println("Case #" + test + ": " + i);
					continue outer;
				}
				if (i == tour.length()) continue;
				char dir = tour.charAt(i);
				x += dx[map.get(dir)];
				y += dy[map.get(dir)];
			}
			System.out.println("Case #" + test + ": IMPOSSIBLE");
		}
	}

}
