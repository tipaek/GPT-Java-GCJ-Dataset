import static java.lang.String.format;
import static java.util.Comparator.comparingInt;
import static java.util.stream.IntStream.range;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static Scanner scanner = new Scanner(new BufferedInputStream(System.in, 64 * 1024));
    private static final char defaultChar = '\u0000';

    public static void main(String[] args) {
        new Solution().solveProblem();
    }

    private void solveProblem() {
        int t = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < t; i++) {
            solveCase(i + 1);
        }
    }

    private void solveCase(int item) {
        Input input = getInput();
        System.out.println(format("Case #%d: %s", item, solve(input)));
    }

    private String solve(Input input) {
        List<Pair> pairs = Arrays.asList(input.pairs);
        pairs.sort(comparingInt(o -> o.q));
        Set<Character> dChars = new HashSet<>();

        Set[] possible = new Set[10];
        Set[] impossible = new Set[10];
        char[] d = new char[10];

        for (Pair pair : pairs) {
            for (char ch : pair.r.toCharArray()) {
                dChars.add(ch);
            }
            if (dChars.size() > 9) {
                break;
            }
        }
        range(0, 10).forEach(i -> {
            impossible[i] = new HashSet<Character>();
            possible[i] = new HashSet<>(dChars);
        });

        for (Pair pair : pairs) {
            remove(possible, 0 ,pair.r.charAt(0));
            impossible[0].add(pair.r.charAt(0));
            if (pair.q == -1) {

            } else {
                String number = String.valueOf(pair.q);
                if (number.length() == pair.r.length()) {
                    range(Integer.parseInt(number.substring(0, 1)) + 1, 10).forEach(i -> {
                        remove(possible, i ,pair.r.charAt(0));
                        impossible[0].add(pair.r.charAt(0));
                    });
                }
            }
        }

        range(0, 10).forEach(i -> {
            if (possible[i].size() == 1) {
                d[i] = (Character) (possible[i].stream().findFirst().get());
            }
        });

        return new String(d);
    }

    private void remove(Set[] possible, int i, char charAt) {
        possible[i].remove(charAt);
        if (possible[i].size() ==1) {
            char ch = (Character) (possible[i].stream().findFirst().get());
            range(0,10).forEach(j -> {
                if (j!=i) {
                    possible[j].remove(ch);
                }
            });
        }
    }

    private Input getInput() {
        int u = scanner.nextInt();
        Pair[] pairs = new Pair[10000];
        for (int i = 0; i < 10000; i++) {
            pairs[i] = new Pair(scanner.nextInt(), scanner.nextLine().trim());
        }
        return new Input(u, pairs);
    }

    class Input {
        int u;
        Pair[] pairs;

        public Input(int u, Pair[] pairs) {
            this.u = u;
            this.pairs = pairs;
        }
    }

    class Pair {
        int q;
        String r;

        public Pair(int q, String r) {
            this.q = q;
            this.r = r;
        }
    }

}
