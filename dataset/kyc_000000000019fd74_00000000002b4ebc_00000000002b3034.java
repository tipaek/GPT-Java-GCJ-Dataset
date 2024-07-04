import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = input.nextInt();

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int N = input.nextInt();
            String[] patterns = new String[N];
            for (int i = 0; i < N; i++)
                patterns[i] = input.next();

            boolean done = false;
            for (String pattern : patterns) {
                if (!pattern.contains("*")) {
                    boolean good = true;
                    for (String p : patterns)
                        if (!pattern.matches(p.replace("*", ".*")))
                            good = false;
                    if (!good) {
                        done = true;
                        System.out.printf("Case #%d: %s\n", caseNum, "*");
                        break;
                    } else {
                        done = true;
                        System.out.printf("Case #%d: %s\n", caseNum, pattern);
                        break;
                    }
                }
            }
            if (done)
                continue;

            StringBuilder prefix = new StringBuilder();
            {
                Set<String> set = new HashSet<>(Arrays.asList(patterns));
                boolean good = true;
                for (int i = 0; true; i++) {
                    char c = 0;
                    for (String pattern : new ArrayList<>(set))
                        if (i < pattern.length()) {
                            char d = pattern.charAt(i);
                            if (d != '*') {
                                if (c != 0 && c != d)
                                    good = false;
                                c = d;
                            } else
                                set.remove(pattern);
                        }
                    prefix.append(c);
                    if (c != 0)
                        prefix.append(c);
                    if (set.isEmpty())
                        break;
                }
                if (!good) {
                    System.out.printf("Case #%d: %s\n", caseNum, "*");
                    continue;
                }
            }

            StringBuilder suffix = new StringBuilder();
            {
                Set<String> set = new HashSet<>(Arrays.asList(patterns));
                boolean good = true;
                for (int i = 0; true; i++) {
                    char c = 0;
                    for (String pattern : new ArrayList<>(set))
                        if (i < pattern.length()) {
                            char d = pattern.charAt(pattern.length() - 1 - i);
                            if (d != '*') {
                                if (c != 0 && c != d)
                                    good = false;
                                c = d;
                            } else
                                set.remove(pattern);
                        }
                    if (c != 0)
                        suffix.append(c);
                    if (set.isEmpty())
                        break;
                }
                suffix.reverse();
                if (!good) {
                    System.out.printf("Case #%d: %s\n", caseNum, "*");
                    continue;
                }
            }

            StringBuilder full = new StringBuilder(prefix);
            for (String pattern : patterns) {
                int start = 0;
                while (pattern.charAt(start) != '*')
                    start++;
                int end = pattern.length() - 1;
                while (pattern.charAt(end) != '*')
                    end--;
                start++;
                if (start < end) {
                    String[] parts = pattern.substring(start, end).split("\\*");
                    for (String part : parts)
                        full.append(part);
                }
            }

            full.append(suffix);

            System.out.printf("Case #%d: %s\n", caseNum, full);
        }
    }
}
