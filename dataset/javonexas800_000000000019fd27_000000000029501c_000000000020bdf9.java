import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.LinkedList;
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
        List<Schedule> C = new LinkedList<>();
        List<Schedule> J = new LinkedList<>();
        for (int i = 0 ; i < inputSize; i++ ) {
            Schedule schedule = new Schedule(in.nextInt(), in.nextInt());
            if (C.size() == 0) {
                C.add(schedule);
                builder.append(CAMERON_FIRST_LETTER);
                continue;
            }

            if (J.size() == 0) {
                J.add(schedule);
                builder.append(JAMIE_FIRST_LETTER);
                continue;
            }

            if (insertActivity(C, schedule)) {
                builder.append(CAMERON_FIRST_LETTER);
                continue;
            }

            if(insertActivity(J, schedule)) {
                builder.append(JAMIE_FIRST_LETTER);
                continue;
            }

            return IMPOSSIBLE_MESSAGE;
        }

        return builder.toString();
    }

    private boolean insertActivity(List<Schedule> list, Schedule schedule) {
        for (int i = 0 ; i < list.size(); i++) {
            Schedule scheduleFromList = list.get(i);
            if (schedule.endTime <= scheduleFromList.startTime) {
                if (i - 1 >= 0 && list.get(i-1).endTime <= schedule.startTime ) {
                    list.add(i, schedule);
                } else {
                    list.add(0, schedule);
                }
                return true;
            }
        }

        if (list.get(list.size() - 1).endTime <= schedule.startTime) {
            list.add(schedule);
            return true;
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
