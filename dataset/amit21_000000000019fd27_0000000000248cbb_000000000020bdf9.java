import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static final int INF = 10000;

    public static class Activity {
        final int startTime;
        final int endTime;
        final int index;
        char answer;

        public Activity(int startTime, int endTime, int index) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        int testCaseCount = sc.nextInt();
        for (int testIndex = 1; testIndex <= testCaseCount; testIndex++) {
            int n = sc.nextInt();
            Activity[] startActivities = new Activity[n];
            Activity[] endActivities = new Activity[n];
            for (int i = 0; i < n; i++) {
                int startTime = sc.nextInt();
                int endTime = sc.nextInt();
                Activity activity = new Activity(startTime, endTime, i);
                startActivities[i] = activity;
                endActivities[i] = activity;
            }
            Arrays.sort(startActivities, new Comparator<Activity>() {
                @Override
                public int compare(Activity activity, Activity t1) {
                    return activity.startTime - t1.startTime;
                }
            });
            Arrays.sort(endActivities, new Comparator<Activity>() {
                @Override
                public int compare(Activity activity, Activity t1) {
                    return activity.endTime - t1.endTime;
                }
            });
            int start = 0;
            int end = 0;
            int currentParallel = 0;
            boolean possibleWithoutOverlap = true;
            while (start < n && end < n) {
                if (startActivities[start].startTime < endActivities[end].endTime) {
                    currentParallel++;
                    start++;
                } else if (startActivities[start].startTime == endActivities[end].endTime) {
                    //New activity will start immediately
                    start++;
                    if (currentParallel == 1) {
                        endActivities[end].answer = 'C';
                    } else if (currentParallel == 2) {
                        endActivities[end].answer = 'J';
                    } else {
                        possibleWithoutOverlap = false;
                    }
                    end++;
                } else {
                    if (currentParallel == 1) {
                        endActivities[end].answer = 'C';
                    } else if (currentParallel == 2) {
                        endActivities[end].answer = 'J';
                    } else {
                        possibleWithoutOverlap = false;
                    }
                    currentParallel--;
                    end++;
                }
                if (currentParallel > 2) {
                    possibleWithoutOverlap = false;
                }
            }
            while (end < n) {
                if (currentParallel == 1) {
                    endActivities[end].answer = 'C';
                } else if (currentParallel == 2) {
                    endActivities[end].answer = 'J';
                } else {
                    possibleWithoutOverlap = false;
                }
                currentParallel--;
                end++;
            }
            Arrays.sort(startActivities, new Comparator<Activity>() {
                @Override
                public int compare(Activity activity, Activity t1) {
                    return activity.index - t1.index;
                }
            });
            StringBuilder sb = new StringBuilder();
            if (possibleWithoutOverlap) {
                for (int i = 0; i < n; i++) {
                    sb.append(startActivities[i].answer);
                }
            } else {
                sb.append("IMPOSSIBLE");
            }
            System.out.println("Case #" + testIndex + ": " + sb.toString());
        }
    }

    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
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
