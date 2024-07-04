import java.util.*;

public class Solution {
    private static final int N = 10000;

    private static boolean isTenThousand(String str) {
        if (str.length() <= 1 || str.charAt(0) != '1') {
            return false;
        }
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }

    private static String solve(Scanner sc) {
        int U = sc.nextInt();
        long[] M = new long[N];
        String[] R = new String[N];
        Map<Character, Integer> max = new HashMap<>();
        Map<Character, Integer> min = new HashMap<>();

        for (int i = 0; i < N; i++) {
            M[i] = sc.nextLong();
            R[i] = sc.next();
        }

        Set<Character> appear = new TreeSet<>();
        Set<Character> head = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            char[] shows = R[i].toCharArray();
            head.add(shows[0]);
            for (char c : shows) {
                appear.add(c);
            }
        }

        for (char ch : appear) {
            if (!head.contains(ch)) {
                max.put(ch, 0);
                min.put(ch, 0);
            } else {
                min.put(ch, 1);
                max.put(ch, 9);
            }
        }

        for (int i = 0; i < N; i++) {
            if (M[i] == -1) continue;

            String Ms = Long.toString(M[i]);
            if (Ms.length() == R[i].length()) {
                char headChar = R[i].charAt(0);
                int maxDigit = Ms.charAt(0) - '0';
                max.put(headChar, Math.min(maxDigit, max.get(headChar)));

                if (isTenThousand(Ms)) {
                    min.put(headChar, 1);
                    max.put(headChar, 1);
                    char nextChar = R[i].charAt(1);
                    min.put(nextChar, 0);
                    max.put(nextChar, 0);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        outerLoop: for (int d = 0; d < 10; d++) {
            for (char ch : appear) {
                if (max.get(ch) == d && result.indexOf(Character.toString(ch)) < 0) {
                    result.append(ch);
                    continue outerLoop;
                }
            }
            for (char ch : appear) {
                if (min.get(ch) <= d && d <= max.get(ch) && result.indexOf(Character.toString(ch)) < 0) {
                    result.append(ch);
                    continue outerLoop;
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            String answer = solve(sc);
            System.out.println("Case #" + t + ": " + answer);
        }
    }
}