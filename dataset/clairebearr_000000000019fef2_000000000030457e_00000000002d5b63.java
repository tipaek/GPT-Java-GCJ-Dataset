import java.io.*;
import java.util.*;

public class Solution {
	
	static boolean done = false, xdone = false;
	static int bound = (int) 1e9;
//	static int bound = 10;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		outer : for (int test = 1; test <= t; test++) {
			done = false;
			xdone = false;
//			int top = searchtop(sc);
//			if (done) continue;
//			int bot = searchbot(sc);
//			if (done) continue;
//			int right = searchright(sc);
//			if (done) continue;
////			System.out.println(right);
//			int left = searchleft(sc);
//			if (done) continue;
////			System.out.println(left);
//			int vert = top - bot;
//			int mvert = vert / 2;
//			int mhor = (right - left) / 2;
			int mvert = 0;
			int mhor = 0;
			for (int i = -5; i <= 5; i++) {
				for (int j = -5; j <= 5; j++) {
					System.out.println((mvert+i) + " " + (mhor+j));
					String resp = sc.next();
					if (resp.equals("CENTER")) {
						continue outer;
					}
				}
			}
		}
		
	}
	
	static int searchright(Scanner sc) {
		int low = -bound;
		int high = bound;
		int y = 0;
		int prevmid = Integer.MAX_VALUE;
		while (low != high) {
			int mid = (low + high + 1) / 2;
			System.out.println(mid + " " + y);
//			if (mid == prevmid) mid++;
			String resp = sc.next();
			if (resp.equals("HIT")) {
				low = mid;
			} else if (resp.equals("MISS")) {
				high = mid - 1;
			} else if (resp.equals("CENTER")) {
				done = true;
				return mid;
			}
			prevmid = mid;
		}
		return low;
	}
	
	static int searchleft(Scanner sc) {
		int low = -bound;
		int high = bound;
		int y = 0;
		int prevmid = Integer.MAX_VALUE;
		while (low != high) {
			int mid = (low + high - 1) / 2;
			int ask = mid;
//			if (mid == prevmid) ask++;
			System.out.println(ask + " " + y);
			String resp = sc.next();
			if (resp.equals("HIT")) {
				high = mid;
			} else if (resp.equals("MISS")) {
				low = mid + 1;
			} else if (resp.equals("CENTER")) {
				done = true;
				return mid;
			}
			prevmid = mid;
		}
		return low;
	}
	
	static int searchtop(Scanner sc) {
		//look for top
		int x = 0;
		int low = (int) -bound;
		int high = (int) bound;
		int prevmid = Integer.MAX_VALUE;
		while (low != high) {
			int mid = (low + high + 1) / 2;
//			if (mid == prevmid) mid++;
			System.out.println(x + " " + mid);
			String resp = sc.next();
			if (resp.equals("HIT")) {
				low = mid;
			} else if (resp.equals("MISS")) {
				high = mid - 1;
			} else if (resp.equals("CENTER")) {
				done = true;
				return mid;
			}
			prevmid = mid;
		}
		return low;
	}
	
	static int searchbot(Scanner sc) {
		int x = 0;
		int low = -bound;
		int high = bound;
		int prevmid = Integer.MAX_VALUE;
		while (low != high) {
			int mid = (low + high - 1) / 2;
//			if (mid == prevmid) mid++;
			System.out.println(x + " " + mid);
			String resp = sc.next();
			if (resp.equals("HIT")) {
				high = mid;
			} else if (resp.equals("MISS")) {
				low = mid + 1;
			} else if (resp.equals("CENTER")) {
				done = true;
				return mid;
			}
			prevmid = mid;
		}
		return low;
	}

}
