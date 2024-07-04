import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		tcloop:
		for (int t = 1; t <= tc; t++) {
			int v = 1000000000;
			int[] ty = { 2*v / 4, 0, -2*v/4, };
			/*for (int i = 0; i < ty.length; i++) {
				int high = v;
				int low = -v;
				while (true) {
					int mid = (low+high)/2;
					System.out.println(mid + " " + ty[i]);
					String res = in.next();
					if (res.equals("CENTER")) {
						continue tcloop;
					} else if (res.equals("MISS")) {
						
					}
				}
			}*/
			
			int low = -v, high = 0;
			while (low < high-1) {
				int mid = (low+high)/2;
				System.out.println(mid + " " + (2*v/4));
				String res = in.next();
				if (res.equals("MISS")) low = mid;
				else if (res.equals("HIT")) high = mid;
				else if (res.equals("CENTER")) continue tcloop;
			}
			int left = high;
			low = 0; high = v;
			while (low < high-1) {
				int mid = (low+high)/2;
				System.out.println(mid + " " + (2*v/4));
				String res = in.next();
				if (res.equals("MISS")) high = mid;
				else if (res.equals("HIT")) low = mid;
				else if (res.equals("CENTER")) continue tcloop;
			}
			int right = low;
			
			high = 2*v/4; low = -v;
			while (low < high-1) {
				int mid = (low+high)/2;
				System.out.println(left + " " + mid);
				String res = in.next();
				if (res.equals("MISS")) low = mid;
				else if (res.equals("HIT")) high = mid;
				else if (res.equals("CENTER")) continue tcloop;
			}
			int leftb = high;
			int cx = (left+right)/2;
			int cy = (left+leftb)/2;
			
			System.out.println(cx + " " + cy);
			String res = in.next();
			if (res.equals("CENTER")) continue tcloop;
			int[] dx = { -1, 0, 1, 1, 1, 0, -1, -1 };
			int[] dy = { 1, 1, 1, 0, -1, -1, -1, 0 };
			for (int i = 0; i < 8; i++) {
				System.out.println((cx+dx[i]) + " " + (cy+dy[i]));
				res = in.next();
				if (res.equals("CENTER")) continue tcloop;
			}
			System.out.println("fail");
			System.exit(0);
		}
	}
}
