import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int k = 1; k <= t; k++) {
			List<int[]> c = new ArrayList<>();
			List<int[]> j = new ArrayList<>();
			int[] tmp;
			int n = sc.nextInt();
			int s;
			int e;
			StringBuilder sb = new StringBuilder();
			String result = ""; char active = 'J';
			for (int i = 0; i < n; i++) {
				s = sc.nextInt();
				e = sc.nextInt();
				tmp = new int[2];
				tmp[0] = s;
				tmp[1] = e;
				if(active == 'J') {
					if (isOverlapping(s, e, j)) {
						if (isOverlapping(s, e, c)) {
							result = "IMPOSSIBLE";
							break;
						} else {
							c.add(tmp);
							sb.append('C');
							active = 'C';
						}
					} else {
						j.add(tmp);
						sb.append('J');
					}
				}
				else {
					if (isOverlapping(s, e, c)) {
						if (isOverlapping(s, e, j)) {
							result = "IMPOSSIBLE";
							break;
						} else {
							j.add(tmp);
							sb.append('J');
							active = 'J';
						}
					} else {
						c.add(tmp);
						sb.append('C');
					}
				}
			}
			result = result.equals("IMPOSSIBLE") ? "IMPOSSIBLE" : sb.toString();
			System.out.println("Case #"+k+": "+result);
		}
		sc.close();
	}
	
	private static boolean isOverlapping(int start, int end, List<int[]> list) {
		int aStart; int aEnd;
		for(int i = 0; i < list.size(); i++) {
			aStart = list.get(i)[0];
			aEnd = list.get(i)[1];
			if ((aStart == start && aEnd == end) || (aStart > start && aStart < end) || (aEnd < end && aEnd > start)
					|| (aStart > start && aEnd < end) || (aStart < start && aEnd > end)) return true;
		}
		return false;
	}

}
