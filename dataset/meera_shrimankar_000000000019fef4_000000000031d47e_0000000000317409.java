import java.util.Scanner;

public class Solution {
	public static int getMinimumMeetPoint(int x, int y, String M) {
		for (int i = 0; i < M.length(); i++) {
			switch (M.charAt(i)) {
			case 'N':
				y++;
				break;
			case 'S':
				y--;
				break;
			case 'E':
				x++;
				break;
			case 'W':
				x--;
				break;
			}
			if (i + 1 >= Math.abs(x) + Math.abs(y)) {
				return i + 1;
			}
		}

		return Integer.MAX_VALUE;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int X[] = new int[T];
		int Y[] = new int[T];
		String M[] = new String[T];
		for (int i = 0; i < T; i++) {
			X[i] = sc.nextInt();
			Y[i] = sc.nextInt();
			M[i] = sc.next();
		}
		for (int i = 0; i < T; i++) {
			int mins = getMinimumMeetPoint(X[i], Y[i], M[i]);
			int index = i + 1;
			if (mins == Integer.MAX_VALUE) {
				System.out.println("Case #" + index + ": IMPOSSIBLE");
			} else {
				System.out.println("Case #" + index + ": " + mins);
			}
		}
	}
}
