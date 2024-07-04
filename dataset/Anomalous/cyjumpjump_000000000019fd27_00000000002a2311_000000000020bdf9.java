import java.io.*;
import java.util.*;

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

    private BufferedReader reader;
    private PrintWriter writer;
    private StringTokenizer tokenizer;

    private String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    private void solve() throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        int testCases = Integer.parseInt(nextToken());
        for (int i = 1; i <= testCases; i++) {
            int N = Integer.parseInt(nextToken());
            int[][] intervals = new int[N][2];
            Map<int[], Integer> originalOrder = new HashMap<>();
            for (int j = 0; j < N; j++) {
                intervals[j][0] = Integer.parseInt(nextToken());
                intervals[j][1] = Integer.parseInt(nextToken());
                originalOrder.put(intervals[j], j);
            }
            Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
            writer.println(String.format("Case #%d: %s", i, assignTasks(intervals, originalOrder)));
        }
        reader.close();
        writer.close();
    }

    private String assignTasks(int[][] intervals, Map<int[], Integer> originalOrder) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Map<Integer, String> assignedTasks = new HashMap<>();
        String currentAssignee = "J";
        int concurrentTasks = 0;

        for (int[] interval : intervals) {
            int originalIndex = originalOrder.get(interval);
            if (pq.isEmpty() || interval[0] < pq.peek()) {
                concurrentTasks++;
                if (concurrentTasks > 2) {
                    return "IMPOSSIBLE";
                }
                if (currentAssignee.equals("J")) {
                    assignedTasks.put(originalIndex, "C");
                    currentAssignee = "C";
                } else {
                    assignedTasks.put(originalIndex, "J");
                    currentAssignee = "J";
                }
            } else {
                pq.poll();
                assignedTasks.put(originalIndex, currentAssignee);
            }
            pq.offer(interval[1]);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < assignedTasks.size(); i++) {
            result.append(assignedTasks.get(i));
        }
        return result.toString();
    }
}