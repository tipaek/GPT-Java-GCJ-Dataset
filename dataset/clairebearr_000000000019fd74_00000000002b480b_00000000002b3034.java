import java.io.*;
import java.util.*;

//solution
public class Solution {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int test = 1; test <= t; test++) {
			int n = sc.nextInt();
			ArrayList<String> needed = new ArrayList<>();
			String beginning = "";
			String end = "";
			boolean possible = true;
			for (int i = 0; i < n; i++) {
				String str = sc.next();
				if (!possible) continue;
				int ast = str.indexOf('*');
				String start = str.substring(0, ast);
				if (ast > 0) {
					if (beginning.indexOf(start) == 0) {
						//we're good
					} else if (start.indexOf(beginning) == 0) {
						beginning = start;
					} else {
						possible = false;
					}
				}
				int prev = ast + 1;
				ast = str.indexOf('*', ast + 1);
				while (ast >= 0) {
					needed.add(str.substring(prev, ast));
					prev = ast + 1;
					ast = str.indexOf('*', ast + 1);
				}
				if (prev < str.length()) {
					String stop = str.substring(prev);
					if (stop.length() > end.length() && stop.substring(stop.length() - end.length()).equals(end)) {
						end = stop;
					} else if (end.length() >= stop.length() && end.substring(end.length() - stop.length()).equals(stop)) {
						// we're good
					} else {
						possible = false;
					}
				}
//				System.out.println(needed);
			}
			if (possible) {
				String ans = beginning;
				for (String s : needed) {
					ans += s;
				}
				ans += end;
				System.out.println("Case #" + test + ": " + ans);
			} else {
				System.out.println("Case #" + test + ": *");
			}
//			System.out.println(needed);
		}
	}

}
