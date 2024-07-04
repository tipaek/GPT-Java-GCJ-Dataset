import java.io.IOException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int b = sc.nextInt();
			String out = "";
			for (int j = 0; j < b; j++) {
				System.out.println(j+1);
				out += sc.next();
			}
			System.out.println(out);
			if (sc.next().equals("Y")) {
				continue;
			} else {
				continue;
			}
		}
		System.exit(0);
	}

}
