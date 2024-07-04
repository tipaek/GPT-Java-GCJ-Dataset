import java.util.*;

/**
 * Made and solved successfully by the Prodigy Programmer
 * @author Julian Paniagua
 */
public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		for (int t = 1; t <= testCases; t++) {
			String zeroLedNumbers = scanner.next();
			for (int i = 1; i <= 9; i++) {
				zeroLedNumbers = zeroLedNumbers.replaceAll("([" + i + "-9]+)", "($1)");
			}
			System.out.println("Case #" + t + ": " + zeroLedNumbers);
		}
	}

}