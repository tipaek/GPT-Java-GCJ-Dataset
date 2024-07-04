import java.util.*;
import java.io.*;
import java.util.regex.Pattern;

public class Solution {
    private static final String OUTPUT_FORMAT = "Case #%d: %s"; // Use with String.format - 1.: number of the test case, 2.: solution
    private static final String ASTERISK = "*";
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int T = in.nextInt(); // number of test cases
        in.nextLine();
        
        for (int currentTestCase = 1; currentTestCase <= T; currentTestCase++) {
            final int N = in.nextInt(); // number of patterns
            in.nextLine();
            final String[] PATTERNS = new String[N];
            
            for (int pi = 0; pi < N; pi++) {
                PATTERNS[pi] = in.nextLine().trim();
            }
            
            StringBuilder sb = new StringBuilder();
            List<String> matchStr = new ArrayList<>();
            
            for (int pi = 0; pi < N; pi++) {
                String[] patternParts = PATTERNS[pi].split(Pattern.quote(ASTERISK));
                
                if (PATTERNS[pi].endsWith(ASTERISK)) {
                    // last character is an asterisk, split removes that for some reason
                    patternParts = Arrays.copyOf(patternParts, patternParts.length + 1);
                    patternParts[patternParts.length - 1] = "";
                }
                
                if (pi == 0) {
                    // add the first parts into our matcher string array
                    matchStr.addAll(Arrays.asList(patternParts));
                    continue;
                }
                
                boolean firstPartMatches = true;
                boolean lastPartMatches = true;
                
                if (!matchStr.get(0).contains(patternParts[0])) {
                    if (patternParts[0].contains(matchStr.get(0))) {
                        // if beginning of our solution until now is contained in the current pattern, we swap
                        matchStr.set(0, patternParts[0]);
                    } else {
                        firstPartMatches = false;
                    }
                }
                
                String lastMatch = matchStr.get(matchStr.size() - 1);
                String lastPattern = patternParts[patternParts.length - 1];
                String shorter = lastPattern.length() <= lastMatch.length() ? lastPattern : lastMatch;
                String longer = lastPattern.length() > lastMatch.length() ? lastPattern : lastMatch;
                
                if (!longer.endsWith(shorter)) {
                    lastPartMatches = false;
                } else {
                    matchStr.set(matchStr.size() - 1, longer);
                }
                
                if (!firstPartMatches || !lastPartMatches) {
                    // beginning or end does not match, there is no solution
                    System.out.println(String.format(OUTPUT_FORMAT, currentTestCase, ASTERISK));
                    continue;
                }
            }
            
            sb.append(matchStr.get(0)).append(matchStr.get(matchStr.size() - 1));
            System.out.println(String.format(OUTPUT_FORMAT, currentTestCase, sb.toString()));
        }
    }
}