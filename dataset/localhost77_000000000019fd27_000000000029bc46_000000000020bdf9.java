import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Solution {

    public static class ScheduleEntry {
        int start;
        int end;

        public ScheduleEntry(int s, int e) {
            this.start = s;
            this.end = e;
        }
    }

    static List<ScheduleEntry> cList = new ArrayList<>(), jList = new ArrayList<>();
    public static String IMPOSSIBLE_TO_SCHEDULE = "IMPOSSIBLE";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = input(reader).get(0);
        for(int i = 1; i <= t; i++) {
            cList.clear();
            jList.clear();

            output(i, solve(reader));
        }

        reader.close();
    }

    private static String checkAndSchedule(int s, int e) {
        boolean conflictFound = false;

        // Check if Cameron is available
        for (ScheduleEntry entry : cList) {
            if ((s >= entry.start && s < entry.end) ||
                    (e >= entry.start && e <= entry.end)) {
                conflictFound = true;
                break;
            }
            if (entry.start >= s && entry.end <= e) {
                conflictFound = true;
                break;
            }
        }

        if (!conflictFound) {
            cList.add(new ScheduleEntry(s, e));
            return "C"; // Cameron is available
        }

        // Cameron is not available
        // Check if Jamie is available

        conflictFound = false;
        for (ScheduleEntry entry : jList) {
            if ((s >= entry.start && s < entry.end) ||
                    (e >= entry.start && e <= entry.end)) {
                conflictFound = true;
                break;
            }
            if (entry.start >= s && entry.end <= e) {
                conflictFound = true;
                break;
            }
        }

        if (!conflictFound) {
            jList.add(new ScheduleEntry(s, e));
            return "J"; // Jamie is available
        }

        return null; // Neither person is available
    }

    private static String solve(BufferedReader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        Integer nEntries = Integer.parseInt(reader.readLine());
        List<String> input = new ArrayList<>();

        for ( int i = 0; i < nEntries; i++) {
            String schedule = reader.readLine();
            input.add(schedule);
        }

        for (String tempSchedule : input) {
            String[] schedule = tempSchedule.split(" ");
            int start = Integer.parseInt(schedule[0]);
            int end = Integer.parseInt(schedule[1]);

            String person = checkAndSchedule(start, end);

            if (person == null) {
                return IMPOSSIBLE_TO_SCHEDULE;
            } else {
                sb.append(person);
            }
        }

        return sb.toString();
    }

    private static List<Integer>  input(BufferedReader reader) throws IOException {
        return input(reader, Integer::valueOf);
    }

    private static <T> List<T> input(BufferedReader reader, Function<String, T> mapper) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .map(mapper)
                .collect(Collectors.toList());
    }

    private static <T> void output(int idx, T answer) {
        System.out.println(
                String.format(
                        "Case #%d: %s",
                        idx,
                        answer.toString()
                )
        );
    }
}
