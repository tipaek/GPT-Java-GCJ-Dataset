import java.util.*;

public class Solution {

    private static String solve(int U, long[] Q, String[] R) {
        Map<Character, Set<Integer>> map = new HashMap<>();

        int len = Q.length;

        for (int i = 0; i < len; i += 1) {
            long query = Q[i];
            char[] response = R[i].toCharArray();
            int rlen = response.length;

            for (char c : response) {
                if (!map.containsKey(c)) {
                    map.put(c, new HashSet<>());
                    for (int d = 0; d < 10; d += 1) map.get(c).add(d);
                }
            }

            // first character cannot be zero, unless it's a single-digit response
            if (rlen > 1) map.get(response[0]).remove(0);

            // first character cannot be greater than first query digit
            // unless query == -1 (unknown query)
            if (query > -1) {
                String queryString = String.valueOf(query);
                int firstDigit = queryString.charAt(0) - '0';

                if (queryString.length() == response.length) {
//                    if (i < 100) {
//                        System.out.printf("query: %s, firstDigit: %d, response: %s\n", query, firstDigit, new String(response));
//                    }

                    for (int d = firstDigit + 1; d < 10; d += 1) map.get(response[0]).remove(d);
                }
            }

            // if it is a single-digit query, digit cannot be greater than query
            // unless query == -1 (unknown query)
            if (query > -1 && query < 10) {
                for (int d = (int)query + 1; d < 10; d += 1) map.get(response[0]).remove(d);
            }
        }

        char[] result = new char[10];

        Set<Integer> found = new HashSet<>();

//        for (Map.Entry<Character, Set<Integer>> e : map.entrySet()) {
//            System.out.printf("%s => %s\n", e.getKey(), e.getValue());
//        }

        while (found.size() < 10) {
            char foundC = ' ';
            int foundD = -1;
            for (Map.Entry<Character, Set<Integer>> e : map.entrySet()) {
                Set<Integer> digits = e.getValue();
                if (digits.size() == 1) {
                    foundC = e.getKey();
                    foundD = (int)digits.toArray()[0];

                    if (found.contains(foundD)) continue;

                    result[foundD] = foundC;
                    found.add(foundD);
                    break;
                }
            }

            if (foundD != -1) {
                for (Map.Entry<Character, Set<Integer>> e : map.entrySet()) {
                    if (e.getKey() == foundC) continue;
                    e.getValue().remove(foundD);
                }
            }

            foundD = -1;
            foundC = ' ';

            for (int d = 0; d < 10; d += 1) {
                if (found.contains(d)) continue;
                int countCandidates = 0;
                char candidate = '.';
                for (Map.Entry<Character, Set<Integer>> e : map.entrySet()) {
                    if (e.getValue().contains(d)) {
                        countCandidates += 1;
                        candidate = e.getKey();
                    }
                }

                if (countCandidates == 1) {
                    foundC = candidate;
                    foundD = d;
                    result[d] = candidate;
                    found.add(d);
                    break;
                }
            }

            if (foundD != -1) {
                for (Map.Entry<Character, Set<Integer>> e : map.entrySet()) {
                    if (e.getKey() == foundC) continue;
                    e.getValue().remove(foundD);
                }
            }

//            for (Map.Entry<Character, Set<Integer>> e : map.entrySet()) {
//                System.out.printf("%s => %s\n", e.getKey(), e.getValue());
//            }
        }


        return new String(result);
    }

    private static final int K = 10000;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int T = s.nextInt();

        for (int t = 1; t <= T; t += 1) {
            int U = s.nextInt();
            long[] Q = new long[K];
            String[] R = new String[K];

            for (int i = 0; i < K; i += 1) {
                Q[i] = s.nextLong();
                R[i] = s.nextLine().trim();
            }

            String result = solve(U, Q, R);

            System.out.printf("Case #%d: %s\n", t, result);
        }
    }
}
