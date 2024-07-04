import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int s = 1; s <= t; s++) {
			int x = in.nextInt();
			int y = in.nextInt();
			int mod = 2;
			boolean works = true;
			String out = "";
			for (int i = 1; i < 32 && works && !(x == 0 && y == 0); i++) {
				int a = x%mod;
				int b = y%mod;
				if (a == b) works = false;
				if (a != 0 && ab(a) != mod/2) works = false;
				if (b != 0 && ab(b) != mod/2) works = false;
				else {
					//System.out.println(x + " " + y + " " + a + " " + b + " " + mod + " " + out);
					mod *= 2;
					if (a == 0) {
						if ((y+b)%mod == (x)%mod || y == b) {
							if (y > 0) out = out + "N";
							else out = out + "S";
							y -= b;
						}
						else if ((y+b)%mod != (x)%mod || y == -b) {
							if (y > 0) out = out + "S";
							else out = out + "N";
							y += b;
						}
					}
					else {
						if ((x+a)%mod == (y)%mod || x == a) {
							if (x > 0) out = out + "E";
							else out = out + "W";
							x -= a;
						}
						else if ((x+a)%mod != (y)%mod || x == -a) {
							if (x > 0) out = out + "W";
							else out = out + "E";
							x += a;
						}
					}
				}
			}
			if (!works || x != 0 || y != 0) System.out.println("Case #" + s + ": IMPOSSIBLE");
			else System.out.println("Case #" + s + ": " + out);
		}
		in.close();
	}
	static int ab(int a) {
		if (a >= 0) return a;
		else return -a;
	}
}