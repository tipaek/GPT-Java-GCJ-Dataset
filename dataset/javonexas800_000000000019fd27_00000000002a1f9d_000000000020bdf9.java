import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static final char CAMERON_FIRST_LETTER = 'C';
    private static final char JAMIE_FIRST_LETTER = 'J';
    private static final String IMPOSSIBLE_MESSAGE = "IMPOSSIBLE";

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(
                new BufferedReader(
                        new InputStreamReader(System.in)));
//        Scanner in = new Scanner(new File("input3.txt"));

        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i = 1; i <= t; ++i) {
            int inputSize = in.nextInt();
            System.out.println("Case #" + i + ": " + new Solution().process(in, inputSize));
        }
    }

    private String process(Scanner in, int inputSize) {
        StringBuilder builder = new StringBuilder();
        List<Schedule> C = new ArrayList<>();
        List<Schedule> J = new ArrayList<>();
        for (int i = 0 ; i < inputSize; i++ ) {
            Schedule schedule = new Schedule(in.nextInt(), in.nextInt());
            if (C.isEmpty()) {
                C.add(schedule);
                builder.append(CAMERON_FIRST_LETTER);
                continue;
            }

            if (J.isEmpty()) {
                J.add(schedule);
                builder.append(JAMIE_FIRST_LETTER);
                continue;
            }

            if (insertActivity(C, schedule)) {
                builder.append(CAMERON_FIRST_LETTER);
                continue;
            }

            if (insertActivity(J, schedule)) {
                builder.append(JAMIE_FIRST_LETTER);
                continue;
            }

            return IMPOSSIBLE_MESSAGE;
        }

        return builder.toString();
    }

    private boolean insertActivity(List<Schedule> list, Schedule schedule) {
        if (list.size() > 0 && list.get(list.size() - 1).endTime <= schedule.startTime) {
            list.add(schedule);
            return true;
        }

        for (int index=0; index < list.size(); index++) {
            Schedule schedule1 = list.get(index);
            if (schedule1 != null && schedule.endTime <= schedule1.startTime) {
                if (index == 0) {
                    list.add(0, schedule);
                    return true;
                } else {
                    Schedule previousSchedule = list.get(index - 1);
                    if (previousSchedule != null && previousSchedule.endTime <= schedule.startTime) {
                        list.add(index, schedule);
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }

        return false;
    }

    class Schedule {
        int startTime;
        int endTime;

        Schedule(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}
