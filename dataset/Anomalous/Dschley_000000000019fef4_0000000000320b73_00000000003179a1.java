import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int u = scanner.nextInt();
            List<Pair> queries = new ArrayList<>();

            for (int j = 0; j < 10000; j++) {
                int qi = scanner.nextInt();
                String ri = scanner.next();
                queries.add(new Pair(qi, ri));
            }

            String result = determineDigits(u, queries);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String determineDigits(int u, List<Pair> queries) {
        queries.sort(Comparator.comparingInt(pair -> pair.q));

        Set<Character> discoveredCharacters = new HashSet<>();
        char[] digits = new char[10];
        int digitIndex = 1;

        for (Pair query : queries) {
            for (char ch : query.r.toCharArray()) {
                if (!discoveredCharacters.contains(ch)) {
                    if (digitIndex == digits.length) {
                        digitIndex = 0;
                    }
                    discoveredCharacters.add(ch);
                    digits[digitIndex++] = ch;
                }
            }
        }

        return new String(digits);
    }

    static class Pair {
        int q;
        String r;

        Pair(int q, String r) {
            this.q = q;
            this.r = r;
        }
    }
}