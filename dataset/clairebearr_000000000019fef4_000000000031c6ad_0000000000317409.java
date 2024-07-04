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
		for (int test = 1; test <= t; test++) {
			int px = sc.nextInt();
			int py = sc.nextInt();
			String tour = sc.next();
			int mx = 0;
			int my = 0;
			int ans = Integer.MAX_VALUE;
			for (int i = 0; i < tour.length(); i++) {
				char dir = tour.charAt(i);
				px += dx[map.get(dir)];
				py += dy[map.get(dir)];
				if (mx == px && my == py) {
					ans = i+1;
					break;
				}
				if (dir == 'E' || dir == 'W') {
					if (my < py) {
						my++;
					} else {
						mx++;
					}
				} else {
					if (mx < px) {
						mx++;
					} else {
						if (my < px)
							my++;
						else
							my--;
					}
				}
				
				if (mx == px && my == py) {
					ans = i+1;
					break;
				}
			}
			System.out.print("Case #" + test + ": ");
			if (ans == Integer.MAX_VALUE)
				System.out.println("IMPOSSIBLE");
			else
				System.out.println(ans);
		}
	}
}
