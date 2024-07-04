import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Solution {

    public static class ScheduleEntry {
        int start;
        int end;
        int initialPosition;
        String assignedPerson;

        public ScheduleEntry(int s, int e, int initial) {
            this.start = s;
            this.end = e;
            this.initialPosition = initial;
            this.assignedPerson = "";
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

    private static String solve(BufferedReader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        Integer nEntries = Integer.parseInt(reader.readLine());
        List<ScheduleEntry> input = new ArrayList<>();
        
        ScheduleEntry c = new ScheduleEntry(0, 0, -1);
        ScheduleEntry j = new ScheduleEntry(0, 0, -1);
        
        for ( int i = 0; i < nEntries; i++) {
            String[] schedule = reader.readLine().split(" ");
            input.add(new ScheduleEntry(Integer.parseInt(schedule[0]), Integer.parseInt(schedule[1]), i));
        }

        input.sort(Comparator.comparingInt(s -> s.start));
        
        for (ScheduleEntry tempSchedule : input) {
            if (tempSchedule.start >= c.end) {
                c = tempSchedule;
                c.assignedPerson = "C";
            } else if (tempSchedule.start >= j.end) {
                j = tempSchedule;
                j.assignedPerson = "J";
            } else {
                return IMPOSSIBLE_TO_SCHEDULE;
            }
        }
        
        input.sort(Comparator.comparingInt(s -> s.initialPosition));
        
        for (ScheduleEntry tempSchedule : input) {
            sb.append(tempSchedule.assignedPerson);
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
