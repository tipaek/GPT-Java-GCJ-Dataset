import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int count = in.nextInt();
			String result = "";
			int jamie = 0;
			int cameron = 0;
			List<int[]> list = new ArrayList<>();
			for (int j = 0; j < count; ++j) {
				list.add(new int[] {in.nextInt(), in.nextInt()});
			}
			list.sort((a,b) -> (a[0] != b[0])? a[0]-b[0] : b[0]-b[1]);
			for (int j = 0; j < count; ++j) {
				int [] a = list.get(j);
				//System.out.println(a[0] + " " + a[1]);
				
				if(cameron <= a[0]) {
					result += "C";
					cameron = a[1];
				} else if(jamie <= a[0]) {
					result += "J";
					jamie = a[1];
				} else {
					result = "IMPOSSIBLE";
					break;
				}
			}

			System.out.println("Case #" + i + ": " + result);
		}
	}
}