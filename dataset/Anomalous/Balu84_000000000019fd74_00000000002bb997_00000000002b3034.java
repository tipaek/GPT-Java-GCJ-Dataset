import java.util.*;
import java.io.*;
import java.util.regex.Pattern;

/*
@see https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd74/00000000002b3034
*/
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
            final String[] patterns = new String[N];
            for (int i = 0; i < N; i++) {
                patterns[i] = in.nextLine().trim();
            }

            StringBuilder result = new StringBuilder();
            List<String> matchStr = new ArrayList<>();
            boolean isPossible = true;

            for (int i = 0; i < N && isPossible; i++) {
                String[] parts = patterns[i].split(Pattern.quote(ASTERISK));
                
                if (patterns[i].endsWith(ASTERISK)) {
                    parts = Arrays.copyOf(parts, parts.length + 1);
                    parts[parts.length - 1] = "";
                }

                if (i == 0) {
                    matchStr.addAll(Arrays.asList(parts));
                    continue;
                }

                boolean firstPartMatches = matchStr.get(0).contains(parts[0]) || parts[0].contains(matchStr.get(0));
                boolean lastPartMatches = matchStr.get(matchStr.size() - 1).contains(parts[parts.length - 1]) || parts[parts.length - 1].contains(matchStr.get(matchStr.size() - 1));

                if (!firstPartMatches || !lastPartMatches) {
                    isPossible = false;
                } else {
                    if (parts[0].contains(matchStr.get(0))) {
                        matchStr.set(0, parts[0]);
                    }
                    if (parts[parts.length - 1].contains(matchStr.get(matchStr.size() - 1))) {
                        matchStr.set(matchStr.size() - 1, parts[parts.length - 1]);
                    }
                }
            }

            if (isPossible) {
                result.append(matchStr.get(0)).append(matchStr.get(matchStr.size() - 1));
                System.out.println(String.format(OUTPUT_FORMAT, currentTestCase, result.toString()));
            } else {
                System.out.println(String.format(OUTPUT_FORMAT, currentTestCase, ASTERISK));
            }
        }
    }
}