import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int z = in.nextInt();
		in.nextLine();
		for (int y = 1; y <= z; y++) {
			StringBuilder sb = new StringBuilder();
			String[] inp = in.nextLine().trim().split(" ");
			int goalx = Integer.parseInt(inp[0]);
			int goaly = Integer.parseInt(inp[1]);
			if (mod(goalx, 2) == mod(goaly, 2)) {
				System.out.println("Case #" + y + ": IMPOSSIBLE");
				continue;
			}
			while (goalx != 0 || goaly != 0) {
				if (goalx == 0 && goaly == -1) {
					goaly++;
					sb.append('S');
				}
				else if (goalx == 0 && goaly == 1) {
					goaly--;
					sb.append('N');
				}
				else if (goaly == 0 && goalx == -1) {
					goalx++;
					sb.append('W');
				}
				else if (goaly == 0 && goalx == 1) {
					goalx--;
					sb.append('E');
				}
				else if (mod(goalx, 2) == 1) {
					if (mod(goalx+1, 4) == mod(goaly, 4)) {
						goalx--;
						sb.append('E');
					}
					else {
						goalx++;
						sb.append('W');
					}
				}
				else {
					if (mod(goalx, 4) == mod(goaly+1, 4)) {
						goaly--;
						sb.append('N');
					}
					else {
						goaly++;
						sb.append('S');
					}
				}
				goalx >>= 1;
				goaly >>= 1;
			}
			System.out.println("Case #" + y + ": " + sb.toString());
		}
		in.close();
	}
	private static int mod(int x, int m) {
		return ((x % m) + m) % m;
	}
}
