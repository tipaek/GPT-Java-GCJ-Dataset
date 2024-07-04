import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int tests = s.nextInt();
		
		for (int test = 1; test <= tests; test++) {
			int num = s.nextInt();
			String[] rules = new String[num];
			for (int i = 0; i < num; i++) {
				rules[i] = s.next();
			}
			
			boolean impossible = false;
			
			String beginning = "";
			for (String rule : rules) {
				String first = rule.substring(0, rule.indexOf('*'));
				if (first.length() > beginning.length()) {
					if (first.contains(beginning)) {
						beginning = first;
					} else {
						impossible = true;
					}
				} else {
					if (!beginning.contains(first)) {
						impossible = true;
					}
				}
			}
			
			String end = "";
			for (String rule : rules) {
				String last = rule.substring(rule.indexOf('*') + 1);
				if (last.length() > end.length()) {
					if (last.contains(end)) {
						end = last;
					} else {
						impossible = true;
					}
				} else {
					if (!end.contains(last)) {
						impossible = true;
					}
				}
			}
			
			String answer = beginning + end;
			if (answer.length() == 0)
				answer = "A";
			
			System.out.println("Case #" + test + ": " + (impossible ? "*" : answer));
		}
		
		s.close();
	}

}