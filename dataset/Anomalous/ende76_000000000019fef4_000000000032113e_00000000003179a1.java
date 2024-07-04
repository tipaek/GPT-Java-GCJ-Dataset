import java.util.*;

public class Solution {

    private static String solve(int U, long[] Q, String[] R) {
        Map<Character, Set<Integer>> charToPossibleDigits = new HashMap<>();
        int len = Q.length;

        for (int i = 0; i < len; i++) {
            long query = Q[i];
            char[] response = R[i].toCharArray();
            int responseLength = response.length;

            for (char c : response) {
                charToPossibleDigits.putIfAbsent(c, new HashSet<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
            }

            if (responseLength > 1) {
                charToPossibleDigits.get(response[0]).remove(0);
            }

            if (query > -1) {
                String queryString = String.valueOf(query);
                int firstDigit = queryString.charAt(0) - '0';

                if (queryString.length() == response.length) {
                    for (int d = firstDigit + 1; d < 10; d++) {
                        charToPossibleDigits.get(response[0]).remove(d);
                    }
                }
            }

            if (query > -1 && query < 10) {
                for (int d = (int) query + 1; d < 10; d++) {
                    charToPossibleDigits.get(response[0]).remove(d);
                }
            }
        }

        char[] result = new char[10];
        Set<Integer> foundDigits = new HashSet<>();

        while (foundDigits.size() < 10) {
            char foundChar = ' ';
            int foundDigit = -1;

            for (Map.Entry<Character, Set<Integer>> entry : charToPossibleDigits.entrySet()) {
                Set<Integer> possibleDigits = entry.getValue();
                if (possibleDigits.size() == 1) {
                    foundChar = entry.getKey();
                    foundDigit = possibleDigits.iterator().next();

                    if (foundDigits.contains(foundDigit)) continue;

                    result[foundDigit] = foundChar;
                    foundDigits.add(foundDigit);
                    break;
                }
            }

            if (foundDigit != -1) {
                for (Map.Entry<Character, Set<Integer>> entry : charToPossibleDigits.entrySet()) {
                    if (entry.getKey() != foundChar) {
                        entry.getValue().remove(foundDigit);
                    }
                }
            }

            foundDigit = -1;
            foundChar = ' ';

            for (int d = 0; d < 10; d++) {
                if (foundDigits.contains(d)) continue;

                int candidateCount = 0;
                char candidateChar = '.';
                for (Map.Entry<Character, Set<Integer>> entry : charToPossibleDigits.entrySet()) {
                    if (entry.getValue().contains(d)) {
                        candidateCount++;
                        candidateChar = entry.getKey();
                    }
                }

                if (candidateCount == 1) {
                    foundChar = candidateChar;
                    foundDigit = d;
                    result[d] = candidateChar;
                    foundDigits.add(d);
                    break;
                }
            }

            if (foundDigit != -1) {
                for (Map.Entry<Character, Set<Integer>> entry : charToPossibleDigits.entrySet()) {
                    if (entry.getKey() != foundChar) {
                        entry.getValue().remove(foundDigit);
                    }
                }
            }
        }

        return new String(result);
    }

    private static final int K = 10000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            int U = scanner.nextInt();
            long[] Q = new long[K];
            String[] R = new String[K];

            for (int i = 0; i < K; i++) {
                Q[i] = scanner.nextLong();
                R[i] = scanner.nextLine().trim();
            }

            String result = solve(U, Q, R);
            System.out.printf("Case #%d: %s\n", t, result);
        }
    }
}