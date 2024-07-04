import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int testCases = sc.nextInt();

        for (int t = 0; t < testCases; t++) {
            int activitiesCount = sc.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < activitiesCount; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                activities.add(new Activity(i, start, end));
            }

            activities.sort(Comparator.comparingInt(a -> a.startTime));

            boolean isPossible = true;
            Activity lastC = null, lastJ = null;

            for (Activity activity : activities) {
                if (lastC == null || lastC.endTime <= activity.startTime) {
                    activity.assignTo("C");
                    lastC = activity;
                } else if (lastJ == null || lastJ.endTime <= activity.startTime) {
                    activity.assignTo("J");
                    lastJ = activity;
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (!isPossible) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                activities.sort(Comparator.comparingInt(a -> a.originalIndex));
                System.out.print("Case #" + (t + 1) + ": ");
                for (Activity activity : activities) {
                    System.out.print(activity.assignedTo);
                }
                System.out.println();
            }
        }
    }

    private static class Activity {
        int startTime, endTime, originalIndex;
        String assignedTo;

        public Activity(int originalIndex, int startTime, int endTime) {
            this.originalIndex = originalIndex;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public void assignTo(String person) {
            this.assignedTo = person;
        }
    }

    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastScanner(String fileName) {
            try {
                br = new BufferedReader(new FileReader(fileName));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
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