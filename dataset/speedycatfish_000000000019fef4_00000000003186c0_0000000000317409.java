import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader bufread = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bufread.readLine());
		for (int counter = 0; counter < t; counter++) {
			StringTokenizer st = new StringTokenizer(bufread.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			String tourPath = st.nextToken();
			int time = 0;
			for (int i = 1; i <= tourPath.length(); i++) {
				char dir = tourPath.charAt(i - 1);
				switch (dir) {
				case 'N':
					y++;
					break;
				case 'E':
					x++;
					break;
				case 'S':
					y--;
					break;
				case 'W':
					x--;
					break;
				}
				if (Math.abs(x) + Math.abs(y) <= i) {
					time = i;
					break;
				}
			}
			if (time == 0) {
				System.out.println("Case #" + (counter + 1) + ": IMPOSSIBLE");
			} else {
				System.out.println("Case #" + (counter + 1) + ": " + time);
			}
		}
		bufread.close();
	}

}
