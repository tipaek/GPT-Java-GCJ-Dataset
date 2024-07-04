import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int x = 1; x <= t; ++x) {
            List<String> patterns = new ArrayList<>();
            int noOfPatterns = in.nextInt();
            for (int i = 0; i < noOfPatterns; i++) {
                String next = in.next();
                next = next.replaceAll("\\*+", "*");
                patterns.add(next);
            }
            System.out.println("Case #" + x + ": " + getPossibleName(patterns));
        }
    }

    private static String getPossibleName(List<String> patterns) {
        String shortest = patterns.stream().min(Comparator.comparingInt(String::length)).orElse("");
        patterns.remove(shortest);

        List<Integer> astSS = getAstPosition(shortest);
        String output = "";

        for (String pat : patterns) {
            List<Integer> astPat = getAstPosition(pat);
            String tmp = "";
            for (int j = 0; j < astSS.size(); j++) {
                int init = 0;
                int next = shortest.length();

                String before = shortest.substring(init, astSS.get(j));
                String after = shortest.substring(astSS.get(j) + 1, next);

                if ((pat.contains(before) && !before.isEmpty()) || (pat.contains(after) && !after.isEmpty())) {
                    tmp = before + pat.substring(pat.contains(before) ? pat.indexOf(before) + before.length() : 0, pat.contains(after) ? pat.indexOf(after) : pat.length()) + after;
                } else {
                    return "*";
                }
            }

            if (tmp.length() > output.length()) {
                output = tmp;
            }
        }

        if (!output.isEmpty() && output.contains("*")) {
            output = output.replaceAll("\\*", "");
        }

        return output;
    }

    private static List<Integer> getAstPosition(String val) {
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < val.length(); i++) {
            if (val.charAt(i) == '*') {
                positions.add(i);
            }
        }
        return positions;
    }
}