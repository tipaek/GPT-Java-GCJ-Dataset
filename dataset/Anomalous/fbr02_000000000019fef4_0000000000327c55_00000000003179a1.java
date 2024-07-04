package Gcj.s2020e1a;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        new Solution().solve();
    }

    private final Scanner sc = new Scanner(System.in);
    private static final int M = 10000;

    private void solve() {
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            processCase(t);
        }
    }

    private void processCase(int t) {
        int U = sc.nextInt();
        Map<Integer, List<Character>> queries = new HashMap<>();
        Set<Character> discovered = new HashSet<>();
        Set<Character> seen = new HashSet<>();

        for (int i = 0; i < M; i++) {
            int q = sc.nextInt();
            String r = sc.next();
            if (r.length() == 2) {
                seen.add(r.charAt(0));
                seen.add(r.charAt(1));
            } else if (q <= 10) {
                queries.computeIfAbsent(q, k -> new ArrayList<>()).add(r.charAt(0));
            }
        }

        char[] assignment = new char[11];
        for (int i = 1; i < 11; i++) {
            List<Character> chars = queries.getOrDefault(i, Collections.emptyList());
            for (char curr : chars) {
                if (!discovered.contains(curr)) {
                    assignment[i] = curr;
                    discovered.add(curr);
                    break;
                }
            }
        }

        for (char d : seen) {
            if (!discovered.contains(d)) {
                assignment[0] = d;
                break;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            result.append(assignment[i]);
        }

        System.out.println("Case #" + (t + 1) + ": " + result);
    }
}