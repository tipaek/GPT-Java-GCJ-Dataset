import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {

    public static String solve(int u, Map<Long, Collection<String>> qm) {
        char[] slots = new char [10];
        Set<String> found = new TreeSet<>();
        Iterator<Map.Entry<Long,Collection<String>>> itr = qm.entrySet().iterator();
        int digitCount = 0;
        while (itr.hasNext() && digitCount < 10) {
            Map.Entry<Long,Collection<String>> entry = itr.next();
            Long n = entry.getKey();
            Collection<String> s = entry.getValue();
            s.removeAll(found);
            if (s.size() == 1) {
                String first = s.iterator().next();
                if (n < 10L) {
                    slots[n.intValue()] = first.charAt(0);
                    digitCount++;
                } else if (n < 100L) {
                    if (n % 10 == 0 && slots[0] == '\0') {
                        slots[0] = first.charAt(1);
                        digitCount++;
                    }
                    // System.out.printf("%s -> %s%n", n, first);
                } else {
                    String ns = String.valueOf(n);
                    for (int i=0; i<ns.length(); i++) {
                        int d = ns.charAt(i) - '0';
                        if (slots[d] == '\0') {
                            slots[d] = first.charAt(i);
                            digitCount++;
                        }
                    }
                }
                found.add(first);
            }
        }
        return new String(slots);
    }

    private static void print(Map<?,?> qm) {
        qm.forEach((n, s) -> {
           System.out.printf("%s - %s%n", n, s);
        });
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            for (int i=0; i<t; i++) {
                int u = sc.nextInt();
                Map<Long, Collection<String>> qm = new TreeMap<>();
                for (int j=0; j<10000; j++) {
                    long q = sc.nextLong();
                    String r = sc.next();
                    Collection<String> rs = qm.computeIfAbsent(q, k -> new TreeSet<>());
                    rs.add(r);
                }
                String sol = solve(u, qm);
                System.out.printf("Case #%s: %s%n", i+1, sol);
            }
        }
    }

}
