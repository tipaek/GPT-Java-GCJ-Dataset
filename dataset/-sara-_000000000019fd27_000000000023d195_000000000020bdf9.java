import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt(); 
		for (int i = 1; i <= t; ++i) {
			List<Integer> jamie = new ArrayList<Integer>();
			List<Integer> cameron = new ArrayList<Integer>();
			for (int j = 0; j <= 1440; j++) {
				jamie.add(0);
				cameron.add(0);
			}
			int n = in.nextInt();
			String solution = "";
			for (int j = 0; j < n; j++) {
				int beginTime = in.nextInt();
				int endTime = in.nextInt();
				if (!jamie.subList(beginTime, endTime).contains(1)) {
					solution = solution + "J";
					for (int k = beginTime; k < endTime; k++) {
						jamie.set(k, 1);
					}
				} else if (!cameron.subList(beginTime, endTime).contains(1)) {
					solution = solution + "C";
					for (int k = beginTime; k < endTime; k++) {
						cameron.set(k, 1);
					}
				} else {
					solution = "IMPOSSIBLE";
					break;
				}
			}
			System.out.println("Case #" + i + ": " + solution);
		}
		in.close();
	}
}
