import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int k= 1; k <= t; ++k) {
            int n = in.nextInt();
            int i = 0;
            PriorityQueue<Triplet> queue = new PriorityQueue<>();
            for (; i < n; i++) {
                int m  = in.nextInt();
                queue.add(new Triplet(i, m, 0));
                int m2  = in.nextInt();
                queue.add(new Triplet(i, m2, 1));
            }

            Map<Integer, Character> map = new HashMap<>();
            boolean mis = false;
            char[] b = new char[n];
            Deque<Character> q = new LinkedList<>();
            while (!queue.isEmpty()) {
                Triplet triplet = queue.poll();
                if (triplet.s == 1) {
                    char person = map.get(triplet.id);
                    map.remove(triplet.id);
                    if (q.peekFirst() == person) {
                        q.pollFirst();
                    } else {
                        q.pollLast();
                    }
                } else if (map.size() > 1) {
                    mis = true;
                    break;
                } else if (map.size() == 0) {
                    map.put(triplet.id, 'C');
                    b[triplet.id] = 'C';
                    q.addLast('C');
                } else if (q.peekLast() == 'C') {
                    map.put(triplet.id, 'J');
                    b[triplet.id] = 'J';
                    q.addLast('J');
                } else {
                    map.put(triplet.id, 'C');
                    b[triplet.id] = 'C';
                    q.addLast('C');
                }
            }

            if (mis) {
                System.out.println("Case #" + k + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + k + ": ");
                for (char c : b) {
                    System.out.print(c);
                }
                System.out.println();
            }
        }
    }

    private static class Triplet implements Comparable<Triplet> {
        int id;
        int m;
        int s;

        Triplet(int a, int b, int c) {
            id = a;
            m = b;
            s = c;
        }

        @Override
        public int compareTo(Triplet o) {
            int first = Integer.compare(m, o.m);
            if (first != 0) {
                return first;
            }
            return -Integer.compare(s, o.s);
        }
    }
}
