import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int u = Integer.parseInt(in.nextLine());
            List<E> entries = new ArrayList<>();
            for (int j = 0; j < 10000; j++) {
                String[] qr = in.nextLine().split(" ");
                long q = Long.parseLong(qr[0]);
                String r = qr[1];
                entries.add(new E(q, u, r));
            }

            System.out.println("Case #" + i + ": " + derandomize(entries));
        }
    }

    private static String derandomize(List<E> entries) {
        Map<Long, List<String>> m = new HashMap<>();
        for (final E e : entries) {
            m.compute(e.getQ(), (x, l) -> {
                if (l == null) {
                    l = new ArrayList<>();
                }

                l.add(e.getR());
                return l;
            });
        }

        Set<Character> chars = getAllChars(entries);
        if (chars.size() != 10) {
            throw new IllegalArgumentException("Wrong char number " + chars.size());
        }

        Map<Character, Set<Integer>> eliminated = new HashMap<>();
        StringBuilder answer = new StringBuilder();
        eliminate(eliminated, entries);

        for (Character c : chars) {
            if (!eliminated.containsKey(c)) {
                answer.append(c);
            }
        }

        for (int i = 1; i <= 9; i++) {
            Character a = unambiguous(eliminated, i);
            answer.append(a);
        }

        return answer.toString();
    }

    private static void eliminate(Map<Character, Set<Integer>> eliminated, List<E> entries) {
        for (E e : entries) {
            if (e.isUseful()) {
                char leading = e.getR().charAt(0);
                int leadingInt = e.getLeading();

                eliminate(eliminated, leading, 0);
                for (int d = leadingInt + 1; d <= 9; d++) {
                    eliminate(eliminated, leading, d);
                }
            }
        }
    }

    private static char unambiguous(Map<Character, Set<Integer>> eliminated, int digit) {
        Character uno = null;
        for (Character c : eliminated.keySet()) {
            List<Integer> not = notEliminated(eliminated.get(c));
            if (not.size() == 1 && not.get(0) == digit) {
                if (uno == null) {
                    uno = c;
                } else {
                    throw new RuntimeException("Could not disambiguate");
                }
            }
        }

        if (uno != null) {
            eliminated.forEach((c, s) -> s.add(digit));
            return uno;
        }

        throw new RuntimeException("Could not disambiguate");
    }

    private static List<Integer> notEliminated(Set<Integer> eliminated) {
        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            if (!eliminated.contains(i)) {
                lst.add(i);
            }
        }

        return lst;
    }

    private static void eliminate(Map<Character, Set<Integer>> eliminated, char leading, final int i) {
        eliminated.compute(leading, (c, s) -> {
            if (s == null) {
                s = new HashSet<>();
            }

            s.add(i);
            return s;
        });
    }

    private static Set<Character> getAllChars(List<E> entries) {
        Set<Character> chars = new HashSet<>();
        for (E e : entries) {
            for (Character c : e.getR().toCharArray()) {
                chars.add(c);
            }
        }

        return chars;
    }

    public static class E {
        private final long q;
        private final String r;
        private final boolean useful;
        private final int leading;

        public E(long q, int u, String r) {
            this.q = q;
            this.r = r;
            this.useful = r.length() == u || q >= 0 && Long.toString(q).length() == r.length();
            this.leading = Long.toString(q).charAt(0) - '0';
        }

        public int getLeading() {
            return leading;
        }

        public long getQ() {
            return q;
        }

        public String getR() {
            return r;
        }

        public boolean isUseful() {
            return useful;
        }
    }
}