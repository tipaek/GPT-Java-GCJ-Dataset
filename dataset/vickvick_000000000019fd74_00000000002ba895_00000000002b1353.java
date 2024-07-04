
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		long t = scan.nextInt();
		for (long it = 1; it <= t; ++it) {
			long n = scan.nextLong();
			String res = cal(n);
			System.out.println("Case #" + it + ":");
			System.out.println(res);
		}
		scan.close();
	}

	private static String cal(long n) {
		if (n == 1) {
			return "1";
		}
		if (n == 2) {
			return "1 1\n2 1";
		}
		if (n <= 1000) {
			List<String> res = new ArrayList<>();
			res.add("1 1");
			boolean even = n % 2 == 0;
			long maxRow1 = even ? n / 2 : n / 2 + 1;
			for (int i = 2; i <= maxRow1; ++i) {
				res.add(i + " 1");
			}
			if (even)
				res.add((maxRow1 + 1) + " 2");
			else
				res.add(maxRow1 + " 2");
			return res.stream().collect(Collectors.joining("\n"));

		}
		return "bye";
	}

}