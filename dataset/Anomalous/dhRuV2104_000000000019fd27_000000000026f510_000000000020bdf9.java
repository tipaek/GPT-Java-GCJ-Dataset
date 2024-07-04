import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Time {
    int time;
    String worker;
    boolean start;
    int index;

    public Time(int time, boolean start) {
        this.time = time;
        this.start = start;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int i = 1; i <= t; ++i) {
            int n = scanner.nextInt();
            List<Time> times = new ArrayList<>();
            Map<Time, Time> intervals = new HashMap<>();
            
            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                Time startTime = new Time(start, true);
                startTime.index = j;
                int end = scanner.nextInt();
                Time endTime = new Time(end, false);
                
                times.add(startTime);
                times.add(endTime);
                intervals.put(startTime, endTime);
            }
            
            String result = getRoutine(times, intervals);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String getRoutine(List<Time> times, Map<Time, Time> intervals) {
        times.sort((o1, o2) -> {
            if (o1.time != o2.time) {
                return Integer.compare(o1.time, o2.time);
            }
            if (o1.start != o2.start) {
                return o1.start ? -1 : 1;
            }
            return 0;
        });

        Queue<String> availableWorkers = new LinkedList<>(Arrays.asList("C", "J"));
        char[] result = new char[intervals.size()];

        for (Time time : times) {
            if (time.start) {
                if (availableWorkers.isEmpty()) {
                    return "IMPOSSIBLE";
                }
                String worker = availableWorkers.poll();
                time.worker = worker;
                intervals.get(time).worker = worker;
                result[time.index] = worker.charAt(0);
            } else {
                availableWorkers.offer(time.worker);
            }
        }

        return new String(result);
    }
}