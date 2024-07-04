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
        Set<Character> deciphered = new HashSet<>();
        Set<Character> seenCharacters = new HashSet<>();

        for (int i = 0; i < M; i++) {
            int q = sc.nextInt();
            if (q == -1) continue;
            String response = sc.next();
            if (response.length() == 2) {
                seenCharacters.add(response.charAt(0));
                seenCharacters.add(response.charAt(1));
            } else if (response.length() == 1 && q <= 10) {
                queryMap.computeIfAbsent(q, k -> new ArrayList<>()).add(response.charAt(0));
            }
        }

        char[] resultArray = new char[11];
        for (int i = 1; i < 11; i++) {
            List<Character> characters = queryMap.get(i);
            if (characters != null) {
                for (char character : characters) {
                    if (deciphered.add(character)) {
                        resultArray[i] = character;
                        break;
                    }
                }
            }
        }

        for (char character : seenCharacters) {
            if (!deciphered.contains(character)) {
                resultArray[0] = character;
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