import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        new Solution().solve();
    }

    private void solve() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(reader.readLine());
            for (int currentCase = 1; currentCase <= testCases; currentCase++) {
                System.out.println("Case #" + currentCase + ": " + processCase(reader));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String processCase(BufferedReader reader) throws IOException {
        StringBuilder result = new StringBuilder();
        boolean[] cSchedule = new boolean[2400];
        boolean[] jSchedule = new boolean[2400];

        int activities = Integer.parseInt(reader.readLine());
        for (int i = 0; i < activities; i++) {
            String[] times = reader.readLine().split("\\s+");
            int start = Integer.parseInt(times[0]);
            int end = Integer.parseInt(times[1]);

            if (isAvailable(cSchedule, start, end)) {
                markSchedule(cSchedule, start, end);
                result.append('C');
            } else if (isAvailable(jSchedule, start, end)) {
                markSchedule(jSchedule, start, end);
                result.append('J');
            } else {
                skipRemainingActivities(reader, activities - i - 1);
                return IMPOSSIBLE;
            }
        }
        return result.toString();
    }

    private boolean isAvailable(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i]) {
                return false;
            }
        }
        return true;
    }

    private void markSchedule(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = true;
        }
    }

    private void skipRemainingActivities(BufferedReader reader, int remainingActivities) throws IOException {
        for (int i = 0; i < remainingActivities; i++) {
            reader.readLine();
        }
    }
}