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
        Map<Integer, List<Character>> queryMap = new HashMap<>();
        Set<Character> determinedCharacters = new HashSet<>();
        Set<Character> seenCharacters = new HashSet<>();

        for (int i = 0; i < M; i++) {
            int q = sc.nextInt();
            String r = sc.next();
            if (q == -1) continue;
            if (r.length() == 2) {
                seenCharacters.add(r.charAt(0));
                seenCharacters.add(r.charAt(1));
            } else if (r.length() == 1 && q <= 10) {
                queryMap.computeIfAbsent(q, k -> new ArrayList<>()).add(r.charAt(0));
            }
        }

        char[] assignment = new char[11];
        for (int i = 1; i <= 10; i++) {
            List<Character> characters = queryMap.getOrDefault(i, Collections.emptyList());
            for (char curr : characters) {
                if (!determinedCharacters.contains(curr)) {
                    assignment[i] = curr;
                    determinedCharacters.add(curr);
                    break;
                }
            }
        }

        for (char d : seenCharacters) {
            if (!determinedCharacters.contains(d)) {
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