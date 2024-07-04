import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {

  static class Interval {

    int startTime;
    int endTime;
    String person;
    int index;

    Interval(int index, int startTime, int endTime) {
      this.index = index;
      this.startTime = startTime;
      this.endTime = endTime;
    }

  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int tests = Integer.parseInt(scanner.nextLine());
    for (int testIndex = 1; testIndex <= tests; testIndex++) {
      int numOfIntervals = Integer.parseInt(scanner.nextLine());
      boolean isImpossible = false;
      List<Interval> intervals = new LinkedList<>();
      for (int interval = 0; interval < numOfIntervals; interval++) {
        String[] intervalStr = scanner.nextLine().split(" ");
        intervals.add(new Interval(interval, Integer.parseInt(intervalStr[0]), Integer.parseInt(intervalStr[1])));
      }
      intervals.sort(Comparator.comparingInt(interval -> interval.startTime));
      String person = "C";
      intervals.get(0).person = person;
      int cEndTime = intervals.get(0).endTime;
      int jEndTime = 0;
      for (int interval = 1; interval < numOfIntervals; interval++) {
        if (intervals.get(interval - 1).endTime > intervals.get(interval).startTime) {
          person = "J".equals(person) ? "C" : "J";
          if (person.equals("C")) {
            if (cEndTime > intervals.get(interval).startTime) {
              isImpossible = true;
              break;
            }
            cEndTime = intervals.get(interval).endTime;
          } else {
            if (jEndTime > intervals.get(interval).startTime) {
              isImpossible = true;
              break;
            }
            jEndTime = intervals.get(interval).endTime;
          }
        }
        intervals.get(interval).person = person;
      }
      if (isImpossible) {
        System.out.println("Case #" + testIndex + ": IMPOSSIBLE");
      } else {
        intervals.sort(Comparator.comparingInt(interval -> interval.index));
        StringBuilder solutionBuilder = new StringBuilder();
        for (Interval interval : intervals) {
          solutionBuilder.append(interval.person);
        }
        System.out.println("Case #" + testIndex + ": " + solutionBuilder);
      }

    }
  }

}
