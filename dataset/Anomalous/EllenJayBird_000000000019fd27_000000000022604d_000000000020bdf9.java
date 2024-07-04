import java.util.*;
import java.io.*;

public class Solution implements Runnable {

    public static void main(String[] args) {
        new Thread(new Solution()).start();
    }

    @Override
    public void run() {
        try {
            solve();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private BufferedReader rd;
    private PrintWriter wr;

    private String nextToken() throws IOException {
        return rd.readLine();
    }

    private String calculator(int caseNumber) throws IOException {
        int n = Integer.parseInt(nextToken());
        List<int[]> activities = new ArrayList<>();
        Map<int[], Integer> order = new HashMap<>();
        char[] schedule = new char[n];

        for (int i = 0; i < n; i++) {
            String[] times = nextToken().split("\\s+");
            int start = Integer.parseInt(times[0]);
            int end = Integer.parseInt(times[1]);

            if (start > end || start < 0 || end > 24 * 60) {
                return "Case #" + caseNumber + ": IMPOSSIBLE";
            }

            int[] activity = new int[]{start, end};
            activities.add(activity);
            order.put(activity, i);
        }

        activities.sort(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> jQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        PriorityQueue<int[]> cQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        jQueue.offer(activities.get(0));
        schedule[order.get(activities.get(0))] = 'J';

        for (int i = 1; i < n; i++) {
            int[] currentActivity = activities.get(i);
            if (currentActivity[0] >= jQueue.peek()[1]) {
                jQueue.poll();
                jQueue.offer(currentActivity);
                schedule[order.get(currentActivity)] = 'J';
            } else if (cQueue.isEmpty() || currentActivity[0] >= cQueue.peek()[1]) {
                cQueue.offer(currentActivity);
                schedule[order.get(currentActivity)] = 'C';
            } else {
                return "Case #" + caseNumber + ": IMPOSSIBLE";
            }
        }

        return "Case #" + caseNumber + ": " + new String(schedule);
    }

    private void solve() throws IOException {
        rd = new BufferedReader(new InputStreamReader(System.in));
        wr = new PrintWriter(System.out);

        int testCases = Integer.parseInt(nextToken());

        for (int i = 0; i < testCases; i++) {
            String result = calculator(i + 1);
            wr.println(result);
        }

        rd.close();
        wr.close();
    }
}