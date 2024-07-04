import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			new Solution().solve(i, br);
		}
	}

	private void solve(int t, BufferedReader br) throws IOException {
		String in[] = br.readLine().split(" ");
		int x = Integer.parseInt(in[0]);
		int y = Integer.parseInt(in[1]);
		String s = "";
		char c1 = 'N', c2 = 'E', c3 = 'S', c4 = 'W';
		if (x < 0) {
			x = x * -1;
			c2 = 'W';
			c4 = 'E';
		}
		if (y < 0) {
			y=y*-1;
			c1 = 'S';
			c3 = 'N';
		}
		if (x % 2 == 0 && y % 2 == 0) {
			System.out.println("Case #"+t+": IMPOSSIBLE");
		} else if (x % 2 == 1 && y % 2 == 1) {
			System.out.println("Case #"+t+": IMPOSSIBLE");
		} else {
			long b = get(x + y);
			s=cal(x, y, b/2, c1, c2, c3, c4);
			if(s.equals("IMPOSSIBLE")) {
				s= cal(x, y, b, c1, c2, c3, c4);
				if(s.equals("IMPOSSIBLE")) {
					System.out.println("Case #"+t+": IMPOSSIBLE");
				}else {
					System.out.println("Case #"+t+": "+s);
				}
			}else {
				System.out.println("Case #"+t+": "+s);
			}
			
		}

	}

	private String cal(long x, long y, long b, char c1, char c2, char c3, char c4) {
		String s="";
		while (b != 1) {
			if (Math.abs(x) > Math.abs(y)) {
				if (x >= 0) {
					x = x - b;
					s = c2+s;
				} else {
					x = x + b;
					s = c4+s;
				}
			} else {
				if (y >= 0) {
					y = y - b;
					s = c1+s;
				} else {
					y = y + b;
					s = c3+s;
				}
			}
			b = b / 2;
		}
		if (x == 0 && y == 1) {
			s = c1+s;
		} else if (x == 0 && y == -1) {
			s = c3+s;
		} else if (y == 0 && x == 1) {
			s = c2+s;
		} else if (y == 0 && x == -1) {
			s = c4+s;
			
		} else {
			return "IMPOSSIBLE";
		} // TODO Auto-generated method stub
		return s;
	}

	private long get(int i) {
		long a = 1;
		while (a < i) {
			a = a * 2;
		}
		return a;
	}

}
