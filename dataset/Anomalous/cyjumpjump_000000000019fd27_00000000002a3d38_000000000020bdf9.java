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
    private StringTokenizer tokenizer = null;

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
            Map<int[], Integer> intervalIndexMap = new HashMap<>();
            for (int j = 0; j < N; j++) {
                intervals[j][0] = Integer.parseInt(nextToken());
                intervals[j][1] = Integer.parseInt(nextToken());
                intervalIndexMap.put(intervals[j], j);
            }
            Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
            writer.println(String.format("Case #%d: %s", i, assignTasks(intervals, intervalIndexMap)));
        }
        reader.close();
        writer.close();
    }

    private String assignTasks(int[][] intervals, Map<int[], Integer> intervalIndexMap) {
        PriorityQueue<Integer> endTimeQueue = new PriorityQueue<>();
        Map<Integer, String> assignmentMap = new HashMap<>();
        String currentAssignment = "C";
        int taskCount = 0;

        for (int[] interval : intervals) {
            int index = intervalIndexMap.get(interval);

            if (endTimeQueue.isEmpty()) {
                taskCount++;
                endTimeQueue.offer(interval[1]);
                assignmentMap.put(index, currentAssignment);
            } else {
                if (interval[0] >= endTimeQueue.peek()) {
                    for (Map.Entry<int[], Integer> entry : intervalIndexMap.entrySet()) {
                        if (entry.getKey()[1] == endTimeQueue.peek() && assignmentMap.containsKey(entry.getValue())) {
                            currentAssignment = assignmentMap.get(entry.getValue());
                        }
                    }
                    assignmentMap.put(index, currentAssignment);
                    endTimeQueue.poll();
                } else {
                    taskCount++;
                    currentAssignment = currentAssignment.equals("J") ? "C" : "J";
                    assignmentMap.put(index, currentAssignment);
                }
                endTimeQueue.offer(interval[1]);
            }

            if (taskCount > 2) {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < assignmentMap.size(); i++) {
            result.append(assignmentMap.get(i));
        }
        return result.toString();
    }
}