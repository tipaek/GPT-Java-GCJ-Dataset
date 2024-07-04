import java.util.*;

class Period {
    public int s;
    public int e;
    public int i;
}

class Event {
    public int type;
    public int time;
    public int tend;
    public int i;
}

class PeriodComparator implements Comparator<Period> {
    public int compare (Period a, Period b) {
        return Integer.compare(a.e, b.e);
    }
}

class EventComparator implements Comparator<Event> {
    public int compare (Event a, Event b) {
        return Integer.compare(a.time, b.time);
    }
}


class Solution {

    private static void solve(int N, Scanner sc, int x) {
        Period[] P = new Period[N];

        int[] table = new int[1441];

        boolean possible = true;
        PriorityQueue<Event> events = new PriorityQueue<>(2010, new EventComparator());


        for (int i = 0; i < N; i++) {
            P[i] = new Period();
            P[i].s = sc.nextInt();
            P[i].e = sc.nextInt();
            P[i].i = i;

            Event ev1 = new Event();
            ev1.type = 0;
            ev1.time = P[i].s;
            ev1.tend = P[i].e;
            ev1.i = i;

            events.add(ev1);
        }

        for (int i = 0; i < N; i++) {
            table[P[i].s]++;
            table[P[i].e]--;
        }

        for (int i = 1; i < 1441; i++) {
            table[i] += table[i - 1];
        }

        int max = -1;
        for (int i = 0; i < 1441; i++) {
            if (max < table[i]) {
                max = table[i];
            }
        }

        if (max > 2) {
            possible = false;
        }

        if (possible) {
            char[] result = new char[N];
            boolean isbusy = false;
            int end = -1;
            while (!events.isEmpty()) {
                Event ev = events.poll();
                int idx = ev.i;

                if (end <= ev.time) {
                    isbusy = false;
                }

                switch(ev.type) {
                    case 0:
                        if (!isbusy) {
                            result[idx] = 'C';
                            isbusy = true;
                            end = ev.tend;
                        } else {
                            result[idx] = 'J';
                        }
                        break;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (char c :result) {
                sb.append(c);
            }

            System.out.println(String.format("Case #%d: %s", x, sb.toString()));
        } else {
            System.out.println(String.format("Case #%d: IMPOSSIBLE", x));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();


        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            solve(N, sc, i + 1);
        }
    }
}
