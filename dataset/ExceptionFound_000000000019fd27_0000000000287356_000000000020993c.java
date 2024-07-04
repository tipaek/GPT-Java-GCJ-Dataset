import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			List<List<Integer>> list = new ArrayList<>();
			int rowCount = 0, colCount = 0, sum = 0;
			int n = in.nextInt();
			for (int j = 0; j < n; j++) {
				String str = in.nextInt() + in.nextLine();
				String s[] = str.split(" ");
				sum += Integer.parseInt(s[j]);
				Set<Integer> set = new HashSet<>();
				List<Integer> rowList = new ArrayList<>();
				int count = 0;
				for (int k = 0; k < s.length; k++) {
					int num = Integer.parseInt(s[k]);
					rowList.add(num);
					if (set.contains(num)) {
						count++;
					} else {
						set.add(num);
					}
				}
				if(count > 0) rowCount++;
				list.add(rowList);
			}
			
			for (int m = 0; m < list.size(); m++) {
				Set<Integer> set = new HashSet<>();
				for (int l = 0; l < list.get(m).size(); l++) {
					int num = list.get(l).get(m);
					if (set.contains(num)) {
						colCount++;
						break;
					} else {
						set.add(num);
					}
				}
			}

			System.out.println("Case #" + i + ": " + sum + " " + rowCount + " " + colCount);
		}
		in.close();
	}
}