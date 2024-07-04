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
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            writer.printf("Case #%d: %s%n", i, assignTasks(intervals, intervalIndexMap));
        }
        reader.close();
        writer.close();
    }

    private String assignTasks(int[][] intervals, Map<int[], Integer> intervalIndexMap) {
        Map<Integer, String> assignmentMap = new HashMap<>();
        int endC = 0, endJ = 0;

        for (int[] interval : intervals) {
            int index = intervalIndexMap.get(interval);
            int start = interval[0], end = interval[1];

            if (endC <= start) {
                endC = end;
                assignmentMap.put(index, "C");
            } else if (endJ <= start) {
                endJ = end;
                assignmentMap.put(index, "J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder taskAssignments = new StringBuilder();
        for (int i = 0; i < assignmentMap.size(); i++) {
            taskAssignments.append(assignmentMap.get(i));
        }
        return taskAssignments.toString();
    }
}