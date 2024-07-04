import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static class Activity {
        int startTime, endTime;
        String assignment;

        @Override
        public String toString() {
            return "[" + startTime + ", " + endTime + ", " + assignment + "]";
        }
    }

    static Scanner in;
    static int T;
    static int N;
    static List<Activity> activities;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        T = in.nextInt();

        for (int c = 1; c <= T; c++) {
            readInput();

            System.out.print("Case #" + c + ": ");
            if (assignAll()) {
                for (Activity a : activities) {
                    System.out.print(a.assignment);
                }
            } else {
                System.out.print("IMPOSSIBLE");
            }

            System.out.println();
        }

        in.close();
    }

    public static void readInput() {
        N = in.nextInt();
        activities = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            Activity a = new Activity();
            a.startTime = in.nextInt();
            a.endTime = in.nextInt();
            activities.add(a);
        }
    }

    public static boolean assignAll() {
        List<Activity> startList = new ArrayList<>(activities);
        List<Activity> endList = new ArrayList<>(activities);

        startList.sort((a1, a2) -> Integer.compare(a1.startTime, a2.startTime));
        endList.sort((a1, a2) -> Integer.compare(a1.endTime, a2.endTime));

        int startPtr = 0, endPtr = 0;
        boolean jAvailable = true, cAvailable = true;

        while (startPtr < startList.size() || endPtr < endList.size()) {
            Activity start = (startPtr < startList.size()) ? startList.get(startPtr) : new Activity();
            Activity end = (endPtr < endList.size()) ? endList.get(endPtr) : new Activity();

            if (startPtr == startList.size()) {
                start.startTime = Integer.MAX_VALUE;
                start.endTime = Integer.MAX_VALUE;
            }

            if (endPtr == endList.size()) {
                end.startTime = Integer.MAX_VALUE;
                end.endTime = Integer.MAX_VALUE;
            }

            if (start.startTime < end.endTime) {
                if (jAvailable) {
                    start.assignment = "J";
                    jAvailable = false;
                } else if (cAvailable) {
                    start.assignment = "C";
                    cAvailable = false;
                } else {
                    return false;
                }
                startPtr++;
            } else {
                if ("J".equals(end.assignment)) {
                    jAvailable = true;
                } else if ("C".equals(end.assignment)) {
                    cAvailable = true;
                } else {
                    throw new IllegalStateException();
                }
                endPtr++;
            }
        }
        return true;
    }
}