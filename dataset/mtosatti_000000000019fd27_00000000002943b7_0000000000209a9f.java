import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();

		for (int tc = 1; tc <= t; ++tc) {
			String s = in.next();
			System.out.print("Case #" + tc + ": ");
			int c = 0;
			for (byte b: s.getBytes()) {
				b -= 48;
				int d = b - c;
				int a = Math.abs(d);
				for(int i = 0; i < a; ++i) {
					if(d > 0) {
						System.out.print('(');
					} else if (d < 0) {
						System.out.print(')');
					}
				}
				System.out.print(b);
				c = b;
			}
			for(int i = 0; i < c; ++i) {
				System.out.print(')');
			}
			System.out.println();
		}
	}

}
