import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		Set<String> patterns = new HashSet<>();
		
		for(int i = 0; i < testCases; i++) {
			// patterns?
			int patternsCount = scanner.nextInt();
			for(int j = 0; j < patternsCount; j++) {
				String p = scanner.next().replace("*", "");
				patterns.add(p);
			}
			int maxSize = 0;
			String max = new String();
			for(String s : patterns) {
				if (s.length() > maxSize) {
					maxSize = s.length();
					max = s;
				}
			}
			
			for(String s : patterns) {
				if (!max.contains(s)) max = "*";
			}
			
			System.out.println("Case #" + (i+1) + ": " + max);
		}
		
//		System.out.println(match(pattern.toCharArray(), input.toCharArray(), 0, 0));
	}

}
