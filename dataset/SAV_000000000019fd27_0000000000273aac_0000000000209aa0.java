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
			for (int i = 1; i <= N; i++) {
				int diff = K - (N-1)*i;
				if (diff <= N && diff >= 1) {
					if (Math.abs(diff - i) > 1 || diff == i) {
						flag = 1;
						break;
					}
				}
			}
			if (flag == 0) {
				System.out.println("Case #" + t + ": IMPOSSIBLE");
			} else {
				System.out.println("Case #" + t + ": POSSIBLE");
			}
			t++;
		}
	}
}
