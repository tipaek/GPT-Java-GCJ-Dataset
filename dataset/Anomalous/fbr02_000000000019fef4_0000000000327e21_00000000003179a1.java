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
        Map<Integer, List<Character>> questionMap = new HashMap<>();
        Set<Character> discoveredChars = new HashSet<>();
        Set<Character> seenChars = new HashSet<>();

        for (int i = 0; i < M; i++) {
            int q = sc.nextInt();
            String r = sc.next();
            if (r.length() == 2) {
                seenChars.add(r.charAt(0));
                seenChars.add(r.charAt(1));
            } else if (r.length() == 1 && q <= 10) {
                questionMap.computeIfAbsent(q, k -> new ArrayList<>()).add(r.charAt(0));
            }
        }

        char[] resultArray = new char[11];
        for (int i = 1; i <= 10; i++) {
            List<Character> characters = questionMap.get(i);
            if (characters != null) {
                for (char curr : characters) {
                    if (discoveredChars.add(curr)) {
                        resultArray[i] = curr;
                        break;
                    }
                }
            }
        }

        for (char d : seenChars) {
            if (discoveredChars.add(d)) {
                resultArray[0] = d;
                break;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            result.append(resultArray[i]);
        }

        System.out.println("Case #" + (t + 1) + ": " + result);
    }
}