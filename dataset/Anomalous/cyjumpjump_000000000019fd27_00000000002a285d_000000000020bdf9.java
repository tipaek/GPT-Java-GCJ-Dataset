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
            Map<int[], Integer> indexMap = new HashMap<>();

            for (int j = 0; j < N; j++) {
                intervals[j][0] = Integer.parseInt(nextToken());
                intervals[j][1] = Integer.parseInt(nextToken());
                indexMap.put(intervals[j], j);
            }

            Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
            writer.println(String.format("Case #%d: %s", i, assignIntervals(intervals, indexMap)));
        }

        reader.close();
        writer.close();
    }

    private String assignIntervals(int[][] intervals, Map<int[], Integer> indexMap) {
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        int activeIntervals = 0;
        Map<Integer, String> assignmentMap = new HashMap<>();
        String currentAssignee = "C";

        for (int[] interval : intervals) {
            int index = indexMap.get(interval);

            if (endTimes.isEmpty() || interval[0] < endTimes.peek()) {
                activeIntervals++;
                assignmentMap.put(index, currentAssignee);
                currentAssignee = currentAssignee.equals("C") ? "J" : "C";
            } else {
                endTimes.poll();
                assignmentMap.put(index, currentAssignee);
            }

            endTimes.offer(interval[1]);

            if (activeIntervals > 2) {
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