import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 0; t < T; t++) {
			int N = in.nextInt();
			// 1, 1, 2, ... , 498 -> (1+498)*498/2+1 -> 124252
			// Limit 500
			// V1: 1..501
			// V2: 1..1000
			// V3: 1..1000000000
			// int    2147483647
			System.out.println("CASE #" + (t + 1) + ":");
			int[][] debug = new int[35][]; {
				int[] l = new int[] { 0, 1 };
				debug[1] = l;
				for (int r = 2; r < debug.length; r++) {
					int[] ll = new int[l.length + 1];
					ll[1] = 1;
					ll[l.length] = 1;
					for (int c = 2; c < l.length; c++) {
						ll[c] = l[c - 1] + l[c];
					}
					debug[r] = ll;
					l = ll;
				}
//				debug(debug);
			}
			if (N == 1) {
				System.out.println("1 1");
			} else if (N == 2) {
				System.out.println("1 1");
				System.out.println("2 1");
			} else if (N <= 124252) {
				System.out.println("1 1");
//				System.err.println("I " + debug[1][1]);
				int remain = N - 1;
				int r = 2;
				for (;;) {
					int vR = r - 1;
					if (remain >= vR) {
						System.out.println(r + " " + (r - 1));
//						System.err.println("L " + debug[r][r - 1]);
						remain -= vR;
						r++;
						continue;
					}
					r--;
					break;
				}
				if (remain > 0) {
					System.out.println(r + " " + r);
//					System.err.println("H " + debug[r][r]);
					r++;
					remain--;
				}
				while (remain > 0) {
					System.out.println(r + " " + r);
//					System.err.println("T " + debug[r][r]);
					r++;
					remain--;
				}
			} else {

			}
		}
	}
//	public static void debug(int[][] grid) {
//		for (int y = 0, yMax = grid.length; y < yMax; y++) {
//			debug(grid[y]);
//		}
//	}
//	public static void debug(int[] a) {
//		System.err.println(null == a ? "null" : Arrays.stream(a).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
//	}
}
