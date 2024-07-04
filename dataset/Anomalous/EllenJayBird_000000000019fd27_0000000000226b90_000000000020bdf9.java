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

    private String calculateSchedule(int caseNumber) throws IOException {
        int n = Integer.parseInt(nextToken());
        List<int[]> activities = new ArrayList<>();
        Map<int[], Integer> order = new HashMap<>();
        char[] answer = new char[n];

        for (int i = 0; i < n; i++) {
            String[] input = nextToken().split("\\s+");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            if (start > end || start < 0 || end > 24 * 60) {
                return "Case #" + caseNumber + ": IMPOSSIBLE";
            }
            int[] activity = new int[]{start, end};
            activities.add(activity);
            order.put(activity, i);
        }

        activities.sort(Comparator.comparingInt(a -> a[0]));

        PriorityQueue<int[]> cameronQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        PriorityQueue<int[]> jamieQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        cameronQueue.offer(activities.get(0));
        answer[order.get(activities.get(0))] = 'C';

        for (int i = 1; i < n; i++) {
            int[] currentActivity = activities.get(i);
            if (currentActivity[0] >= cameronQueue.peek()[1]) {
                cameronQueue.offer(currentActivity);
                answer[order.get(currentActivity)] = 'C';
            } else if (jamieQueue.isEmpty() || currentActivity[0] >= jamieQueue.peek()[1]) {
                jamieQueue.offer(currentActivity);
                answer[order.get(currentActivity)] = 'J';
            } else {
                return "Case #" + caseNumber + ": IMPOSSIBLE";
            }
        }

        return "Case #" + caseNumber + ": " + new String(answer);
    }

    private void solve() throws IOException {
        rd = new BufferedReader(new InputStreamReader(System.in));
        wr = new PrintWriter(System.out);

        int testCaseCount = Integer.parseInt(nextToken());

        for (int i = 0; i < testCaseCount; i++) {
            wr.println(calculateSchedule(i + 1));
        }

        rd.close();
        wr.close();
    }
}