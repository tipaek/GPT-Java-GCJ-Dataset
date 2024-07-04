import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(reader.readLine());
		int n, k = 1;
		List<List<String>> al;
		StringBuffer sb = new StringBuffer();
		while (x-- > 0) {
			al = new ArrayList<List<String>>();
			n = Integer.parseInt(reader.readLine());
			for (int i = 0; i < n; i++) {
				al.add(Arrays.asList(reader.readLine().split(" ")));
			}
			sb.append("Case #" + k++ + ": " + calculateTrace(al, n) + "\n");
		}
		sb.substring(0, sb.length() - 1);
		System.out.println(sb.toString());
	}

	public static String calculateTrace(List<List<String>> al, int n) {
		int trace = 0, rows = 0, cols = 0, k = 0;
		Set<Integer> set1;
		Set<Integer> set2;
		for (int i = 0; i < n; i++) {
			set1 = new HashSet<>();
			set2 = new HashSet<>();
			trace += Integer.parseInt(al.get(i).get(i));
			for (int j = 0; j < n; j++) {
				set1.add(Integer.parseInt(al.get(i).get(j)));
				set2.add(Integer.parseInt(al.get(j).get(k)));
			}
			if (set1.size() != n)
				rows++;
			if (set2.size() != n)
				cols++;
			k++;
		}
		return trace + " " + rows + " " + cols;
	}

}
