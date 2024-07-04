import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = s.nextInt();
        s.nextLine();
        for (int t = 1; t <= testCases; t++) {
            int totalPatterns = s.nextInt();
            s.nextLine();
            String[] patterns = IntStream.range(0, totalPatterns).mapToObj(q -> s.nextLine()).toArray(l -> new String[l]);

            String answer = solve(patterns);
            System.out.format("Case #%d: %s\n", t, answer);
        }
    }

    private static String solve(String[] patterns) {
        String longestPrefix = "";
        String longestSuffix = "";
        for (int i = 0; i < patterns.length; i++) {
            String s = patterns[i];
            int firstPos = s.indexOf('*');
            String prefix = s.substring(0, firstPos);
            if (!(prefix.startsWith(longestPrefix) || longestPrefix.startsWith(prefix))) {
                return "*";
            }
            longestPrefix = longestPrefix.length() > prefix.length() ? longestPrefix : prefix;

            int lastPos = s.lastIndexOf("*") + 1;
            String suffix = s.substring(lastPos);
            if (!(suffix.endsWith(longestSuffix) || longestSuffix.endsWith(suffix))) {
                return "*";
            }
            longestSuffix = longestSuffix.length() > suffix.length() ? longestSuffix : suffix;

            patterns[i] = s.substring(firstPos + 1, lastPos);
        }

        StringBuilder result = new StringBuilder(longestPrefix);
        for(String s : patterns) {
            String[] parts = s.split("\\*");
            Arrays.stream(parts).forEach(result::append);
        }
        result.append(longestSuffix);
        return result.toString();
    }


}