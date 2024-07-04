import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int z = in.nextInt();
		in.nextLine();
		for (int y = 1; y <= z; y++) {
			String[] inp = in.nextLine().trim().split(" ");
			int r = Integer.parseInt(inp[0]);
			int s = Integer.parseInt(inp[1]);
			System.out.println("Case #" + y + ": " + (s-1) * (r-1));
			int counter = 0;
			for (int rank = r - 1; rank > 0; rank--) {
				for (int suit = s - 1; suit > 0; suit--) {
					System.out.println(r * (s-1) - counter + " " + rank);
					counter++;
				}
			}
		}
		in.close();
	}
}
