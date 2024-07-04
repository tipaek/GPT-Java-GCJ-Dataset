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
        Map<Integer, List<Character>> qs = new HashMap<>();
        Set<Character> dec = new HashSet<>();
        Set<Character> seen = new HashSet<>();

        for (int i = 0; i < M; i++) {
            int q = sc.nextInt();
            String r = sc.next();
            if (r.length() == 2) {
                seen.add(r.charAt(0));
                seen.add(r.charAt(1));
            } else if (q <= 10) {
                qs.computeIfAbsent(q, k -> new ArrayList<>()).add(r.charAt(0));
            }
        }

        char[] ass = new char[11];
        for (int i = 1; i < 11; i++) {
            List<Character> characters = qs.get(i);
            if (characters != null) {
                for (char curr : characters) {
                    if (!dec.contains(curr)) {
                        ass[i] = curr;
                        dec.add(curr);
                        break;
                    }
                }
            }
        }

        for (char d : seen) {
            if (!dec.contains(d)) {
                ass[0] = d;
                break;
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            res.append(ass[i]);
        }
        System.out.println("Case #" + (t + 1) + ": " + res);
    }
}