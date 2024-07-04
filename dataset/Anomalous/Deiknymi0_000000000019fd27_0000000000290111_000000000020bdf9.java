import java.io.*;
import java.util.*;

public class Solution {
    static short[] minutes = new short[24 * 60];

    public static class Activity {
        public int start, end;
        public char assignedTo;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
            this.assignedTo = ' ';
            for (int i = start; i < end; i++) {
                minutes[i]++;
            }
        }

        public boolean isOverlapping() {
            for (int i = this.start; i < this.end; i++) {
                if (minutes[i] > 1) {
                    return true;
                }
            }
            return false;
        }

        public void assignTo(char c) {
            this.assignedTo = c;
        }
    }

    public static class ActivityWrapper {
        public Activity orig;

        public ActivityWrapper(Activity orig) {
            this.orig = orig;
        }

        public boolean isOverlapping() {
            return orig.isOverlapping();
        }

        public void assignTo(char c) {
            orig.assignTo(c);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int tests = in.nextInt();

        for (int itest = 1; itest <= tests; itest++) {
            Arrays.fill(minutes, (short) 0);
            List<Activity> activities = new ArrayList<>();
            List<ActivityWrapper> wrappers = new ArrayList<>();

            int numActivities = in.nextInt();
            for (int i = 0; i < numActivities; i++) {
                Activity cur = new Activity(in.nextInt(), in.nextInt());
                activities.add(cur);
                wrappers.add(new ActivityWrapper(cur));
            }

            wrappers.sort(Comparator.comparingInt(o -> o.orig.start));

            boolean impossible = Arrays.stream(minutes).anyMatch(m -> m >= 3);

            if (!impossible) {
                for (Activity cur : activities) {
                    if (!cur.isOverlapping()) {
                        cur.assignTo('C');
                    }
                }

                char lastAssigned = ' ';
                for (int iminute = 0; iminute < 24 * 60; ) {
                    boolean overlapFound = false;
                    for (; iminute < 24 * 60; iminute++) {
                        if (minutes[iminute] == 2) {
                            overlapFound = true;
                            break;
                        }
                    }
                    if (overlapFound) {
                        Activity a1 = null, a2 = null;
                        for (ActivityWrapper cur : wrappers) {
                            if (iminute >= cur.orig.start && iminute < cur.orig.end) {
                                if (a1 == null) {
                                    a1 = cur.orig;
                                } else {
                                    a2 = cur.orig;
                                    break;
                                }
                            }
                        }

                        if (a1.assignedTo == ' ') {
                            a1.assignTo(lastAssigned == 'C' ? 'J' : 'C');
                        }

                        a2.assignTo(a1.assignedTo == 'J' ? 'C' : 'J');
                        lastAssigned = (a1.end >= a2.end) ? a1.assignedTo : a2.assignedTo;

                        int minEnd = Math.min(a1.end, a2.end);
                        iminute = minEnd + 1;
                    }
                }

                for (Activity cur : activities) {
                    if (cur.assignedTo == ' ') {
                        cur.assignTo('J');
                    }
                }

                StringBuilder sb = new StringBuilder();
                for (Activity activity : activities) {
                    sb.append(activity.assignedTo);
                }
                out.println("Case #" + itest + ": " + sb.toString());

            } else {
                out.println("Case #" + itest + ": IMPOSSIBLE");
            }
        }

        out.close();
    }
}