import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static class Pair implements Comparable<Pair> {
        int start;
        int end;
        char assignee;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Pair o) {
            int res = this.start - o.start;

            if (res == 0) {
                return this.end - o.end;
            }

            return res;
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int cases = scanner.nextInt();

        for (int c = 1; c <= cases; c++) {

            int times = scanner.nextInt();
            List<Pair> pairs = new ArrayList<>();
            for (int i = 0; i < times; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                Pair pair = new Pair(start, end);

                pairs.add(pair);
            }

            String result = process(pairs);

            System.out.println("Case #" + c + ": " + result);
        }

    }

    private static String process(List<Pair> times) {

        Pair c = null;
        Pair j = null;
        StringBuilder result = new StringBuilder();

        List<Pair> sorted = new ArrayList<>(times);
        sorted.sort(Comparator.naturalOrder());

        for (Pair pair : sorted) {
            if (c == null || c.end <= pair.start) {
                pair.assignee = 'C';
                c = pair;
            } else if (j == null || j.end <= pair.start) {
                pair.assignee = 'J';
                j = pair;
            } else {
                return "IMPOSSIBLE";
            }
        }

        for (Pair pair : times) {
            result.append(pair.assignee);
        }

        return result.toString();
    }
}