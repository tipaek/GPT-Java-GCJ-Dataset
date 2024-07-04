
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();

        int numberOfTest = sc.nextInt();
        for (int i = 0; i < numberOfTest; i++) {
            // Input
            List<Activity> activityList = new ArrayList<>();
            int numberOfActivity = sc.nextInt();
            for (int j = 0; j < numberOfActivity; j++) {
                int startTime = sc.nextInt();
                int endTime = sc.nextInt();
                activityList.add(new Activity(j, startTime, endTime));
            }

            activityList.sort(Comparator.comparingInt(activity -> activity.startTime));

            boolean possible = true;
            Activity lastActivityInC = null, lastActivityInJ = null;
            for (int  j = 0 ; j < numberOfActivity; j++) {
                Activity currentActivity = activityList.get(j);
                if (lastActivityInC == null || lastActivityInC.endTime <= currentActivity.startTime) {
                    currentActivity.setBelongTo("C");
                    lastActivityInC = currentActivity;
                    continue;
                }

                if (lastActivityInJ == null || lastActivityInJ.endTime <= currentActivity.startTime) {
                    currentActivity.setBelongTo("J");
                    lastActivityInJ = currentActivity;
                    continue;
                }
                possible = false;
                break;
            }

            if (!possible) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                activityList.sort(Comparator.comparingInt(activity -> activity.originalPosition));
                System.out.print("Case #" + (i + 1) + ": ");
                for (int j = 0 ; j < numberOfActivity; j++) {
                    System.out.print(activityList.get(j).belongTo);
                }
                System.out.println("");
            }
        }
    }

    private static class Activity {
        int startTime = 0;
        int endTime = 0;
        int originalPosition;
        String belongTo;
        public Activity(int originalPosition, int startTime, int endTime) {
            this.originalPosition = originalPosition;
            this.endTime = endTime;
            this.startTime = startTime;
        }

        public void setBelongTo(String name) {
            belongTo = name;
        }
    }

    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(String s) {
            try {
                br = new BufferedReader(new FileReader(s));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextToken() {
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
            return Integer.parseInt(nextToken());
        }

        long nextLong() {
            return Long.parseLong(nextToken());
        }

        double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }
}
