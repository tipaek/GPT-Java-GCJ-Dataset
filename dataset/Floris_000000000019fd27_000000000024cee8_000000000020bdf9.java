import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream in = System.in;
        Scanner sc = new Scanner(in);
//        sc.useDelimiter(Pattern.compile("[\n /]"));

x:        for (int cs = 1, cases = sc.nextInt(); cs <= cases; cs++) {
            int n = sc.nextInt();
            List<X> entries = new ArrayList<>();
            for(int i = 0; i < n; i++) entries.add(new X(sc.nextInt(), sc.nextInt()));
            List<X> sorted = new ArrayList(entries);
            Collections.sort(sorted);
            int endJ = 0;
            int endC = 0;
            for (X x : sorted) {
                if (x.start >= endJ) {
                    x.who = 'J';
                    endJ = x.end;
                } else if (x.start >= endC) {
                    x.who='C';
                    endC=x.end;
                } else {
                    System.out.printf("Case #%d: %s%n", cs, "IMPOSSIBLE");
                    continue x;
                }
            }
            StringBuilder result = new StringBuilder();
            for (X x : entries) result.append(x.who);
            System.out.printf("Case #%d: %s%n", cs, result.toString());
        }
    }

    private static class X implements Comparable<X>{
        int start, end;
        char who='.';

        public X(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(X t) {
            return Integer.compare(start, t.start);
        }
    }
}
