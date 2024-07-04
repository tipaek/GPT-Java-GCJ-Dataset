import java.util.*;
import java.util.Map.Entry;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] s = sc.nextLine().split(" ");
		int testCases = Integer.parseInt(s[0]);
		for(int i = 0; i < testCases; i++) {
			String[] line = sc.nextLine().split(" ");
			int R = Integer.parseInt(line[0]);
			int S = Integer.parseInt(line[1]);
			int move = 0;
			List<String> out = new ArrayList<>();
			for(int j = 1; j < S; j++) {
				int a = R * j;
				out.add("" + a + " " + (R-1));
				move++;
				for(int k = R; k != 2; k--) {
					int e = k-1;
					int m = k-(j*2);
					out.add("" + e + " " + m);
					move++;
				}
			}
			System.out.println("Case #" + (i+1) + ": " + move);
			for(String o : out) {
				System.out.println(o);
			}
		}
	}
}