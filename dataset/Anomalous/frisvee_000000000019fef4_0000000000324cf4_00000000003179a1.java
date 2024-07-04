import java.io.*;
import java.util.*;

public class Solution {
    private static final int COUNT = 10_000;

    static class Pair {
        long q;
        String s;
    }

    private static String solve(Scanner in, int U) {
        Pair[] pairs = new Pair[COUNT];
        List<Set<Character>> letterSets = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            letterSets.add(new HashSet<>());
        }

        int[] maxLimits = new int[26];
        int[] minLimits = new int[26];
        Arrays.fill(maxLimits, 9);
        Arrays.fill(minLimits, 0);

        for (int i = 0; i < COUNT; i++) {
            long q = in.nextLong();
            String s = in.nextLine().trim();

            if (s.length() == 1) {
                minLimits[s.charAt(0) - 'A'] = 1;
                letterSets.get(0).remove(s.charAt(0));
            }

            long tempQ = q;
            for (int j = s.length() - 1; j >= 0; j--) {
                int digit = (int) (tempQ % 10);
                tempQ = tempQ / 10;

                char c = s.charAt(j);
                if (tempQ == 0) {
                    maxLimits[c - 'A'] = Math.min(digit, maxLimits[c - 'A']);
                    for (int k = 1; k <= 9; k++) {
                        if (k <= maxLimits[c - 'A']) {
                            letterSets.get(k).add(c);
                        } else {
                            letterSets.get(k).remove(c);
                        }
                    }
                } else {
                    for (int k = minLimits[c - 'A']; k <= maxLimits[c - 'A']; k++) {
                        letterSets.get(k).add(c);
                    }
                }
            }
        }

        for (int i = 1; i < 10; i++) {
            Set<Character> uniqueChars = new HashSet<>(letterSets.get(i));
            for (int j = i + 1; j < 10; j++) {
                uniqueChars.removeAll(letterSets.get(j));
                uniqueChars.removeAll(letterSets.get(0));
            }
            letterSets.set(i, uniqueChars);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            result.append(letterSets.get(i).iterator().next());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        for (int t = 1; t <= T; t++) {
            int U = in.nextInt();
            System.out.println("Case #" + t + ": " + solve(in, U));
        }

        in.close();
    }
}