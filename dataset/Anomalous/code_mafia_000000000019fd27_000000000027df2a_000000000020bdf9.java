import java.util.*;

class Time {
    int start;
    int end;
    int id;

    public Time(int start, int end, int id) {
        this.start = start;
        this.end = end;
        this.id = id;
    }

    @Override
    public String toString() {
        return start + " " + end;
    }
}

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = sc.nextInt();
            PriorityQueue<Time> pq = new PriorityQueue<>(Comparator.comparingInt(t -> t.start));
            char[] schedule = new char[n];
            boolean possible = true;

            for (int j = 0; j < n; j++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                pq.add(new Time(start, end, j));
            }

            int cEnd = 0, jEnd = 0;

            while (!pq.isEmpty()) {
                Time current = pq.poll();
                if (current.start >= cEnd) {
                    schedule[current.id] = 'C';
                    cEnd = current.end;
                } else if (current.start >= jEnd) {
                    schedule[current.id] = 'J';
                    jEnd = current.end;
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + i + ": " + new String(schedule));
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }

        sc.close();
    }
}