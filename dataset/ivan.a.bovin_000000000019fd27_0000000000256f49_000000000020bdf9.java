import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.Comparator.*;

public class Solution {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        // test cases
        final int T = input.nextInt();
        for (int x = 0; x < T; ++x) {
            // number of activities
            final int N = input.nextInt();
            final List<Interval> I = new ArrayList<>(N);
            for (int i = 0; i < N; ++i) {
                final int S = input.nextInt();
                final int E = input.nextInt();
                I.add(new Interval(i, S, E));
            }
            I.sort(comparingInt(i -> i.S));
            boolean impossible = false;
            List<Interval> C = new ArrayList<>();
            List<Interval> J = new ArrayList<>();
            for (Interval i : I) {
                if (C.isEmpty()) {
                    C.add(i);
                    i.person = "C";
                } else if (J.isEmpty()) {
                    J.add(i);
                    i.person = "J";
                } else {
                    Interval c = C.get(C.size() - 1);
                    Interval j = J.get(J.size() - 1);
                    if (c.E <= i.S) {
                        C.add(i);
                        i.person = "C";
                    } else if (j.E <= i.S) {
                        J.add(i);
                        i.person = "J";
                    } else {
                        impossible = true;
                        break;
                    }
                }
            }
            if (impossible) {
                System.out.format("Case #%d: IMPOSSIBLE\n", x + 1);
            } else {
                I.sort(comparingInt(i -> i.index));
                String y = I.stream().map(i -> i.person)
                        .collect(Collectors.joining(""));
                System.out.format("Case #%d: %s\n", x + 1, y);
            }
        }
    }

    private static class Interval {
        int index;
        int S;
        int E;
        String person;

        public Interval(int index, int s, int e) {
            this.index = index;
            S = s;
            E = e;
        }
    }
}
