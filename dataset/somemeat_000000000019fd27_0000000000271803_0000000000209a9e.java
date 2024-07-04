import java.io.IOException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int b = sc.nextInt();

		for (int i = 0; i < t; i++) {
			String out = "";
			for (int j = 0; j < b; j++) {
				System.out.println(j + 1);
				out += sc.next();
			}
			System.out.println(out);
			if (sc.next().equals("Y")) {
				continue;
			} else {
				System.exit(0);
			}
		}
		System.exit(0);
	}

}
