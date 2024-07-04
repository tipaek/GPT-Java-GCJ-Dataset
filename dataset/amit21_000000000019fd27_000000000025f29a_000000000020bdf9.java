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
                int startTime = sc.nextInt();
                int endTime = sc.nextInt();
                activities[i] = new Activity(startTime, endTime, i);
                activities[i].answer = 0;
            }
            Integer[] sortedWithStart = new Integer[n];
            Integer[] sortedWithEnd = new Integer[n];
            for (int i = 0; i < n; i++) {
                sortedWithEnd[i] = i;
                sortedWithStart[i] = i;
            }
            Arrays.sort(sortedWithEnd, new Comparator<Integer>() {
                @Override
                public int compare(Integer integer, Integer t1) {
                    return activities[integer].endTime - activities[t1].endTime;
                }
            });
            Arrays.sort(sortedWithStart, new Comparator<Integer>() {
                @Override
                public int compare(Integer integer, Integer t1) {
                    return activities[integer].startTime - activities[t1].startTime;
                }
            });
            int start = 0;
            int end = 0;
            int currentOverlapping = 0;
            int maxOverlapping = 0;
            while (start < n & end < n) {
                if (activities[sortedWithStart[start]].startTime < activities[sortedWithEnd[end]].endTime) {
                    currentOverlapping++;
                    start++;
                } else {
                    currentOverlapping--;
                    end++;
                }
                maxOverlapping = Math.max(currentOverlapping, maxOverlapping);
            }
            String ans;
            if (maxOverlapping >= 3) {
                ans = "IMPOSSIBLE";
            } else {
                int current = 0;
                while (current < n) {
                    activities[sortedWithStart[current]].answer = 1;
                    int left = current + 1, right = n - 1;
                    int targetStartTime = activities[sortedWithStart[current]].endTime;
                    int candidate = n;
                    while (left <= right) {
                        int mid = (left + right) >> 1;
                        int midStartTime = activities[sortedWithStart[mid]].startTime;
                        if (midStartTime >= targetStartTime) {
                            candidate = mid;
                            right = mid - 1;
                        } else {
                            left = mid + 1;
                        }
                    }
                    current = candidate;
                }
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    if (activities[i].answer == 1) {
                        sb.append("J");
                    } else {
                        sb.append("C");
                    }
                }
                ans = sb.toString();
            }
            System.out.println("Case #" + testIndex + ": " + ans);
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
