import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Time {
    int time;
    String worker;
    boolean start;

    public Time(int time, boolean start) {
        this.time = time;
        this.start = start;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            List<Time> times = new ArrayList<>();
            Map<Time, Time> intervals = new HashMap<>();

            for (int j = 0; j < n; j++) {
                int start = in.nextInt();
                Time st = new Time(start, true);
                int end = in.nextInt();
                Time e = new Time(end, false);

                times.add(st);
                times.add(e);
                intervals.put(st, e);
            }

            String ans = getRoutine(times, intervals);
            System.out.println("Case #" + i + ": " + ans);
        }
    }

    private static String getRoutine(List<Time> times, Map<Time, Time> intervals) {
        Collections.sort(times, new Comparator<Time>() {
            @Override
            public int compare(Time o1, Time o2) {
                if (o1.time != o2.time) {
                    return Integer.compare(o1.time, o2.time);
                }
                if (o1.start != o2.start) {
                    return o1.start ? -1 : 1;
                }
                return 0;
            }
        });

        Queue<String> availableWorkers = new LinkedList<>(Arrays.asList("C", "J"));
        StringBuilder schedule = new StringBuilder();

        for (Time t : times) {
            if (t.start) {
                if (availableWorkers.isEmpty()) {
                    return "IMPOSSIBLE";
                }
                String worker = availableWorkers.poll();
                t.worker = worker;
                intervals.get(t).worker = worker;
                schedule.append(worker);
            } else {
                availableWorkers.offer(t.worker);
            }
        }

        return schedule.toString();
    }
}