import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	private static final int MAX_LENGTH = 100 * 100;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numCases = Integer.parseInt(sc.nextLine());
		for (int index = 0; index < numCases; index++) {
			int numPatterns = Integer.parseInt(sc.nextLine());
			String[] patterns = new String[numPatterns];
			for (int i = 0; i < numPatterns; i++) {
				patterns[i] = sc.nextLine();
			}
			System.out.println("Case #" + (index + 1) + ": " + condense(patterns));
		}
		sc.close();
	}
	
	private static String condense(String[] patterns) {
		String ret = patterns[0];
		
		int star = ret.indexOf('*');
		String prefix = ret.substring(0, star);
		String suffix = ret.substring(star + 1);
		
		for (int i = 1; i < patterns.length; i++) {
			String newPat = patterns[i];
			star = newPat.indexOf('*');
			String newPrefix = newPat.substring(0, star);
			String newSuffix = newPat.substring(star + 1);
			
			if (newPrefix.startsWith(prefix)) {
				prefix = newPrefix;
			} else if (! prefix.startsWith(newPrefix)) {
				return "*";
			}
			
			if (newSuffix.endsWith(suffix)) {
				suffix = newSuffix;
			} else if (! suffix.endsWith(newSuffix)) {
				return "*";
			}
		}
		
		if (prefix.endsWith(suffix)) {
			return prefix;
		} else if (suffix.startsWith(prefix)) {
			return suffix;
		} else if (prefix.length() + suffix.length() < MAX_LENGTH) {
			return prefix + suffix;
		}
		return "*";
	}
}
