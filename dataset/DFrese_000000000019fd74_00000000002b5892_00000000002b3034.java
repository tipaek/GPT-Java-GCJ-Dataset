import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int numberOfTestcases = Integer.parseInt(in.nextLine());

        for(int i = 1; i <= numberOfTestcases; i++) {
            findSolution(i, in);
        }
    }

    private static void findSolution(int index, Scanner in) {
        int numberOfPattern = Integer.parseInt(in.nextLine());

        List<String> patterns = new ArrayList<>();

        for(int i = 0; i < numberOfPattern; i++) {
            patterns.add(in.nextLine());
        }

        Collections.sort(patterns, new LengthComparator());

        String longestPattern = patterns.get(0).replaceAll("[*]+", "");

        boolean longestPatternMatchesAll = true;
        for(String pattern : patterns) {
            String convertedPattern = pattern.replaceAll("[*]",".*");

            if(longestPattern.matches(convertedPattern) == false) {
                longestPatternMatchesAll = false;
                break;
            }
        }

        System.out.println(String.format("Case #%s: %s", index, longestPatternMatchesAll ? longestPattern : "*"));
    }
}

class LengthComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return s2.length() - s1.length();
    }
}
