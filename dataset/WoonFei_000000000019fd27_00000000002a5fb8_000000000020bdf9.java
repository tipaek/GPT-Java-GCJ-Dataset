
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] activities = new int[n][2];
            Queue<String> queue = new LinkedList<>();
            Queue<String> tmp = new LinkedList<>();
            queue.add( "J");
            activities[0][0] = in.nextInt();
            activities[0][1] = in.nextInt();
            for (int j = 1; j < n; j++) {
                int startTime = in.nextInt();
                int endTime = in.nextInt();
                while (!queue.isEmpty()) {
                    String schedule = queue.poll();
                    String person = overlappingPerson(activities, startTime, endTime, schedule.length(), schedule);
                    if (person.isEmpty()) {
                        tmp.add(schedule + "C");
                        tmp.add(schedule + "J");
                        continue;
                    }

                    if(person.equals(CONFLICT_WITH_BOTH)) {
                        continue;
                    }

                    if (person.equals("J")) {
                        tmp.add(schedule + "C");
                        continue;
                    }
                    tmp.add(schedule + "J");
                }
                queue.addAll(tmp);
                tmp.clear();
                activities[j][0] = startTime;
                activities[j][1] = endTime;
            }
            if (queue.isEmpty()) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": " + queue.poll());
            }
        }
    }

    public final static String CONFLICT_WITH_BOTH = "CONFLICT_WITH_BOTH";

    public static String overlappingPerson(int[][] activities, int startTime, int endTime, int length, String schedule) {
        String overlappedStr = "";
        for (int k = 0; k < length; k++) {
            if ((activities[k][1] > endTime && activities[k][0] < endTime)
                    || (activities[k][1] > startTime && activities[k][0] < startTime)
                    || (activities[k][0] == startTime)
                    || (activities[k][1] == endTime)) {
                if(!overlappedStr.contains(schedule.substring(k, k + 1)) && !overlappedStr.isEmpty()) {
                    return CONFLICT_WITH_BOTH;
                }
                overlappedStr = schedule.substring(k, k + 1);
            }
        }
        return overlappedStr;
    }
}
