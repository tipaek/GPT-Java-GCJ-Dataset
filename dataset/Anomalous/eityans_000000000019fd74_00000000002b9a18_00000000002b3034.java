import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.next());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(sc.next());
            List<Character> head = new ArrayList<>();
            List<Character> tail = new ArrayList<>();
            boolean enable = true;

            for (int i = 0; i < N; i++) {
                char[] P = sc.next().toCharArray();
                int h = head.size();
                int ta = tail.size();

                for (int s = 0; s < P.length; s++) {
                    char c = P[s];
                    if (c == '*') break;
                    if (h <= s) {
                        head.add(c);
                    } else if (head.get(s) != c) {
                        enable = false;
                    }
                }

                for (int s = P.length - 1; s >= 0; s--) {
                    char c = P[s];
                    if (c == '*') break;
                    if (ta <= P.length - 1 - s) {
                        tail.add(c);
                    } else if (tail.get(P.length - 1 - s) != c) {
                        enable = false;
                    }
                }
            }

            StringBuilder ans = new StringBuilder();
            for (char p : head) ans.append(p);
            for (int i = tail.size() - 1; i >= 0; i--) ans.append(tail.get(i));

            System.out.println("Case #" + (t + 1) + ": " + (enable ? ans.toString() : "*"));
        }

        sc.close();
    }
}