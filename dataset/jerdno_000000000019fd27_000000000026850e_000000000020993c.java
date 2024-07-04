import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

//javac Solution2.java
//python interactive_runner.py python.exe testing_tool.py 0 -- java Solution2
//change name before submit

public class Solution {

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		for (int i = 1; i <= T; i++) {
			Set<Integer> rows = new HashSet<>();
			Set<Integer> columns = new HashSet<>();
			Map<Integer, Set<Integer>> rowMap = new HashMap<>();
			Map<Integer, Set<Integer>> columnMap = new HashMap<>();
			int res = 0;
			int n = input.nextInt();
			for (int ii = 0; ii < n; ii++) {
				for (int iii = 0; iii < n; iii++) {
					int pom = input.nextInt();
					rowMap.putIfAbsent(ii, new HashSet<>());
					if (!rowMap.get(ii).add(pom)) {
						rows.add(ii);
					}
					columnMap.putIfAbsent(iii, new HashSet<>());
					if (!columnMap.get(iii).add(pom)) {
						columns.add(iii);
					}
					if (ii == iii) {
						res = res + pom;
					}
				}
			}
			System.out.println("Case #" + i + ": " + res + " " + rows.size() + " " + columns.size());
		}
	}
}