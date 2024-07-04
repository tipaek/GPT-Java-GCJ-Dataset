import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = Integer.parseInt(in.nextLine());
		//System.out.println("Test cases : " + t);

		for (int i = 1; i <= t; ++i) {
			int n = Integer.parseInt(in.nextLine());

			String[] st = new String[n];
			int biggest = 0;
			for (int j = 0; j < n; j++) {
				st[j] = in.nextLine();
				if (st[j].length() > st[biggest].length()) {
					biggest = j;
				}
				//System.out.println("Read : " + st[j]);
			}

			boolean possible = true;
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < st[j].length()-1; k++) {
					
					if (st[j].charAt(st[j].length() - 1 - k) != st[biggest].charAt(st[biggest].length() - 1 - k)) {
						possible = false;
						break;
					}
				}
				if (!possible)
					break;
			}

			System.out.println("Case #" + i + ": " + (possible ? st[biggest].substring(1) : "*"));

		}
	}
}