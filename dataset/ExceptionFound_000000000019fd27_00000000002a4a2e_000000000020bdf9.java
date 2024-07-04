import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; i++) {
			int m = in.nextInt();
			Map<Integer, HashSet<Character>> map = new TreeMap<>();
			List<Integer> list = new ArrayList<>();
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < m; j++) {
				String str = in.next() + in.nextLine();
				String s[] = str.split(" ");
				int num1 = Integer.parseInt(s[0]);
				int num2 = Integer.parseInt(s[1]);
				list.add(num1);
				list.add(num2);
				map.put(num1, new HashSet<>());
				map.put(num2, new HashSet<>());
			}
			String s = "";
			for (int k = 0; k < list.size() - 1; k = k + 2) {
				int start = list.get(k);
				int end = list.get(k + 1);
				boolean isJ = false, isC = false, isJC = false;
				for (Integer key : map.keySet()) {
					if (key >= start && key < end) {
						if (map.get(key).contains('J') && map.get(key).contains('C')) {
							isJC = true;
						} else if (!map.get(key).contains('J') && map.get(key).contains('C')) {
							isC = true;
						} else if (map.get(key).contains('J') && !map.get(key).contains('C')) {
							isJ = true;
						}
					}
				}

				for (Integer key : map.keySet()) {
					if (key >= start && key < end) {
						if (isJC) {
							sb.setLength(0);
							s = "IMPOSSIBLE";
						} else if (isJ) {
							s = "C";
							map.get(key).add('C');
						} else if (isC) {
							s = "J";
							map.get(key).add('J');
						} else {
							s = "C";
							map.get(key).add('C');
						}
					}
				}
				sb.append(s);
			}
			System.out.println("Case #" + i + ": " + sb.toString());
		}
		in.close();
	}

}