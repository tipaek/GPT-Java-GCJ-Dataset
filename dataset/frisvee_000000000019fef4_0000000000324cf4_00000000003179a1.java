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

        List<Set<Character>> letters = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            letters.add(new HashSet<>());
        }

        int[] maxl = new int[26];
        int[] minl = new int[26];
        for (int i = 0; i < 26; i++) {
            minl[0] = 0;
            maxl[i] = 9;
        }

        for (int i = 0; i < COUNT; i++) {
            long q = in.nextLong();
            String s = in.nextLine().trim();

            if (s.length() == 1) {
                minl[s.charAt(0) - 'A'] = 1;
                letters.get(0).remove(s.charAt(0));
            }

            long qq = q;
            for (int j = s.length() - 1; j >= 0; j--) {
                int dd = (int) (qq % 10);
                qq = qq / 10;

                char c = s.charAt(j);
                if (qq == 0) {
                    maxl[c - 'A'] = Math.min(dd, maxl[c - 'A']);
                    for (int k = 1; k <= 9; k++) {
                        if (k <= maxl[c - 'A']) {
                            letters.get(k).add(c);
                        } else {
                            letters.get(k).remove(c);
                        }
                    }
                } else {
                    for (int k = minl[c - 'A']; k <= maxl[c - 'A']; k++) {
                        letters.get(k).add(c);
                    }
                }
            }
        }

        for (int i = 1; i < 10; i++) {
            Set<Character> set = new HashSet<>(letters.get(i));
            for (int j = i + 1; j < 10; j++) {
                set.removeAll(letters.get(j));
                set.removeAll(letters.get(0));
            }
            letters.set(i, set);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(letters.get(i).iterator().next());
        }
        return sb.toString();
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