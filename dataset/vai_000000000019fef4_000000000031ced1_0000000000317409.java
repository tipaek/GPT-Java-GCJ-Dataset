import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws Exception {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int total = in.nextInt();
		for (int counter = 1; counter <= total; counter++) {

			int x = in.nextInt();
			int y = in.nextInt();
			String route = in.next() + in.nextLine();

			int distance = Math.abs(x) + Math.abs(y);
			int time = -1;

			if (distance == 0) {
				time = 0;
			} else {
				for (int i = 0; i < route.length(); i++) {
					char step = route.charAt(i);
					switch (step) {
					case 'N':
						y++;
						break;
					case 'S':
						y--;
						break;
					case 'E':
						x++;
						break;
					case 'W':
						x--;
						break;
					default:
						break;
					}
					distance = Math.abs(x) + Math.abs(y);
					if ((i + 1) >= distance) {
						time = i + 1;
						break;
					}
				}
			}

			if (time > -1) {
				System.out.println("Case #" + counter + ": " + time);
			} else {
				System.out.println("Case #" + counter + ": IMPOSSIBLE");
			}

		}
		in.close();
	}

}
