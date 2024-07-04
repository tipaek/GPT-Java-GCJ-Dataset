import java.util.*;

/**
 * Made and solved successfully by the Prodigy Programmer
 * @author Julian Paniagua
 */
public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		byte[] bitArray = new byte[scanner.nextInt()];
		for (int t = 1; t <= testCases; t++) {
			int queries = 0;
			for (int i = 0; i < bitArray.length; i++) {
				queries++;
				System.out.println(i + 1);
				System.out.flush();
				byte bit = scanner.nextByte();
				if (queries % 10 == 1) {
					i--;
					continue;
				}
				bitArray[i] = bit;
			}
			for (int i = 0; i < bitArray.length; i++) {
				System.out.print(bitArray[i]);
			}
			System.out.println();
			System.out.flush();
			String wut = scanner.next();
			if (wut.equals("N"))
				System.exit(0);
		}
	}

}