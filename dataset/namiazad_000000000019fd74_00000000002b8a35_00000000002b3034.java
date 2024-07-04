import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static String findCaseOne(List<String> patterns) {
        if (patterns.size() == 1) {
            return patterns.get(0).replace('*', 'A');
        }

        patterns.sort((o1, o2) -> Integer.compare(o2.length(), o1.length()));

        final String longest = patterns.get(0).replace("*", "");
        for (int i = 1; i < patterns.size(); i++) {
            if (!longest.endsWith(patterns.get(i).replace("*", ""))) {
                return "*";
            }
        }

        return longest;
    }

    private static String find(List<String> patterns) {
        if (patterns.stream().allMatch(s -> s.charAt(0) == '*' && !s.substring(1).contains("*"))) {
            return findCaseOne(patterns);
        }

        return "*";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine().trim());
        for (int testCase = 1; testCase <= t; ++testCase) {
            int n = Integer.parseInt(in.nextLine().trim());
            List<String> patterns = new ArrayList<>();
            for (int p = 0; p < n; p++) {
               patterns.add(in.nextLine().trim());
            }
            System.out.println(String.format("Case #%d: %s", testCase, find(patterns)));
        }
    }
}
