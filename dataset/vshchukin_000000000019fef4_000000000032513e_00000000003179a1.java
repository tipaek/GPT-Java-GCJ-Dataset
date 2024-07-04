import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Comparator;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Overrandomized solver = new Overrandomized();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class Overrandomized {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int u = in.nextInt();
            Map<Character, Long> m = new HashMap<>();
            Set<Character> dist = new HashSet<>();
            for (int i = 0; i < 10000; i++) {
                int qs = in.nextInt();
                String rs = in.next();
                char c = rs.charAt(0);
                if (u < 16) {
                    m.putIfAbsent(c, 0L);
                    m.put(c, m.get(c) + 1L);
                    for (int j = 0; j < rs.length(); j++) {
                        dist.add(rs.charAt(j));
                    }
                }
            }
            List<Overrandomized.Item> lst = new ArrayList<>();
            for (Map.Entry<Character, Long> entry : m.entrySet())
                if (u < 16) {
                    lst.add(new Overrandomized.Item(entry.getKey(), entry.getValue()));
                }
            lst.sort(Comparator.comparingLong(o -> -o.cnt));
            //System.out.println("lst = " + lst);
            //System.out.println("dist = " + dist);
            if (u < 16) {
                lst.forEach(elem -> dist.remove(elem.c));
            }
            StringBuilder f = new StringBuilder(u < 16 ? dist.iterator().next().toString() : "A");
            lst.forEach(elem -> f.append(elem.c));
            out.println("Case #" + testNumber + ": " + f.toString());

        }

        static class Item {
            char c;
            long cnt;

            public Item(char c, long cnt) {
                this.c = c;
                this.cnt = cnt;
            }

            public String toString() {
                return "Item{" +
                        "c=" + c +
                        ", cnt=" + cnt +
                        '}';
            }

        }

    }
}

