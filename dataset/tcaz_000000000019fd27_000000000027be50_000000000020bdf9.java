import java.util.*;

public class Solution {

    public static void main(String[] args) {
        new Solution().start();
    }

    private class Event {
        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();
    }

    void start() {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        for (int i = 0; i < cases; i++) {
            boolean impossible = false;
            int activities = scan.nextInt();
            char[] acts = new char[activities];
            Event[] events = new Event[1441];
            for (int j = 0; j < activities; j++) {
                int start = scan.nextInt();
                int end = scan.nextInt();
                if (events[start] == null) {
                    events[start] = new Event();
                }
                if (events[end] == null) {
                    events[end] = new Event();
                }
                events[start].start.add(j);
                events[end].end.add(j);
            }
            boolean cIsWorking = false;
            boolean jIsWorking = false;
            int cActivity = -1;
            int jActivity = -1;
            for (int t = 0; t < events.length && !impossible; t++) {
                Event curr = events[t];
                if (curr == null) {
                    continue;
                }
                if (cIsWorking || jIsWorking) {
                    for (Integer k : curr.end) {
                        if (k == cActivity) {
                            cIsWorking = false;
                            cActivity = -1;
                        }
                        if (k == jActivity) {
                            jIsWorking = false;
                            jActivity = -1;
                        }
                    }
                }
                for (Integer k : curr.start) {
                    if (!cIsWorking) {
                        cIsWorking = true;
                        cActivity = k;
                        acts[k] = 'C';
                    } else if (!jIsWorking) {
                        jIsWorking = true;
                        jActivity = k;
                        acts[k] = 'J';
                    } else {
                        impossible = true;
                    }
                }
            }
            System.out.println("Case #" + (i+1) + ": " + (impossible ? "IMPOSSIBLE" : String.valueOf(acts)));
        }
    }

}
