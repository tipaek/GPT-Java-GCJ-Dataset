import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws Exception {
        final Scanner input = new Scanner(System.in);
        final int T = input.nextInt();
        for (long t = 1; t <= T; ++t) {
            final int U = input.nextInt();
            final List<In> in = new ArrayList<>();
            final Set<Character> letters = new HashSet<>();
            for (long i = 1; i <= 10000; ++i) {
                final int number = input.nextInt();
                final String response = input.next();
                in.add(new In(number, response));
                for (int n = 0; n < response.length(); ++n) {
                    letters.add(response.charAt(n));
                }
            }
            final Dict dict = new Dict(U, letters);
            in.forEach(i -> {
                dict.not(i.response.charAt(0), 0);
            });
            while (!dict.ready()) {
                in.forEach(i -> {
                    if (i.digits.length == i.response.length()) {
                        char c0 = i.response.charAt(0);
                        int d0 = i.digits[0];
                        for (int d = d0 + 1; d <= 9; ++d) {
                            dict.not(c0, d);
                        }
                    }
                });
            }
            System.out.format("Case #%d: %s\n", t, dict.answer());
        }
    }

    static class In {
        int number;
        int[] digits;
        String response;

        public In(int number, String response) {
            this.number = number;
            this.response = response;
            String s = String.valueOf(this.number);
            digits = new int[s.length()];
            for (int n = 0; n < s.length(); ++n) {
                digits[n] = s.charAt(n) - '0';
            }
        }
    }

    static class Dict {
        Set<Character> letters;
        Map<Integer, Set<Character>> possible = new HashMap<>(10);
        Map<Character, Set<Integer>> bad = new HashMap<>(10);
        Set<Integer> readyd = new HashSet<>(10);
        Set<Character> readyc = new HashSet<>(10);

        public Dict(int U, Set<Character> letters) {
            this.letters = letters;
            for (int digit = 0; digit < 10; ++digit) {
                possible.computeIfAbsent(digit, z -> new HashSet<>(letters));
            }
            letters.forEach(letter -> bad.computeIfAbsent(letter, z -> new HashSet<>()));
        }

        public boolean ready() {
            return readyc.size() == 10 ||
                    readyd.size() == 10;
        }

        public String answer() {
            return possible.entrySet().stream().sorted(Map.Entry.comparingByKey())
                    .map(e -> String.valueOf(e.getValue().iterator().next()))
                    .collect(Collectors.joining(""));
        }

        public void not(char c, int d) {
            boolean removed = possible.get(d).remove(c);
            if (!removed) {
                return;
            }
            boolean added = bad.get(c).add(d);
            if (!added) {
                return;
            }
            if (possible.get(d).size() == 1) {
                readyd.add(d);
                Character cc = possible.get(d).iterator().next();
                readyc.add(cc);
                for (int dd = 0; dd < 10; ++dd) {
                    if (dd != d)
                        not(cc, dd);
                }
                letters.forEach(ccc -> {
                    if (ccc != cc)
                        not(ccc, d);
                });
            }
        }
    }
}
