    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.util.*;
    import java.util.stream.Collectors;

    public class Solution {
        public static void main(String[] args) {
            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int nTest = in.nextInt();

            for (int i = 0; i < nTest; i++) {
                int nActivities = in.nextInt();
                PriorityQueue<Activity> activities = new PriorityQueue<>(
                        (a, b) -> a.start - b.start
                );
                List<Activity> keepInOrder = new ArrayList<>();

                for (int i1 = 0; i1 < nActivities; i1++) {
                    int start = in.nextInt();
                    int end = in.nextInt();
                    Activity act = new Activity(start, end);
                    activities.add(act);
                    keepInOrder.add(act);
                }
                String result = "IMPOSSIBLE";
                if (doIntervalPartitioning(activities)) {
                    result = keepInOrder.stream().map(a -> a.who).collect(Collectors.joining());
                }
                System.out.println("Case #"+ (i+1) + ": " + result);
                System.out.flush();
            }

        }

        private static boolean doIntervalPartitioning(PriorityQueue<Activity> activities) {
            Activity first =  activities.poll();
            first.who = "C";
            int cEnd = first.end;
            int jEnd = 0;

            while (!activities.isEmpty()) {
                Activity act = activities.poll();
                if (act.start >= cEnd) {
                    act.who = "C";
                    cEnd = act.end;
                } else if (act.start >= jEnd) {
                    act.who = "J";
                    jEnd = act.end;
                } else
                    return false;
            }
            return true;
        }

        private static class Activity{
            public final int start;
            public final int end;
            public String who;

            public Activity(int start, int end) {
                this.start = start;
                this.end = end;
            }

        }

    }
