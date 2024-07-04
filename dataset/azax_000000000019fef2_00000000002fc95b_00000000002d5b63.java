import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	private static final String CENTER = "CENTER";
	private static final String HIT = "HIT";
	private static final String MISS = "MISS";
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		String[] line = sc.nextLine().split(" ");
		int numCases = Integer.parseInt(line[0]);
		for (int index = 0; index < numCases; index++) {
			for (int x = -5; x < 6; x++) {
				boolean finished = false;
				for (int y = -5; y < 6; y++) {
					System.out.println(x + " " + y);
					String answer = sc.nextLine();
					if (CENTER.equals(answer)) {
						finished = true;
						break;
					}
				}
				if (finished) {
					break;
				}
			}
		}
		sc.close();
	}
}