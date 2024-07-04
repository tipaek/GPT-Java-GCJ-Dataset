import java.util.*;
import java.io.*;

class Solution {
    static int len = 0;

    public static String schedule(List<int[]> times) {
        List<String> result = new ArrayList<>();
        len = times.size();
        
        // Sort times based on start time
        times.sort(Comparator.comparingInt(a -> a[0]));
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        boolean isJFull = false, isCFull = false;

        for (int[] time : times) {
            if (pq.isEmpty()) {
                pq.add(new int[]{time[0], time[1], 0});
                isJFull = true;
                result.add("J");
                continue;
            }

            int[] earliestEnd = pq.peek();
            if (earliestEnd[1] <= time[0]) {
                int[] finishedTask = pq.poll();
                if (finishedTask[2] == 0) {
                    isJFull = false;
                } else if (finishedTask[2] == 1) {
                    isCFull = false;
                }
            }

            int assignedPerson = 0;
            if (!isJFull) {
                assignedPerson = 0;
                isJFull = true;
                result.add("J");
            } else if (!isCFull) {
                assignedPerson = 1;
                isCFull = true;
                result.add("C");
            } else {
                return "IMPOSSIBLE";
            }

            pq.add(new int[]{time[0], time[1], assignedPerson});
        }

        return parseList(result);
    }

    public static String parseList(List<String> result) {
        if (result.size() != len) return "IMPOSSIBLE";
        return String.join("", result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt(); // Number of test cases

        for (int i = 1; i <= t; ++i) {
            int n = scanner.nextInt(); // Number of activities
            List<int[]> activities = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new int[]{start, end});
            }

            System.out.println("Case #" + i + ": " + schedule(activities));
        }
    }
}