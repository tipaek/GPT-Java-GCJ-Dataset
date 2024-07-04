import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Solution {

	static String str = "";
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int            t  = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			Solution.str = "";
			String in[] = br.readLine().split(" ");
			long   second = Long.parseLong(in[0]);
			long   first  = Long.parseLong(in[1]);
			if ((((first % 2) == 0) && ((second % 2) != 0)) || (((first % 2) != 0) && ((second % 2) == 0))) {
				if((first%2)==0) {
					if (Solution.checkSolution(first, second + 1)) {
						System.out.println("Case #" + i + ": W" + Solution.str);
					} else if (Solution.checkSolution(first, second - 1)) {
						System.out.println("Case #" + i + ": E" + Solution.str);
					} else {
						System.out.println("Case #" + i + ": IMPOSSIBLE");
					}
					
				}else {
					if (Solution.checkSolution(first + 1, second)) {
						System.out.println("Case #" + i + ": S" + Solution.str);
					} else if (Solution.checkSolution(first - 1, second)) {
						System.out.println("Case #" + i + ": N" + Solution.str);
					} else {
						System.out.println("Case #" + i + ": IMPOSSIBLE");
					}
				}
			} else {
				System.out.println("Case #" + i + ": IMPOSSIBLE");
			}
		}

	}
	
	private static boolean checkSolution(long first, long second) {
		List<Integer> list1 = new ArrayList<>();
		while (Math.abs(first) > 0) {
			int n = Solution.highestPowerof2(Math.abs(first));
			if (first > 0) {
				first -= n;
				list1.add(n);
			} else {
				first += n;
				list1.add(-n);
			}
		}
		List<Integer> list2 = new ArrayList<>();
		while (Math.abs(second) > 0) {
			int n = Solution.highestPowerof2(Math.abs(second));
			if (second > 0) {
				second -= n;
				list2.add(n);
			} else {
				second += n;
				list2.add(-n);
			}
		}
		TreeSet<Integer> s = new TreeSet<>();
		s.addAll(list1);
		s.addAll(list2);
		TreeSet<Integer> temp = new TreeSet<>();
		s.forEach(i -> {
			if (i < 0) {
				temp.add(-i);
			} else {
				temp.add(i);
			}
		});
		s = temp;
		if ((list1.size() + list2.size()) == s.size()) {
			int n = Solution.powerof2(s.last());
			for (int i = 1; i <= n; i++) {
				if (list1.contains((int) Math.pow(2, i))) {
					Solution.str = Solution.str + "N";
				} else if (list2.contains((int) Math.pow(2, i))) {
					Solution.str = Solution.str + "E";
				} else if (list1.contains(-(int) Math.pow(2, i))) {
					Solution.str = Solution.str + "S";
				} else if (list2.contains(-(int) Math.pow(2, i))) {
					Solution.str = Solution.str + "W";
				} else {
					return false;
				}
				if (i == n) {
					return true;
				}
			}
		}
		return false;
	}

	static int powerof2(long first) {
		int p = (int) (Math.log(first) / Math.log(2));
		return p;
	}
	static int highestPowerof2(long first) {
		int p = (int) (Math.log(first) / Math.log(2));
		return (int) Math.pow(2, p);
	}
}
