import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Pair {
    int[] interval = new int[2];
    Character assignment;
}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCasesNumber = in.nextInt();
        for (int testCase = 1; testCase <= testCasesNumber; testCase++) {
            int eventsNumber = in.nextInt();
            Pair[] events = new Pair[eventsNumber];
            for (int i = 0; i < eventsNumber; i++) {
                events[i] = new Pair();
                events[i].interval[0] = in.nextInt();
                events[i].interval[1] = in.nextInt();
            }
            System.out.println(String.format("Case #%s: %s", testCase, makeASchedule(events, eventsNumber)));
        }
    }

    public static String makeASchedule(Pair[] events, int eventsNumber) {
        for (int i = 0; i < eventsNumber; i++) {
            for (int j = 0; j < i; j++) {
                if (overlap(events[i].interval[0], events[i].interval[1], events[j].interval[0], events[j].interval[1])) {
                    if (events[j].assignment == 'J' && events[i].assignment != null && events[i].assignment == 'J') {
                        return "IMPOSSIBLE";
                    } else if (events[j].assignment == 'J') {
                        events[i].assignment = 'C';
                    }
                    if (events[j].assignment == 'C' && events[i].assignment != null && events[i].assignment != 'C') {
                        return "IMPOSSIBLE";
                    }  else if (events[j].assignment == 'C') {
                        events[i].assignment = 'J';
                    }
                    if (events[j].assignment == 'B' && events[i].assignment == null) {
                        events[j].assignment = 'J';
                        events[i].assignment = 'C';
                    } else if (events[j].assignment == 'B' && events[i].assignment == 'C') {
                        events[j].assignment = 'J';
                    } else if (events[j].assignment == 'B' && events[i].assignment == 'J') {
                        events[j].assignment = 'C';
                    }
                }
            }
            if (events[i].assignment == null) {
                events[i].assignment = 'B';
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < eventsNumber; i++) {
            if (events[i].assignment == 'B') {
                result.append('J');
            } else {
                result.append(events[i].assignment);
            }
        }
        return result.toString();
    }



    public static boolean overlap(int x1, int x2, List<int[]> schedule) {
        for (int[] event : schedule) {
            if (overlap(x1, x2, event[0], event[1])) {
                return true;
            }
        }
        return false;
    }

    public static boolean overlap(int x1, int x2, int y1, int y2) {
        return x1 < y2 && x2 > y1;
    }
}
