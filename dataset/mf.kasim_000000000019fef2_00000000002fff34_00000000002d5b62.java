import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		try (Scanner s = new Scanner(System.in)) {

			int T = s.nextInt();
			for (int i = 1; i <= T; i++) {
				int X = s.nextInt();
				int Y = s.nextInt();
				s.nextLine();

				String result = solve(X, Y);
				System.out.println("Case #" + i + ": " + result);
			}
		}
	}

	private static String solve(int X, int Y) {

		int absMinSteps = Math.abs(X) + Math.abs(Y);
		int msb = 31 - Integer.numberOfLeadingZeros(absMinSteps);

		int upgradeSteps = 0;
		for (int i = 0; i <= msb; i++) {
			upgradeSteps = upgradeSteps + (1 << i);
//			System.out.println(Integer.toBinaryString(upgradeSteps) + "," + absMinSteps);
		}
		String result = "";
		int currentX = X, currentY = Y;
		X = 0;
		Y = 0;
		while (msb >= 0) {

			int value = upgradeSteps & (1 << msb);
//			System.out.println("currentX" + currentX + ", cY= " + currentY + ",X=" + X + ",Y= " + Y + "VAL=" + value);

			if (Math.abs((X - currentX)) > Math.abs((Y - currentY))) {

				if (X > currentX) {
					currentX += value;
					result += "W";
				} else {
					currentX -= value;
					result += "E";
				}

			} else {

				if (Y > currentY) {
					currentY += value;
					result += "S";
				} else {
					currentY -= value;
					result += "N";
				}

			}
			msb--;
		}

		if (currentX != X || currentY != Y) {
			return "IMPOSSIBLE";
		} else {
			String reverse = "";
			for (int i = result.length() - 1; i >= 0; i--) {
				reverse = reverse + result.charAt(i);
			}
			result = reverse;
		}

		return result;
	}

}
