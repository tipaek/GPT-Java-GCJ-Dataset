import java.io.IOException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < t; i++) {
			int b = Integer.parseInt(sc.nextLine());
			String out = "";
			for (int j = 0; j < 10; j++) {
				System.out.println(j);
				out += sc.nextLine();
			}
			System.out.println(out);
			if (sc.nextLine().equals("Y")) {
				continue;
			} else {
				System.exit(0);
			}
		}
	}

}
