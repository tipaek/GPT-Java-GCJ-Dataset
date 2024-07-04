
import java.util.Scanner;

public class Solution {

	int t;
	Scanner s;
	static int r;
	long toEdge = 1000000000;
	int smallestHitX;
	int smallestHitY;

	public Solution(int t, Scanner s) {
		super();
		this.t = t;
		this.s = s;
	}

	public void solve() {
		// read input and solve
		int gap = (int) ((toEdge - r)*2);
		long gapArray[] = new long[gap + 1];
		for (int i = 0; i <= gap; i++) {
			gapArray[i] = i;
		}
		smallestHitX = gap + 1;
		int left = 0;
		int right = gap + 1;
		while (left <= right) {
			int center = (left + right) / 2;
			System.out.println((-toEdge + center) + " " + 0);
			String res = s.next();
			if (res.equals("HIT")) {
				if (center < smallestHitX) {
					smallestHitX = center;
				}
				if(left == right) {
					break;
				}
				right = center-1;
				center = left;

			} else {
				// MISS
				if(left == right) {
					break;
				}
				left = center+1;
				center = right;
				
			}
		}

		smallestHitY = gap + 1;
		left = 0;
		right = gap + 1;
		while (left <= right) {
			int center = (left + right) / 2;
			System.out.println(0 + " " + (-toEdge + center));
			String res = s.next();
			if (res.equals("HIT")) {
				if (center < smallestHitY) {
					smallestHitY = center;
				}
				if(left == right) {
					break;
				}
				right = center-1;
				center = left;

			} else {
				// MISS
				if(left == right) {
					break;
				}
				left = center+1;
				center = right;
				
			}
		}

		System.out.println((-gap/2 + smallestHitX) + " " + (-gap/2 + smallestHitY));
		s.next();
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();
		r = s.nextInt();
		s.nextInt();
		for (int i = 0; i < testCases; i++) {
			new Solution(i + 1, s).solve();
		}

		s.close();
	}

}
