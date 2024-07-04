import javafx.util.Pair;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Pair<Integer, Integer>> times = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                times.add(new Pair<>(s, e));
            }

            String result = scheduleActivities(times);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static String scheduleActivities(List<Pair<Integer, Integer>> times) {
        if (times.size() < 2) return "IMPOSSIBLE";

        StringBuilder schedule = new StringBuilder();
        List<Pair<Integer, Integer>> jSchedule = new ArrayList<>();
        List<Pair<Integer, Integer>> cSchedule = new ArrayList<>();

        jSchedule.add(times.get(0));
        schedule.append("J");
        cSchedule.add(times.get(1));
        schedule.append("C");

        times.remove(0);
        times.remove(0);

        for (Pair<Integer, Integer> activity : times) {
            if (!isOverlapping(activity, jSchedule)) {
                jSchedule.add(activity);
                schedule.append("J");
            } else if (!isOverlapping(activity, cSchedule)) {
                cSchedule.add(activity);
                schedule.append("C");
            } else {
                return "IMPOSSIBLE";
            }
        }
        return schedule.toString();
    }

    private static boolean isOverlapping(Pair<Integer, Integer> activity, List<Pair<Integer, Integer>> schedule) {
        for (Pair<Integer, Integer> scheduledActivity : schedule) {
            if (isOverlapping(activity, scheduledActivity)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isOverlapping(Pair<Integer, Integer> a, Pair<Integer, Integer> b) {
        return (a.getKey() < b.getValue() && a.getValue() > b.getKey());
    }
}