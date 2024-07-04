import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            PriorityQueue<Triplet> events = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                events.add(new Triplet(i, start, 0));
                int end = scanner.nextInt();
                events.add(new Triplet(i, end, 1));
            }

            Map<Integer, Character> assignments = new HashMap<>();
            boolean impossible = false;
            char[] schedule = new char[n];
            Deque<Character> available = new LinkedList<>();

            while (!events.isEmpty()) {
                Triplet event = events.poll();
                if (event.s == 1) {
                    char person = assignments.get(event.id);
                    assignments.remove(event.id);
                    if (available.peekFirst() == person) {
                        available.pollFirst();
                    } else {
                        available.pollLast();
                    }
                } else if (assignments.size() > 1) {
                    impossible = true;
                    break;
                } else if (assignments.isEmpty()) {
                    assignments.put(event.id, 'C');
                    schedule[event.id] = 'C';
                    available.addLast('C');
                } else if (available.peekLast() == 'C') {
                    assignments.put(event.id, 'J');
                    schedule[event.id] = 'J';
                    available.addLast('J');
                } else {
                    assignments.put(event.id, 'C');
                    schedule[event.id] = 'C';
                    available.addLast('C');
                }
            }

            if (impossible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + t + ": ");
                System.out.println(new String(schedule));
            }
        }
    }

    private static class Triplet implements Comparable<Triplet> {
        int id;
        int m;
        int s;

        Triplet(int id, int m, int s) {
            this.id = id;
            this.m = m;
            this.s = s;
        }

        @Override
        public int compareTo(Triplet other) {
            int timeComparison = Integer.compare(this.m, other.m);
            if (timeComparison != 0) {
                return timeComparison;
            }
            return -Integer.compare(this.s, other.s);
        }
    }
}