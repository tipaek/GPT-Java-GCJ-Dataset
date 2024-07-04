import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    static class Time {
        int startTime;
        int endTime;
        int index;

        public Time(int startTime, int endTime, int index) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.index = index;
        }
    }

    static class Pair {
        char ch;
        int index;

        public Pair(char ch, int index) {
            this.ch = ch;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            ArrayList<Time> timeList = new ArrayList<>();
            int cEndTime = -1;
            int jEndTime = -1;
            boolean isImpossible = false;
            ArrayList<Pair> schedule = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                timeList.add(new Time(startTime, endTime, i));
            }

            Collections.sort(timeList, Comparator.comparingInt(o -> o.startTime));

            for (Time time : timeList) {
                if (time.startTime >= cEndTime) {
                    schedule.add(new Pair('J', time.index));
                    cEndTime = time.endTime;
                } else if (time.startTime >= jEndTime) {
                    schedule.add(new Pair('C', time.index));
                    jEndTime = time.endTime;
                } else {
                    isImpossible = true;
                    break;
                }
            }

            Collections.sort(schedule, Comparator.comparingInt(o -> o.index));

            StringBuilder result = new StringBuilder();
            if (isImpossible) {
                result.append("IMPOSSIBLE");
            } else {
                for (Pair pair : schedule) {
                    result.append(pair.ch);
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + result.toString());
        }
    }
}