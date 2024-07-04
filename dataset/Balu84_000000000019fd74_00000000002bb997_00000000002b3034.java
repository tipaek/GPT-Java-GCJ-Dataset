import java.util.*;
import java.io.*;
import java.util.regex.Pattern;

/*

@see https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd74/00000000002b3034
*/
public class Solution {
    private static final String OUTPUT_FORMAT = "Case #%d: %s"; //Use with String.format - 1.: number of the test case, 2.: solution
    private static final String ASTERISK = "*";
    
    public static void main(String[] args) {
        //String[] alma = "*ALMA".split(Pattern.quote(ASTERISK));
        //System.out.println(Arrays.toString(alma) + " - " + alma.length);
        //System.out.println("".indexOf(""));
        //System.out.println("".contains(""));
        //String[] alma = "ALMA*".split(Pattern.quote(ASTERISK));
        //System.out.println(Arrays.toString(alma) + " - " + alma.length);
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int T = in.nextInt(); //number of test cases
        in.nextLine();
test:   for (int currentTestCase = 1; currentTestCase <= T; currentTestCase++) {
            final int N = in.nextInt(); //number of patterns
            in.nextLine();
            final String[] PATTERNS = new String[N];
            for(int pi=0; pi<N; pi++) {
                PATTERNS[pi] = in.nextLine().trim();
            }
            //start solution
            StringBuilder sb = new StringBuilder();
            List<String> matchStr = new ArrayList();
            List<String> matchStrLeftover = null;
            for(int pi=0; pi<N; pi++) {
                String[] patternParts = PATTERNS[pi].split(Pattern.quote(ASTERISK));
                if(PATTERNS[pi].lastIndexOf(ASTERISK) == PATTERNS[pi].length()-1) {
                    //last character is an asterisk, split removes that for some reason
                    patternParts = Arrays.copyOf(patternParts, patternParts.length+1);
                    patternParts[patternParts.length-1] = "";
                }
                if(pi == 0) {
                    //add the first parts into our matcher string array
                    matchStr.addAll(Arrays.asList(patternParts));
                    continue;
                }
                boolean firstPartMatches = true;
                boolean lastPartMatches = true;
                if(matchStr.get(0).contains(patternParts[0])) {
                    //if beginning of current pattern is contained in our solution already, we are fine
                }
                else if(patternParts[0].contains(matchStr.get(0))) {
                    //if beginning of our solution until know is contained in the current pattern, we swap
                    matchStr.set(0, patternParts[0]);
                }
                else {
                    firstPartMatches = false;
                }
                if(matchStr.get(matchStr.size()-1).contains(patternParts[patternParts.length-1])) {
                    //if beginning of current pattern is contained in our solution already, we are fine
                }
                else if(patternParts[patternParts.length-1].contains(matchStr.get(matchStr.size()-1))) {
                    //if beginning of our solution until know is contained in the current pattern, we swap
                    matchStr.set(matchStr.size()-1, patternParts[patternParts.length-1]);
                }
                else {
                    lastPartMatches = false;
                }
                if(firstPartMatches && lastPartMatches) {
                    //continue and check the other patterns as well
                }
                else {
                    //beginning or end does not match, there is no solution
                    System.out.println(String.format(OUTPUT_FORMAT, currentTestCase, ASTERISK));
                    continue test;
                }
            } // end of patterns
            sb.append(matchStr.get(0)).append(matchStr.get(matchStr.size()-1));
            //end solution
            System.out.println(String.format(OUTPUT_FORMAT, currentTestCase, sb.toString()));
        } //end of test cases
    }
}