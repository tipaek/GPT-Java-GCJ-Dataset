import java.util.*;

public class Solution {
	
	public static void main(String... args) {
		Scanner scanner = new Scanner(System.in);
    	int tests = scanner.nextInt();
    	
        for (int test = 0; test < tests; ++test) {
        	int npatterns = scanner.nextInt();
        	
        	char wordLetters[] = new char[10010]; 
        	int ixStart = wordLetters.length-1;
        	wordLetters[ixStart] = '*';
        	
        	boolean impossible = false;
        	for (int i = 0; i < npatterns; i++) {
        		String pattern = scanner.next();
        		
        		// subcase1
        		if (pattern.indexOf('*') == 0) {
        			for (int j = 0; j < pattern.length()-1; j++) {
        				int ix = wordLetters.length-1 - j;
        				if (ix > ixStart) {
        					if (wordLetters[ix] != '*' &&  wordLetters[ix] != pattern.charAt(pattern.length()-1 - j)) {
        						impossible = true;
        						break;
        					}
        				}
        				wordLetters[ix] = pattern.charAt(pattern.length()-1 - j);
        			}
        			
        			if (wordLetters.length - pattern.length() < ixStart) {
        				ixStart = wordLetters.length - pattern.length();
        			}

        		}
       		
        	}
        	
        	
        	if (impossible) {
        		System.out.println(String.format("Case #%d: *", test + 1));
        	} else {
        		StringBuilder sb = new StringBuilder();
        		char[] word = Arrays.copyOfRange(wordLetters, ixStart + 1, wordLetters.length);
        		sb.append(word);
        		System.out.println(String.format("Case #%d: %s", test + 1, sb.toString()));
        	}
        	
        }
	}
	
}