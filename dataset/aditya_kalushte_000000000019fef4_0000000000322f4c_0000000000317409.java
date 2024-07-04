
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testcases = sc.nextInt();
		for (int t = 0; t < testcases; t++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			String m = sc.next();
			char moves[] = m.toCharArray();

			int xAway = x;
			int yAway = y;

			int minutesToReach = 0;
			boolean reached = false;
			for (int i = 0; i < moves.length; i++) {

				// tour moves
				switch (moves[i]) {
				case 'N': {
					yAway++;
					break;
				}
				case 'S': {
					yAway--;
					break;
				}
				case 'E': {
					xAway++;
					break;
				}
				case 'W': {
					xAway--;
					break;
				}
				default: {
					break;
				}
				}
				if (xAway == 0 && yAway == 0) {
					minutesToReach++; // waited at same intersection
					reached = true;
					break;
				} else {
					// fan moves
					if (Math.abs(xAway) > Math.abs(yAway)) {
						if (xAway < 0) {
							xAway = (Math.abs(xAway) - 1) * -1;
						} else {
							xAway--;
						}
					} else if (Math.abs(xAway) == Math.abs(yAway)) {
						if ((i + 1) < moves.length) {
							int tempXAway = xAway;
							int tempYAway = yAway;

							switch (moves[i + 1]) {
							case 'N': {
								tempYAway++;
								break;
							}
							case 'S': {
								tempYAway--;
								break;
							}
							case 'E': {
								tempXAway++;
								break;
							}
							case 'W': {
								tempXAway--;
								break;
							}
							default: {
								break;
							}
							}
							if (Math.abs(tempXAway) > Math.abs(tempYAway)) {
								if (xAway < 0) {
									xAway = (Math.abs(xAway) - 1) * -1;
								} else {
									xAway--;
								}
							} else {
								if (yAway < 0) {
									yAway = (Math.abs(yAway) - 1) * -1;
								} else {
									yAway--;
								}
							}
						}
					} else {
						if (yAway < 0) {
							yAway = (Math.abs(yAway) - 1) * -1;
						} else {
							yAway--;
						}
					}

					minutesToReach++;

					if (xAway == 0 && yAway == 0) {
						reached = true;
						break;
					}
				}

			}

			if (reached) {
				System.out.println("Case #" + (t + 1) + ": " + minutesToReach);
			} else {
				System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
			}
		}
		sc.close();
	}
}
