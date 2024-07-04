
import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
      int numberOfTestCase = sc.nextInt();
      for (int i = 0; i < numberOfTestCase; i++) {
        int numberOfActivities = sc.nextInt();
        List<Pair<Integer, Integer>> activities = new ArrayList<>();
        for (int activity = 0; activity < numberOfActivities; activity++) {
          int startTime = sc.nextInt();
          int endTime = sc.nextInt();
          activities.add(new Pair<>(startTime, endTime));
        }
        activities.sort(new SortActivityByStartTime());
        int cameronEndTurn = -1;
        int jamieEndTurn = -1;
        StringBuilder schedule = new StringBuilder();
        int activityIndex = 0;
        for (int minute = 0; minute <= 24 * 60; minute++) {
          if (activityIndex >= activities.size()) {
            break;
          }
          Pair<Integer, Integer> activity = activities.get(activityIndex);
          if (activity.getKey() > minute) {
            continue;
          }
          if (cameronEndTurn != -1 && minute >= cameronEndTurn) {
            cameronEndTurn = -1;
          }
          if (jamieEndTurn != -1 && minute >= jamieEndTurn) {
            jamieEndTurn = -1;
          }
          if (cameronEndTurn == -1) {
            schedule.append("C");
            cameronEndTurn = activity.getValue();
            activityIndex++;
            minute--;
          } else if (jamieEndTurn == -1) {
            schedule.append("J");
            jamieEndTurn = activity.getValue();
            activityIndex++;
            minute--;
          } else {
            schedule = new StringBuilder("IMPOSSIBLE");
            break;
          }
        }
        System.out.println(String.format("Case #%d: %s", (i + 1), schedule.toString()));
      }

    }
  }

  private static class SortActivityByStartTime implements Comparator<Pair<Integer, Integer>> {
    @Override
    public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
      return Integer.compare(o1.getKey(), o2.getKey());
    }
  }
}
