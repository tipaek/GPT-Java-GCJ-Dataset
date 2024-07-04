import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    static class Case {
        long basis;

        int diners = 1;
        int cuts = 0;

        public Case(long basis) {
            this.basis = basis;
        }

        void add(long i) {
            if (i == basis) {
                diners++;
            } else if (i % basis % i == 0) {
                diners += i / basis;
                cuts += i / basis - 1;
            }
        }

        @Override
        public String toString() {
            return "Case{" +
                    "basis=" + basis +
                    ", diners=" + diners +
                    ", cuts=" + cuts +
                    '}';
        }
    }

    public static void main(String[] args) {
        int t = scanner.nextInt();

        outer:
        for (int tt = 0; tt < t; tt++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();

            int max = d - 1;

            long[] a = new long[n];

            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextLong();
            }

            Arrays.sort(a);

            List<Case> cases = new LinkedList<>();

            for (long i : a) {
                for (Case c : cases) {
                    c.add(i);
                    if (c.cuts + d - c.diners < max) {
                        max = c.cuts + d - (c.diners <= d ? c.diners : d);
                    }
                }

                cases.add(new Case(i));
            }

            //System.out.println(cases);

            System.out.printf("Case #%d: %d\n", tt + 1, max);
        }
    }
}
