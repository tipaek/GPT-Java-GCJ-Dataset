import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class A {
	public static void main(String[] args) throws Exception {
		int t = new Integer(br.readLine());
		for (int i = 1; i <= t; i++) {
			System.out.print("Case #" + i + ": ");
			solve();
		}
	}

	// **SOLUTION**
	public static void solve() throws Exception {
		String[] ip = br.readLine().split(" ");
		int x = -new Integer(ip[0]);
		int y = -new Integer(ip[1]);

		int time = 0;
		for (int i = 0; i < ip[2].length(); i++) {
			time++;
			switch (ip[2].charAt(i)) {
			case 'N':
				y--;
				break;
			case 'S':
				y++;
				break;
			case 'E':
				x--;
				break;
			case 'W':
				x++;
				break;
			}
			int t = Math.abs(x) + Math.abs(y);
			if (t <= time) {
				System.out.println(time);
				return;
			}
		}
		System.out.println("IMPOSSIBLE");
	}

	public static InputStreamReader r = new InputStreamReader(System.in);

	public static BufferedReader br = new BufferedReader(r);

	public static Scanner sc = new Scanner(System.in);
}
