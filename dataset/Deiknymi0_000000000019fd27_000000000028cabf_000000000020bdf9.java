import java.io.*;
import java.util.*;

import static java.lang.System.in;

public class Solution {
    static short minutes[] = new short[24*60];

    static class Activity {
        public int start, end;
        public char assignedTo;

        public Activity(int start, int end) {
            this.start =  start;
            this.end = end;
            this.assignedTo = ' ';
            for (int i=start; i < end; i++)
                minutes[i]++;
        }

        public boolean isOverlapping() {
            for (int i=this.start; i < this.end; i++) {
                if (minutes[i] > 1)
                    return true;
            }
            return  false;
        }

        public void AssignTo(char c) {
            this.assignedTo = c;
            for (int i=this.start; i < this.end; i++) {
                minutes[i]--;
            }
        }
    }

    static class ActivityWrapper {  // for sorted list
        public Activity orig;

        public ActivityWrapper(Activity orig) {
            this.orig = orig;
        }

        public boolean isOverlapping() {
            return orig.isOverlapping();
        }

        public void AssignTo(char c) {
            orig.AssignTo(c);
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        /*String initialString = "4\n" +
                "3\n" +
                "360 480\n" +
                "420 540\n" +
                "600 660\n" +
                "3\n" +
                "0 1440\n" +
                "1 3\n" +
                "2 4\n" +
                "5\n" +
                "99 150\n" +
                "1 100\n" +
                "100 301\n" +
                "2 5\n" +
                "150 250\n" +
                "2\n" +
                "0 720\n" +
                "720 1440";
        Scanner in = new Scanner(new ByteArrayInputStream(initialString.getBytes()));*/

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        out = new PrintWriter(new BufferedOutputStream(System.out));

        int tests = in.nextInt();

        for (int itest = 1; itest <= tests; itest++) {
            // prepare for the test
            for (int i=0; i < 24*60; i++)
                minutes[i]= 0;
            List<Activity> activities = new ArrayList<>();
            List<ActivityWrapper> wrappers = new ArrayList<>();

            // read test params
            int numActivities = in.nextInt();
            for (int i = 0; i < numActivities; i++) {
                Activity cur = new Activity(in.nextInt(), in.nextInt());
                activities.add(cur);
                wrappers.add(new ActivityWrapper(cur));
            }

            Collections.sort(wrappers, (o1, o2) -> Integer.valueOf(o1.orig.start).compareTo(o2.orig.start));

            // determine if some minute used 3 or more times
            boolean impossible = false;
            for (int i=0; i < 24*60; i++) {
                if (minutes[i] >= 3) {
                    impossible = true;
                    break;
                }
            }

            if (!impossible) {
                // assign non-overlapping activities
                for (int i = 0; i < numActivities; i++) {
                    Activity cur = activities.get(i);
                    if (!cur.isOverlapping()) {
                        cur.AssignTo('C');
                    }
                }

                // assign overlapping
                char lastAssigned = ' ';
                for (int iminute = 0; iminute < 24*60; ) {
                    boolean overlapFound = false;
                    for (; iminute < 24*60; iminute++) {
                        if (minutes[iminute] == 2) {
                            overlapFound = true;
                            break;
                        }
                    }
                    if (overlapFound) {
                        Activity a1 = null, a2 = null;
                        for (int i=0; i < wrappers.size(); i++) {
                            ActivityWrapper cur = wrappers.get(i);
                            if (cur.orig.assignedTo == ' ' && iminute >= cur.orig.start && iminute < cur.orig.end)
                            {
                                if (a1 == null)
                                    a1 = cur.orig;
                                else
                                    a2 = cur.orig;
                            }
                        }
                        a1.AssignTo(lastAssigned == 'C' ? 'J' : 'C');
                        a2.AssignTo(a1.assignedTo == 'J' ? 'C' : 'J');
                        lastAssigned = (a1.end >= a2.end) ? a1.assignedTo : a2.assignedTo;
                    }
                }

                // assign non-overlapping activities
                for (int i = 0; i < numActivities; i++) {
                    Activity cur = activities.get(i);
                    if (cur.assignedTo == ' ') {
                        cur.AssignTo('J');
                    }
                }

                // output
                StringBuilder sb = new StringBuilder();
                for (int i=0; i < activities.size(); i++) {
                    sb.append(activities.get(i).assignedTo);
                }
                out.println("Case #" + itest + ": " +sb.toString());

            } else {
                out.println("Case #" + itest + ": IMPOSSIBLE");
            }
        }

        out.close();
    }


    public static PrintWriter out;

    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
