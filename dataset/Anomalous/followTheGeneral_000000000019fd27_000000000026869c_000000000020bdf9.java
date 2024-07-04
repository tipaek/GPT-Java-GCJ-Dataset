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
            int totalCases = Integer.parseInt(reader.readLine());

            while (totalCases-- > 0) {
                System.out.println("Case #" + caseNumber++ + ": " + processCase(reader));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String processCase(BufferedReader reader) throws IOException {
        StringBuilder result = new StringBuilder();
        boolean[] cSchedule = new boolean[2400];
        boolean[] jSchedule = new boolean[2400];

        int intervals = Integer.parseInt(reader.readLine());
        for (int i = 0; i < intervals; i++) {
            String[] timeRange = reader.readLine().split("\\s+");
            int startTime = Integer.parseInt(timeRange[0]);
            int endTime = Integer.parseInt(timeRange[1]);

            boolean[] assignedSchedule;

            if (isFree(cSchedule, startTime, endTime)) {
                assignedSchedule = cSchedule;
                result.append('C');
            } else if (isFree(jSchedule, startTime, endTime)) {
                assignedSchedule = jSchedule;
                result.append('J');
            } else {
                skipRemainingIntervals(reader, intervals - i - 1);
                return IMPOSSIBLE;
            }

            markSchedule(assignedSchedule, startTime, endTime);
        }
        return result.toString();
    }

    private boolean isFree(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i]) return false;
        }
        return true;
    }

    private void markSchedule(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = true;
        }
    }

    private void skipRemainingIntervals(BufferedReader reader, int remaining) throws IOException {
        for (int i = 0; i < remaining; i++) {
            reader.readLine();
        }
    }
}