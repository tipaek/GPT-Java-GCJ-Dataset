import java.util.*;

public class Solution {
    static final int N = 10000;

    static boolean isTenThousand(String str) {
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

    static String solve(Scanner sc) {
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

        for (String r : R) {
            char[] shows = r.toCharArray();
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
            if (M[i] == -1) {
                continue;
            }
            String Ms = Long.toString(M[i]);
            if (Ms.length() == R[i].length()) {
                char headc = R[i].charAt(0);
                int maxi = Ms.charAt(0) - '0';
                max.put(headc, Math.min(maxi, max.get(headc)));
                if (isTenThousand(Ms)) {
                    min.put(headc, 1);
                    max.put(headc, 1);
                    char nextc = R[i].charAt(1);
                    min.put(nextc, 0);
                    max.put(nextc, 0);
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        outerLoop:
        for (int d = 0; d < 10; d++) {
            for (char ch : appear) {
                if (max.get(ch) == d) {
                    ans.append(ch);
                    continue outerLoop;
                }
            }
            for (char ch : appear) {
                if (min.get(ch) <= d && d <= max.get(ch) && ans.indexOf(String.valueOf(ch)) < 0) {
                    ans.append(ch);
                    continue outerLoop;
                }
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            String ans = solve(sc);
            System.out.println("Case #" + t + ": " + ans);
        }
    }
}