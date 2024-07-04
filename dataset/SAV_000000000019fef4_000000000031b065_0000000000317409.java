import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int t = 1;
		String buffer = sc.nextLine();
		while (t <= T) {
			String str = sc.nextLine();
			String[] strs = str.split("\\s+");
			int x = Integer.parseInt(strs[0]);
			int y = Integer.parseInt(strs[1]);
			boolean flag = true;
			String path = strs[2];
			for (int i = 1; i <= path.length(); i++) {
				char ch = path.charAt(i-1);
				if (ch == 'S') {
					y--;
				} else if (ch == 'N') {
					y++;
				} else if (ch == 'E') {
					x++;
				} else {
					x--;
				}
				int distance = Math.abs(x) + Math.abs(y);
				if (distance <= i) {
					flag = false;
					System.out.print("Case #" + t + ": ");
					System.out.println(i);
					break;
				}
			}
			if (flag) {
				System.out.print("Case #" + t + ": ");
				System.out.println("IMPOSSIBLE");
			}
			t++;
		}
	}
}

		
