import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int numTest = Integer.parseInt(in.nextLine());

    for (int i=0;i<numTest;i++) {
      int numActivities = Integer.parseInt(in.nextLine());
      ArrayList<Activity> activities = new ArrayList<>();

      for (int j=0;j<numActivities;j++) {
        String row = in.nextLine();
        String[] values = row.split(" ");
        Activity activity = new Activity(Integer.parseInt(values[0]), Integer.parseInt(values[1]),j);
        activities.add(activity);
      }

      scheduling(i, activities);
    }
  }

  private static void scheduling(int numTest, ArrayList<Activity> activities) {
    Collections.sort(activities);
    Activity lastCActivity = new Activity(0, 0, 0);
    Activity lastJActivity= new Activity(0, 0, 0);


    for (int index=0; index<activities.size();index++) {
      Activity currentActivity = activities.get(index);

      if (currentActivity.isAfter(lastCActivity)) {
        lastCActivity = currentActivity;
        currentActivity.setAssigned("C");
      } else if (currentActivity.isAfter(lastJActivity)) {
        lastJActivity = currentActivity;
        currentActivity.setAssigned("J");
      } else if (checkImpossible(lastCActivity, lastJActivity, currentActivity)) {
        printStatement("IMPOSSIBLE", numTest);
        return;
      }
    }

    Collections.sort(activities, new SortByPosition());
    StringBuilder schedule = new StringBuilder();
    for (int i=0;i<activities.size();i++) {
      schedule.append(activities.get(i).getAssigned());
    }

    printStatement(schedule.toString(), numTest);
  }

  private static void printStatement(String statement, int testNum) {
    testNum++;
    System.out.println("Case #" + testNum + ": " + statement);
  }

  private static boolean checkImpossible(Activity cAct, Activity jAct, Activity curAct) {
    return (
        cAct.getEndTime() > curAct.getStartTime()
        && jAct.getEndTime() > curAct.getStartTime()
        );
  }
}

class Activity implements Comparable<Activity> {

  private int startTime;
  private int endTime;
  private int pos;
  private String assigned;

  Activity(int s, int e, int p) {
    this.startTime = s;
    this.endTime = e;
    this.pos = p;
  }

  public int getStartTime() {
    return startTime;
  }

  public int getEndTime() {
    return endTime;
  }

  public int getPos() {
    return pos;
  }

  public void setAssigned(String assigned) {
    this.assigned = assigned;
  }

  public String getAssigned() {
    return assigned;
  }

  @Override
  public int compareTo(Activity o) {
    int result = 0;
    if (this.startTime < o.startTime) {
      result = -1;
    } else {
      result = this.startTime > o.startTime ? 1 : 0;
    }

    return result;
  }

  public boolean isAfter(Activity activity) {
    return this.startTime >= activity.endTime;
  }
}

class SortByPosition implements Comparator<Activity> {

  @Override
  public int compare(Activity o1, Activity o2) {
    return o1.getPos() - o2.getPos();
  }
}
