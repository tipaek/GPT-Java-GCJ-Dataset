import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws Exception {
        // final Scanner input = new Scanner(new File("C:\\pro\\my\\src\\main\\resources\\in2.txt"));
        final Scanner input = new Scanner(System.in);
        final int T = input.nextInt();
        for (long t = 1; t <= T; ++t) {
            final int U = input.nextInt();
            final List<In> in = new ArrayList<>();
            final Set<Character> letters = new HashSet<>();
            for (long i = 1; i <= 10000; ++i) {
                final long number = input.nextLong();
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
        long number;
        int[] digits;
        String response;

        public In(long number, String response) {
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
        Map<Integer, Set<Character>> possibleChars = new HashMap<>(10);
        Map<Character, Set<Integer>> possibleDigits = new HashMap<>(10);
        Map<Character, Set<Integer>> bad = new HashMap<>(10);
        Set<Integer> readyd = new HashSet<>(10);
        Set<Character> readyc = new HashSet<>(10);

        public Dict(int U, Set<Character> letters) {
            this.letters = letters;
            for (int digit = 0; digit < 10; ++digit) {
                possibleChars.computeIfAbsent(digit, z -> new HashSet<>(letters));
            }
            letters.forEach(c -> possibleDigits.computeIfAbsent(c, z -> new HashSet<>()));
            letters.forEach(c -> bad.computeIfAbsent(c, z -> new HashSet<>()));
        }

        public boolean ready() {
            return readyc.size() == 10 ||
                    readyd.size() == 10;
        }

        public String answer() {
            return possibleChars.entrySet().stream().sorted(Map.Entry.comparingByKey())
                    .map(e -> String.valueOf(e.getValue().iterator().next()))
                    .collect(Collectors.joining(""));
        }

        public void not(char c, int d) {
            boolean removedChar = possibleChars.get(d).remove(c);
            boolean removedDigit = possibleDigits.get(c).remove(d);
            boolean added = bad.get(c).add(d);
            if (!removedChar && !removedDigit && !added) {
                return;
            }
            if (possibleDigits.get(c).size() == 1) {
                readyc.add(c);
                Integer dd = possibleDigits.get(c).iterator().next();
                readyd.add(dd);

                for (int ddd = 0; ddd < 10; ++ddd) {
                    if (ddd != dd)
                        not(c, ddd);
                }
                letters.forEach(ccc -> {
                    if (ccc != c)
                        not(ccc, d);
                });
            }
            if (possibleChars.get(d).size() == 1) {
                readyd.add(d);
                Character cc = possibleChars.get(d).iterator().next();
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
