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
            int[] qs = new int[10000];
            String[] rs = new String[10000];
            Map<Character, Integer> m = new HashMap<>();
            Set<Character> dist = new HashSet<>();
            for (int i = 0; i < 10000; i++) {
                qs[i] = in.nextInt();
                rs[i] = in.next();
                if (rs[i].length() == 1) {
                    char c = rs[i].charAt(0);
                    m.putIfAbsent(c, 0);
                    m.put(c, m.get(c) + 1);
                }
                for (int j = 0; j < rs[i].length(); j++) {
                    dist.add(rs[i].charAt(j));
                }
            }
            List<Overrandomized.Item> lst = new ArrayList<>();
            for (Map.Entry<Character, Integer> characterIntegerEntry : m.entrySet()) {
                lst.add(new Overrandomized.Item(characterIntegerEntry.getKey(), characterIntegerEntry.getValue()));
            }
            lst.sort(Comparator.comparingInt(o -> -o.cnt));
            lst.forEach(dist::remove);
            StringBuilder f = new StringBuilder(dist.iterator().next().toString());
            lst.forEach(elem -> f.append(elem.c));
            out.println("Case #1: " + f.toString());

        }

        static class Item {
            char c;
            int cnt;

            public Item(char c, int cnt) {
                this.c = c;
                this.cnt = cnt;
            }

        }

    }
}

