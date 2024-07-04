import java.util.Scanner;

public class Solution {
	public static String route(int X, int Y) {
		String ans = "IMPOSSIBLE";
		int minDistance = Math.abs(X) + Math.abs(Y);
		double possibleDistance = 0;
		int i = 0;
		while (possibleDistance < minDistance) {
			possibleDistance = possibleDistance + Math.pow(2, i);
			i++;
		}
		i--;
		double endPoint = Math.pow(2, i);
		StringBuilder sb = new StringBuilder();
		while ((X != 0 || Y != 0) && i >= 0) {
			endPoint = Math.pow(2, i);
			if (Math.abs(X) < Math.abs(Y)) {
				if (Y > 0) {
					sb.append("N");
					Y = Y - (int) endPoint;
				} else {
					sb.append("S");
					Y = (int) endPoint - Math.abs(Y);
				}
			} else if (Math.abs(X) > Math.abs(Y)) {
				if (X > 0) {
					sb.append("E");
					X = X - (int) endPoint;
				} else {
					sb.append("W");
					X = (int) endPoint - Math.abs(X);
				}
			} else {
				return "IMPOSSIBLE";
			}
			i--;
		}
		String s = sb.reverse().toString();
		return s;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int points[][] = new int[T][2];
		for (int i = 0; i < T; i++) {
			points[i][0] = sc.nextInt();
			points[i][1] = sc.nextInt();
		}
		for (int i = 0; i < T; i++) {
			int index = i + 1;
			String ans = route(points[i][0], points[i][1]);
			System.out.println("Case #" + index + ": " + ans);
		}
	}
}
