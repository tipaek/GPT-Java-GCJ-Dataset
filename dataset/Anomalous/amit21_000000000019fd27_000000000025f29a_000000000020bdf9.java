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
        int answer;

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
            Activity[] activities = new Activity[n];
            for (int i = 0; i < n; i++) {
                activities[i] = new Activity(sc.nextInt(), sc.nextInt(), i);
            }
            Integer[] sortedWithStart = new Integer[n];
            Integer[] sortedWithEnd = new Integer[n];
            for (int i = 0; i < n; i++) {
                sortedWithStart[i] = sortedWithEnd[i] = i;
            }
            Arrays.sort(sortedWithEnd, Comparator.comparingInt(i -> activities[i].endTime));
            Arrays.sort(sortedWithStart, Comparator.comparingInt(i -> activities[i].startTime));

            int start = 0, end = 0, currentOverlapping = 0, maxOverlapping = 0;
            while (start < n && end < n) {
                if (activities[sortedWithStart[start]].startTime < activities[sortedWithEnd[end]].endTime) {
                    currentOverlapping++;
                    start++;
                } else {
                    currentOverlapping--;
                    end++;
                }
                maxOverlapping = Math.max(currentOverlapping, maxOverlapping);
            }

            String result;
            if (maxOverlapping >= 3) {
                result = "IMPOSSIBLE";
            } else {
                Arrays.fill(activities, new Activity(0, 0, 0));
                int current = 0;
                while (current < n) {
                    activities[sortedWithStart[current]].answer = 1;
                    int left = current + 1, right = n - 1;
                    int targetStartTime = activities[sortedWithStart[current]].endTime;
                    int candidate = n;
                    while (left <= right) {
                        int mid = (left + right) / 2;
                        if (activities[sortedWithStart[mid]].startTime >= targetStartTime) {
                            candidate = mid;
                            right = mid - 1;
                        } else {
                            left = mid + 1;
                        }
                    }
                    current = candidate;
                }

                StringBuilder sb = new StringBuilder();
                for (Activity activity : activities) {
                    sb.append(activity.answer == 1 ? "J" : "C");
                }
                result = sb.toString();
            }

            System.out.println("Case #" + testIndex + ": " + result);
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