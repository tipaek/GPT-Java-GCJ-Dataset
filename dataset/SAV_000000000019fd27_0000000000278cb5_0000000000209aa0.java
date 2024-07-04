import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int t = 1;
		String buffer = sc.nextLine();
		while (t <= T) {
			String str = sc.nextLine();
			String[] strs = str.split("\\s+");
			int N = Integer.parseInt(strs[0]);
			int K = Integer.parseInt(strs[1]);
			int flag = 0;
			if (N == 3 && K == 5) {
				flag = 1;
			}
			if ((K == (N + 1)) || (K == (N*N -1))) {
				flag = 1;
			}
			if (flag == 1) {
				System.out.println("Case #" + t + ": IMPOSSIBLE");
			} else {
				System.out.println("Case #" + t + ": POSSIBLE");
			}
			t++;
		}
	}
}
