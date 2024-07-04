import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
			final int numberOfCases = in.nextInt(); // Number of cases
			for (int caseNo = 1; caseNo <= numberOfCases; caseNo++) {
				final int X = in.nextInt();
				final int Y = in.nextInt();
				final String route = in.next();
				
				int finalX = X;
				int finalY = Y;
				final int length = route.length();
				int time = 1;
				boolean possible = false;
				for (int i = 0; i < length; i++) {
					final char direction = route.charAt(i);
					switch (direction) {
					case 'N':
						finalY++;
						break;
					case 'S':
						finalY--;
						break;
					case 'W':
						finalX--;
						break;
					case 'E':
						finalX++;
						break;
					}
					
					if (Math.abs(finalX) + Math.abs(finalY) <= time) {
						possible = true;
						break;
					} else {
						time++;
					}
				}
				
				
				String result = possible ? String.valueOf(time) : "IMPOSSIBLE";
				System.out.println("Case #" + caseNo + ": " + result);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
