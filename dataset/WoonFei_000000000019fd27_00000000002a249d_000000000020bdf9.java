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
            String ans = "J";
            queue.add(ans);
            activities[0][0] = in.nextInt();
            activities[0][1] = in.nextInt();
            for (int j = 1; j < n; j++) {
                int startTime = in.nextInt();
                int endTime = in.nextInt();
                while (!queue.isEmpty()) {
                    String schedule = queue.poll();
                    int index = overlappingIndex(activities, startTime, endTime, schedule.length());
                    if (index == -1) {
                        tmp.add(schedule + "C");
                        tmp.add(schedule + "J");
                        continue;
                    }

                    String person = schedule.substring(index, index + 1);
                    boolean overlappingWithOthers = overlappingWithOthers(activities, startTime, endTime, schedule.length(), person, schedule);
                    if (overlappingWithOthers) {
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

    public static int overlappingIndex(int[][] activities, int startTime, int endTime, int length) {
        for (int k = 0; k < length; k++) {
            if ((activities[k][1] > endTime && activities[k][0] < endTime)
                    || (activities[k][1] > startTime && activities[k][0] < startTime)) {
                return k;
            }
        }
        return -1;
    }

    public static boolean overlappingWithOthers(int[][] activities, int startTime, int endTime, int length, String person, String schedule) {
        for (int k = 0; k < length; k++) {
            if ((activities[k][1] > endTime && activities[k][0] < endTime)
                    || (activities[k][1] > startTime && activities[k][0] < startTime)) {
                if (!schedule.substring(k, k + 1).equals(person)) {
                    return true;
                }
            }
        }
        return false;
    }
}
