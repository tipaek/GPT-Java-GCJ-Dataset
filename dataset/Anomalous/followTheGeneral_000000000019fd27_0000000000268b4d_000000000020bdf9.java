import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        new Solution().execute();
    }

    private void execute() {
        int caseNumber = 1;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfCases = Integer.parseInt(reader.readLine());

            while (numberOfCases-- > 0) {
                System.out.println("Case #" + caseNumber++ + ": " + processCase(reader));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String processCase(BufferedReader reader) throws IOException {
        StringBuilder result = new StringBuilder();
        boolean[] cTimeline = new boolean[2400];
        boolean[] jTimeline = new boolean[2400];

        int numberOfActivities = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfActivities; i++) {
            String[] times = reader.readLine().split("\\s+");
            int startTime = Integer.parseInt(times[0]);
            int endTime = Integer.parseInt(times[1]);

            if (isAvailable(cTimeline, startTime, endTime)) {
                markTimeline(cTimeline, startTime, endTime);
                result.append('C');
            } else if (isAvailable(jTimeline, startTime, endTime)) {
                markTimeline(jTimeline, startTime, endTime);
                result.append('J');
            } else {
                skipRemainingActivities(reader, numberOfActivities - i - 1);
                return IMPOSSIBLE;
            }
        }
        return result.toString();
    }

    private boolean isAvailable(boolean[] timeline, int start, int end) {
        for (int i = start; i < end; i++) {
            if (timeline[i]) {
                return false;
            }
        }
        return true;
    }

    private void markTimeline(boolean[] timeline, int start, int end) {
        for (int i = start; i < end; i++) {
            timeline[i] = true;
        }
    }

    private void skipRemainingActivities(BufferedReader reader, int remainingActivities) throws IOException {
        for (int i = 0; i < remainingActivities; i++) {
            reader.readLine();
        }
    }
}