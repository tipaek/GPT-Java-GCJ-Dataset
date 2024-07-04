import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author avcbcoder last modified @19-Apr-2020 @10:31:00 PM Codejam 2020 B -
 *         TODO
 */

 class Solution {
	public static void main(String[] args) throws Exception {
		String[] ip = br.readLine().split(" ");
		int t = new Integer(ip[0]);
		int a = new Integer(ip[1]);
		int b = new Integer(ip[2]);
		while (t-- > 0)
			solve(a, b);
	}

	// **SOLUTION**
	public static void solve(int A, int B) throws Exception {
		int xmid = 0, ymid = 0;
		for (int r = xmid - 6; r <= xmid + 6; r++) {
			for (int c = ymid - 6; c <= ymid + 6; c++) {
				System.out.println(r + " " + c);
				String judge = br.readLine();
				if (judge.equals("CENTER"))
					return;
			}
		}
	}

	public static InputStreamReader r = new InputStreamReader(System.in);
	public static BufferedReader br = new BufferedReader(r);
}
