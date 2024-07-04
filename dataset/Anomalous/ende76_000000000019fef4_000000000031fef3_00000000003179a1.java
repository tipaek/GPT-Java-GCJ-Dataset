import java.util.*;

public class Solution {

    private static String solve(int U, int[] Q, String[] R) {
        Map<Character, Set<Integer>> charToDigits = new HashMap<>();
        int numQueries = Q.length;

        for (int i = 0; i < numQueries; i++) {
            int query = Q[i];
            char[] response = R[i].toCharArray();
            int responseLength = response.length;

            for (char c : response) {
                charToDigits.putIfAbsent(c, new HashSet<>());
                for (int d = 0; d < 10; d++) charToDigits.get(c).add(d);
            }

            if (responseLength > 1) charToDigits.get(response[0]).remove(0);

            if (query > -1) {
                String queryString = String.valueOf(query);
                int firstDigit = queryString.charAt(0) - '0';

                if (queryString.length() == response.length) {
                    for (int d = firstDigit + 1; d < 10; d++) charToDigits.get(response[0]).remove(d);
                }
            }

            if (query > -1 && query < 10) {
                for (int d = query + 1; d < 10; d++) charToDigits.get(response[0]).remove(d);
            }
        }

        char[] result = new char[10];
        Set<Integer> assignedDigits = new HashSet<>();

        while (assignedDigits.size() < 10) {
            char foundChar = ' ';
            int foundDigit = -1;

            for (Map.Entry<Character, Set<Integer>> entry : charToDigits.entrySet()) {
                Set<Integer> digits = entry.getValue();
                if (digits.size() == 1) {
                    foundChar = entry.getKey();
                    foundDigit = digits.iterator().next();

                    if (assignedDigits.contains(foundDigit)) continue;

                    result[foundDigit] = foundChar;
                    assignedDigits.add(foundDigit);
                    break;
                }
            }

            if (foundDigit != -1) {
                for (Map.Entry<Character, Set<Integer>> entry : charToDigits.entrySet()) {
                    if (entry.getKey() != foundChar) {
                        entry.getValue().remove(foundDigit);
                    }
                }
            }

            foundDigit = -1;
            foundChar = ' ';

            for (int d = 0; d < 10; d++) {
                if (assignedDigits.contains(d)) continue;
                int candidateCount = 0;
                char candidateChar = '.';
                for (Map.Entry<Character, Set<Integer>> entry : charToDigits.entrySet()) {
                    if (entry.getValue().contains(d)) {
                        candidateCount++;
                        candidateChar = entry.getKey();
                    }
                }

                if (candidateCount == 1) {
                    foundChar = candidateChar;
                    foundDigit = d;
                    result[d] = candidateChar;
                    assignedDigits.add(d);
                    break;
                }
            }

            if (foundDigit != -1) {
                for (Map.Entry<Character, Set<Integer>> entry : charToDigits.entrySet()) {
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
            int[] Q = new int[K];
            String[] R = new String[K];

            for (int i = 0; i < K; i++) {
                Q[i] = scanner.nextInt();
                R[i] = scanner.nextLine().trim();
            }

            String result = solve(U, Q, R);
            System.out.printf("Case #%d: %s\n", t, result);
        }
    }
}