import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCasesNumber = in.nextInt();
        for (int testCase = 1; testCase <= testCasesNumber; testCase++) {
            int eventsNumber = in.nextInt();
            int[][] events = new int[eventsNumber][2];
            for (int i = 0; i < eventsNumber; i++) {
                events[i][0] = in.nextInt();
                events[i][1] = in.nextInt();
            }
            System.out.println(String.format("Case #%s: %s", testCase, makeASchedule(events, eventsNumber)));
        }
    }

    public static String makeASchedule(int[][]events, int eventsNumber) {
        StringBuilder result = new StringBuilder();
        List<int[]> jSchedule = new ArrayList<>();
        List<int[]> cSchedule = new ArrayList<>();
        for (int i = 0; i < eventsNumber; i++) {
            if (!overlap(events[i][0], events[i][1], jSchedule)) {
                jSchedule.add(events[i]);
                result.append("J");
            } else if (!overlap(events[i][0], events[i][1], cSchedule)) {
                cSchedule.add(events[i]);
                result.append("C");
            } else {
                return "IMPOSSIBLE";
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
