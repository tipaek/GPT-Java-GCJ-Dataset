import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String args[]) {
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = scan.nextInt();

		for (int i = 0; i < T; i++) {
			int count = 0;

			int x = scan.nextInt();
			int y = scan.nextInt();
			String direct = scan.next();

			for (int j = 0; j < direct.length(); j++) {
				char direction = direct.charAt(j);
				count++;
				if (x == 0 && y == 0) {
					count--;
					break;
				}
				if (x > 0) {
					x--;
					if (direction == 'S') {
						y -= 1;
					} else {
						y += 1;
					}
					continue;
				}

				if (direction == 'S') {
					y -= 1;
					if (y == 0) {
						break;
					}
					if (y > 0) {
						y -= 1;
					}else if(y<0){
						y +=1;
					}
					if (y == 0) {
						break;
					}
				} else {
					y += 1;
					if (y == 0) {
						break;
					}
					if (y > 0) {
						y -= 1;
					}else if(y<0){
						y +=1;
					}
					if (y == 0) {
						break;
					}
				}
			}

			if (y != 0 || x != 0) {
				System.out.println("Case #" + (i + 1) + ": " + "IMPOSSIBLE");
			} else
				System.out.println("Case #" + (i + 1) + ": " + count);
		}

	}

}